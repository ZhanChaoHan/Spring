package com.jachs.annotation.part2;

import java.lang.annotation.Annotation;


/***
 * 
 * @author zhanchaohan
 *
 */
public class TestExcute {
	@ExcuteSQL(connectURL = "jdbc:mysql://127.0.0.1:3306/jpatest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
			driverClass = "com.mysql.cj.jdbc.Driver", passWorld = "", userName = "root",
			excuteSQLText = "")
	public class excuteO {};
	
	
	@ExcuteSQL(connectURL = "jdbc:mysql://127.0.0.1:3306/jpatest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
			driverClass = "com.mysql.cj.jdbc.Driver", passWorld = "", userName = "root",
			excuteSQLText = "")
	public class excuteN {};
	
	public static void main(String[] args) {
		Class myTest=TestExcute.class;
		
		Annotation[] arrList=myTest.getAnnotations();
		
		for (Annotation annotation : arrList) {
			System.out.println(annotation.toString());
		}
//		ExcuteSQL e1=excuteO.class.getAnnotation(ExcuteSQL.class);
		
	}
}
