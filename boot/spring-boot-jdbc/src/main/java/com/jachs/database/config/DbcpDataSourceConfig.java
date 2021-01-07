package com.jachs.database.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


/***
 * 
 * @author zhanchaohan
 *
 */
@Configuration
@PropertySource( encoding = "Utf-8", value = "classpath:/dbcp2.properties" )
public class DbcpDataSourceConfig{
    
    @Bean( "dbcpSource" )
    @ConfigurationProperties( prefix = "spring.datasource.dbcp2" )
    public DataSource dbcpSourceDs () {
        return DataSourceBuilder.create ().build ();
    }

    @Bean(name = "dbcpTransactionManager")
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("dbcpSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
   
    @Bean(name = "dbcpJdbcTemplate")
    public JdbcTemplate JdbcTemplate(@Qualifier("dbcpSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}