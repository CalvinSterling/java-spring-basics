package com.hol.book.dao;

import com.hol.book.domain.Book;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Book addBook(Book book) throws DataAccessException;

    Optional<Book> getBook(final int id) throws DataAccessException;

    List<Book> getAllBooks() throws DataAccessException;

    Optional<Book> updateBook(Book book) throws DataAccessException;

    Optional<Book> deleteBook(final int id) throws DataAccessException;
}
