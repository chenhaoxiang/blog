---
layout: post
title: "HDOJ1021题 Fibonacci Again   应用求模公式"
date: 2015-08-21 05:53:13 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 模拟/推导/打表
tags: [求模公式-HDOJ,1021]
keyword: 陈浩翔, 谙忆
description: Problem Description 
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).Input 
Input consists of a sequence of lines, each containing an integer n. (n < 1,0
求模公式 
---


Problem Description 
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).Input 
Input consists of a sequence of lines, each containing an integer n. (n &#60; 1,0
求模公式
&#60;!-- more --&#62;
----------

Problem Description
There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).

 

Input
Input consists of a sequence of lines, each containing an integer n. (n &#60; 1,000,000).

 

Output
Print the word "yes" if 3 divide evenly into F(n).

Print the word "no" if not.

 

Sample Input
0
1
2
3
4
5
 

Sample Output
no
no
yes
no
no
no

应用求模公式
        （1） (a + b) % p = (a % p + b % p) % p 
        （2） (a - b) % p = (a % p - b % p) % p 
        （3） (a * b) % p = (a % p * b % p) % p 
        （4）  a ^ b % p = ((a % p)^b) % p 
        如果不用的话会溢出。
代码：

```
#include &#60;iostream&#62;
#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;
#include&#60;string.h&#62;
using namespace std;

int main()
{
    int a[1000001],i,j,s;
    a[0]=7;a[1]=11;
    for(i=2;i&#60;1000001;i++)
    {
        a[i]=(a[i-1]%3+a[i-2]%3)%3;//只写最后那个%3也可以
    }
    while(~scanf("%d",&s))
    {
        if(a[s]%3==0)
            printf("yes\n");
        else
            printf("no\n");
    }
    return 0;
}

```
