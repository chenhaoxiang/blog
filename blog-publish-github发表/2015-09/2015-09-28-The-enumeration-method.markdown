---
layout: post
title: "枚举法"
date: 2015-09-28 08:15:30 +0800
comments: true
categories: c-plus-plus
tags: [c++]
keyword: 陈浩翔, 谙忆
description: 口袋里有红、黄、蓝、白、黒5种颜色的球若干，每次从口袋中先后取出3个球，问得到3种不同颜色的球的可能取法，输出每种排列的情况 
---
 
口袋里有红、黄、蓝、白、黒5种颜色的球若干，每次从口袋中先后取出3个球，问得到3种不同颜色的
球的可能取法，输出每种排列的情况 

<!-- more -->
----------

```C++
#include <stdio.h>
#include <stdlib.h>

int main()
{
    enum Color {red,yellow,blue,white,black};
    enum Color i,j,k,pri;
    int n,loop;
    n=0;
    for(i=red;i<=black;i++)
        for(j=red;j<=black;j++)
    {
        if(i!=j)
        {
            for(k=red;k<=black;k++)
            {
                if((k!=i)&&(k!=j))
                {
                    n++;
                    printf("%-4d",n);
                    for(loop=1;loop<=3;loop++)
                    {
                        switch(loop)
                        {
                            case 1:pri=i;break;
                            case 2:pri=j;break;
                            case 3:pri=k;break;
                            default :break;
                        }
                        switch(pri)
                        {
                            case red:printf("%-10s","red");break;
                            case yellow:printf("%-10s","yellow");break;
                            case blue:printf("%-10s","blue");break;
                            case white:printf("%-10s","white");break;
                            case black:printf("%-10s","black");break;
//不能用printf("%s",red);来输出“red”字符串。
//必须打上引号。
                            default :break;
                        }

                    }
                    putchar('\n');
                }
            }
        }
    }
    printf("\ntotal:%5d\n",n);
    return 0;
}

```

这个题完全可以用常量1-5来代替颜色，   
但这样写更直观，不是吗！  

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
