---
layout: post
title: "【IDEA】Intellij IDEA创建的Web项目配置Tomcat并启动Maven项目"
date: 2016-11-20 11:23:09 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ④、Web学习之旅
tags: [tomcat,idea,intellij idea,maven,web]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本篇博客讲解IDEA如何配置Tomcat、大部分是直接上图哦、点击如图所示的地方，进行添加Tomcat配置页面弹出页面后，按照如图顺序找到，点击+号tomcat Service -> Local注意，这里不要选错了哦，还有一个TomEE Service！按照下面图所示进行配置。图中数字 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
本篇博客讲解IDEA如何配置Tomcat、大部分是直接上图哦、点击如图所示的地方，进行添加Tomcat配置页面弹出页面后，按照如图顺序找到，点击+号tomcat Service -&#62; Local注意，这里不要选错了哦，还有一个TomEE Service！按照下面图所示进行配置。图中数字
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

本篇博客讲解IDEA如何配置Tomcat、

大部分是直接上图哦、

**点击如图所示的地方，进行添加Tomcat配置页面**

![](http://img.blog.csdn.net/20161120093455354)

**弹出页面后，按照如图顺序找到，点击+号**

![](http://img.blog.csdn.net/20161120093947267)

tomcat Service -&#62; Local

![](http://img.blog.csdn.net/20161120094126348)

注意，这里不要选错了哦，还有一个TomEE Service！


按照下面图所示进行配置。


图中数字的地方代表的配置意思:
1代表名称，给配置的Tomcat取名称。
2代表配置Tomcat的安装路径。
3代表Tomcat服务器启动后，默认打开的浏览器，根据自己习惯打开。
4代表浏览器显示路径，根据自己喜好可以改。
5和6都是默认的，不需要修改。

![](http://img.blog.csdn.net/20161120095237254)

配置Deployment，webapp为项目的webapp，后面的名字可以自己定义，别忘了加“/”.

![](http://img.blog.csdn.net/20161120105753626)


如果你配置好Tomcat之后还是无法启动web项目，那么你可以试试下面的方法:

Facets 的web设置

![](http://img.blog.csdn.net/20161120111830114)

![](http://img.blog.csdn.net/20161120112025526)

添加Artifacts

![](http://img.blog.csdn.net/20161120112113870)

再添加tomcat

![](http://img.blog.csdn.net/20161120105753626)


启动tomcat

![](http://img.blog.csdn.net/20161120112211667)

![](http://img.blog.csdn.net/20161120112233308)



本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
