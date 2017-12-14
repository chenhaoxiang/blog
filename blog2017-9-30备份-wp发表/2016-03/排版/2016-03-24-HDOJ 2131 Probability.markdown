---
layout: post
title: "HDOJ 2131 Probability"
date: 2016-03-24 06:06:52 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Mickey is interested in probability recently. One day , he played a game which is about probability with mini.First mickey gives a letter and a word to mini.Then mini calculate the 
---


Problem Description 
Mickey is interested in probability recently. One day , he played a game which is about probability with mini.First mickey gives a letter and a word to mini.Then mini calculate the
&#60;!-- more --&#62;
----------

Problem Description
Mickey is interested in probability recently. One day , he played a game which is about probability with mini.First mickey gives a letter and a word to mini.Then mini calculate the probability that the letter appears in the word.For example,give you the letter "a" and the word "apple". the probability of this case is 0.20000.
 

Input
The input contains several test cases. Each test case consists of a letter and a word.The length of the word is no longer than 200.
 

Output
For each test case, print the probability rounded to five digits after the decimal point.

 

Sample Input
a apple
c Candy
a banana
 

Sample Output
0.20000
0.20000
0.50000


题意：
先输入一个字符，再输入一个字符串，然后输出该字符在字符串中占多少比例；保留5位小数。
属于简单题。

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String a = sc.next();
			String strs = sc.next();
			int anum = 0;
			String strss = "";
			for(int i=0;i&#60;strs.length();i++){
				strss = strs.charAt(i)+"";
				if(a.equalsIgnoreCase(strss)){
					anum++;
				}
			}
			double num = (double)((double)anum/(double)strs.length());
			System.out.printf("%.5f\t\n",num);
		}
	}
}

```