package com.java.vk.vk.DAO;

import com.java.vk.vk.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByActivationCode(String code);
}
