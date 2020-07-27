package com.islam.spring.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.islam.spring.aop.data.Dao2;

@Service
public class Business2 {

	@Autowired
	private Dao2 dao2;
	
	public String calc() {
		return dao2.retriveData();
	}
}
