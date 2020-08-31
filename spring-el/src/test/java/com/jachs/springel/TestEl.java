package com.jachs.springel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.jachs.springel.bean.ElBean;
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
}
