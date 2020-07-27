package com.islam.spring.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.islam.spring.aop.aspects.TrackTimeAnnotation;
import com.islam.spring.aop.data.Dao1;

@Service
public class Business1 {

	@Autowired
	private Dao1 dao1;
	
	public String calc() {
//		throw new RuntimeException("throw Exception");
		return dao1.retriveData();
	}
	
	@TrackTimeAnnotation
	public String calcSomething() {
		return dao1.retriveData();
	}
}
