---
layout: post
title: "POJ  2260（ZOJ 1949）  Error Correction  一个水题"
date: 2015-10-30 08:37:48 +0800
comments: true
categories:❶ ACM,----- POJ-ACM,----- ZOJ-ACM
tags: [poj,zoj]
keyword: 陈浩翔, 谙忆
description: DescriptionA boolean matrix has the parity property when each row and each column has an even sum, i.e. contains an even number of bits which are set. Here’s a 4 x 4 matrix which has the parity propert 
---


DescriptionA boolean matrix has the parity property when each row and each column has an even sum, i.e. contains an even number of bits which are set. Here’s a 4 x 4 matrix which has the parity propert
&#60;!-- more --&#62;
----------

Description

A boolean matrix has the parity property when each row and each column has an even sum, i.e. contains an even number of bits which are set. Here's a 4 x 4 matrix which has the parity property: 
1 0 1 0

0 0 0 0

1 1 1 1

0 1 0 1

The sums of the rows are 2, 0, 4 and 2. The sums of the columns are 2, 2, 2 and 2. 
Your job is to write a program that reads in a matrix and checks if it has the parity property. If not, your program should check if the parity property can be established by changing only one bit. If this is not possible either, the matrix should be classified as corrupt. 

Input

The input will contain one or more test cases. The first line of each test case contains one integer n (n&#60;100), representing the size of the matrix. On the next n lines, there will be n integers per line. No other integers than 0 and 1 will occur in the matrix. Input will be terminated by a value of 0 for n.
Output

For each matrix in the input file, print one line. If the matrix already has the parity property, print "OK". If the parity property can be established by changing one bit, print "Change bit (i,j)" where i is the row and j the column of the bit to be changed. Otherwise, print "Corrupt".
Sample Input

4
1 0 1 0
0 0 0 0
1 1 1 1
0 1 0 1
4
1 0 1 0
0 0 1 0
1 1 1 1
0 1 0 1
4
1 0 1 0
0 1 1 0
1 1 1 1
0 1 0 1
0
Sample Output

OK
Change bit (2,3)
Corrupt


一开始我看不懂题目什么意思，想了很久，后来才明白，
就是求每一行，每一列的和是偶数，如果都是，就输出OK。
如果能够通过改一个数字使之全部行列为偶数，就输出需要修改那个
字的行和列。
如果不能，就输出Corrupt。
很水的一个题，，，。。。
奈何英语不好啊！！
附上代码：

```
#include &#60;iostream&#62;
#include &#60;stdio.h&#62;
#include &#60;string.h&#62;
#include &#60;stdlib.h&#62;
using namespace std;

int main(){
    int n,m;
    bool s[105][105];
    short int a[105],b[105];
    bool a1[105],b1[105];
    while(cin&#62;&#62;n&&n!=0){
            int hang=0;
            int lie=0;
        for(int i=0;i&#60;n;i++){
                a[i]=0;
            for(int j=0;j&#60;n;j++){
                scanf("%d",&s[i][j]);
                a[i]+=s[i][j];
            }
        }
        for(int j=0;j&#60;n;j++){
                b[j]=0;
            for(int i=0;i&#60;n;i++){
                b[j]+=s[i][j];
            }
        }
        for(int i=0;i&#60;n;i++){
            a1[i]=1;
            b1[i]=1;
            if(a[i]%2!=0){
                a1[i]=0;
            }
            if(b[i]%2!=0){
                b1[i]=0;
            }
        }
        int flag1 = 0, flag2=0;
        int hang1,lie1;
        for(int i=0;i&#60;n;i++){
            if(a1[i]==0){
                hang++;
                if(flag1==0){
                    hang1=i+1;
                }
            }
            if(b1[i]==0){
                lie++;
                if(flag2==0){
                    lie1=i+1;
                }
            }
        }
        if(hang==1&&lie==1){
            printf("Change bit (%d,%d)\n",hang1,lie1);
        }else if(hang==0&&lie==0){
            printf("OK\n");
        }
        else{
            printf("Corrupt\n");
        }
    }
    return 0;
}

```