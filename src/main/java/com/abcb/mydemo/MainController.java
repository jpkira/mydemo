package com.abcb.mydemo;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Controller
    public String help(Model model) {
        return "help";
    }

    @GetMapping("/index")
    public String welcome(Model model) {
        // Add dynamic data to the model
        model.addAttribute("title", "Hello, Thymeleaf User!");
        model.addAttribute("todayDate", new Date());
        model.

        // Return the name of the template file (welcome.html)
        return "welcome";
    }
}
