package com.jachs.annotation.part1;

import org.junit.Test;

/**
 * @author zhanchaohan
 * 注解测试
 */
public class TestDescription {
    @Description(author = "Mooc Boy", desc = "I am eyeColor",age=18)
    public class descriptionC{
        
    }
    
    @Test
    public void beTest() throws NoSuchMethodException, SecurityException, NoSuchFieldException {
        boolean hasAnnotation = descriptionC.class.isAnnotationPresent(Description.class);
        if ( hasAnnotation ) {
            Description testAnnotation = descriptionC.class.getAnnotation(Description.class);
            System.out.println("desc:"+testAnnotation.desc ());
            System.out.println("author:"+testAnnotation.author ());
            System.out.println("age:"+testAnnotation.age ());
        }
        
    }
}
