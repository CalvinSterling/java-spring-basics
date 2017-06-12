package com.hol.book.controller;

import com.hol.book.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("books")
public class BooksController {

    @RequestMapping("/welcome")
    public ModelAndView welcome(ModelAndView modelAndView) {
        String message = "<h1>This message comes from the BooksController class<h1>";
        modelAndView.addObject("message", message);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook() {
        return new Book("Test Book");
    }
}
