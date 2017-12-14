---
layout: post
title: "HDOJ2063过山车  匈牙利算法"
date: 2015-09-21 09:03:21 +0800
comments: true
categories: acm-c
tags: [算法,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description RPG girls今天和大家一起去游乐场玩，终于可以坐上梦寐以求的过山车了。可是，过山车的每一排只有两个座位，而且还有条不成文的规矩，就是每个女生必须找个个男生做partner和她同坐。但是，每个女孩都有各自的想法，举个例子把，Rabbit只愿意和XHD或PQK做partner，Grass只愿意和linle或LL做partner，PrincessSnow愿意 
---

Problem Description  
RPG girls今天和大家一起去游乐场玩，终于可以坐上梦寐以求的过山车了。可是，过山车的每一排只有两个座位，而且还有条不成文的规矩，就是每个女生必须找个个男生做partner和她同坐。但是，每个女孩都有各自的想法，举个例子把，Rabbit只愿意和XHD或PQK做partner，Grass只愿意和linle或LL做partner，PrincessSnow愿意和水域浪子或伪酷儿做partner。考虑到经费问题，boss刘决定只让找到partner的人去坐过山车，其他的人，嘿嘿，就站在下面看着吧。聪明的Acmer，你可以帮忙算算最多有多少对组合可以坐上过山车吗？
 
<!-- more -->
----------
Input  
输入数据的第一行是三个整数K , M , N，分别表示可能的组合数目，女生的人数，男生的人数。0< K<=1000
1<=N 和M<=500.接下来的K行，每行有两个数，分别表示女生Ai愿意和男生Bj做partner。最后一个0结束输入。
 

Output  
对于每组数据，输出一个整数，表示可以坐上过山车的最多组合数。
 

Sample Input  
```
6 3 3
1 1
1 2
1 3
2 1
2 3
3 1
0
 

Sample Output
3
```

```C++
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int map[1005][1005],c[1005];
int d[1005];
int a,b;
int k,m,n;
int fun(int u)
{
    int i;
    for(i=1; i<=n; i++)
    {
        if(map[u][i]==1&&d[i]==0)
        {
            d[i]=1;
            if(c[i]==0)
            {
                c[i]=u;
                return 1;
            }
            else if(fun(c[i])==1)
            {
                c[i]=u;
                return 1;
            }
        }
    }
    return 0;
}
int main()
{

    int i,j,sum;
    while(~scanf("%d",&k))
    {
        if(k==0)
            break;
        scanf("%d%d",&m,&n);
        sum=0;
        memset(c,0,sizeof(c));
        memset(map,0,sizeof(map));
        for(i=1; i<=k; i++)
        {
            scanf("%d%d",&a,&b);
            map[a][b]=1;
        }
        for(i=1; i<=m; i++)
        {
            memset(d,0,sizeof(d));
            if(fun(i))
                sum++;
        }
        printf("%d\n",sum);
    }
    return 0;
}

```

```C++
编程（匈牙利算法）：
 
bool 寻找从k出发的对应项出的可增广路
{
    while (从邻接表中列举k能关联到顶点j)
    {
        if (j不在增广路上)
        {
            把j加入增广路;
            if (j是未盖点 或者 从j的对应项出发有可增广路)
            {
                修改j的对应项为k;
                则从k的对应项出有可增广路,返回true;
            }
        }
    }
    则从k的对应项出没有可增广路,返回false;
}
void 匈牙利hungary()
{
    for i->1 to n
    {
        if (则从i的对应项出有可增广路)
            匹配数++;
    }
    输出 匹配数;
}

代码：
 
#include <iostream>
using namespace std;
bool map[505][505],d[505];
int n,m;
int s[505];
bool find(inta)
{
    int i;
    for(i=1;i<=m;i++)
    {
        if(!d[i]&&map[a][i])
        {
            d[i]=1;
            if(!s[i]||find(s[i]))
            {
                s[i]=a;
                return true;
            }
        }
    }
    return false;
}
int main()
{
    int t,a,b,i,ans;
    while(cin>>t,t)
    {
        ans=0;
        memset(map,0,sizeof(map));
        memset(s,0,sizeof(s));
        cin>>n>>m;
        while(t--)
        {
            cin>>a>>b;
            map[a][b]=true;
        }
        for(i=1;i<=n;i++)
        {
            memset(d,0,sizeof(d));
            if(find(i))
                ans++;
        }
        cout<<ans<<endl;
    }
    return 0;
}
```

本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
