package com.webservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class GoogleRepository {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public GoogleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(String fromAddress, String toAddress, String distance) {
        return jdbcTemplate.update("insert into locations values('"+fromAddress+"','"+toAddress+"','"+distance+"')");

    }

    public String getDistance(String fromAddress, String toAddress) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select distance from locations where fromAddress='" + fromAddress + "' and toAddress='" + toAddress + "'");
        sqlRowSet.next();
        return sqlRowSet.getString("distance");
    }

    public boolean isLocationPresent(String fromAddress, String toAddress) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select distance from locations where fromAddress='" + fromAddress + "' and toAddress='" + toAddress + "'");
        return sqlRowSet.next();
    }
}
