package com.jachs.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.config.properties.C3p0Properties;
import com.jachs.database.config.properties.DbcpProperties;


/***
 * Springboot默认支持4种数据源类型，定义在 org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 * 中，分别是： <br>
 * org.apache.tomcat.jdbc.pool.DataSource <br>
 * com.zaxxer.hikari.HikariDataSource org.apache.commons.dbcp.BasicDataSource <br>
 * org.apache.commons.dbcp2.BasicDataSource <br>
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class TestDefaultSource {
    @Autowired
    private DataSource ds;
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
	private C3p0Properties c3p0Properties;
	@Autowired
	private DbcpProperties dbcpProperties;
	
    @Test
    public void testDs () throws SQLException {
        System.out.println ( "用户名：" + dataSourceProperties.getUsername () );
        System.out.println ( "密码：" + dataSourceProperties.getPassword () );
        System.out.println ( "Url：" + dataSourceProperties.getUrl () );
        System.out.println ( "驱动类：" + dataSourceProperties.getDriverClassName () );
        
        
        System.out.println ( "得到的数据源：" + ds );
        System.out.println ( "得到的连接：" + ds.getConnection () );
        
    }
}
