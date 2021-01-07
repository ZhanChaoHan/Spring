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
@PropertySource( encoding = "Utf-8", value = "classpath:/c3p0.properties" )
public class C3p0DataSourceConfig{
    
    @Bean( "c3p0Source" )
    @ConfigurationProperties( prefix = "c3p0" )
    public DataSource c3p0SourceDs () {
        return DataSourceBuilder.create ()
                .type(com.mchange.v2.c3p0.ComboPooledDataSource.class)
                .build();
    }
    
    @Bean(name = "c3p0TransactionManager")
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("c3p0Source")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
   
    @Bean(name = "c3p0JdbcTemplate")
    public JdbcTemplate JdbcTemplate(@Qualifier("c3p0Source")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}