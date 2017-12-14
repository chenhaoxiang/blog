---
layout: post
title: "HDOJ 1089 A+B for Input-Output Practice (I)"
date: 2015-10-22 03:59:54 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [hdoj,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to Calculate a + b. 
Too easy?! Of course! I specially designed the problem for acm beginners.  
You must have found that some problems have the same titles with this 
---


Problem Description 
Your task is to Calculate a + b. 
Too easy?! Of course! I specially designed the problem for acm beginners.  
You must have found that some problems have the same titles with this
&#60;!-- more --&#62;
----------

Problem Description
Your task is to Calculate a + b.
Too easy?! Of course! I specially designed the problem for acm beginners. 
You must have found that some problems have the same titles with this one, yes, all these problems were designed for the same aim. 
 

Input
The input will consist of a series of pairs of integers a and b, separated by a space, one pair of integers per line. 
 

Output
For each pair of input integers a and b you should output the sum of a and b in one line, and with one line of output for each line in input. 
 

Sample Input
1 5
10 20
 

Sample Output
6
30


```

import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
    int a= sc.nextInt();
    int b=sc.nextInt();
    System.out.println(a+b);   
    }
  }
}
```