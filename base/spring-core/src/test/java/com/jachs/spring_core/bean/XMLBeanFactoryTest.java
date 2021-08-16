package com.jachs.spring_core.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;

/***
 * 
 * @author zhanchaohan
 *
 */
public class XMLBeanFactoryTest {

	@Test
	public void test1() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("XMLBeanFactory.xml"));

		People people = (People) beanFactory.getBean("jack");

		System.out.println(people.getName());
		System.out.println(people.getAge());
		System.out.println(people.getPhoneNum());
	}

	@Test
	public void test2() throws FileNotFoundException {
		InputStream is = new FileInputStream("E:\\EclipseWorkSpace\\spring-core\\src\\main\\resources\\XMLBeanFactory.xml");
		XmlBeanFactory factory = new XmlBeanFactory(new InputStreamResource(is));
		
		People people = (People) factory.getBean("jack");

		System.out.println(people.getName());
		System.out.println(people.getAge());
		System.out.println(people.getPhoneNum());
	}
}
