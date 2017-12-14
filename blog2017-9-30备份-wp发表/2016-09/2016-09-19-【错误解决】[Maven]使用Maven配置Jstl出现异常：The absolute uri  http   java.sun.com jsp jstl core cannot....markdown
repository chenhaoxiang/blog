---
layout: post
title: "【错误解决】[Maven]使用Maven配置Jstl出现异常：The absolute uri  http   java.sun.com jsp jstl core cannot..."
date: 2016-09-19 09:35:25 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,❻ 其他,----- 上网技巧/问题解决
tags: [servlet,异常,uri,maven,jstl]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
也就是出现如下错误:严重: Servlet.service() for servlet jsp threw exception 
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/j 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
也就是出现如下错误:严重: Servlet.service() for servlet jsp threw exception 
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/j
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;


也就是出现如下错误:

严重: Servlet.service() for servlet jsp threw exception
org.apache.jasper.JasperException: The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application
	at org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:56)
	at org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:410)...

![](http://img.blog.csdn.net/20160919212430998)

我的JSP页面是这样导入的:

![](http://img.blog.csdn.net/20160919212507404)

我的maven是这样配置的:

![](http://img.blog.csdn.net/20160919212551170)

访问页面出现500错误。

解决方案:

一:
web项目出现如上问题，据查是版本问题：
    JSTL 1.0 的声明是：
    &#60;%@ taglib prefix="c" uri="http://java.sun.com/jstl/core " %&#62;
    JSTL1.1以后 的声明是：
    &#60;%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%&#62;

二：
一方案没问题后，可能是你的Tomcat缺少JSTL包，所以，你只需要在项目的lib下导入JSTL对应版本的包就可以解决该异常了。或者在Tomcat的lib下导入JSTL对应版本的包就可以了。




本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
