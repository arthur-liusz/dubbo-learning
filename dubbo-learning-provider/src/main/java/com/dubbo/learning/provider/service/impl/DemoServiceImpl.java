package com.dubbo.learning.provider.service.impl;

import com.dubbo.learning.common.service.DemoService;

/**
 * dubbo学习项目,demo服务接口实现类
 * 
 * @author arthur
 *
 */
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		String result = (new StringBuilder()).append("Hello, ").append(name).toString();
		return result;
	}

	@Override
	public String sayGoodbye(String name) {
		String result = (new StringBuilder()).append("Goodbye, ").append(name).toString();
		return result;
	}
}