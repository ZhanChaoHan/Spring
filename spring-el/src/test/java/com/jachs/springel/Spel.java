package com.jachs.springel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jachs.springel.entity.Circle;
import com.jachs.springel.entity.Email;

public class Spel {
    @Test
    public void testSpel () {
        ApplicationContext ac = new ClassPathXmlApplicationContext ( "classpath:spel.xml" );
        Circle circle = ac.getBean ( "circle", Circle.class );
        System.out.println ( circle );
        Email email = ac.getBean ( "email", Email.class );
        System.out.println ( email );
    }
}
