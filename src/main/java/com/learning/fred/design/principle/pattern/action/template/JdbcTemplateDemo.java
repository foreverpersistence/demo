package com.learning.fred.design.principle.pattern.action.template;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fred
 * @date 2020/12/25 11:35
 * @description todo
 */
public class JdbcTemplateDemo {

    private JdbcTemplate jdbcTemplate;

    public Object query(long id) {
        String sql = "";
        return jdbcTemplate.query(sql, new UserRowMapper()).get(0);
    }
//    RowCallbackHandler, RowCallbackHandler
    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null;
        }
    }
}
