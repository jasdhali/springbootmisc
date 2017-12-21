package com.spring.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);

/*	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	    
	    LOGGER.debug(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}*/
	
/*	@Before("@annotation(LogExecutionTime)")
	public void beforeMethodExecution(JoinPoint joinPoint,LogExecutionTime executionTime) throws Throwable {
		Object[] args = joinPoint.getArgs(); 
		String name = joinPoint.getSignature().getName();
		
		String mthdNm = executionTime.methodName();
		int wt = executionTime.weight();
		
		String msg = joinPoint.getSignature() + " has args=>> " +  args + " and name is >>"+name;
		if( mthdNm!=null ){
			msg += "method ==>" + mthdNm;
		}
		if( wt>0){
			msg += " and method weight ==>" + wt;
		}
		LOGGER.debug( msg );
	    System.out.println(msg);
	}
	*/
	@After("@annotation(logExecutionTime)")
	public void afterMethodExecution(JoinPoint joinPoint,LogExecutionTime logExecutionTime) throws Throwable {
		Object[] args = joinPoint.getArgs(); 
		String name = joinPoint.getSignature().getName();
		String mthdNm = logExecutionTime.methodName();
		int wt = logExecutionTime.weight();
		
		String msg = joinPoint.getSignature() + " has args=>> " +  args + " and name is >>"+name;
		if( mthdNm!=null ){
			msg += "method ==>" + mthdNm;
		}
		if( wt>0){
			msg += " and method weight ==>" + wt;
		}
		LOGGER.debug( msg );
	    System.out.println(msg);
	}
	/*
    @After("@annotation(LogExecutionTime)")
	public void afterMethodExecution(JoinPoint joinPoint)  {
		Object[] args = joinPoint.getArgs(); 
		String name = joinPoint.getSignature().getName();
		
		String msg = joinPoint.getSignature() + " has args=>> " +  args + " and name is >>"+name;
		
		LOGGER.debug( msg );
	    System.out.println(msg);
	}
	*/
	@AfterThrowing("@annotation(LogExecutionTime)")
	public void afterThrowingMethodExecution(JoinPoint joinPoint)  {
		Object[] args = joinPoint.getArgs(); 
		String name = joinPoint.getSignature().getName();
		
	    LOGGER.debug(joinPoint.getSignature() + " has thrown exception =>>  and name is >>" + name);
	    System.out.println(joinPoint.getSignature() + " has thrown exception =>>  and name is >>" + name);
	}
	
}