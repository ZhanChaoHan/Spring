package com.jachs.aspectj.demo.part1;


import org.springframework.stereotype.Component;

/***
 * 
 * @author zhanchaohan
 *
 */
@Component
public class HuMan {
	private String name="张三";
	private int age=15;
	
	public void Pc() {
		System.out.println("Pc");
	}
	public void openMouth() {
		System.out.println("openMouth");
	}
	public void speak() {
		System.out.println("speak");
	}
	public void speak(String word) {
		System.out.println(this.name+"speak："+word);
	}
}
