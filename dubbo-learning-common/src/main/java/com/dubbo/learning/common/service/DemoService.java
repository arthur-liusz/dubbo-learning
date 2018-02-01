package com.dubbo.learning.common.service;

/**
 * dubbo学习项目，demo服务接口
 * 
 * @author arthur
 *
 */
public interface DemoService {

	/**
	 * 在传入的参数前面加上一段固定的前缀“hello，”，然后返回
	 * 
	 * @param name
	 *            传入参数
	 * @return 添加前缀后的结果
	 */
	public String sayHello(String name);

	/**
	 * 在传入的参数前面加上一段固定的前缀“goodbye，”，然后返回
	 * 
	 * @param name
	 *            传入参数
	 * @return 添加前缀后的结果
	 */
	public String sayGoodbye(String name);
}