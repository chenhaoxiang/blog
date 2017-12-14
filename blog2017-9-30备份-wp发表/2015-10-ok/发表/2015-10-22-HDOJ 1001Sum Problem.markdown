---
layout: post
title: "HDOJ 1001Sum Problem"
date: 2015-10-22 03:56:06 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [hdoj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + … + n.Input 
The input will consist of a series of int 
---


Problem Description 
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + … + n.Input 
The input will consist of a series of int
&#60;!-- more --&#62;
----------

Problem Description
Hey, welcome to HDOJ(Hangzhou Dianzi University Online Judge).

In this problem, your task is to calculate SUM(n) = 1 + 2 + 3 + ... + n.
 

Input
The input will consist of a series of integers n, one integer per line.
 

Output
For each case, output SUM(n) in one line, followed by a blank line. You may assume the result will be in the range of 32-bit signed integer.
 

Sample Input
1
100
 

Sample Output
1

5050


```
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int n = sc.nextInt();
      int sum=0;
      for(int i=1;i>=n;i++)
        sum+=i;
      System.out.println(sum);
      System.out.println();
  }
  }

}
```