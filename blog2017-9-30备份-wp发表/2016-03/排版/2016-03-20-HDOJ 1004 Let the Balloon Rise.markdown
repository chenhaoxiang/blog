---
layout: post
title: "HDOJ 1004 Let the Balloon Rise"
date: 2016-03-20 04:48:42 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges’ favorite time is guessing the most popular problem. When the contest is 
---


Problem Description 
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges’ favorite time is guessing the most popular problem. When the contest is
&#60;!-- more --&#62;
----------

Problem Description
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest is over, they will count the balloons of each color and find the result.

This year, they decide to leave this lovely job to you. 

 

Input
Input contains multiple test cases. Each test case starts with a number N (0 &#60; N >= 1000) -- the total number of balloons distributed. The next N lines contain one color each. The color of a balloon is a string of up to 15 lower-case letters.

A test case with N = 0 terminates the input and this test case is not to be processed.

 

Output
For each case, print the color of balloon for the most popular problem on a single line. It is guaranteed that there is a unique solution for each test case.

 

Sample Input
5
green
red
blue
red
red
3
pink
orange
pink
0
 

Sample Output
red
pink


题意：找输入的n组字符串出现次数最多的那个字符串，然后输出

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n==0){
				return ;
			}
			//System.out.println("n="+n);
			int anumber[][] = new int[n][2];
			//初始化
			for(int i=0;i&#60;n;i++){
				anumber[i][0] =0;
				anumber[i][1] =0;
			}
			String a[] = new String[n];
			for(int i=0;i&#60;n;i++){
				a[i] = sc.next();
				//System.out.println("i="+i+","+a[i]);
			}
			
			for(int i=0;i&#60;a.length-1;i++){
				for(int j=i+1;j&#60;a.length;j++){
					if(anumber[j][1]==0&&a[i].equals(a[j])){
						anumber[j][1]=1;
						anumber[i][0]++;
					}
				}
			}
			int max = anumber[0][0];
			int k=0;
			for(int i=0;i&#60;a.length;i++){
				if(anumber[i][0]&#62;max){
					max = anumber[i][0];
					k=i;
				}
			}
			
			System.out.println(a[k]);
			
			
			
		}
		
	}

}

```