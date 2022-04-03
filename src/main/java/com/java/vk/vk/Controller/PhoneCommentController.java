package com.java.vk.vk.Controller;

import com.java.vk.vk.Entity.Comment;
import com.java.vk.vk.Entity.Phone;
import com.java.vk.vk.Service.CommentService;
import com.java.vk.vk.Service.PhoneService;
import com.java.vk.vk.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PhoneCommentController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @GetMapping("/number")
    public String show(Model model) {

        model.addAttribute("numberForm", new Phone());
        return "number";
    }



    @PostMapping("/number")
    public String addOrFindUser(@ModelAttribute("numberForm") @Valid Phone phone, BindingResult bindingResult, Model model,
                                @RequestParam(required = true, defaultValue = "") String number,
                                @RequestParam(required = true, defaultValue = "") String action,
                                @RequestParam(required = true, defaultValue = "") Double grade
                                ) {


        if (bindingResult.hasErrors()) {
            return "number";
        }

        Phone phone1 = phoneService.findPhoneByNumber(phone.getNumber());
        if (action.equals("find")) {
            if (phone1 == null) {

                List<Phone> list = phoneService.findAllNumberStart(phone.getNumber()+"%");
                if(!list.isEmpty()){
                    model.addAttribute("NumberStartWith",list);
                    return "number";
                }
                model.addAttribute("PhoneNotContains", "Phone Not Contains");
                model.addAttribute("phone", phone);
                return "number";
            } else {
                model.addAttribute("phoneModel", phone1);
            }
        }
        if (action.equals("add")) {
            phoneService.addPhone(number);
            return "number";
        }
        if (action.equals("addGrade")) {
            commentService.addGrade(Long.parseLong(number),grade);
            return "number";
        }


        return "number";
    }

    @GetMapping("/addComment/{number}")
    public String showComment(Model model) {
        model.addAttribute("commentForm", new Comment());
        return "addComment";
    }
    @PostMapping("/addComment/{number}")
    public String addComment(@ModelAttribute("commentForm") @Valid Comment comment, @PathVariable String number,Model model){
        commentService.saveComment(comment);
        phoneService.addComment(comment,number);
        model.addAttribute("Thanks", userService.getCurrentUsername()+" ,thanks for comment");

        return "addComment";
    }



}
