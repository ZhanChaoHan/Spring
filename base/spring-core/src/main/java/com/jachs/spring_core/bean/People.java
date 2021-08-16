package com.jachs.spring_core.bean;

/***
 * 
 * @author zhanchaohan
 *
 */
public class People {
	private String name;
	private int age;
	private long phoneNum;
	
	public People() {
		super();
	}
	public People(String name, int age, long phoneNum) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
