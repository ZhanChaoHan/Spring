package com.jachs.annotation.part2;

/**
 * @author zhanchaohan
 * 
 */
public abstract class Animal implements Eat{
    
    private void printSt1() {
        System.out.println ( "这是个动物" );
    }
    
    protected abstract void run();
}
