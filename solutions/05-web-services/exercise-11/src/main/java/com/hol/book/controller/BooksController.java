package com.hol.book.controller;

import com.hol.book.dao.BookDao;
import com.hol.book.domain.Book;
import org.apache.avalon.framework.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("books/")
public class BooksController {

    private BookDao bookDao;

    @Autowired
    public BooksController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("welcome")
    public ModelAndView welcome(ModelAndView modelAndView) {
        String message = "<h1>This message comes from the BooksController class<h1>";
        modelAndView.addObject("message", message);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookTest() {
        return new Book(1, "Test Book");
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Book> createBook(@RequestBody Book b) {
        try {
            Book book = bookDao.addBook(b);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception e) {
            return handleError(e);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        try {
            Optional<Book> book = bookDao.getBook(id);
            if (book.isPresent()) {
                return ResponseEntity.ok(book.get());
            } else {
                return handleNotFound();
            }
        } catch (Exception e) {
            return handleError(e);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookDao.getAllBooks());
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Book> updateBook(@RequestBody Book b) {
        try {
            Optional<Book> book = bookDao.updateBook(b);
            if (book.isPresent()) {
                return ResponseEntity.ok(book.get());
            } else {
                return handleNotFound();
            }
        } catch (Exception e) {
            return handleError(e);
        }
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        try {
            Optional<Book> book = bookDao.deleteBook(id);
            if (book.isPresent()) {
                return ResponseEntity.ok().build();
            } else {
                return handleNotFound();
            }
        } catch (Exception e) {
            return handleError(e);
        }
    }

    @ResponseBody
    private ResponseEntity<Book> handleNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    private ResponseEntity<Book> handleError(Exception e) {
        System.out.println("Error: " + ExceptionUtil.printStackTrace(e));
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
