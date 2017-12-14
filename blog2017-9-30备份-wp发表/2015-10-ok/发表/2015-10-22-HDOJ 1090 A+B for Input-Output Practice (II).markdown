---
layout: post
title: "HDOJ 1090 A+B for Input-Output Practice (II)"
date: 2015-10-22 04:01:02 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [lines]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to Calculate a + b.Input 
Input contains an integer N in the first line, and then N lines follow. Each line consists of a pair of integers a and b, separated by a spac 
---


Problem Description 
Your task is to Calculate a + b.Input 
Input contains an integer N in the first line, and then N lines follow. Each line consists of a pair of integers a and b, separated by a spac
&#60;!-- more --&#62;
----------

Problem Description
Your task is to Calculate a + b.
 

Input
Input contains an integer N in the first line, and then N lines follow. Each line consists of a pair of integers a and b, separated by a space, one pair of integers per line.
 

Output
For each pair of input integers a and b you should output the sum of a and b in one line, and with one line of output for each line in input. 
 

Sample Input
2
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
    int t = sc.nextInt();
    while(t--&#62;0){
      int a=sc.nextInt();
      int b=sc.nextInt();
      System.out.println(a+b);   
    }
  }
}
```