---
layout: post
title: "HDOJ 1091  A+B for Input-Output Practice (III)"
date: 2015-10-22 04:01:58 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to Calculate a + b.Input 
Input contains multiple test cases. Each test case contains a pair of integers a and b, one pair of integers per line. A test case containing 
---


Problem Description 
Your task is to Calculate a + b.Input 
Input contains multiple test cases. Each test case contains a pair of integers a and b, one pair of integers per line. A test case containing
&#60;!-- more --&#62;
----------

Problem Description
Your task is to Calculate a + b.
 

Input
Input contains multiple test cases. Each test case contains a pair of integers a and b, one pair of integers per line. A test case containing 0 0 terminates the input and this test case is not to be processed.
 

Output
For each pair of input integers a and b you should output the sum of a and b in one line, and with one line of output for each line in input. 
 

Sample Input
1 5
10 20
0 0
 

Sample Output
6
30


```
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc =new Scanner(System.in);
    while(sc.hasNext()){

    int a=sc.nextInt();
    int b=sc.nextInt();
    if(a==0&&b==0)
      return ;  
    System.out.println(a+b);
    }
  }
}
```