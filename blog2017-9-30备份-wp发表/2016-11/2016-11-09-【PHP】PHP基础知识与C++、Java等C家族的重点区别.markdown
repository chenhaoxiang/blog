---
layout: post
title: "【PHP】PHP基础知识与C++、Java等C家族的重点区别"
date: 2016-11-09 04:52:20 +0800
comments: true
categories:❹ PHP
tags: [php,java,博客,计算机,c语言]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。然后就想着写一写基础知识的一点不同，方便记忆与区分。本篇博客适宜人群： 
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。 
以及刚 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。然后就想着写一写基础知识的一点不同，方便记忆与区分。本篇博客适宜人群： 
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。 
以及刚
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

刚刚接触PHP，看着PHP的基础知识，发现还是有一些地方与Java有比较大的区别。

然后就想着写一写基础知识的一点不同，方便记忆与区分。

本篇博客适宜人群：
对Java基础知识有着一定的了解(最好是已经深入学习Java的人，否则有时候，不同计算机语言之间的语法会把你弄懵逼的)。
以及刚学习PHP的人。

在这里，我只列出PHP的基础知识是哪样的，Java的不列出。

##输出字符串
PHP的输出前面都是有着:echo。
```
&#60;?php
  echo print 'Hello Word!';
  echo "&#60;br/&#62;";
?&#62;
&#60;?php
  echo printf("这是我的第%d个程序&#60;br/&#62;&#60;br/&#62;",2);
?&#62;
```

##数据类型
PHP有两种特殊类型、
1、NULL(Null)
2、resource(资源)
(前面的是数据类型，括号内的是中文名称)

PHP中:
Array-也就是数组。
3中定义方式:

```
&#60;?php
  $array = array("a","b","c",12,"d");
  print_r($array);
  echo "&#60;br/&#62;&#60;br/&#62;";
?&#62;
&#60;?php
  $array = array(
  	"key1" =&#62; "a",
	"key2" =&#62; 12,
	"key3" =&#62; "b",
  );
  print_r($array);
  echo "&#60;br/&#62;&#60;br/&#62;";
  //自PHP5.4起，定义方式改为:
  $array = [
    "key1" =&#62; "a",
	"key2" =&#62; 12,
	//"key3" =&#62; "b",
	"key3" =&#62; "b"//最后写不写逗号都一样的
  ];
  print_r($array);
  echo "&#60;br/&#62;&#60;br/&#62;";
?&#62;
```

NULL类型的变量唯一的可能值就是NULL，而且不区分大小写！
用来表示一个变量没有值！

###Object对象-调用对象中的函数
```
&#60;?php
  class hello{
  	function do_print(){
		echo "print";
	}
  }
  
  $a = new hello;//new 对象
  $a-&#62;do_print();//调用$a中函数
  echo "&#60;br/&#62;&#60;br/&#62;";
?&#62;
```


##变量
PHP表示一个变量的方法是：使用符号$开头，后跟变量名称。
PHP是弱类型语言。

```
&#60;?php
  $a = 12;
  $b = "abc";
?&#62;
```



##引用赋值
PHP中:
```
&#60;?php
	$num1=5;
	$num2=&$num1;
	$num2=10;
	echo $num1;//输出10
?&#62;
```

##局部变量与全局变量
PHP中:
局部变量只能在被定义的函数内使用，在该被定义的函数之外无法访问该变量。
全局变量指在函数的外部被定义，其只能在函数外部使用！

也就是说，全局变量与局部变量是分开的！

不过我们还是有一种方法可以在函数内部访问全局变量。
我们可以在函数内部也定义同样的变量，只是我们需要在变量前面加上关键字 global 。
示例如下:
```
&#60;?php
	$sun=20;
	function example(){
		global $sum;
		$num1 = 10;
		$num2 = $num1 * 2;
		$sum = $num1+$num2; 
	}
	example();
	echo $sum; //输出30
?&#62;
```

##常量
PHP中:
常量需要使用define()函数进行设置。
示例:

```
&#60;?php
	define("FIRST","abc");
	echo FIRST;
?&#62;
```
define()函数有3个参数。
1.定义常量名称
2.定义常量的值
3.定义了常量名称是否区分大小写，该参数可选，默认是false.

##运算符
PHP中：
比较运算符 "==="
三个等于表示是否完全相同。
也就是`$a`等于`$b`,而且它们的数据类型相同。为TRUE

"!=="非全等于
也就是`$a` 不等于`$b`,或它们的数据类型不相同。为TRUE

"&#60;&#62;"不等于，类似"!="

##逻辑运算符
PHP中
逻辑异或 "xor"

```
$a xor $b   
如果$a或$b任一为true，但不同时为true。结果为true。
也就是$a与$b值不同时，结果为true。
```

##"."运算符
PHP中
连接字符串的运算符、

##数组运算符
PHP中
"==="全等
```
如果$a和$b拥有相同的键/值对，且顺序相同，类型相同，则返回true、
```
"!=="不全等
```
与 === 相对
```

##条件判断语句
PHP中
elseif可以写在一起、

```
elseif和else if一样的
```


如有错误或者补充，欢迎在评论区指正，谢谢，我会继续编辑，以及加上补充者ID。


本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

