---
layout: post
title: "【Linux】Linux下修改主机名-简单三步搞定"
date: 2016-12-20 04:26:16 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [服务器,linux,终端]
keyword: 陈浩翔, 谙忆
description: 在阿里云买了一台Linux服务器，可是root用户名竟然是产品ID，用起来很不爽。

如何改用户名呢，下面简单的三步就可以搞定。

一、
以root用户登录，或者登录后切换到root用户、
在终端输入： hostname 会显示当前主机名。 
---


在阿里云买了一台Linux服务器，可是root用户名竟然是产品ID，用起来很不爽。

如何改用户名呢，下面简单的三步就可以搞定。

一、
以root用户登录，或者登录后切换到root用户、
在终端输入： hostname 会显示当前主机名。
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

在阿里云买了一台Linux服务器，可是root用户名竟然是产品ID，用起来很不爽。

如何改用户名呢，下面简单的三步就可以搞定。

一、
以root用户登录，或者登录后切换到root用户、
在终端输入： hostname 会显示当前主机名。

![](http://img.blog.csdn.net/20161220031135572?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

输入vi /etc/sysconfig/network，然后将HOSTNAME=后面的值改为想要设置的主机名。

![](http://img.blog.csdn.net/20161220034231018?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

二、
更改/etc下的hosts文件，在提示符下输入vi /etc/hosts，然后将localhost.localdomain(可能是其他的，请按照图片找到对应位置，在我这里为chenhaoxiang)改为想要设置的主机名。

![](http://img.blog.csdn.net/20161220034417723?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


三、

输入reboot命令，重新启动服务器。

重启后登录，再输入hostname查看主机名！
总结上面核心命令也就是：

```
vi /etc/sysconfig/network
vi /etc/hosts
reboot
```

本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;