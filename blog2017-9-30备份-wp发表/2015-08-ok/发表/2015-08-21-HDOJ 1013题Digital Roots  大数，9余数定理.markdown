---
layout: post
title: "HDOJ 1013题Digital Roots  大数，9余数定理"
date: 2015-08-21 05:00:24 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❺ 算法及基础题,----- 大数问题
tags: [c语言,HDOJ,大数]
keyword: 陈浩翔, 谙忆
description: Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resultin 
---


Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resultin
&#60;!-- more --&#62;
----------


&#60;div class="panel_title" align="left"&#62;Problem Description&#60;/div&#62;
&#60;div class="panel_content"&#62;The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are
 summed and the process is repeated. This is continued as long as necessary to obtain a single digit.&#60;br&#62;
&#60;br&#62;
For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process
 must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Input&#60;/div&#62;
&#60;div class="panel_content"&#62;The input file will contain a list of positive integers, one per line. The end of the input will be indicated by an integer value of zero.&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Output&#60;/div&#62;
&#60;div class="panel_content"&#62;For each integer in the input, output its digital root on a separate line of the output.&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Sample Input&#60;/div&#62;
&#60;div class="panel_content"&#62;
&#60;pre&#62;&#60;div style="font-family:Courier New,Courier,monospace"&#62;24
39
0&#60;/div&#62;&#60;/pre&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;p&#62;&#60;/p&#62;
&#60;div class="panel_title" align="left"&#62;Sample Output&#60;/div&#62;
&#60;div class="panel_content"&#62;
&#60;pre&#62;&#60;div style="font-family:'Courier New',Courier,monospace"&#62;6
3&#60;/div&#62;&#60;/pre&#62;
&#60;/div&#62;
&#60;p&#62;&#60;/p&#62;
&#60;p&#62;&#60;br&#62;
&#60;/p&#62;
&#60;div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace"&#62;
&#60;strong&#62;&#60;/strong&#62;&#60;/div&#62;
&#60;p&#62;&#60;/p&#62;
&#60;div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace"&#62;
一个数对九取余，得到的数称之为九余数；&#60;/div&#62;
&#60;div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace"&#62;
一个数的九余数等于它的各个数位上的数之和的九余数！&#60;/div&#62;
&#60;br&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px"&#62;
题目大意：&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px"&#62;
&#60;/p&#62;
&#60;div&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;给定一个正整数，根据一定的规则求出该数的&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，其规则如下：&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例如给定&nbsp;数字&nbsp;&#60;span style="font-family:'Times New Roman'"&#62;24&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，将&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;24&#60;/span&#62;&#60;span style="font-family:宋体"&#62;的各个位上的数字&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;分离&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，分别得到数字&nbsp;&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;2&nbsp;&#60;/span&#62;&#60;span style="font-family:宋体"&#62;和&nbsp;&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;4&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，而&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;2&#43;4=6&#60;/span&#62;&#60;span style="font-family:宋体"&#62;；&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因为&nbsp;&#60;span style="font-family:'Times New Roman'"&#62;6&nbsp;&lt;&nbsp;10&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，所以就认为&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;6&#60;/span&#62;&#60;span style="font-family:宋体"&#62;是数字&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;24&#60;/span&#62;&#60;span style="font-family:宋体"&#62;的&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;；&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;而对于数字&nbsp;&#60;span style="font-family:'Times New Roman'"&#62;39&nbsp;&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，&#60;/span&#62;&nbsp;将&#60;span style="font-family:'Times New Roman'"&#62;39&#60;/span&#62;&#60;span style="font-family:宋体"&#62;的各个位上的数字&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;分离&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，分别得到数字&nbsp;&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;3&nbsp;&#60;/span&#62;&#60;span style="font-family:宋体"&#62;和&nbsp;&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;9&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，而&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;3&#43;9=12,&#60;/span&#62;&#60;span style="font-family:宋体"&#62;且&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;12&gt;10&#60;/span&#62;&#60;span style="font-family:宋体"&#62;；&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所以依据规则再对&nbsp;&#60;span style="font-family:'Times New Roman'"&#62;12&nbsp;&#60;/span&#62;&#60;span style="font-family:宋体"&#62;进行相应的运算，最后得到数字&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;3&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，而&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;3&lt;10&#60;/span&#62;&#60;span style="font-family:宋体"&#62;，所以就认为&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;3&#60;/span&#62;&#60;span style="font-family:宋体"&#62;是数字&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;39&#60;/span&#62;&#60;span style="font-family:宋体"&#62;的&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;。&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过运算可以发现任何一个数的&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;都是一个取&#20540;范围在&nbsp;&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;1&nbsp;~&nbsp;9&#60;/span&#62;&#60;span style="font-family:宋体"&#62;之间的正整数，&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;且任何一个正整数都只有唯一的一个&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;span style="font-family:宋体"&#62;与其相对应。&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目要求数字&nbsp;&#60;span style="font-family:'Times New Roman'"&#62;n^n&nbsp;&#60;/span&#62;&#60;span style="font-family:宋体"&#62;的&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;“&#60;/span&#62;&#60;span style="font-family:宋体"&#62;数根&#60;/span&#62;&#60;span style="font-family:'Times New Roman'"&#62;”&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&#60;span style="font-family:'Times New Roman'"&#62;解题思路：&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&#60;span style="font-family:'Times New Roman'"&#62;&#60;strong&#62;九余数定理&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&#60;span style="font-family:'Times New Roman'"&#62;&#60;strong&#62;一个数对九取余后的结果称为九余数。&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; color:rgb(85,85,85); font-family:'microsoft yahei'; font-size:15px; line-height:35px"&#62;
&#60;span style="font-family:'Times New Roman'"&#62;&#60;strong&#62;一个数的各位数字之和想加后得到的&lt;10的数字称为这个数的九余数（如果相加结果大于9，则继续各位相加）&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;/div&#62;
&#60;div&#62;代码如下：&#60;/div&#62;
&#60;div class="panel_title" align="left"&#62;&#60;pre name="code" class="cpp"&#62;#include &lt;stdio.h&gt;
#include &lt;stdlib.h&gt;
#include&lt;string.h&gt;
int main()
{
    char a[1010];
    int i,j,s,l;
    while(~scanf(&quot;%s&quot;,&amp;a)&amp;&amp;a[0]!=&#39;0&#39;)
    {
        l=strlen(a);
        s=0;
        for(i=0;i&lt;l;i++)
        {
            s=s+a[i]-&#39;0&#39;;
        }
        s=s%9;
        if(s==0)
            s=9;
        printf(&quot;%d\n&quot;,s);
    }
    return 0;
}
&#60;/pre&#62;&#60;br&#62;
&#60;br&#62;
&#60;/div&#62;
&#60;div style="top:0px"&#62;
&#60;div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace"&#62;
一个数对九取余，得到的数称之为九余数；&#60;/div&#62;
&#60;div style="color:rgb(50,62,50); font-size:14px; line-height:21px; background-color:rgb(156,174,193); font-family:'Courier new',Courier,monospace"&#62;
一个数的九余数等于它的各个数位上的数之和的九余数！&#60;/div&#62;
&#60;/div&#62;
