package com.search_system.repository.mapper;

import com.search_system.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRoleId(UUID.fromString(rs.getString("role_id")));

        return user;
    }
}
