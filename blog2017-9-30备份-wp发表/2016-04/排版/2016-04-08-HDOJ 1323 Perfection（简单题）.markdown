---
layout: post
title: "HDOJ 1323 Perfection（简单题）"
date: 2016-04-08 12:59:09 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
From the article Number Theory in the 1994 Microsoft Encarta: “If a, b, c are integers such that a = bc, a is called a multiple of b or of c, and b or c is called a divisor or fact 
---


Problem Description 
From the article Number Theory in the 1994 Microsoft Encarta: “If a, b, c are integers such that a = bc, a is called a multiple of b or of c, and b or c is called a divisor or fact
&#60;!-- more --&#62;
----------

Problem Description
From the article Number Theory in the 1994 Microsoft Encarta: "If a, b, c are integers such that a = bc, a is called a multiple of b or of c, and b or c is called a divisor or factor of a. If c is not 1/-1, b is called a proper divisor of a. Even integers, which include 0, are multiples of 2, for example, -4, 0, 2, 10; an odd integer is an integer that is not even, for example, -5, 1, 3, 9. A perfect number is a positive integer that is equal to the sum of all its positive, proper divisors; for example, 6, which equals 1 + 2 + 3, and 28, which equals 1 + 2 + 4 + 7 + 14, are perfect numbers. A positive number that is not perfect is imperfect and is deficient or abundant according to whether the sum of its positive, proper divisors is smaller or larger than the number itself. Thus, 9, with proper divisors 1, 3, is deficient; 12, with proper divisors 1, 2, 3, 4, 6, is abundant." 
Given a number, determine if it is perfect, abundant, or deficient. 

 

Input
A list of N positive integers (none greater than 60,000), with 1 &#60; N &#60; 100. A 0 will mark the end of the list.

 

Output
The first line of output should read PERFECTION OUTPUT. The next N lines of output should list for each input integer whether it is perfect, deficient, or abundant, as shown in the example below. Format counts: the echoed integers should be right justified within the first 5 spaces of the output line, followed by two blank spaces, followed by the description of the integer. The final line of output should read END OF OUTPUT.

 

Sample Input
15 28 6 56 60000 22 496 0
 

Sample Output
PERFECTION OUTPUT
   15  DEFICIENT
   28  PERFECT
    6  PERFECT
   56  ABUNDANT
60000  ABUNDANT
   22  DEFICIENT
  496  PERFECT
END OF OUTPUT


题意也比较容易理解：找一个数的约数之和是不是和这个数相等，
或者是大于，还是小于。
如果相等，后面接：PERFECT
如果约数和小于这个数，后面接：DEFICIENT
如果约数和大于这个数，后面接：ABUNDANT
然后。。。就写吧。水题

```java
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strNum = sc.nextLine();
		String strsNum[] = strNum.split(" ");
		int[] num = new int[strsNum.length-1];
		
		for(int i=0;i&#60;num.length;i++){
			num[i]=Integer.parseInt(strsNum[i]);
		}
		System.out.println("PERFECTION OUTPUT");
		for(int i=0;i&#60;num.length;i++){
			strNum = "ABUNDANT";
			if(isTrue(num[i])==-1){
				strNum = "DEFICIENT";
			}
			if(isTrue(num[i])==0){
				strNum = "PERFECT";
			}
			System.out.printf("%5d",num[i]);
			System.out.println("  "+strNum);
		}
		System.out.println("END OF OUTPUT");
		
	}

	private static int isTrue(int i) {
		int sum=0;//约数之和
		for(int k=1;k>=i/2;k++){
			if(i%k==0){
				sum=sum+k;
			}
		}
		if(sum&#60;i){
			return -1;
		}
		if(sum==i){
			return 0;
		}
		return 1;
	}

}

```