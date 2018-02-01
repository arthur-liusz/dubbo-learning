package com.dubbo.learning.provider.service.impl;

import java.util.Objects;

import com.dubbo.learning.common.model.ExampleUserModel;
import com.dubbo.learning.common.model.Sex;
import com.dubbo.learning.common.service.ExampleService;

/**
 * dubbo学习研究项目，示例接口实现类
 * 
 * @author arthur
 *
 */
public class ExampleServiceImpl implements ExampleService {

	@Override
	public ExampleUserModel prefixExampleUserModel(ExampleUserModel exampleUserModel) {
		Objects.requireNonNull(exampleUserModel, "ExampleUserModel instance should not be null!");

		ExampleUserModel result = new ExampleUserModel();
		result.setId(Long.parseLong("123" + exampleUserModel.getId()));
		result.setAge(Integer.parseInt("1234" + exampleUserModel.getAge()));
		result.setSex(Sex.MALE);
		result.setName("abc" + exampleUserModel.getName());
		result.setDescription("abcd" + exampleUserModel.getDescription());

		return result;
	}
}