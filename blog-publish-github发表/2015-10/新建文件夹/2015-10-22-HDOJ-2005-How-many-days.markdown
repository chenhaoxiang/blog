---
layout: post
title: "HDOJ 2005  第几天？"
date: 2015-10-22 05:12:48 +0800
comments: true
categories: acm-java
tags: [hdoj,acm,java]
keyword: 陈浩翔, 谙忆
description: Problem Description 给定一个日期，输出这个日期是该年的第几天。Input 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,另外，可以向你确保所有的输入数据是合法的。Output 对于每组输入数据，输出一行，表示该日期是该年的第几天。Sample Input 1985/1/20 2006/3/12Sample Outpu 
---

Problem Description   
给定一个日期，输出这个日期是该年的第几天。

<!-- more -->
----------
 
Input  
输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,另外，可以向你确保所有的输入数据是合法的。
 

Output  
对于每组输入数据，输出一行，表示该日期是该年的第几天。
 

Sample Input
```
1985/1/20
2006/3/12
```

Sample Output
```
20
71
```


```C++
import java.util.*;
class Main{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
          String str = sc.next();
                String strs[]=str.split("/");
                int year = Integer.parseInt(strs[0]);
                int month = Integer.parseInt(strs[1]);
                int day = Integer.parseInt(strs[2]);
         int s=0,run_1=0;
         if(run(year)){
            run_1=1;
         }
         switch(month){
               case 12: s+=30;           
               case 11: s+=31;
               case 10: s+=30;
               case 9 : s+=31;
               case 8 : s+=31;
               case 7 : s+=30;
               case 6 : s+=31;
               case 5 : s+=30;
               case 4 : s+=31;
               case 3 : s+=28+run_1;
               case 2 : s+=31;
            }
         s+=day;
         System.out.println(s);
      }
   }
   public static boolean run(int year){
      if((year%100!=0&&year%4==0)||(year%400==0))
         return true;
      return false;
   }
}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
