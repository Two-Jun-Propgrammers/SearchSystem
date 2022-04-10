package com.search_system.repository;

import com.search_system.model.User;
import com.search_system.repository.mapper.RoleMapper;
import com.search_system.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    public List<User> findAll() {
        String sql = "SELECT * FROM auth.users";

        return template.query(sql, userMapper);
    }

    public User findByLogin(String login) {
        String sql = "SELECT * FROM auth.users WHERE login = :login";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("login", login);

        return template.queryForObject(sql, params, userMapper);
    }

//    public User findById(UUID id){
//        String sql = "SELECT * FROM auth.users WHERE id = :id";
//        SqlParameterSource params = new MapSqlParameterSource()
//                .addValue("id", id);
//
//        return template.queryForObject(sql, params, userMapper);
//    }

    public String getRole(UUID id){
        String sql = "SELECT * FROM auth.roles WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, params, roleMapper).getName();
    }

    public UUID getRole(String name){
        String sql = "SELECT * FROM auth.roles WHERE name = :name";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", name);

        return template.queryForObject(sql, params, roleMapper).getId();
    }

    public boolean saveUser(User user){
        String sql = "INSERT INTO auth.users VALUES (:id, :login, :password, :roleId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("login", user.getLogin())
                .addValue("password", user.getPassword())
                .addValue("roleId", user.getRoleId());
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean search(UUID id){
        String sql = "SELECT * FROM auth.users WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, params, userMapper).equals(null);
    }

    public User search(String name){
        String sql = "SELECT * FROM auth.users WHERE users.login = :name";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", name);

        return template.queryForObject(sql, params, userMapper);
    }

    public boolean update(UUID oldId, User user) {
        if (search(oldId)) {
            return false;
        }
        String sql = "UPDATE auth.users SET login = :login, password = :password, role_id = :roleId WHERE id = :oldId";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("login", user.getLogin())
                .addValue("password", user.getPassword())
                .addValue("roleId", user.getRoleId())
                .addValue("oldId", oldId);
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(UUID id){
        String sql = "DELETE FROM auth.users WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
