package com.jachs.spring_jdbc.dbcp;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DbcpTest {
	
	@Test
	public void test1() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("/database/dbcp/dbcp.xml"));
		
		JdbcTemplate jdbcTemplate=(JdbcTemplate) beanFactory.getBean("jdbcTemplate");
		
		Map<String, Object> maps=jdbcTemplate.queryForMap("show tables");
		
		for (String keys : maps.keySet()) {
			System.out.println(keys);
		}
	}
}
