package com.jachs.aspectj.demo.part1;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest()
public class HuManTest {
	@Autowired
	private HuMan huMan;
	@Autowired
	private HuManAsp huManAsp;
	
	@Test
	public void test() {
		huMan.speak();
	}
}
