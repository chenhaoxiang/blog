---
layout: post
title: "HDOJ 1002 A + B Problem II"
date: 2016-02-02 05:18:03 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.Input 
The first line of the input contains an integer T(1<=T<=20) which 
---


Problem Description 
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.Input 
The first line of the input contains an integer T(1>=T>=20) which
&#60;!-- more --&#62;
----------


Problem Description
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.

 

Input
The first line of the input contains an integer T(1>=T>=20) which means the number of test cases. Then T lines follow, each line consists of two positive integers, A and B. Notice that the integers are very large, that means you should not process them by using 32-bit integer. You may assume the length of each integer will not exceed 1000.

 

Output
For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case. The second line is the an equation "A + B = Sum", Sum means the result of A + B. Note there are some spaces int the equation. Output a blank line between two test cases.

 

Sample Input
2
1 2
112233445566778899 998877665544332211
 

Sample Output
Case 1:
1 + 2 = 3

Case 2:
112233445566778899 + 998877665544332211 = 1111111111111111110


```java
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t=1;
		while(n--&#62;0){
			if(t==1){
				
			}else{
				System.out.println();
			}
			
			
			BigDecimal a = sc.nextBigDecimal();
			BigDecimal b = sc.nextBigDecimal();
			BigDecimal c = a.add(b);
			System.out.println("Case "+t+":");
			System.out.println(a+" + "+b+" = "+c);
			t++;
		}
		
		
		
	}
	

}

```