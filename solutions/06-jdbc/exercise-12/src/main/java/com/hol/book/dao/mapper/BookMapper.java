package com.hol.book.dao.mapper;

import com.hol.book.domain.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book> {
    public static final String ID = "ID", TITLE = "TITLE";

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt(ID), rs.getString(TITLE));
    }
}
