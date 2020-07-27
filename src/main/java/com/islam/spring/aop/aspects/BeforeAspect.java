package com.islam.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// could be Authentication Aspect
@Aspect
@Configuration
public class BeforeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.islam.spring.aop.business.*.*(..))")  //PointCut  // business package
//	@Before("execution(* com.islam.spring.aop..*.*(..))")  //parent & business & data packages
//	@Before("execution(* com.islam.spring.aop.*.*.*(..))")  //business & data packages
	public void before(JoinPoint joinPoint) {
		//advice
		logger.info("Before execution of {}", joinPoint);
	}
	
	@Before("com.islam.spring.aop.config.PointCutConfig.bothLayersExecution()")
	public void before1(JoinPoint joinPoint) {
		logger.info("Before1 execution of {}", joinPoint);
	}
	
	@Before("com.islam.spring.aop.config.PointCutConfig.allBeansContainsDao()")
	public void beforeBeanNameContains(JoinPoint joinPoint) {
		logger.info("beforeBeanNameContains Dao of {}", joinPoint);
	}
	
	@Before("com.islam.spring.aop.config.PointCutConfig.allCallswithDataPackage()")
	public void beforeWithin(JoinPoint joinPoint) {
		logger.info("before within {}", joinPoint);
	}
	
}
