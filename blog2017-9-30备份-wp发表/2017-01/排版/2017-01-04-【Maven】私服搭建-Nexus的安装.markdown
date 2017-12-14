---
layout: post
title: "【Maven】私服搭建-Nexus的安装"
date: 2017-01-04 08:37:29 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [maven,nexus,局域网]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215本文源自【大学之旅_谙忆的博客】
可以想象这样一个情景，当公司一个项目，先是3个人开发的时候，他们用Maven已经依赖了很多包了，现在来了一个新人，他也需要开发这个项目，如果他继续从中央仓库下载，那么无疑会下载很久，那么有什么办法解决呢，那就是搭建私服，在公司局域网中下载包当然会快很多！现在来讲解一下如何安装nexus吧 
---


转载请注明出处：http://blog.csdn.net/qq_26525215本文源自【大学之旅_谙忆的博客】
可以想象这样一个情景，当公司一个项目，先是3个人开发的时候，他们用Maven已经依赖了很多包了，现在来了一个新人，他也需要开发这个项目，如果他继续从中央仓库下载，那么无疑会下载很久，那么有什么办法解决呢，那就是搭建私服，在公司局域网中下载包当然会快很多！现在来讲解一下如何安装nexus吧
&#60;!-- more --&#62;
----------
 

可以想象这样一个情景，当公司一个项目，先是3个人开发的时候，他们用Maven已经依赖了很多包了，现在来了一个新人，他也需要开发这个项目，如果他继续从中央仓库下载，那么无疑会下载很久，那么有什么办法解决呢，那就是搭建私服，在公司局域网中下载包当然会快很多！

现在来讲解一下如何安装nexus吧。

首先当然是去下载nexus咯
<a href="https://www.sonatype.com/download-oss-sonatype" target='_blank'>https://www.sonatype.com/download-oss-sonatype</a>

![](http://img.blog.csdn.net/20170104202236689?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
下载2.14.2版本的。

![](http://img.blog.csdn.net/20170104202417308?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

解压之后，将bin目录的路径添加到path环境变量中去。

![](http://img.blog.csdn.net/20170104202533793?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

添加之后，输入nexus测试一下，会出现如上情况。

先不要管他。接着我们需要改一个配置
![](http://img.blog.csdn.net/20170104202637613?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在bin/jsw/conf目录下找到该文件，打开。

![](http://img.blog.csdn.net/20170104202741082?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

将：
```java
wrapper.java.command=java
```
改为：
```java
wrapper.java.command=C:\Program Files\Java\jdk1.7.0_04\bin\java
```
C:\Program Files\Java\jdk1.7.0_04\bin\java为我的JDK的java.exe文件的绝对路径，你改成你的就可以了！

![](http://img.blog.csdn.net/20170104203044881?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

输入nexus install添加nexus服务

![](http://img.blog.csdn.net/20170104203148833?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

输入nexus start启动服务

![](http://img.blog.csdn.net/20170104203255710?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

验证服务是否正常启动：

在浏览器输入：
http://localhost:8081/nexus/
端口默认是8081 ---当然你可以修改

用户名:admin
密码:admin123
![](http://img.blog.csdn.net/20170104203455117?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

安装完成了！

![](http://img.blog.csdn.net/20170104203557851?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

