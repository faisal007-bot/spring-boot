package com.jdbc.rowmapper;

import com.jdbc.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImplementation implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setCity(rs.getString(3));
        return user;
    }
}
