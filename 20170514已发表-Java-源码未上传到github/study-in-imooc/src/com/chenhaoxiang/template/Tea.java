package com.chenhaoxiang.template;

/**
 * 具体子类
 * 提供了制备茶的具体实现
 * @author chenhaoxiang
 *
 */
public class Tea extends RefreshBeverage{

	@Override
	protected void brew() {
		System.out.println("用80度的热水浸泡茶叶5分钟...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("茶也要调味品？反正我不加.");
	}

	/**
	 * 子类通过覆盖的形式选择挂载钩子函数并且提供了一个符合自己需求的实现
	 */
	@Override
	protected boolean isCustomerWantsCondiments() {
		return false;//返回false ，addCondiments方法不会执行
	}
	
}
