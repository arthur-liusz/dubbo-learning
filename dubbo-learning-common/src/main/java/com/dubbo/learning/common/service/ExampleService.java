package com.dubbo.learning.common.service;

import com.dubbo.learning.common.model.ExampleUserModel;

/**
 * dubbo学习研究项目，示例接口
 * 
 * @author arthur
 *
 */
public interface ExampleService {

	/**
	 * 加前缀，在ExampleUserModel对象的每个字段前面添加一个前缀，然后返回这个对象
	 * 
	 * @param exampleUserModel
	 * @return
	 */
	public ExampleUserModel prefixExampleUserModel(ExampleUserModel exampleUserModel);
}