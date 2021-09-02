package com.jachs.spring_jdbc.dbcp.jdbc.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * 
 * @author zhanchaohan
 *
 */
public class JdbcConfigTest {

	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my/person/Person.xml","my/person/PersonAdvice.xml");
		
	}
}
