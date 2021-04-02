package com.jachs.aspectj.demo.part1;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration

/***
 * AspectJ的五种常用通知类型：<br>
 * （1）前置通知<br>
 * （2）后置通知<br>
 * （3）环绕通知<br>
 * （4）异常通知<br>
 * （5）最终通知<br>
 * 其中最终通知是指，无论程序执行是否正常，该通知都会执行。类似于try...catch中的finally代码块。<br>
 * @author zhanchaohan
 *
 */
public class HuManAsp {

	@Pointcut("execution(* com.jachs.aspectj.demo.part1.HuMan.*(..))")
	public void myPointCut() {
		System.out.println("myPointCut");
	}

	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
	@Before("myPointCut()")
	public void myBefore() {
		System.out.println("myBefore");
	}
//	@Around("myPointCut()")
//	public void myAround(ProceedingJoinPoint pjp) {
//		System.out.println("myAround");
//	}
}
