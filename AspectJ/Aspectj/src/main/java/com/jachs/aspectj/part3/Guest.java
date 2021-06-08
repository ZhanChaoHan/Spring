package com.jachs.aspectj.part3;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Guest {
	private String name;

	private Guest() {
		super();
	}

	public Guest(String name) {
		super();
		this.name ="客人:"+ name;
	}
	
	public void takeAnWalk() {
		System.out.println(this.name+"出去走了走");
	}
}
