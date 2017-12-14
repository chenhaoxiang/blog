---
layout: post
title: "HDOJ 1096 A+B for Input-Output Practice (VIII)"
date: 2015-10-22 04:07:34 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: [hdoj]
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
For each group of input integers you should output their sum in one line, and you must note that there is a blank line between outputs.
 

Sample Input
3
4 1 2 3 4
5 1 2 3 4 5
3 1 2 3
 

Sample Output
10

15

6


```
import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        int m=sc.nextInt();
        while(m--&#62;0){
            int n=sc.nextInt();
            int sum=0;
            for(int i=0;i&#60;n;i++){
            int a=sc.nextInt();
            sum+=a;
            }
            if(isFirst){
                isFirst=false;
            }else{
                System.out.println();
            }
            System.out.println(sum);
        }
    }
}
```