package com.jachs.springel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

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
       
        //表达式解析器
        ExpressionParser ep = new SpelExpressionParser();
        //创建角色对象
        Role2 role = new Role2(1L, "role_name", "note");
        Expression ex = ep.parseExpression("note");
        //相当于从role中获取备注信息
        String note = (String) ex.getValue(role);
        System.out.println(note);
        //变量环境类，并且将角色对象role作为其根节点
        EvaluationContext ctx = new StandardEvaluationContext(role);
        //变量环境类操作根节点
        ep.parseExpression("note").setValue(ctx, "new_note");
        //获取备注，这里的String.class指明，我们希望返回的是一个字符串
        note = ep.parseExpression("note").getValue(ctx, String.class);
        System.out.println(note);
        //调用getRoleName方法
        String roleName = ep.parseExpression("getRoleName()").getValue(ctx, String.class);
        System.out.println(roleName);
        //新增环境变量
        List<String> list = new ArrayList<String>();
        list.add("value1");
        list.add("value2");
        //给变量环境增加变量
        ctx.setVariable("list", list);
        //通过表达式去读/写环境变量的值
        ep.parseExpression("#list[1]").setValue(ctx, "update_value2");
        System.out.println(ep.parseExpression("#list[1]").getValue(ctx));
        
    }
}
