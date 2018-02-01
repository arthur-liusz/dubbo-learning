package com.dubbo.learning.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.learning.common.model.ExampleUserModel;
import com.dubbo.learning.common.model.Sex;
import com.dubbo.learning.common.service.DemoService;
import com.dubbo.learning.common.service.ExampleService;

/**
 * dubbo学习项目，服务接口消费方的程序入口主类
 * 
 * @author arthur
 *
 */
public class ConsumerApplication {
	/**
	 * 程序入口main方法
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws InterruptedException {
		String contextFile = "consumer-spring-application-context.xml";

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(contextFile);
		System.out.println("********consumer loaded spring context== " + context);

		context.start();

		// 第一个接口调用
		DemoService demoService = (DemoService) context.getBean("demoService");
		System.out.println("********got demoService instance from context== " + demoService);
		// 方法1
		String result = demoService.sayHello("consumer");
		System.out.println("********got return result== " + result);
		// 方法2
		String result2 = demoService.sayGoodbye("consumer");
		System.out.println("********got return result2== " + result2);

		// 第二个接口调用
		ExampleService exampleService = (ExampleService) context.getBean("exampleService");
		ExampleUserModel exampleUserModel = new ExampleUserModel();
		exampleUserModel.setId(123l);
		exampleUserModel.setAge(35);
		exampleUserModel.setSex(Sex.UNKNOWN);
		exampleUserModel.setName(", liushizhen");
		exampleUserModel.setDescription(", I am the consumer of ExampleService.");
		ExampleUserModel result3 = exampleService.prefixExampleUserModel(exampleUserModel);
		System.out.println(result3.toString());

		Thread.currentThread().join();
	}
}