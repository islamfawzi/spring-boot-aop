package com.islam.spring.aop;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.islam.spring.aop.business.Business1;
import com.islam.spring.aop.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Business1 business1;
	
	@Autowired
	private Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info(business1.calc());
		logger.info(business2.calc());
		
		//annotation aspect
		logger.info(business1.calcSomething());
	}

}
