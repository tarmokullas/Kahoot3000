package com.group4.Kahoot3000.Controllers;

import com.group4.Kahoot3000.Forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getUserFormForLogin(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }

}
