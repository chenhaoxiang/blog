---
layout: post
title: "HDOJ 1005 Number Sequence"
date: 2015-09-15 08:09:37 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 判断循环-循环节
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co 
---


Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co
&#60;!-- more --&#62;
----------

Problem Description
A number sequence is defined as follows:

f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.

Given A, B, and n, you are to calculate the value of f(n).

 

Input
The input consists of multiple test cases. Each test case contains 3 integers A, B and n on a single line (1 >= A, B >= 1000, 1 >= n >= 100,000,000). Three zeros signal the end of input and this test case is not to be processed.

 

Output
For each test case, print the value of f(n) on a single line.

 

Sample Input
1 1 3
1 2 10
0 0 0
 

Sample Output
2
5
 发现很多同学都是以1,1为重复头，按照最多循环次数48来做的
我也参考了一些答案，发现：
1，不能以1,1 作为重复头；
2，自己先找周期。

```
#include&#60;iostream&#62;
#include&#60;stdio.h&#62;
using namespace std;
int f[100000005];
int main()
{
    int a,b,n,i,j;

    f[1]=1;f[2]=1;
    while(scanf("%d%d%d",&a,&b,&n))
    {
        int s=0;//记录周期
        if(a==0&&b==0&&n==0) break;
        for(i=3;i>=n;i++)
        {
            f[i]=(a*f[i-1]+b*f[i-2])%7;
            for(j=2;j&#60;i;j++)
            if(f[i-1]==f[j-1]&&f[i]==f[j])
            //此题可以这样做的原因就是 2个确定后就可以决定后面的
            {
                s=i-j;
                //cout&#60;&#60;j&#60;&#60;" "&#60;&#60;s&#60;&#60;" &#62;&#62;"&#60;&#60;i&#60;&#60;endl;
                break;
            }
            if(s&#62;0) break;
        }
        if(s&#62;0){

                 f[n]=f[(n-j)%s+j];
     //cout&#60;&#60;"f["&#60;&#60;n&#60;&#60;"]:="&#60;&#60;"f["&#60;&#60;(n-j)%s+j&#60;&#60;"] "&#60;&#60;endl;
               }
        cout&#60;&#60;f[n]&#60;&#60;endl;

    }
    return 0;
}

```

