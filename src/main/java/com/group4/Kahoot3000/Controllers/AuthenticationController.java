package com.group4.Kahoot3000.Controllers;

import com.group4.Kahoot3000.Model.User;
import com.group4.Kahoot3000.Forms.*;
import com.group4.Kahoot3000.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {


    UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    //******************//
    //     REGISTER     //
    //******************//

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String gerUserFormForRegister(Model model) {

        model.addAttribute("userForm", new UserForm());

        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute("userForm") UserForm userForm) {

        if (!userService.doPasswordsMatch(userForm.getPassword(), userForm.getPasswordRepeat())) {
            return "redirect:/register?passworderror";
        }

        /*if (userService.usernameExists(userForm.getUsername())) {
            return "redirect:/register?usernameerror";
        }*/
        User userToRegister = new User(userForm.getUsername(), userForm.getPassword());
        userService.addUser(userToRegister);

        return "redirect:login";
    }

    //***************//
    //     LOGIN     //
    //***************//

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getUserFormForLogin(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginSubmit(Model model, @ModelAttribute("userForm") UserForm userForm) {

        try {
            User userToLogin = userService.findUserByUsername(userForm.getUsername());
            if (userToLogin.confirmLogin(userForm.getPassword())) {
                return "userpage";
            } else {
                return "redirect:login?passworderror";
            }

        } catch (NullPointerException e) {
            return "redirect:login?usernameerror";
        }

    }


}
