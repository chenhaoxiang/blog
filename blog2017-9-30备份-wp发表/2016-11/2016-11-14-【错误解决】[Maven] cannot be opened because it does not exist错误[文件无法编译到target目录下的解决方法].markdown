---
layout: post
title: "【错误解决】[Maven] cannot be opened because it does not exist错误[文件无法编译到target目录下的解决方法]"
date: 2016-11-14 10:08:52 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,❻ 其他,----- 上网技巧/问题解决
tags: [path,idea,class,maven]
keyword: 陈浩翔, 谙忆
description: 使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist 
---


使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

使用IDEA搭建的Maven项目，在写SpringEL和资源调用时出现了如下错误:
相信我，代码没问题的、
```
Caused by: java.io.FileNotFoundException: class path resource [cn/hncu/p2_2_2SpringEL/test.properties] cannot be opened because it does not exist
```
![](http://img.blog.csdn.net/20161114092449245)

文件无法找到，后来在csdn论坛提问后才知道。

因为IDEA有个配置项，默认只把.class的文件放到编译目录中，也就是target目录。

后来我去看了target目录下，确实没有那文件。
![](http://img.blog.csdn.net/20161114092611652)

我的Java目录下是有的：

![](http://img.blog.csdn.net/20161114092651527)

找到了问题所在，就好办了.

开始我想重新去改一下IDEA的配置。但是没找到怎么改。

现在先说下用代码配置、
原因是： idea不会编译src的java目录的除Java外的文件

解决办法:
```
将IDEA maven项目中src源代码下的资源文件编译进target目录classes文件夹
具体操作方法就是：配置maven的pom文件配置，在&#60;build&#62;节点下添加&#60;resources&#62;代码：
```
也就是:
```
&#60;build&#62;
		&#60;resources&#62;
            &#60;resource&#62;
                &#60;directory&#62;src/main/java&#60;/directory&#62;
                &#60;includes&#62;
                    &#60;include&#62;**/*.*&#60;/include&#62;
                &#60;/includes&#62;
                &#60;excludes&#62;
                    &#60;exclude&#62;**/*.java&#60;/exclude&#62;
                &#60;/excludes&#62;
            &#60;/resource&#62;
        &#60;/resources&#62;
&#60;/build&#62;
```

这样就是把除.java外的src下的文件，自动编译到target目录classes文件夹下！

问题解决！

因为是刚用IDEA，也不知道怎么去IDEA配置编译其他文件到target目录，也不知道是不是IDEA不支持自动拷贝其他类型的文件到target目录。

![](http://img.blog.csdn.net/20161114100416918)

如果有朋友知道，望在评论区解答，谢谢。

Eclipse是在build path里配置的:

![](http://img.blog.csdn.net/20161114100502410)

本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
