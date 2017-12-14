---
layout: post
title: "HDOJ 2002 计算球体积"
date: 2015-10-22 04:10:00 +0800
comments: true
categories: acm-c
tags: [hdoj,acm,c++]
keyword: 陈浩翔, 谙忆
description: 根据输入的半径值，计算球的体积。Input 输入数据有多组，每组占一行，每行包括一个实数，表示球的半径。Output 输出对应的球的体积，对于每组输入数据，输出一行，计算结果保留三位小数。Sample Input 
---


Problem Description   
根据输入的半径值，计算球的体积。 

<!-- more -->
---------- 

Input  
输入数据有多组，每组占一行，每行包括一个实数，表示球的半径。
 

Output  
输出对应的球的体积，对于每组输入数据，输出一行，计算结果保留三位小数。
 

Sample Input  
```
1
1.5
```

Sample Output
```
4.189
14.137
```


Hint
PI 3.1415927
 
 

```C+++
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    while(sc.hasNext()){
      double r = sc.nextDouble();
      r = 4.0/3.0*3.1415927 * r *r *r;
      System.out.printf("%.3f",r);
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
