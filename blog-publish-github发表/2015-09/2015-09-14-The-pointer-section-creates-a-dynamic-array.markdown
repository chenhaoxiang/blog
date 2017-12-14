---
layout: post
title: "指针部分，建立动态数组"
date: 2015-09-14 09:47:54 +0800
comments: true
categories: c-plus-plus
tags: [数组,指针,C++]
keyword: 陈浩翔, 谙忆
description: 建立动态数组
---
 
建立动态数组

<!-- more -->
----------

```C++
#include <stdio.h>
#include <stdlib.h>

void check(int *p[])
{
    int i;
    printf("没及格的成绩有：\n");
    for(i=0;i<5;i++)
    {
        if(p[i]<60)
            printf("%d ",p[i]);
    }
        printf("\n");
}
int main()
{
    int *pl,i;
    pl=(int *)malloc(5*sizeof(int));
    for(i=0;i<5;i++)
    {
        scanf("%d",pl+i);
    }
    check(pl);
    return 0;
}

```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
