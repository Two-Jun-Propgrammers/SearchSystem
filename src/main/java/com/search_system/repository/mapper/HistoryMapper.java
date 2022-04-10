package com.search_system.repository.mapper;

import com.search_system.model.History;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class HistoryMapper implements RowMapper<History> {
    @Override
    public History mapRow(ResultSet rs, int rowNum) throws SQLException {
        History history = new History();
        history.setId(UUID.fromString(rs.getString("id")));
        history.setName(rs.getString("name"));
        history.setUserId(UUID.fromString(rs.getString("user_id")));

        return history;
    }
}
