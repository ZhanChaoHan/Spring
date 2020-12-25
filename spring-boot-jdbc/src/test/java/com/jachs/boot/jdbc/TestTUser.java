package com.jachs.boot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.boot.jdbc.dao.TuserDao;
import com.jachs.boot.jdbc.entity.Tuser;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class TestTUser {
    @Autowired
    private TuserDao tuserDao;
    
    @Test
    public void testU() {
        for ( Tuser user : tuserDao.queryAll () ) {
            System.out.println ( user.toString () );
        }
    }
}
