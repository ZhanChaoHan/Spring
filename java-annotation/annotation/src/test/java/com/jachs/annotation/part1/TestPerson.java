package com.jachs.annotation.part1;

import java.lang.reflect.Method;

/***
 * 
 * @author zhanchaohan
 *
 */
public class TestPerson {
	@Person(name = "knjs",age = 15)
	public void testMethon() {
	}

	public static void main(String[] args) {
		Class thisClass = TestPerson.class;

		Method[] meList = thisClass.getMethods();

		for (Method method : meList) {
			if (method.isAnnotationPresent(Person.class)) {
				Person p = method.getAnnotation(Person.class);

				System.out.println(p.name() + "\t\t" + p.age());
			}
		}
	}
}
