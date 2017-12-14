---
layout: post
title: "n个灯，k个人的开灯问题"
date: 2015-09-22 07:57:29 +0800
comments: true
categories: c-plus-plus
tags: [c++]
keyword: 陈浩翔, 谙忆
description: 有n个灯，编号为1-n。第一个人把所以灯打开，第二个人按下 所有编号为2的倍数的开关，第三个人按下3的倍数的开关，依次类推， 一共有k个人，问最后有哪些灯开着？ 样例输
---

有n个灯，编号为1-n。第一个人把所以灯打开，第二个人按下
所有编号为2的倍数的开关，第三个人按下3的倍数的开关，依次类推，
一共有k个人，问最后有哪些灯开着？

<!-- more -->
----------

有n个灯，编号为1-n。第一个人把所以灯打开，第二个人按下  
所有编号为2的倍数的开关，第三个人按下3的倍数的开关，依次类推，  
一共有k个人，问最后有哪些灯开着？  
样例输入：  
7 3  
样例输出：  
1 5 6 7  


```C++
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    int a[1005],i,j,k,n,first=1;
    scanf("%d%d",&n,&k);
    memset(a,0,sizeof(a));
    for(i=1;i<=k;i++)
        for(j=1;j<=n;j++)
    {
        if(j%i==0)
            a[j]=!a[j];
    }
    for(i=1;i<=n;i++)
    {
        if(a[i])
        {
            if(first)
                first=0;
            else
                printf(" ");
            printf("%d",i);
        }
    }
    printf("\n");
    return 0;
}

```

memset(a,0,sizeof(a));的作用是把数组a全部赋为0；  
为了避免输出多余的空格，设置了一个变量first，可以表示当前要输出的变量是否为第一个。第一个变量前面没有空格，其他变量都有。  

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
