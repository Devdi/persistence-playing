package com.devdi.persistence.jdbc;

import com.devdi.persistence.Cat;
import com.devdi.persistence.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by devdi on 8/23/14.
 */
@Repository
public class CatJdbcRepository implements CatService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cat getCat(int id) {
        Cat cat = (Cat) jdbcTemplate.queryForObject("select id, name from cat where id = ?", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cat cat = new Cat();
                cat.setId(rs.getInt(1));
                cat.setName(rs.getString(2));
                return cat;
            }
        }, id);
        return cat;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
