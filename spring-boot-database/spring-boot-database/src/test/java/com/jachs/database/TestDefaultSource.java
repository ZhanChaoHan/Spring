package com.jachs.database;

import org.springframework.boot.test.context.SpringBootTest;

/***
 * Springboot默认支持4种数据源类型，定义在 org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration 中，分别是：
	org.apache.tomcat.jdbc.pool.DataSource
	com.zaxxer.hikari.HikariDataSource
	org.apache.commons.dbcp.BasicDataSource
	org.apache.commons.dbcp2.BasicDataSource
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class TestDefaultSource {

}
