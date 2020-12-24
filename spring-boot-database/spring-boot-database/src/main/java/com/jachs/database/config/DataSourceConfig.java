package com.jachs.database.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:druid.properties")
public class DataSourceConfig {
    /**
         * 虽然我们配置了druid连接池的其它属性，但是不会生效。因为默认是使用的java.sql.Datasource的类来获取属性的，
         * 有些属性datasource没有。如果我们想让配置生效，需要手动创建Druid的配置文件
     * @throws IOException 
     */ 
    /* @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource () throws IOException {
        Properties pro=new Properties();
        pro.load ( DataSourceConfig.class.getResourceAsStream ( "/druid2.properties" ) );
        DruidDataSource dataSource = new DruidDataSource ();
        dataSource.setConnectProperties ( pro );
        return dataSource;
    //        return  DruidDataSourceBuilder.create ().build ();
    }*/

    /**
     * Druid的最强大之处在于它有着强大的监控，可以监控我们发送到数据库的所有sql语句。方便我们后期排插错误 配置Druid的监控
     * 配置一个管理后台的Servlet http://localhost:8080/druid/login.html
     */
    /*
    @Bean
    public ServletRegistrationBean statViewServlet () {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean ( new StatViewServlet (), "/druid/*" );

        Map<String, String> initParams = new HashMap<> ();
        //登录名
        initParams.put ( "loginUsername", "admin" );
        //登录密码
        initParams.put ( "loginPassword", "admin" );
        //默认就是允许所有访问
        initParams.put ( "allow", "" );
        //拒接访问
        //initParams.put("deny","127.0.0.1");
        registrationBean.setInitParameters ( initParams );
        return registrationBean;
    }
    */
    /**
     * 配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
 
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
 
        bean.setInitParameters(initParams);
 
        bean.setUrlPatterns(Arrays.asList("/*"));
 
        return  bean;
    }
}