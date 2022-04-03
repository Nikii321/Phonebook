package com.java.vk.vk.Service;

import com.java.vk.vk.DAO.CommentRepo;
import com.java.vk.vk.Entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserService userService;
    public Comment findByComment(Long id){
        return commentRepo.getById(id);
    }

    public void saveComment(Comment comment){

        String userName = userService.getCurrentUsername();
        comment.setNameAuthor(userName);
        commentRepo.save(comment);
    }
    public void addGrade(Long id,Double grade){

            Comment comment = commentRepo.getById(id);
            if (comment.getSum() == null) {
                comment.setSum(0d);
            }
            if (comment.getCount() == null) {
                comment.setCount(0L);
            }
            comment.setSum(comment.getSum() + grade);
            comment.setCount(comment.getCount() + 1);
            comment.setReting(Math.ceil((comment.getSum() / comment.getCount())*100)/100);
            commentRepo.save(comment);

    }
}
