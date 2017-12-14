---
layout: post
title: "POJ  2390  Bank Interest"
date: 2015-10-23 06:20:54 +0800
comments: true
categories:❶ ACM,----- POJ-ACM
tags: [poj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is com 
---


Problem Description 
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is com
&#60;!-- more --&#62;
----------

Problem Description
Farmer John made a profit last year! He would like to invest it well but wonders how much money he will make. He knows the interest rate R (an integer between 0 and 20) that is compounded annually at his bank. He has an integer amount of money M in the range 100..1,000,000. He knows how many years Y (range: 0..400) he intends to invest the money in the bank. Help him learn how much money he will have in the future by compounding the interest for each year he saves. Print an integer answer without rounding. Answers for the test data are guaranteed to fit into a signed 32 bit integer.
 

Input
* Line 1: Three space-separated integers: R, M, and Y
 

Output
* Line 1: A single integer that is the number of dollars FJ will have after Y years.
 

Sample Input
5 5000 4
 

Sample Output
6077
 

```
#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;

int main(){
    int y;
    double r,m;
    scanf("%lf%lf%d",&r,&m,&y);
    int i;
    for(i=0;i&#60;y;i++){
        m+=m*(r/100.0);
    }
    int a=(int)m;
    printf("%d\n",a);
    return 0;
}

```