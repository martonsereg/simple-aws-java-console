package com.martons.aws;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.martons.aws.engine.SimpleAWSEngine;

public class SimpleAWSBootstrap {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleAWSBootstrap.class.getPackage().getName());
		applicationContext.getBean(SimpleAWSEngine.class).run(args);
		applicationContext.close();
	}
}
