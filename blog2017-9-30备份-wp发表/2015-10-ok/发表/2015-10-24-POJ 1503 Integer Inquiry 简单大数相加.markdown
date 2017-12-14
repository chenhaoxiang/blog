---
layout: post
title: "POJ 1503 Integer Inquiry 简单大数相加"
date: 2015-10-24 01:59:53 +0800
comments: true
categories:❶ ACM,----- POJ-ACM,❺ 算法及基础题,----- 大数问题
tags: [poj]
keyword: 陈浩翔, 谙忆
description: DescriptionOne of the first users of BIT’s new supercomputer was Chip Diller. He extended his exploration of powers of 3 to go from 0 to 333 and he explored taking various sums of those numbers.  
This 
---


DescriptionOne of the first users of BIT’s new supercomputer was Chip Diller. He extended his exploration of powers of 3 to go from 0 to 333 and he explored taking various sums of those numbers.  
This
&#60;!-- more --&#62;
----------

Description

One of the first users of BIT's new supercomputer was Chip Diller. He extended his exploration of powers of 3 to go from 0 to 333 and he explored taking various sums of those numbers. 
``This supercomputer is great,'' remarked Chip. ``I only wish Timothy were here to see these results.'' (Chip moved to a new apartment, once one became available on the third floor of the Lemon Sky apartments on Third Street.) 
Input

The input will consist of at most 100 lines of text, each of which contains a single VeryLongInteger. Each VeryLongInteger will be 100 or fewer characters in length, and will only contain digits (no VeryLongInteger will be negative). 

The final input line will contain a single zero on a line by itself. 
Output

Your program should output the sum of the VeryLongIntegers given in the input.
Sample Input

123456789012345678901234567890
123456789012345678901234567890
123456789012345678901234567890
0
Sample Output

370370367037037036703703703670

```
#include &#60;iostream&#62;
#include &#60;string&#62;
#include &#60;stdio.h&#62;
using namespace std;
string doo(string str1,string str2){
    string s;
    int str11=str1.length();
    int str22=str2.length();

    if(str11&#62;str22){
        for(int i=0;i&#60;str11-str22;i++){
            str2="0"+str2;
        }
    }
    else{
        for(int i=0;i&#60;str22-str11;i++){
            str1="0"+str1;
        }
    }
    str11=str1.length();

    int cmp=0;
    int cf=0;
    for(int i=str11-1;i>=0;i--){
        cmp=str1[i]-'0'+str2[i]-'0'+cf;
        cf=cmp/10;
        cmp=cmp%10;
        s=char(cmp+'0')+s;
    }
    if(cf!=0){
        s=char(cf+'0')+s;
    }

    return s;


}
int main(){
   string sum="0";
   string str;
   while(cin&#62;&#62;str){
        if(str=="0"){
            break;
        }
    sum=doo(sum,str);
   }
   cout&#60;&#60;sum&#60;&#60;endl;
   return 0;
}

```

另外二种方法

```
#include &#60;string&#62;
#include &#60;stdlib.h&#62;
#include &#60;stdio.h&#62;
#include &#60;string.h&#62;

char a[200],b[200],c[200],d[200];
int main()
{
    int n1,n2;
    b[0]='0';
    while(1){
        scanf("%s",a);
        if(strcmp(a,"0")==0){
              printf("%s\n",b);
              return 0;
        }
        int i;
        int n1=strlen(a)-1;
        int n2=strlen(b)-1;
        int p=0;
        for(i=0;n1>=0||n2>=0;i++,n1--,n2--)
        {
            if(n1>=0&&n2>=0){c[i]=a[n1]+b[n2]-'0'+p;}
            if(n1>=0&&n2&#60;0){c[i]=a[n1]+p;}
            if(n1&#60;0&&n2>=0){c[i]=b[n2]+p;}
           p=0;
            if(c[i]&#62;'9'){c[i]=c[i]-10;p=1;}
        }
        if(p==1){
            c[strlen(c)]='1';
        }
        for(int i=0;i&#60;strlen(c);i++){
            d[strlen(c)-i-1]=c[i];
        }

        strcpy(b,d);

    }
}

```
——————————————————

```
#include &#60;stdio.h&#62;
#include &#60;stdlib.h&#62;
#include &#60;string.h&#62;

char a[200],b[200],c[200];
int main()
{
    //int n1,n2;
    b[0]='0';
    while(~scanf("%s",a))
    {
        if(strcmp(a,"0")==0)
        {
                printf("%s\n",b);
                return 0;
        }
        int i;
        int n1=strlen(a)-1;
        int n2=strlen(b)-1;
        int p=0;
        i=n1;
        if(i&#60;n2)
            i=n2;
        for(i; n1>=0||n2>=0; i--,n1--,n2--)
        {
            if(n1>=0&&n2>=0)
            {
                c[i]=a[n1]+b[n2]-'0'+p;
            }
            if(n1>=0&&n2&#60;0)
            {
                c[i]=a[n1]+p;
            }
            if(n1&#60;0&&n2>=0)
            {
                c[i]=b[n2]+p;
            }
            p=0;
            if(c[i]&#62;'9')
            {
                c[i]=c[i]-10;
                p=1;
            }
        }
        if(p==1)
        {

            for(i=strlen(c); i&#62;0; i--)
                c[i]=c[i-1];
            c[0]='1';
        }
        strcpy(b,c);
    }
}

```

