---
layout: post
title: "HDOJ 2003 求绝对值"
date: 2015-10-22 04:10:51 +0800
comments: true
categories: acm-c
tags: [acm,c,c++]
keyword: 陈浩翔, 谙忆
description: Problem Description 求实数的绝对值。Input 输入数据有多组，每组占一行，每行包含一个实数。Output 对于每组输入数据，输出它的绝对值，要求每组数据输出一行，结果保留两位小数。Sample Input 
---


Problem Description   
求实数的绝对值 

<!-- more -->
----------

Input  
输入数据有多组，每组占一行，每行包含一个实数。
 

Output  
对于每组输入数据，输出它的绝对值，要求每组数据输出一行，结果保留两位小数。
 

Sample Input
```
123
-234.00
```

Sample Output
```
123.00
234.00
```

```C++
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      double a = sc.nextDouble();
      if(a<0)
      a=a*(-1.0);
      System.out.printf("%.2f",a);
      System.out.println();
    }
  }
}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
