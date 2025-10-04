package com.example.main.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SakilaRepository {

    private final JdbcTemplate jdbcTemplate;

    public SakilaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAll() {
        return jdbcTemplate.queryForList("SELECT * FROM actor");
    }

    public Map<String, Object> findById(int id) {
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }
}
