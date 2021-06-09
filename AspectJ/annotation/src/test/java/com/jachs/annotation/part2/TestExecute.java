package com.jachs.annotation.part2;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.jachs.annotation.part1.Description;


/***
 * 
 * @author zhanchaohan
 *
 */
public class TestExecute {
	@ExecuteSQL(connectURL = "jdbc:mysql://127.0.0.1:3306/jpatest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
			driverClass = "com.mysql.cj.jdbc.Driver", passWorld = "123456", userName = "root",
			excuteSQLText = "insert into computer value(66,'神州',7500)")
	public class excuteO {};
	
	
	@ExecuteSQL(connectURL = "jdbc:mysql://127.0.0.1:3306/jpatest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
			driverClass = "com.mysql.cj.jdbc.Driver", passWorld = "123456", userName = "root",
			excuteSQLText = "insert into computer value(99,'apa',9500)")
	public class excuteN {};
	
	@ExecuteSQL(connectURL = "jdbc:mysql://127.0.0.1:3306/jpatest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
			driverClass = "com.mysql.cj.jdbc.Driver", passWorld = "123456", userName = "root",
			excuteSQLText = "insert into computer value(789,'okay',2658)")
	public interface excuteQ {};
	
	@Description(author = "Jame", desc = "buleHair",age=18)
    public class descriptionC{}
	
	
	public static void main(String[] args) {
		Class myTest=TestExecute.class;
		
		Class[]  clList=myTest.getClasses();
		
		for (Class cls : clList) {
			for (Annotation class1 : cls.getAnnotations()) {
				if(cls.isAnnotationPresent(ExecuteSQL.class)) {//判断注解类型是否是ExcuteSQL
					ExecuteSQL eSQL=(ExecuteSQL) cls.getAnnotation(ExecuteSQL.class);
					
					excuteMethod(eSQL.driverClass(), eSQL.userName(), eSQL.passWorld(), eSQL.connectURL(), eSQL.excuteSQLText());
				}
			}
		}
	}
	private static  void excuteMethod(String driverClass,String userName,String passWorld,String connectURL,String excuteSQLText) {
		Connection connect=null;
		Statement statement=null;
		
		try {
			Class.forName(driverClass);
			connect=DriverManager.getConnection(connectURL, userName, passWorld);
			statement=connect.createStatement();
			
			statement.execute(excuteSQLText);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connect!=null) {
					connect.close();
				}
				if(statement!=null) {
					statement.close();
				}
			}catch (Exception e) {
			}
		}
	}
}
