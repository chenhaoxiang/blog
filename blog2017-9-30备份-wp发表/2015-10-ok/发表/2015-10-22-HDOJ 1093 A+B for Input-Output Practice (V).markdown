---
layout: post
title: "HDOJ 1093 A+B for Input-Output Practice (V)"
date: 2015-10-22 04:03:50 +0800
comments: true
categories:----- HDOJ-JAVA
tags: [lines]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Your task is to calculate the sum of some integers.Input 
Input contains an integer N in the first line, and then N lines follow. Each line starts with a integer M, and then M inte 
---


Problem Description 
Your task is to calculate the sum of some integers.Input 
Input contains an integer N in the first line, and then N lines follow. Each line starts with a integer M, and then M inte
&#60;!-- more --&#62;
----------

Problem Description
Your task is to calculate the sum of some integers.
 

Input
Input contains an integer N in the first line, and then N lines follow. Each line starts with a integer M, and then M integers follow in the same line. 
 

Output
For each group of input integers you should output their sum in one line, and with one line of output for each line in input. 
 

Sample Input
2
4 1 2 3 4
5 1 2 3 4 5
 

Sample Output
10
15

```
import java.util.*;
class Main{
    public static void main(String arge[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n--&#62;0){
            int m =sc.nextInt();
            int sum=0;
            for(int i=0;i&#60;m;i++){
                int a=sc.nextInt();
                sum+=a;
            }
            System.out.println(sum);
        }
    }
}
```