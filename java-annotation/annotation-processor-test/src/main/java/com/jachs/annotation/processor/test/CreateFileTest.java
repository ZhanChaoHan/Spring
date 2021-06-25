package com.jachs.annotation.processor.test;

import com.jachs.annotation.part1.Person;
import com.jachs.annotation.part3.CreateClass;
import com.jachs.annotation.part3.CreateFile;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CreateFileTest {
	@CreateFile(fileName = "a.txt", filePath = "e:\\")
	public class a{};
	@CreateFile(fileName = "b.txt", filePath = "e:\\",message = "ABCHCGT")
	public class b{};
	@CreateFile(fileName = "c.txt", filePath = "e:\\",message = "guguBird")
	public class c{};
	
	@Person(age = 15,name = "jacks")
	public void pcl(){};
	
	@CreateClass(className = "GuguBird")
	public class d{};
	@CreateClass(className = "OnlyForTest",message = "hello java")
	public class e{};
	
	public static void main(String[] args) {
		 
	}
}
