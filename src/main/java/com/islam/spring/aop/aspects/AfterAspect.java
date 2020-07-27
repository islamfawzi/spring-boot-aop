package com.islam.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("com.islam.spring.aop.config.PointCutConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("After excuting {}", joinPoint);
	}
	
	@AfterReturning(value="com.islam.spring.aop.config.PointCutConfig.businessLayerExecution()", returning="result")
	public void afterReturn(JoinPoint joinPoint, Object result) {
		logger.info("After excuting {} returing {}", joinPoint, result);
	}
	
	@AfterThrowing(value="com.islam.spring.aop.config.PointCutConfig.businessLayerExecution()", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		logger.info("After excuting {} throwing '{}'", joinPoint, exception.getMessage());
	}
}
