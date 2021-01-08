package com.jachs.database.jdbc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * @author zhanchaohan
 */
@Repository
public class TgoodsDao {
    @Autowired
    @Qualifier("dbcpJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    
}
