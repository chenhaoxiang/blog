---
layout: post
title: "ZOJ Problem Set - 3758   素数"
date: 2015-08-23 06:36:23 +0800
comments: true
categories:❶ ACM,----- ZOJ-ACM,❺ 算法及基础题,----- 素数相关
tags: [zoj,中国]
keyword: 陈浩翔, 谙忆
description: Singles’ DayTime Limit: 2 Seconds      Memory Limit: 65536 KB Singles’ Day(or One’s Day), an unofficial holiday in China, is a pop culture entertaining holiday on November 11 for young Chinese to celeb 
---


Singles’ DayTime Limit: 2 Seconds      Memory Limit: 65536 KB Singles’ Day(or One’s Day), an unofficial holiday in China, is a pop culture entertaining holiday on November 11 for young Chinese to celeb
&#60;!-- more --&#62;
----------

Singles' Day

--------------------------------------------------------------------------------

Time Limit: 2 Seconds      Memory Limit: 65536 KB 

--------------------------------------------------------------------------------

Singles' Day(or One's Day), an unofficial holiday in China, is a pop culture entertaining holiday on November 11 for young Chinese to celebrate their bachelor life. With the meaning of single or bachelor of number '1' and the huge population of young single man. This festival is very popular among young Chinese people. And many Young bachelors organize parties and Karaoke to meet new friends or to try their fortunes that day. 

On Singles' Day, a supermarket has a promotional activity. Each customer will get a ticket on which there are two integers b and N, representing an integer M that only contains N digits 1 using b as the radix. And if the number M is a prime number, you will get a gift from the supermarket. 

Since there are so many customers, the supermarket manager needs your help. 

Input
There are multiple test cases. Each line has two integers b and N indicating the integer M, which might be very large. (2 >= b >= 16, 1 >= N >= 16) 

Output
If the customer can get a gift, output "YES", otherwise "NO". 

Sample Input
3 3
2 4
2 1
10 2

Sample Output
YES
NO
NO
YES

Hint
For the first sample, b=3, N=3, so M=(111)3, which is 13 in decimal. And since 13 is a prime number, the customer can get a gift, you should output "YES" on a line. 
题意很简单，就是求长度为n的b进制数在每一位都是1的情况下，是不是素数

```
#include &#60;stdio.h&#62;
#include&#60;math.h&#62;
int su(long long x);
int main()
{
    long long s,p;
    int n,m,i,j;
    while(~scanf("%d%d",&n,&m))
    {
        s=0;
        while(m--)
        {
            s=s+pow(n,m);
        }
            if(su(s)==1)
            {printf("YES\n");}
        else
            {printf("NO\n");}
    }
    return 0;
}
int su(long long x)
{
    long long i;
    if(x&#60;2)return 0;
    for(i=2;i*i>=x;i++)
        {
            if(x%i==0)
              return 0;
        }
    return 1;
}

```
