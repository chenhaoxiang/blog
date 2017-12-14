---
layout: post
title: "HDOJ 1157  Who's in the Middle"
date: 2015-10-26 07:32:46 +0800
comments: true
categories:----- HDOJ-C++
tags: [hdoj]
keyword: 陈浩翔, 谙忆
description: Problem Description 
FJ is surveying his herd to find the most average cow. He wants to know how much milk this ‘median’ cow gives: half of the cows give as much or more than the median; half give as m 
---


Problem Description 
FJ is surveying his herd to find the most average cow. He wants to know how much milk this ‘median’ cow gives: half of the cows give as much or more than the median; half give as m
&#60;!-- more --&#62;
----------

Problem Description
FJ is surveying his herd to find the most average cow. He wants to know how much milk this 'median' cow gives: half of the cows give as much or more than the median; half give as much or less. 

Given an odd number of cows N (1 >= N &#60; 10,000) and their milk output (1..1,000,000), find the median amount of milk given such that at least half the cows give the same amount of milk or more and at least half give the same or less.
 

Input
* Line 1: A single integer N 

* Lines 2..N+1: Each line contains a single integer that is the milk output of one cow.
 

Output
* Line 1: A single integer that is the median milk output.
 

Sample Input
5
2
4
1
3
5
 

Sample Output
3

Hint
 
INPUT DETAILS: 

Five cows with milk outputs of 1..5 

OUTPUT DETAILS: 

1 and 2 are below 3; 4 and 5 are above 3.
 
一道求中位数的简单题

```
#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;
#include &#60;string.h&#62;
#include&#60;iostream&#62;

#include&#60;algorithm&#62;

using namespace std;
bool cmp(int a,int b){
    return a&#62;b;
}//从大到小排序；

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i&#60;n;i++){
        scanf("%d",&arr[i]);
    }
         sort(arr,arr+n,cmp);
    printf("%d\n",arr[(n-1)/2]);
    }
    return 0;
}


```

下面用快排做：

```
/**#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;
#include &#60;string.h&#62;
#include&#60;iostream&#62;

#include&#60;algorithm&#62;

using namespace std;
bool cmp(int a,int b){
    return a&#62;b;
}//从大到小排序；

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i&#60;n;i++){
        scanf("%d",&arr[i]);
    }
         sort(arr,arr+n,cmp);
    printf("%d\n",arr[(n-1)/2]);
    }
    return 0;
}
**/

#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;
#include &#60;string.h&#62;
#include&#60;iostream&#62;

#include&#60;algorithm&#62;

using namespace std;
int cmp(const void *x,const void *y){
    return (*(int *)x-*(int *)y);//从小到大
   /** return (*(int *)y-*(int *)x);//从大到小**/
}

int main(){
    int n;
    while(scanf("%d",&n)==1){
    int i,j,arr[10005];
    for(i=0;i&#60;n;i++){
        scanf("%d",&arr[i]);
    }
         qsort(arr,n,sizeof(int),cmp);
       /**  for(int i=0;i&#60;n;i++){
            printf("%d\n",arr[i]);
         }**/
    printf("%d\n",arr[(n-1)/2]);
    }
    return 0;
}


```