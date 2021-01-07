package com.jachs.database;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jdbc.dao.TorderDao;


/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class TestTOrder {
    @Autowired
    private TorderDao torderDao;
    
    @Test
    public void testO() {
        
    }
}
