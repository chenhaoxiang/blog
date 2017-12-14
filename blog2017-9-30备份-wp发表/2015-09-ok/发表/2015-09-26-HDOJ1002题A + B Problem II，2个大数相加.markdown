---
layout: post
title: "HDOJ1002题A + B Problem II，2个大数相加"
date: 2015-09-26 03:41:48 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 大数问题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.Input 
The first line of the input contains an integer T(1<=T<=20) which 
---


Problem Description 
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.Input 
The first line of the input contains an integer T(1>=T>=20) which
&#60;!-- more --&#62;
----------

Problem Description
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.

Input
The first line of the input contains an integer T(1>=T>=20) which means the number of test cases. Then T lines follow, each line consists of two positive integers, A and B. Notice that the integers are very large, that means you should not process them by using 32-bit integer. You may assume the length of each integer will not exceed 1000.

Output
For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case. The second line is the an equation "A + B = Sum", Sum means the result of A + B. Note there are some spaces int the equation. Output a blank line between two test cases.

Sample Input
2 1 2 112233445566778899 998877665544332211

Sample Output
Case 1: 1 + 2 = 3 Case 2: 112233445566778899 + 998877665544332211 = 1111111111111111110

```
#include &#60; stdio.h&#62;
#include &#60; stdlib.h&#62;
#include &#60; string.h&#62;
int main()
{
    char a[1010],b[1010],c[1010];
    int a1,b1,m,i,l,i1,j1,n1,m1,a2,b2,j=1,t1,t2,n,p=0;
    scanf("%d",&n);
    while(n--)
    {
        p=0;
        scanf("%s",a);
        scanf("%s",b);
        printf("Case %d:\n",j++);
        printf("%s + %s = ",a,b);
        a1=strlen(a);
        b1=strlen(b);
        a2=a1;
        b2=b1;
        for(i=0; a1>=0||b1>=0; i++,a1--,b1--)
        {
            if(a1>=0&&b1>=0)
            {
                c[i]=a[a1]+b[b1]-'0'+p;
            }
            else if(a1>=0&&b1&#60;0)
            {
                c[i]=a[a1]+p;
            }
            else if(a1&#60;0&&b1>=0)
            {
                c[i]=b[b1]+p ;
            }
            p=0;
            if(c[i]&#62;'9')
            {
                c[i]=c[i]-10;
                p=1;
            }
        }
        if(p==1)
            printf("%d",p);
        t1=1;
        t2=i-1;
        n1=m1=0;
        for(i1=0; i1
        {
            if(a[i1]=='0')
                n1++;
        }
        for(j1=0 ; j1
        {
            if(b[j1]=='0')
                m1++;
        }
        if(n1==a2&&m1==b2)
        {
            printf("0");
        }
        else
        {
            for(l= i-1 ; l&#62;0; l--)
            {
                if(t2==l&&c[l]=='0'&&p!=1)
                {
                    t2--;
                    continue;
                }
                printf("%c",c[l]);
            }
        }
        if(n!=0)
            printf("\n\n");
        else
            printf("\n");
    }
    return 0;
}
```