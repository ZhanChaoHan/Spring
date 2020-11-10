package com.jachs.springel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.jachs.springel.bean.ElBean;
import com.jachs.springel.entity.Inventor;
import com.jachs.springel.entity.Role2;

/**
 * @author zhanchaohan
 * 
 */
public class TestEl {

    @Test
    public void testa () {
        //表达式解析器
        ExpressionParser parser = new SpelExpressionParser ();
        // 设置表达式
        Expression exp = parser.parseExpression ( "'hello world'" );
        String str = (String) exp.getValue ();
        System.out.println ( str );
        //通过EL访问普通方法
        exp = parser.parseExpression ( "'hello world'.charAt(0)" );
        char ch = (Character) exp.getValue ();
        System.out.println ( ch );
        //通过EL访问的getter方法
        exp = parser.parseExpression ( "'hello world'.bytes" );
        byte[] bytes = (byte[]) exp.getValue ();
        System.out.println ( bytes );
        //通过EL访问属性，相当于"hello world".getBytes().length
        exp = parser.parseExpression ( "'hello world'.bytes.length" );
        int length = (Integer) exp.getValue ();
        System.out.println ( length );
        exp = parser.parseExpression ( "new String('abc')" );
        String abc = (String) exp.getValue ();
        System.out.println ( abc );

        System.out.println ( "-----------------------------------------------" );

    }

    //https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#expressions-evaluation
    @Test
    public void test () {
        //example 1
        ExpressionParser parser = new SpelExpressionParser ();
        Expression exp = parser.parseExpression ( "'Hello World'" );
        String message = (String) exp.getValue ();
        System.out.println ( message );
    }

    @Test
    public void test1 () {
        //example 2
        ExpressionParser parser = new SpelExpressionParser ();
        Expression exp = parser.parseExpression ( "'Hello World'.concat('!')" );
        String message = (String) exp.getValue ();
        System.out.println ( message );
    }

    @Test
    public void test2 () {
        //example 3
        ExpressionParser parser = new SpelExpressionParser ();
        // invokes 'getBytes()'
        Expression exp = parser.parseExpression ( "'Hello World'.bytes" );
        byte[] bytes = (byte[]) exp.getValue ();
        System.out.println ( new String ( bytes ) );
    }

    @Test
    public void test3 () {
        //example 4
        ExpressionParser parser = new SpelExpressionParser ();

        // invokes 'getBytes().length'
        Expression exp = parser.parseExpression ( "'Hello World'.bytes.length" );
        int length = (Integer) exp.getValue ();
        System.out.println ( length );
    }
    @Test
    public void test4 () {
        //example 5
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()"); 
        String message = exp.getValue(String.class);
        System.out.println ( message );
    }
    @Test
    public void test5 () {
        //example 6
     // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) exp.getValue(tesla);
        // name == "Nikola Tesla"

        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        // result == true
        System.out.println ( result );
    }
}
