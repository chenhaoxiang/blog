---
layout: post
title: "生成元"
date: 2015-09-26 03:10:57 +0800
comments: true
categories: c-plus-plus
tags: [c语言,惠普,x]
keyword: 陈浩翔, 谙忆
description: 如果x+x的各个数字之和得到y，就是说x是y的生成元。给出n（1<=n<=100000), 求最小生成元。无解输出0.例如，n=216,121,2005时的解分别是198,0,1979
---
 
例题3-5：   
如果x+x的各个数字之和得到y，就是说x是y的生成元。给出n（1<=n<=100000),   
求最小生成元。无解输出0.例如，n=216,121,2005时的解分别是198,0,1979.    

<!-- more -->
----------
 
利用打表法：  
代码：  

```C++
#include <stdio.h>
#include <stdlib.h>
#define maxn 100005
int anx[maxn];
int main()
{
    int T,n;
    memset(anx,0,sizeof(anx));
    int m;
    for(m=0;m<maxn;m++)
    {
        int x,y;
        x=m,y=m;
        while(x>0)
            y=y+x%10,x=x/10;
        if(anx[y]==0||m<anx[y])
            anx[y]=m;
    }
    scanf("%d",&T);
    while(T--)
    {
        scanf("%d",&n);
        printf("%d\n",anx[n]);
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
