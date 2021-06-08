package com.jachs.aspectj.part3;

/***
 * 只能是一个厨师采用单例
 * @author zhanchaohan
 *
 */
public class Chef {
	private String name;

	private static Chef chef;

	private Chef() {
		super();
	}

	private Chef(String name) {
		super();
		this.name = name;
	}

	public static Chef initChef(String name) {
		if(chef==null) {
			chef= new Chef(name);
		}
		return chef;
	}
	
}
