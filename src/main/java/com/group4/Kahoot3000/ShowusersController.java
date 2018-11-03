package com.group4.Kahoot3000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowusersController {

    @Autowired
    UserService userService;

    @RequestMapping("/showusers")
    public String showUsers(Model model) {
        List<User> users = (List<User>) userService.findAll();

        model.addAttribute("users", users);

        return "showUsers";
    }
}
