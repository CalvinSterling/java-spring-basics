package com.hol.book.dao;

import com.hol.book.domain.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FakeBookDao implements BookDao {
    private List<Book> bookDb = new ArrayList<Book>();
    private int nextId = 1;

    public FakeBookDao() {
        bookDb.add(new Book(nextId, "Book 1"));
        nextId++;
        bookDb.add(new Book(nextId, "Book 2"));
        nextId++;
    }

    public Book addBook(Book book) throws DataAccessException {
        Book b = new Book(nextId, book.getTitle());
        bookDb.add(b);
        nextId++;
        return b;
        // real dao would throw exception when insert failed
    }

    public Optional<Book> getBook(final int id) throws DataAccessException {
        return bookDb.stream().filter(b -> b.getId() == id).findAny();
    }

    public List<Book> getAllBooks() throws DataAccessException {
        return bookDb;
    }

    public Optional<Book> updateBook(Book book) throws DataAccessException {
        Optional<Book> oldBook = bookDb.stream().filter(b -> b.getId() == book.getId()).findAny();
        return oldBook.map(b -> {
            int i = bookDb.indexOf(b);
            bookDb.set(i, book);
            return book;
        });
    }

    public Optional<Book> deleteBook(final int id) throws DataAccessException {
        return bookDb.stream().filter(b -> b.getId() == id).findAny().map(b -> {
            bookDb.remove(b);
            return b;
        });
    }
}
