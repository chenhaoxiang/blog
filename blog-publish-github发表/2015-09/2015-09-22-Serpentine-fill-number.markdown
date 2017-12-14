---
layout: post
title: "蛇形填数"
date: 2015-09-22 08:44:08 +0800
comments: true
categories: c-plus-plus
tags: [c++]
keyword: 陈浩翔, 谙忆
description: 蛇形填数
---

样例输入： 
4 
样例输出： 
```
10  11  12  1 
9    16  13  2 
8    15  14  3 
7     6     5  4 
```
<!-- more -->
----------

```
样例输入：
4
样例输出：
10  11  12  1
9   16  13  2
8   15  14  3
7    6   5  4
```

```C++
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    int a[50][50];
    int i,j,x,y,cot,n;
    scanf("%d",&n);
    memset(a,0,sizeof(a));
    cot=a[0][n-1]=1;
    y=n-1,x=0;
    cot=2;
    while(cot<=n*n)
    {
        while(x+1<n&&(!a[x+1][y]))
        {
            a[++x][y]=cot++;
           // printf("1\n");
        }
        while(y-1>=0&&(!a[x][y-1]))
        {
            a[x][--y]=cot++;
            //printf("2\n");
        }
        while(x-1>=0&&(!a[x-1][y]))
        {
            a[--x][y]=cot++;
            //printf("3\n");
        }
        while(y+1<n&&(!a[x][y+1]))
        {
            a[x][++y]=cot++;
            //printf("4\n");
        }
    }
    for(i=0; i<n; i++)
    {
        for(j=0; j<n; j++)
            printf("%3d",a[i][j]);
        printf("\n");
    }
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
