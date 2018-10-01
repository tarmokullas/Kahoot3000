package com.group4.Kahoot3000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestDatabaseController {
        @RequestMapping(value = {"/testdatabase"}, method = RequestMethod.GET)
        public String testdatabase(Model model) {
            model.addAttribute("user", new User());
            return "testdatabase";
        }

        @PostMapping("/testdatabase")
        public String userSubmit(@ModelAttribute User user) {
            return "testdatabase";
        }
}
