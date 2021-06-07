package com.jachs.aspectj.part2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/***
 * 
 * @author zhanchaohan
 *
 */
@Aspect
public class HumanAspect {
	@Pointcut(value = "execution(* com.jachs.aspectj.part2.Human.*(..))")
	public void myPoint() {}
	
//	@Before(value = "myPoint()")
//	public void myBefore() {
//		System.out.println("myBefore");
//	}
//	@After(value = "myPoint()")
//	public void myAfter() {
//		System.out.println("myAfter");
//	}
	// 环绕通知
    @Around("myPoint()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        Object result = pjp.proceed();
        System.out.println("环绕后");
        return result;
    }
    // 后置 发生异常时不会执行
    @AfterReturning("myPoint()")
    public void returning() {
        System.out.println("After returning 后置");
    }
    // 发生异常
    @AfterThrowing("myPoint()")
    public void throwing() {
        System.out.println("发生异常了");
    }
}
