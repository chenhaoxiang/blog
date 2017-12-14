---
layout: post
title: "HDOJ 2007 平方和与立方和"
date: 2015-10-22 04:13:28 +0800
comments: true
categories: acm-java
tags: [Java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。Input 输入数据包含多组测试实例，每组测试实例包含一行，由两个整数m和n组成。Output 对于每组输入数据，输出一行，应包括两个整数x和y，分别表示该段连续的整数中所有偶数的平方和以及所有奇数的立方和。 你可以认为32位整数足以保存结果。Sample Input  
---


Problem Description   
给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。 

<!-- more -->
----------

 
Input  
输入数据包含多组测试实例，每组测试实例包含一行，由两个整数m和n组成。
 

Output  
对于每组输入数据，输出一行，应包括两个整数x和y，分别表示该段连续的整数中所有偶数的平方和以及所有奇数的立方和。  
你可以认为32位整数足以保存结果。
 

Sample Input
```
1 3
2 5
```

Sample Output
```
4 28
20 152
```

```java
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      long a = sc.nextInt();
      long b =sc.nextInt();
      long min=a;
      long max=b;
      if(a>b){
        min=b;
        max=a;
      }
      long ping=0;
      long li=0;
      for(long i=min;i<=max;i++){
        if(i%2==0)
          ping+=i*i;
         else
          li+=i*i*i;
      }
     System.out.println(ping +" "+ li);
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
