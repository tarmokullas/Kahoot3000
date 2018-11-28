package com.group4.Kahoot3000.Controllers;

import com.group4.Kahoot3000.Forms.UserForm;
import com.group4.Kahoot3000.Model.User;
import com.group4.Kahoot3000.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        if (userService.usernameExists(userForm.getUsername())) {
            return "redirect:/register?usernameerror";
        }

        User userToRegister = new User(userForm.getUsername(), userForm.getPassword());
        userToRegister.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userService.addUser(userToRegister);

        return "redirect:login";
    }

}
