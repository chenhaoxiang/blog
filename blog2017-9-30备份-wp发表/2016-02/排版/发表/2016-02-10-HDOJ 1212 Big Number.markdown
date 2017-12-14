---
layout: post
title: "HDOJ 1212 Big Number"
date: 2016-02-10 04:25:08 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 大数问题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
As we know, Big Number is always troublesome. But it’s really important in our ACM. And today, your task is to write a program to calculate A mod B.To make the problem easier, I pr 
---


Problem Description 
As we know, Big Number is always troublesome. But it’s really important in our ACM. And today, your task is to write a program to calculate A mod B.To make the problem easier, I pr
&#60;!-- more --&#62;
----------

Problem Description
As we know, Big Number is always troublesome. But it's really important in our ACM. And today, your task is to write a program to calculate A mod B.

To make the problem easier, I promise that B will be smaller than 100000.

Is it too hard? No, I work it out in 10 minutes, and my program contains less than 25 lines.

 

Input
The input contains several test cases. Each test case consists of two positive integers A and B. The length of A will not exceed 1000, and B will be smaller than 100000. Process to the end of file.

 

Output
For each test case, you have to ouput the result of A mod B.

 

Sample Input
2 3
12 7
152455856554521 3250
 

Sample Output
2
5
1521

public BigDecimal remainder(BigDecimal divisor)返回其值为 (this % divisor) 的 BigDecimal。 
余数由 this.subtract(this.divideToIntegralValue(divisor).multiply(divisor)) 给出。注意，这不是模操作（结果可以为负）。 
参数：
divisor - 此 BigDecimal 要除以的值。 
返回：
this % divisor。 


```java
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			BigDecimal a = sc.nextBigDecimal();
			int b = sc.nextInt();
			System.out.println(a.remainder(new BigDecimal(b)));
		}
	}

}

```