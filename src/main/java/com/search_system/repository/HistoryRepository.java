package com.search_system.repository;

import com.search_system.model.History;
import com.search_system.model.User;
import com.search_system.repository.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class HistoryRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryMapper historyMapper;

    public List<History> search(String name, String login){
        UUID userId = userRepository.search(login).getId();
        String sql = "SELECT * FROM history.history WHERE user_id = :userId and name like :name";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("name", "%" + name + "%");

        return template.query(sql, params, historyMapper);
    }

    public boolean create(String name, String login) {
        UUID userId = userRepository.search(login).getId();
        String sql = "INSERT INTO history.history VALUES (:id, :name, :userId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", name)
                .addValue("userId", userId);
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
