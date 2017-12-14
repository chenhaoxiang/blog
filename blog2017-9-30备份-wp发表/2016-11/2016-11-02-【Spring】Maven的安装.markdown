---
layout: post
title: "【Spring】Maven的安装"
date: 2016-11-02 05:09:07 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [apache,maven,项目管理,对象]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，先介绍下Maven是啥吧。Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。例如: 
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先，先介绍下Maven是啥吧。Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。例如: 
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

首先，先介绍下Maven是啥吧。

Apache Maven 是一个软件项目管理工具，基于项目对象模型(Project Object Model,POM)的概念，Maven可用来管理项目的依赖、编译、文档等信息。

例如:
以前我们需要依赖第三方jar包时，需要下载那个包，然后导入项目。
现在有了Maven，就不一样了。
使用Maven管理项目时，项目依赖的jar包将不再包含在项目内，而是集中放置在用户的.m2文件夹中。

下载Maven:
Maven下载地址:
https://maven.apache.org/download.cgi

![](http://img.blog.csdn.net/20161102165651442)

点一个下载就好。

![](http://img.blog.csdn.net/20161102170043222)


下载完之后解压。

![](http://img.blog.csdn.net/20161102170115144)

配置系统环境变量。

![](http://img.blog.csdn.net/20161102170249571)
例如:
MAVEN_HOME
D:\apache-maven-3.3.9

添加到Path：

![](http://img.blog.csdn.net/20161102170356351)
Path
%MAVEN_HOME%\bin;

最后，就是测试一下Maven是否安装成功。
在控制台输入"mvn -v"。
以下信息表示安装成功。
![](http://img.blog.csdn.net/20161102170727027)


本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
