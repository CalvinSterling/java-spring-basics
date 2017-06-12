package com.hol.book.dao;

import com.hol.book.dao.mapper.BookMapper;
import com.hol.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static com.hol.book.dao.mapper.BookMapper.ID;
import static com.hol.book.dao.mapper.BookMapper.TITLE;

@Component
public class RealBookDao implements BookDao {
    private static final String SELECT_ID = "SELECT * FROM BOOKSERVICE.BOOKS WHERE ID=:" + ID;
    private static final String SELECT_ALL = "SELECT * FROM BOOKSERVICE.BOOKS";
    private static final String INSERT = "INSERT INTO BOOKSERVICE.BOOKS (" + TITLE + ") VALUES (:" + TITLE + ")";
    private static final String UPDATE = "UPDATE BOOKSERVICE.BOOKS SET (" + TITLE + ") = (:" + TITLE + ") WHERE ID=:" + ID;
    private static final String DELETE = "DELETE FROM BOOKSERVICE.BOOKS WHERE ID=:" + ID;

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final BookMapper bookMapper;

    @Autowired
    public RealBookDao(final DataSource dataSource, final BookMapper bookMapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.bookMapper = bookMapper;
    }

    public Optional<Book> getBook(int id) throws DataAccessException {
        final MapSqlParameterSource parameterMap = new MapSqlParameterSource();
        parameterMap.addValue(ID, id);
        List<Book> bookList = jdbcTemplate.query(SELECT_ID, parameterMap, bookMapper);
        return bookList.stream().findFirst();
    }

    public List<Book> getAllBooks() throws DataAccessException {
        return jdbcTemplate.query(SELECT_ALL, bookMapper);
    }

    public Book addBook(Book book) throws DataAccessException {
        final MapSqlParameterSource parameterMap = new MapSqlParameterSource();
        parameterMap.addValue(TITLE, book.getTitle());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(INSERT, parameterMap, keyHolder, new String[]{"id"});
        if (rowsAffected == 1) {
            return new Book(keyHolder.getKey().intValue(), book.getTitle());
        } else {
            throw new DataAccessResourceFailureException(String.format("Rows affected should be 1, but was: %s", rowsAffected));
        }
    }

    public Optional<Book> updateBook(Book book) throws DataAccessException {
        final MapSqlParameterSource parameterMap = new MapSqlParameterSource();
        parameterMap.addValue(ID, book.getId());
        parameterMap.addValue(TITLE, book.getTitle());

        int rowsAffected = jdbcTemplate.update(UPDATE, parameterMap);
        if (rowsAffected == 1) {
            return Optional.of(book);
        }
        return Optional.empty();
    }


    public Optional<Book> deleteBook(int id) throws DataAccessException {
        final MapSqlParameterSource parameterMap = new MapSqlParameterSource();
        parameterMap.addValue(ID, id);

        int rowsAffected = jdbcTemplate.update(DELETE, parameterMap);
        if (rowsAffected == 1) {
            return Optional.of(new Book(id, ""));
        }
        return Optional.empty();
    }
}
