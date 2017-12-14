package com.chenhaoxiang.template;

/**
 * 具体子类
 * 提供了咖啡制备的具体实现
 * 
 * @author chenhaoxiang
 *
 */
public class Coffee extends RefreshBeverage{

	@Override
	protected void brew() {
		System.out.println("冲泡咖啡...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("加入咖啡调料...");
	}

}
