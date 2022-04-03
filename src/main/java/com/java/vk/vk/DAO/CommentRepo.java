package com.java.vk.vk.DAO;

import com.java.vk.vk.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    Comment getById(Long id);
}
