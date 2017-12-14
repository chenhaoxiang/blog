---
layout: post
title: "【系统】[Linux]CentOS 7之下载、制作U盘系统盘篇"
date: 2016-09-13 06:46:14 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [centos,u盘,linux]
keyword: 陈浩翔, 谙忆
description: 下载CentOS镜像:
下载这个CentOS镜像的方式有很多种，这这里只介绍2种比较好的下载链接网址与方式。
还有制作CentOS7的U盘系统盘教程 
---


下载CentOS镜像:
下载这个CentOS镜像的方式有很多种，这这里只介绍2种比较好的下载链接网址与方式。
还有制作CentOS7的U盘系统盘教程
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

#下载CentOS镜像:

下载这个CentOS镜像的方式有很多种，这这里只介绍2种比较好的下载链接网址与方式。
##第一种:

进入http://centos.ustc.edu.cn/centos/ 此官方下载网站，包含了所有的版本，在这里，最新的能下载iso的是7.2版本。
在这里，我演示的是7.0版本的。

点击7.0.1406进入...

![](http://img.blog.csdn.net/20160913172906907)

然后点击isos目录，继续进入...

![](http://img.blog.csdn.net/20160913173242693)

这个版本只有64位的，于是我们选择这个64位版本进去...

![](http://img.blog.csdn.net/20160913173317975)

下面这些列出的，是CentOS7 的不同小版本，一般的，我们下载DVD的就可以了。

![](http://img.blog.csdn.net/20160913173351835)

对于这些版本，解释是:

```
CentOS-7.0-1406-x86_64-DVD.iso             标准安装版，一般下载这个就可以了
CentOS-7.0-1406-x86_64-NetInstall.iso       网络安装镜像
CentOS-7.0-1406-x86_64-Everything.iso     对完整版安装盘的软件进行补充，集成所有软件。
CentOS-7.0-1406-x86_64-GnomeLive.iso   GNOME桌面版
CentOS-7.0-1406-x86_64-KdeLive.iso         KDE桌面版
CentOS-7.0-1406-x86_64-livecd.iso            光盘上运行的系统，类拟于winpe 
```
##第二种方式:

进入此网站: https://www.centos.org/download/

![](http://img.blog.csdn.net/20160913173434695)

直接点击DVD ISO进入就可以去下载了。

![](http://img.blog.csdn.net/20160913173934812)

Actual Country 实际国家,其实就是你所在的国家，即“本国”
Nearby Countries 附近国家 。

我选择本国的第一个进去:

![](http://img.blog.csdn.net/20160913174042743)

随便选一个下载就可以了。

#制作U盘系统盘:

下载好CentOS7的系统镜像了，我们需要一个系统启动盘。
这里用到了一个工具:UltraISo.
为了你们方便，直接给你们破解版的下载链接:

https://github.com/chenhaoxiang/Java/blob/master/UltraISO/UltraISO.zip

注:请勿用于商用，如有版权纠纷，于博主无任何关系。

在下面选中我们需要安装的CentOS的镜像，双击打开。

![](http://img.blog.csdn.net/20160913174413885)

启动---&#62;写入硬盘映像...

![](http://img.blog.csdn.net/20160913174501495)

硬盘驱动器：选择将要写入的U盘。
写入方式 : USB-HDD+ 
刻录校验：最好选上

![](http://img.blog.csdn.net/20160913174531823)

然后点写入。

点是之前确保U盘中的内容已经备份好哦、

![](http://img.blog.csdn.net/20160913174852261)

开始写入硬盘映像，可能需要几分钟，耐心等待哦。

![](http://img.blog.csdn.net/20160913174932059)

到这一步就是成功了，点返回。

![](http://img.blog.csdn.net/20160913175015529)

这样就成功了，注意，如果想要以后U盘还想用这个系统安装盘。就不要去删刚刚做好了之后U盘中的任何东西哦。
当然存储与删除其他文件是没问题的。


本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
