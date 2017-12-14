---
layout: post
title: "HDOJ 2006 求奇数的乘积"
date: 2015-10-22 04:12:34 +0800
comments: true
categories: acm-java
tags: [hdoj,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 给你n个整数，求他们中所有奇数的乘积。Input 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。Output 输出每组数中的所有奇数的乘积，对于测试实例，输出一行。Sample Input 3 1 2 3 4 2 3 4 5Sample Output 
---


Problem Description   
给你n个整数，求他们中所有奇数的乘积。

<!-- more -->
----------
 
Input  
输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。  
 

Output  
输出每组数中的所有奇数的乘积，对于测试实例，输出一行。
 

Sample Input
```
3 1 2 3
4 2 3 4 5
```

Sample Output
```
3
15
```

```C++
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int t = sc.nextInt();
      int s =1;
      for(int i=0;i<t;i++){
        int a = sc.nextInt(); 
        if(a%2!=0)
           s*=a;
      }
      System.out.println(s);
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
