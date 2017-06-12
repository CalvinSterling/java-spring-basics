package com.hol.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    @RequestMapping("welcome")
    public ModelAndView welcome() {
        String message = "<h1>This message comes from the WelcomeController class<h1>";
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping("test")
    public ModelAndView test() {
        String[] list = new String[]{"Hallo 1", "Hallo 2", "Hallo 3"};
        return new ModelAndView("test", "list", list);
    }
}
