---
layout: post
title: "HDOJ 2117 Just a Numble（模拟除法）"
date: 2016-03-24 07:01:33 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 模拟/推导/打表
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Now give you two integers n m, you just tell me the m-th number after radix point in 1/n,for example n=4,the first numble after point is 2,the second is 5,and all 0 followedInput 
---


Problem Description 
Now give you two integers n m, you just tell me the m-th number after radix point in 1/n,for example n=4,the first numble after point is 2,the second is 5,and all 0 followedInput
&#60;!-- more --&#62;
----------

Problem Description
Now give you two integers n m, you just tell me the m-th number after radix point in 1/n,for example n=4,the first numble after point is 2,the second is 5,and all 0 followed
 

Input
Each line of input will contain a pair of integers for n and m(1>=n>=10^7,1>=m>=10^5)
 

Output
For each line of input, your program should print a numble on a line,according to the above rules
 

Sample Input
4 2
5 7
123 123
 

Sample Output
5
0
8


开始想用JAVA的大数做的，可是超时了。。。
所以只有走上算法的路，用了模拟。
```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int sum = 1;
			int t=0;
			for(int i=0;i&#60;m;i++){
				if(sum==0){
					t=0;
					break;
				}
				sum = sum*10;
				t = sum/n;
				sum = sum%n;
				
			}
			System.out.println(t%10);
		}
		
	}
	
}

```