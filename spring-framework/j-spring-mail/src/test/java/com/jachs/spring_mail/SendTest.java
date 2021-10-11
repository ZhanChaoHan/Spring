package com.jachs.spring_mail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SendTest {
	
	@Test
	public void test1() {
		System.out.println("OKX");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mail.xml");

		JavaMailSender mailSender=ctx.getBean("javaMailSender",JavaMailSender.class);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("zhanchaohan22@163.com");
		message.setTo("nikeName");
		message.setSubject("主题");
		message.setText("类容");
		
		mailSender.send(message);
	}
}
