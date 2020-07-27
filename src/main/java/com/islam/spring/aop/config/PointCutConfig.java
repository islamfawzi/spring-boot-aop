package com.islam.spring.aop.config;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutConfig {

	@Pointcut("execution(* com.islam.spring.aop.business.*.*(..))")
	public void businessLayerExecution() {}
	
	@Pointcut("execution(* com.islam.spring.aop.data.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("dataLayerExecution() || businessLayerExecution()")
	public void bothLayersExecution() {}
	
	@Pointcut("bean(*dao*)")  // any request to bean name contains dao
	public void allBeansContainsDao() {}
	
	@Pointcut("within(com.islam.spring.aop.data..*)")
	public void allCallswithDataPackage() {}
	
	@Pointcut("@annotation(com.islam.spring.aop.aspects.TrackTimeAnnotation)")
	public void trackTimeAnnotation() {}
	
	
}
