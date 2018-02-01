package com.dubbo.learning.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.learning.common.service.DemoService;

/**
 * dubbo学习项目，服务接口提供方的程序入口主类
 * 
 * @author arthur
 *
 */
public class ProviderApplication {

	/**
	 * 程序入口main方法
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {
		String contextFile = "provider-spring-application-context.xml";

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(contextFile);
		System.out.println("********provider loaded spring context== " + context);

		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService");
		System.out.println("********got demoService instance from context== " + demoService);

		String result = demoService.sayHello("provider");
		System.out.println("********got return result== " + result);

		Thread.currentThread().join();
	}
}