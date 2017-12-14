---
layout: post
title: "HDOJ 2008 数值统计"
date: 2015-10-22 04:14:14 +0800
comments: true
categories: acm-java
tags: [acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 统计给定的n个数中，负数、零和正数的个数。Input 输入数据有多组，每组占一行，每行的第一个数是整数n（n<100），表示需要统计的数值的个数，然后是n个实数；如果n=0，则表示输入结束，该行不做处理。Output 对于每组输入数据，输出一行a,b和c，分别表示给定的数据中负数、零和正数的个数。Sample Input 6 0 1 2 3 -1 0 
---


Problem Description   
统计给定的n个数中，负数、零和正数的个数。 


<!-- more -->
----------
 
Input  
输入数据有多组，每组占一行，每行的第一个数是整数n（n<100），表示需要统计的数值的个数，然后是n个实数；如果n=0，则表示输入结束，该行不做处理。
 

Output  
对于每组输入数据，输出一行a,b和c，分别表示给定的数据中负数、零和正数的个数。
 

Sample Input
```
6 0 1 2 3 -1 0
5 1 2 3 4 0.5
0 
```

Sample Output
```
1 2 3
0 0 5
```
 

```java
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc =new Scanner(System.in);
    while(sc.hasNext()){
      int n =sc.nextInt();
      if(n==0)
        return ;
      int a=0;
      int b=0;
      int c=0;
      for(int i= 0;i<n;i++){
        double m =sc.nextDouble();
        if(m<0)
          a++;
        if(m==0)
          b++;
        if(m>0)
          c++;
       
      }
      System.out.println(a+" "+b+" "+c);
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
