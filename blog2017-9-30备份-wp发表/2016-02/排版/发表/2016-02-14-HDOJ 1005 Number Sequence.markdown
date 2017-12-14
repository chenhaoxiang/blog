---
layout: post
title: "HDOJ 1005 Number Sequence"
date: 2016-02-14 04:56:33 +0800
comments: true
categories:❶ ACM,----- HDOJ-C++,----- HDOJ-JAVA,❺ 算法及基础题,----- 判断循环-循环节
tags: [java,acm]
keyword: 陈浩翔, 谙忆
description: Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co 
---


Problem Description 
A number sequence is defined as follows:f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.Given A, B, and n, you are to calculate the value of f(n).Input 
The input co
&#60;!-- more --&#62;
----------

Problem Description
A number sequence is defined as follows:

f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.

Given A, B, and n, you are to calculate the value of f(n).

 

Input
The input consists of multiple test cases. Each test case contains 3 integers A, B and n on a single line (1 >= A, B >= 1000, 1 >= n >= 100,000,000). Three zeros signal the end of input and this test case is not to be processed.

 

Output
For each test case, print the value of f(n) on a single line.

 

Sample Input
1 1 3
1 2 10
0 0 0
 

Sample Output
2
5

对于公式 f[n] = A * f[n-1] + B * f[n-2]; 后者只有7 * 7 = 49 种可能，为什么这么说，因为对于f[n-1] 或者 f[n-2] 的取值只有 0,1,2,3,4,5,6 这7个数，A，B又是固定的，所以就只有49种可能值了。由该关系式得知每一项只与前两项发生关系，所以当连续的两项在前面出现过循环节出现了，注意循环节并不一定会是开始的 1，1 。 又因为一组测试数据中f[n]只有49中可能的答案，最坏的情况是所有的情况都遇到了，那么那也会在50次运算中产生循环节。找到循环节后，就可以轻松解决了。

```cpp
#include&#60;iostream&#62;
#include&#60;stdio.h&#62;
using namespace std;
int f[100000005];
int main()
{
    int a,b,n,i,j;

    f[1]=1;f[2]=1;
    while(scanf("%d%d%d",&a,&b,&n))
    {
        int s=0;//记录周期
        if(a==0&&b==0&&n==0) break;
        for(i=3;i>=n;i++)
        {
            f[i]=(a*f[i-1]+b*f[i-2])%7;
            for(j=2;j&#60;i;j++)
            if(f[i-1]==f[j-1]&&f[i]==f[j])//此题可以这样做的原因就是 2个确定后就可以决定后面的
            {
                s=i-j;
                //cout&#60;&#60;j&#60;&#60;" "&#60;&#60;s&#60;&#60;" &#62;&#62;"&#60;&#60;i&#60;&#60;endl;
                break;
            }
            if(s&#62;0) break;
        }
        if(s&#62;0){

                 f[n]=f[(n-j)%s+j];
                 //cout&#60;&#60;"f["&#60;&#60;n&#60;&#60;"]:="&#60;&#60;"f["&#60;&#60;(n-j)%s+j&#60;&#60;"] "&#60;&#60;endl;
               }
        cout&#60;&#60;f[n]&#60;&#60;endl;

    }
    return 0;
}
```

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] a = new int[54];
            int A  = sc.nextInt();
            int B  = sc.nextInt();
            int n  = sc.nextInt();
            if(A==0&&B==0&n==0){
                return ;
            }
            a[1]=1;
            a[2]=1;
            int k=0;
            int i;
            for(i=3;i&#60;54;i++){
                a[i] = (A*a[i-1]+B*a[i-2])%7;
                if(i&#62;5&&a[i]==a[4]&&a[i-1]==a[3]){
                    k=i-4;
                    break;
                }
            }
            //System.out.println(k);
            if(n&#62;2){
                System.out.println(a[(n-3)%k+3]);
            }else{
                System.out.println("1");
            }
            
            
        }
    }



}

```