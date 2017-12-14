package com.chenhaoxiang.template;

public class RefreshBeverageTest {
	
	public static void main(String[] args) {
		
		System.out.println("制备咖啡...");
		
		RefreshBeverage beverage = new Coffee();
		beverage.prepareBeverageTemplate();
		System.out.println("咖啡制作好了.");
		
		System.out.println("---------------------");
		
		System.out.println("开始制备茶.");
		RefreshBeverage beverage2 = new Tea();
		beverage2.prepareBeverageTemplate();
		System.out.println("茶制作成功.");
		
		
		
	}
}
