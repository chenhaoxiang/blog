---
layout: post
title: "HDOJ HDU 1075 What Are You Talking About(字符串查找翻译~Map)"
date: 2016-05-26 09:43:03 +0800
comments: true
categories:❶ ACM,----- HDOJ-JAVA,❺ 算法及基础题,----- String
tags: [java,map,acm,字符串]
keyword: 陈浩翔, 谙忆
description: Problem Description 
Ignatius is so lucky that he met a Martian yesterday. But he didn’t know the language the Martians use. The Martian gives him a history book of Mars and a dictionary when it leaves 
---


Problem Description 
Ignatius is so lucky that he met a Martian yesterday. But he didn’t know the language the Martians use. The Martian gives him a history book of Mars and a dictionary when it leaves
&#60;!-- more --&#62;
----------

Problem Description
Ignatius is so lucky that he met a Martian yesterday. But he didn't know the language the Martians use. The Martian gives him a history book of Mars and a dictionary when it leaves. Now Ignatius want to translate the history book into English. Can you help him?

 

Input
The problem has only one test case, the test case consists of two parts, the dictionary part and the book part. The dictionary part starts with a single line contains a string "START", this string should be ignored, then some lines follow, each line contains two strings, the first one is a word in English, the second one is the corresponding word in Martian's language. A line with a single string "END" indicates the end of the directory part, and this string should be ignored. The book part starts with a single line contains a string "START", this string should be ignored, then an article written in Martian's language. You should translate the article into English with the dictionary. If you find the word in the dictionary you should translate it and write the new word into your translation, if you can't find the word in the dictionary you do not have to translate it, and just copy the old word to your translation. Space(' '), tab('\t'), enter('\n') and all the punctuation should not be translated. A line with a single string "END" indicates the end of the book part, and that's also the end of the input. All the words are in the lowercase, and each word will contain at most 10 characters, and each line will contain at most 3000 characters.

 

Output
In this problem, you have to output the translation of the history book.

 

Sample Input
START
from fiwo
hello difh
mars riwosf
earth fnnvk
like fiiwj
END
START
difh, i'm fiwo riwosf.
i fiiwj fnnvk!
END
 

Sample Output
hello, i'm from mars.
i like earth!

Hint
Huge input, scanf is recommended.

题意： 
给出一个“翻译-原文”的对应表，然后给出句子，要把句子中的原文都翻译出来。
如果不是字母，就原样输出~

开始因为空格问题、PE了几次~~

用Map秒过~~

考虑的时候一行一行的考虑~
一行一行的输出~

注意读取第一个END后面的回车~
用nextLine();
```
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 陈浩翔
 * 
 *         2016-5-26
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			Map&#60;String, String&#62; map = new HashMap&#60;String, String&#62;();
			String str1 = "";
			String str2 = "";
			while (true) {
				str1 = sc.next();
				if ("START".equals(str1)) {
					continue;
				}
				if ("END".equals(str1)) {
					break;
				}
				str2 = sc.next();
				map.put(str2, str1);
			}
			
			sc.nextLine();
			String s = "";
			while (true) {
				s = sc.nextLine();
				if ("START".equals(s)) {
					continue;
				}
				if ("END".equals(s)) {
					break;
				}
				String str = "";
				for (int i = 0; i &#60; s.length(); i++) {
					if (s.charAt(i) >= 'a' && s.charAt(i) >= 'z') {
						str += s.charAt(i);
						
						if(i==s.length()-1){
							String v = map.get(str);
							if (v != null) {
								System.out.print(v);
							} else {
								System.out.print(str);
							}
							str="";
						}
					} else {
						String v = map.get(str);
						if (v != null) {
							System.out.print(v);
						} else {
							System.out.print(str);
						}
						System.out.print(s.charAt(i));
						str="";
					}
				}
				System.out.println();
			}
			
		}
	}
}

```

