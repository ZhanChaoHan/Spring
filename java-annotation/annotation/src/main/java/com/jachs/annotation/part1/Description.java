package com.jachs.annotation.part1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解是什么意思呢？</br>
元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。</br>
如果难于理解的话，你可以这样理解。元注解也是一张标签，但是它是一张特殊的标签，它的作用和目的就是给其他普通的标签进行解释说明的。</br>
元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。</br>

@Retention</br>
Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。</br>
它的取值如下：</br>
RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。</br>
RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。</br>
RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。</br>

@Documented</br>
顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。</br>

@Target</br>
Target 是目标的意思，@Target 指定了注解运用的地方。</br>
你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。</br>
类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。@Target 有下面的取值</br>
ElementType.ANNOTATION_TYPE 可以给一个注解进行注解</br>
ElementType.CONSTRUCTOR 可以给构造方法进行注解</br>
ElementType.FIELD 可以给属性进行注解</br>
ElementType.LOCAL_VARIABLE 可以给局部变量进行注解</br>
ElementType.METHOD 可以给方法进行注解</br>
ElementType.PACKAGE 可以给一个包进行注解</br>
ElementType.PARAMETER 可以给一个方法内的参数进行注解</br>
ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举</br>

@Inherited</br>
Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。</br>


@Repeatable</br>
Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。</br>
什么样的注解会多次应用呢？通常是注解的值可以同时取多个。</br>
举个例子，一个人他既是程序员又是产品经理,同时他还是个画家。</br>
 * @author zhanchaohan
 * 
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();
    String author();
    int age() default 15;
}
