package com.java.vk.vk.Service;

import com.java.vk.vk.DAO.RoleRepo;
import com.java.vk.vk.DAO.UserRepo;
import com.java.vk.vk.Entity.Role;
import com.java.vk.vk.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.UUID;
@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepo userRepository;
    @Autowired
    RoleRepo roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userName = userRepository.findByEmail(email);

        if (userName == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return  userName;
    }

    public boolean saveUser(User user) {
        User userFromDBEmail = userRepository.findByEmail(user.getEmail());
        if (userFromDBEmail  != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(0L, "NO_ACTIVE")));

        user.setActivationCode(UUID.randomUUID().toString());
        String massage = String.format(
                "Hello, %s \n"+
                        "Welcome to RusFace. Please,visit next link: http://localhost:8080/activate/%s",
                user.getUsername(),user.getActivationCode()
        );
        if(user.getEmail() != null){
            emailService.sendEmail(user.getEmail(),"Подтверждение почты",massage);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return true;
    }
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    public boolean activateUser(String code) {

        User user =userRepository.findByActivationCode(code);
        if(user ==null){
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setActive(true);
        user.setActivationCode(null);
        deleteUser(user.getId());
        userRepository.save(user);
        return true;
    }
    public String getCurrentUsername(){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        if(userName.equals("anonymousUser")){
            userName = "Anonymous";
        }
        return userName;
    }



}
