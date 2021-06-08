package com.jachs.aspectj.part3;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Demo {
	public static void main(String[] args) {
		Chef chef=Chef.initChef("皮皮虾");
		
		Guest guest=new Guest("小龙虾");
		Guest guest1=new Guest("大龙虾");
		
		
		guest.takeAnWalk();
		guest1.takeAnWalk();
	}
}
