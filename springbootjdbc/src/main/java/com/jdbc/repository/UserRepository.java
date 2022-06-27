package com.jdbc.repository;

import com.jdbc.model.User;
import com.jdbc.rowmapper.RowMapperImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate template;

    public int saveUser(User user) {
        final String query = "insert into user values(?,?,?)";
        int update = template.update(query, user.getId(), user.getName(), user.getCity());
        return update;
    }

    public int updateUser(User user) {
        final String query = "update user set name=?,city=? where id=?";
        int update = template.update(query, user.getName(), user.getCity(), user.getId());
        return update;
    }

    public int deleteUser(int id) {
        final String query = "delete from user where id=?";
        int update = template.update(query, id);
        return update;
    }

    public User getUser(int id) {
        final String query = "select * from user where id=?";
        User user = template.queryForObject(query, new RowMapperImplementation(), id);
        return user;
    }

    public List<User> getUsers() {
        final String query = "select * from user";
        List<User> users = template.query(query, new RowMapperImplementation());
        return users;
    }

    public int[] batchSaveUsers(final List<User> users) {
        final String query = "insert into user values(?,?,?)";
        int[] batchSave = template.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, users.get(i).getId());
                ps.setString(2, users.get(i).getName());
                ps.setString(3, users.get(i).getCity());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
        return batchSave;
    }

    public int[] batchUpdateUsers(final List<User> users) {
        final String query = "update user set name=?,city=? where id=?";
        int[] batchUpdate = template.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getName());
                ps.setString(2, users.get(i).getCity());
                ps.setInt(3, users.get(i).getId());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
        return batchUpdate;
    }
}
