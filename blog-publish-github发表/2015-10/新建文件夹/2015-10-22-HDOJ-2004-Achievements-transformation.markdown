---
layout: post
title: "HDOJ 2004 成绩转换"
date: 2015-10-22 04:11:46 +0800
comments: true
categories: acm-c
tags: [hdoj,acm,c,c++]
keyword: 陈浩翔, 谙忆
description: Problem Description 输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下90~100为A; 80~89为B;70~79为C; 60~69为D; 0~59为E;Input 输入数据有多组，每组占一行，由一个整数组成。Output 对于每组输入数据，输出一行。如果输入数据
---


Problem Description   
输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下：   
90~100为A;   
80~89为B;   
70~79为C;   
60~69为D;   
0~59为E;   

<!-- more -->
----------
 
Input  
输入数据有多组，每组占一行，由一个整数组成。
 

Output  
对于每组输入数据，输出一行。如果输入数据不在0~100范围内，请输出一行：“Score is error!”。
 

Sample Input  
```
56
67
100
123
```

Sample Output
```
E
D
A
Score is error!
```

```C++
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc =new Scanner(System.in);
    while(sc.hasNext()){
      int a = sc.nextInt();
      if(a<0||a>100)
        System.out.println("Score is error!");
      if(a>=90&&a<=100)
        System.out.println("A");
      if(a>=80&&a<=89)
        System.out.println("B");
      if(a>=70&&a<=79)
        System.out.println("C");
      if(a>=60&&a<=69)
        System.out.println("D");
      if(a>=0&&a<=59)
        System.out.println("E");
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
