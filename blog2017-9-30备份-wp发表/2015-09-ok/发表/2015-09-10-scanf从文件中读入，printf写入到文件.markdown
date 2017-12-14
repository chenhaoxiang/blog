---
layout: post
title: "scanf从文件中读入，printf写入到文件"
date: 2015-09-10 09:22:35 +0800
comments: true
categories:❸ C/C++
tags: [printf]
keyword: 陈浩翔, 谙忆
description: #include <iostream>
#include <stdio.h>
#define LOCAL
using namespace std;int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen(" 
---


#include &#60;iostream&#62;
#include &#60;stdio.h&#62;
#define LOCAL
using namespace std;int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen("
&#60;!-- more --&#62;
----------

重定向方式读写文件
```
#include &#60;stdio.h&#62;
#define LOCAL
int main()
{
    #ifdef LOCAL
    freopen("input.txt","r",stdin);
    //使得scanf从文件input.txt读入
    //r只读，如果文件不存在，出错
    freopen("output.txt","w",stdout);
    //使得printf写入文件output.txt
    //w只写，如果文件不存在，建立新文件
    #endif
    //只有定义了符号LOCAL，才编译2条freopen语句。
    int j;
    scanf("%d",&j);
    for(int i=0;i&#60;5;i++)
        printf("%d\n",i);
    printf("%d\n",j);
    return 0;
}

```
非重定向方式读写文件

```
int main()
{
    FILE *fin,*fout;
    fin=fopen("data.in.txt","r");
    fout=fopen("data.out.txt","w");
    int j;
    fscanf(fin,"%d",&j);
    for(int i=0;i&#60;5;i++)
        fprintf(fout,"%d\n",i);
    fprintf(fout,"%d\n",j);
    fclose(fin);
    fclose(fout);
    return 0;
}

```