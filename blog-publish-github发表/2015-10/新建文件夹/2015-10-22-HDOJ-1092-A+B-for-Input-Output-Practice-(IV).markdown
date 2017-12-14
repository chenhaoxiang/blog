---
layout: post
title: "HDOJ 1092 A+B for Input-Output Practice (IV)"
date: 2015-10-22 04:02:56 +0800
comments: true
categories: acm-java
tags: [hdoj,java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description Your task is to Calculate the sum of some integers.Input Input contains multiple test cases. Each test case contains a integer N, and then N integers follow in the same line. A te 
---
Problem Description  
Your task is to Calculate the sum of some integers.
 
<!-- more -->
----------



Input  
Input contains multiple test cases. Each test case contains a integer N, and then N integers follow in the same line. A test case starting with 0 terminates the input and this test case is not to be processed.
 

Output  
For each group of input integers you should output their sum in one line, and with one line of output for each line in input. 
 

Sample Input  
```
4 1 2 3 4
5 1 2 3 4 5
0 
```

Sample Output
```
10
15
```

```java
import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int t = sc.nextInt();
      if(t==0)
         return ;
      int sum=0;
      while(t-->0){
      int a=sc.nextInt();
      sum +=a;
      }
      System.out.println(sum);
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
