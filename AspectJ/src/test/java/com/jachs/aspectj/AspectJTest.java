package com.jachs.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

/**
 * @author zhanchaohan
 * 
 */
@Aspect
public class AspectJTest {

//    @Test
    public static void test () {
        System.out.println ( "test" );
    }

    public static void main ( String[] args ) {
        test ();
    }

    @After( "execution(* com.jachs.aspectj.AspectJTest.test())" )
    public void test1 () {
        System.out.println ( "test1" );
    }

    @Before( "execution(* com.jachs.aspectj.AspectJTest.test())" )
    public void test2 () {
        System.out.println ( "test2" );
    }

}
