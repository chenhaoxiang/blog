---
layout: post
title: "HDOJ(HDU) 2164 Rock  Paper  or Scissors "
date: 2016-05-05 07:52:53 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- 基础题
tags: []
keyword: 陈浩翔, 谙忆
description: Problem Description 
Rock, Paper, Scissors is a two player game, where each player simultaneously chooses one of the three items after counting to three. The game typically lasts a pre-determined numbe 
---


Problem Description 
Rock, Paper, Scissors is a two player game, where each player simultaneously chooses one of the three items after counting to three. The game typically lasts a pre-determined numbe
&#60;!-- more --&#62;
----------

Problem Description
Rock, Paper, Scissors is a two player game, where each player simultaneously chooses one of the three items after counting to three. The game typically lasts a pre-determined number of rounds. The player who wins the most rounds wins the game. Given the number of rounds the players will compete, it is your job to determine which player wins after those rounds have been played. 

The rules for what item wins are as follows:

?Rock always beats Scissors (Rock crushes Scissors)
?Scissors always beat Paper (Scissors cut Paper)
?Paper always beats Rock (Paper covers Rock) 

 

Input
The first value in the input file will be an integer t (0 &#60; t &#60; 1000) representing the number of test cases in the input file. Following this, on a case by case basis, will be an integer n (0 &#60; n &#60; 100) specifying the number of rounds of Rock, Paper, Scissors played. Next will be n lines, each with either a capital R, P, or S, followed by a space, followed by a capital R, P, or S, followed by a newline. The first letter is Player 1抯 choice; the second letter is Player 2抯 choice.


 

Output
For each test case, report the name of the player (Player 1 or Player 2) that wins the game, followed by a newline. If the game ends up in a tie, print TIE.
 

Sample Input
3
2
R P
S R
3
P P
R S
S R
1
P R
 

Sample Output
Player 2
TIE
Player 1


题意：
R代表石头，S代表剪刀，P代表纸，就是剪刀石头布的规则。
第一个字符是人1出的，第二个字符是人2出的。
判断最后是谁胜利。（赢的次数多的胜利）
人一胜利就输出：Player 1
平局就输出：TIE
人二胜利就输出：Player 2


Java不能从终端读取单个字符(char型)。这个有点不好。。。。得自己转换。。

```
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		String strs1[] = {"RS","SP","PR"};
		String strs2[] = {"SR","PS","RP"};
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t--&#62;0){
			int n = sc.nextInt();
			int p1=0;
			int p2=0;
			String str1=null;
			String str2=null;
			String str=null;
			for(int i=0;i&#60;n;i++){
				str1 = sc.next();
				str2 = sc.next();
				if(str1.equals(str2)){
					continue;
				}
				boolean isStr1=false;
				
				str=str1+str2;
				for(int j=0;j&#60;strs1.length;j++){
					if(str.equals(strs1[j])){
						p1++;
						isStr1=true;
						break;
					}
				}
				if(isStr1)
					continue;
				for(int j=0;j&#60;strs2.length;j++){
					if(str.equals(strs2[j])){
						p2++;
						break;
					}
				}
			}
			if(p1&#62;p2){
				System.out.println("Player 1");
			}else if(p1&#60;p2){
				System.out.println("Player 2");
			}else{
				System.out.println("TIE");
			}
		}
	}
}

```