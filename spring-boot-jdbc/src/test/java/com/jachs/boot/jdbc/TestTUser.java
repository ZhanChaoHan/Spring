package com.jachs.boot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class TestTUser {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void testU() {
        System.out.println ( "aaaaa" );
    }
}
