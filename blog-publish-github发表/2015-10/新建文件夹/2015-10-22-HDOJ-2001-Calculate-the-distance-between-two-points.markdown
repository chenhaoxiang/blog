---
layout: post
title: "HDOJ 2001 计算两点间的距离"
date: 2015-10-22 04:08:53 +0800
comments: true
categories: acm-c
tags: [hdoj,acm,c++]
keyword: 陈浩翔, 谙忆
description: 输入两点坐标（X1,Y1）,（X2,Y2）,计算并输出两点间的距离。Input 输入数据有多组，每组占一行，由4个实数组成，分别表示x1,y1,x2,y2,数据之间用空格隔开。Output 对于每组输入数据，输出一行，结果保留两位小数。Sample Input 
---

Problem Description  
输入两点坐标（X1,Y1）,（X2,Y2）,计算并输出两点间的距离。
 
<!-- more -->
----------



Input  
输入数据有多组，每组占一行，由4个实数组成，分别表示x1,y1,x2,y2,数据之间用空格隔开。
 

Output  
对于每组输入数据，输出一行，结果保留两位小数。
 

Sample Input  
```
0 0 0 1
0 1 1 0
```

Sample Output
```
1.00
1.41
```
 

```C++
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      double x1 = sc.nextDouble(); 
      double y1 = sc.nextDouble();
      double x2 = sc.nextDouble();
      double y2 = sc.nextDouble();
      double s =(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
      s=Math.sqrt(s);
      System.out.printf("%.2f",s);
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
