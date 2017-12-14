---
layout: post
title: "HDOJ 1004题 Let the Balloon Rise  strcmp()函数"
date: 2015-08-21 02:38:46 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,❸ C/C++,----- C/C++函数应用
tags: [c语言,HDOJ]
keyword: 陈浩翔, 谙忆
description: Problem Description
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest i 
---


Problem Description
Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest i
&#60;!-- more --&#62;
----------


&#60;div class="panel_title" align="left"&#62;Problem Description&#60;/div&#62;
&#60;div class="panel_content"&#62;Contest time again! How excited it is to see balloons floating around. But to tell you a secret, the judges' favorite time is guessing the most popular problem. When the contest is over, they will count the balloons of each color
 and find the result.&#60;br&#62;
&#60;br&#62;
This year, they decide to leave this lovely job to you. &#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Input&#60;/div&#62;
&#60;div class="panel_content"&#62;Input contains multiple test cases. Each test case starts with a number N (0 &lt; N &lt;= 1000) -- the total number of balloons distributed. The next N lines contain one color each. The color of a balloon is a string of up to 15 lower-case
 letters.&#60;br&#62;
&#60;br&#62;
A test case with N = 0 terminates the input and this test case is not to be processed.&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Output&#60;/div&#62;
&#60;div class="panel_content"&#62;For each case, print the color of balloon for the most popular problem on a single line. It is guaranteed that there is a unique solution for each test case.&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;br&#62;
&#60;div class="panel_title" align="left"&#62;Sample Input&#60;/div&#62;
&#60;div class="panel_content"&#62;
&#60;pre&#62;&#60;div style="font-family:Courier New,Courier,monospace"&#62;5
green
red
blue
red
red
3
pink
orange
pink
0&#60;/div&#62;&#60;/pre&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;div class="panel_title" align="left"&#62;Sample Output&#60;/div&#62;
&#60;div class="panel_content"&#62;
&#60;pre&#62;&#60;div style="font-family:Courier New,Courier,monospace"&#62;red
pink&#60;/div&#62;&#60;/pre&#62;
&#60;/div&#62;
&#60;div class="panel_bottom"&#62;&#60;/div&#62;
&#60;div class="panel_title" align="left"&#62;代码：&#60;/div&#62;
&#60;div class="panel_title" align="left"&#62;&#60;pre name="code" class="cpp"&#62;#include &lt;iostream&gt;
#include&lt;stdio.h&gt;
#include&lt;stdlib.h&gt;
#include&lt;string.h&gt;
using namespace std;

int main()
{
    int n,i,j,s=1,b[1010],f[1010];
    char a[1010][20];
    while(~scanf(&quot;%d&quot;,&amp;n)&amp;&amp;n)
    {
        memset(b,0,sizeof(b));
        for(i=0; i&lt;n; i++)
        {
            scanf(&quot;%s&quot;,a[i]);
        }
        for(i=0; i&lt;n; i++)
        {
            f[i]=1;
            for(j=i+1; j&lt;n; j++)
            {
                if(b[j]==0)
                {

                    if(strcmp(a[i],a[j])==0)//这里我不知道为什么用a[i]==a[j]就不可以，求大神评论解释一下，谢谢了
                    {
                        b[j]=1;
                        f[i]=f[i]+1;
                    }
                }
            }
        }
        int s=0;
        for(i=0; i&lt;n; i++)
        {
            if(f[s]&lt;=f[i])
            {
                s=i;
            }
        }
        printf(&quot;%s\n&quot;,a[s]);
    }
    return 0;
}
&#60;/pre&#62;&#60;br&#62;
&#60;br&#62;
&#60;/div&#62;
&#60;div class="panel_content"&#62;
&#60;pre&#62;&#60;div style="font-family:Courier New,Courier,monospace"&#62;&#60;/div&#62;&#60;/pre&#62;
&#60;/div&#62;
