package com.group4.Kahoot3000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("registerForm", new RegisterForm());

        return "register";
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerSubmit(Model model, @ModelAttribute("registerForm") RegisterForm registerForm) {

        if(registerForm.getPassword().equals(registerForm.getPasswordRepeat())) {
            User user = new User(registerForm.getUsername(), registerForm.getPassword());
            TestDatabaseController.addUsertoDatabase(user);
            return "redirect:login";
        }
        return "register";
    }

}
