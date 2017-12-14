---
layout: post
title: "【错误解决】MySQL出现Can't connect to MySQL server on 'localhost' (10060)错误"
date: 2016-11-19 10:31:32 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库,❻ 其他,----- 上网技巧/问题解决
tags: [mysql,数据库,server,防火墙,博客]
keyword: 陈浩翔, 谙忆
description: 本文源自【大学之旅_谙忆的博客】
今天连接数据库遇到一个问题， 
错误提示: 
Can’t connect to MySQL server on ‘localhost’ (10060)开始弄了很久，没弄好。后来去谷歌了一下。发现原来是我的防火墙问题、我也是醉得不要不要了。然后，果断把防火墙关闭。哈哈，连接成功！当然，我 
---


本文源自【大学之旅_谙忆的博客】
今天连接数据库遇到一个问题， 
错误提示: 
Can’t connect to MySQL server on ‘localhost’ (10060)开始弄了很久，没弄好。后来去谷歌了一下。发现原来是我的防火墙问题、我也是醉得不要不要了。然后，果断把防火墙关闭。哈哈，连接成功！当然，我
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

今天连接数据库遇到一个问题，
错误提示:
Can't connect to MySQL server on 'localhost' (10060)

![](http://img.blog.csdn.net/20161119222647718)

开始弄了很久，没弄好。

后来去谷歌了一下。

发现原来是我的防火墙问题、我也是醉得不要不要了。

![](http://img.blog.csdn.net/20161119222611746)

然后，果断把防火墙关闭。

![](http://img.blog.csdn.net/20161119222637921)

哈哈，连接成功！

![](http://img.blog.csdn.net/20161119222707497)


当然，我这个连接的是本机数据库。

如果是连接远程的数据库，可能还有其他一些问题哦，本章博客不去深究。遇到了请去谷歌自己解决哦。

本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;