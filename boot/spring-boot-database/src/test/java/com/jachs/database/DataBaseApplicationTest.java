package com.jachs.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class DataBaseApplicationTest {
    @Autowired
    @Qualifier("c3p0Source")
    private DataSource c3ds;
    
    @Autowired
    @Qualifier("dbcpSource")
    private DataSource dbds;
    
    @Autowired
    @Qualifier("druidDataSource")
    private DataSource druidDataSource;
    
    @Test
    public void bsTest() throws SQLException {
        System.out.println ( c3ds.getConnection ().isClosed () );
        System.out.println ( dbds.getConnection ().isClosed () );
        System.out.println ( druidDataSource.getConnection ().isClosed () );
    }
}
