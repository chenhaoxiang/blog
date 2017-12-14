package com.chenhaoxiang.template;

/**
 * 抽象基类 为所有子类提供一个算法框架
 * 
 * 提神饮料
 * 
 * @author chenhaoxiang
 *
 */
public abstract class RefreshBeverage {
	/**
	 * final阻止子类对方法的复写 制备饮料的模板方法 封装了所有子类共同遵循的算法框架
	 */
	public final void prepareBeverageTemplate() {
		// 步骤1:将水煮沸
		boilWater();
		// 步骤2:泡制饮料
		brew();
		// 步骤3:将饮料倒入杯中
		pourInCup();
		if( isCustomerWantsCondiments() ){
			// 步骤4: 加入调味料
			addCondiments();
		}
	}
	
	/**
	 * 钩子(Hook)函数
	 * 提供一个默认或空的实现
	 * 具体的子类可以自行决定是否挂钩以及如何挂钩
	 * (让子类选择性的可以钩或者不钩中实现)
	 * 询问用户是否需要加入调料
	 * @return
	 */
	protected boolean isCustomerWantsCondiments() {
		return true;
	}

	/**
	 * 基本方法:将水煮沸
	 */
	private void boilWater() {
		System.out.println("将水煮沸");
	}
	
	
	/**
	 * 抽象的基本方法
	 * 泡制饮料
	 * 注意访问权限为protected
	 */
	protected abstract void brew();
	
	/**
	 * 通用方法
	 * 将饮料倒入杯中
	 */
	private void pourInCup() {
		System.out.println("将饮料倒入杯子中");
	}
	/**
	 * 抽象的基本方法
	 * 加入调味料
	 */
	protected abstract void addCondiments();

}
