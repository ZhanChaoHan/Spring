package com.jachs.annotation.part2;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

/**
 * @author zhanchaohan
 * 反射测试
 */
public class TestPart2 {

    /***
     * 构造方法测试
     * @author zhanchaohan
     * getDeclaredConstructors();　　　　获取所有的构造函数<br>
        　　　getDeclaredConstructor(参数类型);　　获取一个所有的构造函数<br>
        　　　getConstructors();　　　　　　　　　　获取所有公开的构造函数<br>
        　　　getConstructor(参数类型);　　　　　　　　获取单个公开的构造函数<br>
     */
    @Test
    public void testConstructors () throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class catClass = Cat.class;
        Constructor[] cList = catClass.getConstructors ();//获取全部构造方法不包括私有
        for ( Constructor constructor : cList ) {
            System.out.println ( constructor.getName () );
        }
        System.out.println ( "获取全部构造方法不包括私有结束----------------------------------" );

        Constructor fisconstructor = catClass.getConstructor ( new Class[] { String.class } );//获取一个参数String的构造方法，如果不存在会抛出异常

        Constructor[] constructors = catClass.getDeclaredConstructors ();//获取构造方法全部包括私有

        for ( int i = 0 ; i < constructors.length ; i++ ) {
            System.out.println ( Modifier.toString ( constructors[i].getModifiers () ) + "参数：" );
            Class[] parametertypes = constructors[i].getParameterTypes ();
            for ( int j = 0 ; j < parametertypes.length ; j++ ) {
                System.out.print ( parametertypes[j].getName () + " \t\t" );
            }
            System.out.println (  );
        }
        System.out.println ( "获取构造方法全部包括私有结束----------------------------------" );
        Constructor constructor = catClass.getConstructor(String.class,int.class);//实例化
        Cat myObject = (Cat) constructor.newInstance("dog",10);
        System.out.println ( myObject.getName ()+"\t\t"+myObject.getAge ());
        System.out.println ( "实例化构造方法结束----------------------------------" );
    }
    /***
     * 方法测试
     * getDeclaredMethods()获取当前类全部方法<br>
     * getMethods()获取当前类公共方法<br>
     * getMethods(方法名称)获取当前类指定公共类<br>
     * getDeclaredMethods(方法名称)获取当前类指定公共类<br>
     */
    @Test
    public void testMethods () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
        Class catClass = Cat.class;
        Method[] meList = catClass.getMethods ();//获取当前类全部方法，不包括私有的
        for ( Method method : meList ) {
            System.out.println ("公共方法:\t\t"+ method.getName () );
        }
        System.out.println ( "-------------------------------------------" );
        Method[] allMeList =  catClass.getDeclaredMethods();
        for ( Method methodsa : allMeList ) {
            System.out.println ("公共方法:\t\t"+ methodsa.getName ()+"\t\t"+Modifier.toString (methodsa.getModifiers ()) );
        }
        
        Method method = catClass.getMethod("sinp",String.class);        //获取单个的公开方法
        method.invoke(catClass.newInstance(),"Duang");//实例化这个方法
        
        Method sleep = catClass.getDeclaredMethod ( "sleep");
        sleep.setAccessible ( true );
        sleep.invoke(catClass.newInstance());//实例化私有方法
    }
    @Test
    public void testFields() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Class catClass = Cat.class;
        Field[] fList=catClass.getFields ();//获取全部公共参数
        for ( Field field : fList ) {
            System.out.println ( field.getName () );
        }
        System.out.println ( "-------------------------------------" );
        Field[] fAList=catClass.getDeclaredFields ();//获取全部参数
        for ( Field field : fAList ) {
            System.out.println ( field.getName ()+"\t\t"+Modifier.toString (field.getModifiers ()) );
        }
        System.out.println ( "-------------------------------------" );
        Field fis= catClass.getField ( "as" );
        System.out.println ( fis );
        
        
    }
}
