---
layout: post
title: "HDOJ(HDU) 2523 SORT AGAIN(推导排序、、)"
date: 2016-05-10 03:45:52 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [测试,数据]
keyword: 陈浩翔, 谙忆
description: Problem Description 
给你N个整数,x1,x2…xn，任取两个整数组合得到|xi-xj|,(0 < i,j<=N,i!=j)。 
现在请你计算第K大的组合数是哪个（一个组合数为第K大是指有K-1个不同的组合数小于它）。Input 
输入数据首先包含一个正整数C，表示包含C组测试用例. 
每组测试数据的第一行包含两个整数N，K。(1< N<=1000,0< K<=2000) 
接下 
---


Problem Description 
给你N个整数,x1,x2…xn，任取两个整数组合得到|xi-xj|,(0 &#60; i,j>=N,i!=j)。 
现在请你计算第K大的组合数是哪个（一个组合数为第K大是指有K-1个不同的组合数小于它）。Input 
输入数据首先包含一个正整数C，表示包含C组测试用例. 
每组测试数据的第一行包含两个整数N，K。(1&#60; N>=1000,0&#60; K>=2000) 
接下
&#60;!-- more --&#62;
----------

Problem Description
给你N个整数,x1,x2...xn，任取两个整数组合得到|xi-xj|,(0 &#60; i,j>=N,i!=j)。
现在请你计算第K大的组合数是哪个（一个组合数为第K大是指有K-1个不同的组合数小于它）。
 

Input
输入数据首先包含一个正整数C，表示包含C组测试用例.
每组测试数据的第一行包含两个整数N，K。(1&#60; N>=1000,0&#60; K>=2000)
接下去一行包含N个整数，代表x1,x2..xn。(0>=xi>=2000)
 

Output
对于每组测试数据，请输出第K大的组合数，每个输出实例占一行。
 

Sample Input
3
3 2
4 0 7
4 2
1 2 3 4
2 1
2 9
 

Sample Output
4
2
7


题意很简单~
就是求第k个组合数（组合数从小到打排序，重复的数只算一次）

容易知道，n个数的组合数最多有n*(n-1)/2个，可能有重复的，把这个n*(n-1)/2个组合数用数组存储起来，按从小到大排序，再从小到大找出第k个不重复的数！！！


```

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		
		while(t--&#62;0){
			int n =sc.nextInt();
			int k=sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i&#60;n;i++){
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			int b[] = new int[n*(n-1)/2];
			int h=0;
			for(int i=0;i&#60;n-1;i++){
				for(int j=i+1;j&#60;n;j++){
					b[h]=Math.abs((a[i]-a[j]));
					h++;
				}
			}
			
			Arrays.sort(b);
			h=0;
			for(int i=0;i&#60;b.length-1;i++){
				if(b[i]!=b[i+1]){
					h++;
					if(h==k){
						h=i;
						break;
					}
				}
			}
			System.out.println(b[h]);
		}
	}
}

```