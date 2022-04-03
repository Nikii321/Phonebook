package com.java.vk.vk.DAO;

import com.java.vk.vk.Entity.Role;
import com.java.vk.vk.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
