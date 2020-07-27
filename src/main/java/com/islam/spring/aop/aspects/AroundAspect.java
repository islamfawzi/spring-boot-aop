package com.islam.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.islam.spring.aop.config.PointCutConfig.businessLayerExecution()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis() - startTime;
		
		logger.info("around executing {} took time {}", joinPoint, endTime);
		
	}
	
	@Around("com.islam.spring.aop.config.PointCutConfig.trackTimeAnnotation()")
	public void trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis() - startTime;
		
		logger.info("around annotation {} took time {}", joinPoint, endTime);
	}
}
