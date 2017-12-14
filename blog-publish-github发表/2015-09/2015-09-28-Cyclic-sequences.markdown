---
layout: post
title: "环状序列"
date: 2015-09-28 07:32:03 +0800
comments: true
categories: c-plus-plus
tags: [c++]
keyword: 陈浩翔, 谙忆
description: 长度为n的环状串有n种表示法，分别为从某个位置开始顺时针得到。 求字典序最小的，也就是最小表示 
---


长度为n的环状串有n种表示法，分别为从某个位置开始顺时针得到。   
求字典序最小的，也就是最小表示   

<!-- more -->
----------

长度为n的环状串有n种表示法，分别为从某个位置开始顺时针得到。  
求字典序最小的，也就是最小表示  

```C++
#include <stdio.h>
#include <string.h>
#define maxn 105
int less(char *s,int p,int q)
{
   int i,n;
   n=strlen(s);
   for(i=0;i<n;i++)
   {
      if(s[(p+i)%n]!=s[(q+i)%n])
      return s[(p+i)%n]<s[(q+i)%n];
   }
   return 0;
}
int main()
{
   int T ;
   char s[maxn];
   scanf("%d",&T);
   while(T--)
   {
      scanf("%s",s);
      int ans=0;
      int n=strlen(s);
      int i;
      for(i=0;i<n;i++)
      {
         if(less(s,i,ans)) ans=i;
         //不断更新ans
      }
      for(i=0;i<n;i++)
         putchar(s[(ans+i)%n]);
         putchar('\n');
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
