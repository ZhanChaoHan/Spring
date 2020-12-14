package com.jachs.annotation.part2;

/**
 * @author zhanchaohan
 * 
 */
public class Fish extends Animal{
    public String name="shark";
    
    public void nms() {
        System.out.println ( "print nms" );
    }
    @Override
    public void eatSomeThing () {
        System.out.println ( name+"eat fish" );
    }

    @Override
    protected void run () {
        System.out.println ( name+"swim to fish" );
    }

}
