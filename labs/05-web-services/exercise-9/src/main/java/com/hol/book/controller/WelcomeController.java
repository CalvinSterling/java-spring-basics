package com.hol.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    @RequestMapping("welcome")
    public ModelAndView welcome() {
        String message = "<h1>This message comes from the WelcomeController class<h1>";
        return new ModelAndView("welcome", "message", message);
    }
}
