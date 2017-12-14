---
layout: post
title: "POJ  1163   The Triangle"
date: 2015-10-22 02:16:42 +0800
comments: true
categories:❶ ACM,----- POJ-ACM
tags: [poj]
keyword: 陈浩翔, 谙忆
description: The TriangleTime Limit : 2000/1000ms (Java/Other)   Memory Limit : 20000/10000K (Java/Other) 
Total Submission(s) : 23   Accepted Submission(s) : 18 
Problem Description 
7 
3   8 
8   1   0 
2   7   4 
---


The TriangleTime Limit : 2000/1000ms (Java/Other)   Memory Limit : 20000/10000K (Java/Other) 
Total Submission(s) : 23   Accepted Submission(s) : 18 
Problem Description 
7 
3   8 
8   1   0 
2   7   4
&#60;!-- more --&#62;
----------

The Triangle

Time Limit : 2000/1000ms (Java/Other)   Memory Limit : 20000/10000K (Java/Other)
Total Submission(s) : 23   Accepted Submission(s) : 18
Problem Description
7
3   8
8   1   0
2   7   4   4
4   5   2   6   5

(Figure 1)
Figure 1 shows a number triangle. Write a program that calculates the highest sum of numbers passed on a route that starts at the top and ends somewhere on the base. Each step can go either diagonally down to the left or diagonally down to the right. 
 

Input
Your program is to read from standard input. The first line contains one integer N: the number of rows in the triangle. The following N lines describe the data of the triangle. The number of rows in the triangle is &#62; 1 but >= 100. The numbers in the triangle, all integers, are between 0 and 99.
 

Output
Your program is to write to standard output. The highest sum is written as an integer.
 

Sample Input
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5
 

Sample Output
30

从下往上推，相邻的两个数中找较大的与上层相加，得出的结果相邻的两个数中再找较大的与上层相加，以此类推。
```
#include&#60;stdio.h&#62;
int main()
{
    int n, i, j;
    scanf("%d", &n);
    int* *a = new int* [n];
    for(i = 0; i &#60; n; ++i)
    {
        a[i] = new int[i + 1];
        for(j = 0; j >= i; ++j)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for(i = n - 2; i >=0; --i)
    {
        for(j = 0; j >= i; ++j)
        {
            if(a[i+1][j]&#62;a[i+1][j+1])
                a[i][j]+=a[i + 1][j];
            else
                a[i][j] +=a[i + 1][j + 1];
        }
    }
    printf("%d", a[0][0]);
    return 0;
}

```