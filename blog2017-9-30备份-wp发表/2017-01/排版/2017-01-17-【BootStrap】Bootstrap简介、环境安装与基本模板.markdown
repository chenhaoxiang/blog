---
layout: post
title: "【BootStrap】Bootstrap简介、环境安装与基本模板"
date: 2017-01-17 08:16:41 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,javascript,html,css,设计师]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
BootStrap简介什么是BootStrap它由Twitter的设计师Mark Otto和Jacob Thornton合作开发。 
基于 HTML、CSS、JAVASCRIPT。 
主要是前端的框架(HTML、CSS、JS)。 
（使用BootStrap前需要先导入JQurey）Bo 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
BootStrap简介什么是BootStrap它由Twitter的设计师Mark Otto和Jacob Thornton合作开发。 
基于 HTML、CSS、JAVASCRIPT。 
主要是前端的框架(HTML、CSS、JS)。 
（使用BootStrap前需要先导入JQurey）Bo
&#60;!-- more --&#62;
----------

# BootStrap简介

## 什么是BootStrap

它由Twitter的设计师Mark Otto和Jacob Thornton合作开发。
基于 HTML、CSS、JAVASCRIPT。
主要是前端的框架(HTML、CSS、JS)。
（使用BootStrap前需要先导入JQurey）
## Bootstrap有什么样的特点？

学习比较简单，只要有了一定的HTML、CSS、JS基础，就可以学习。
响应式布局。
移动设备优先。

# Bootstrap环境安装

## 下载网址:
BootStrap3: 
<a href="http://v3.bootcss.com/" target='_blank'>http://v3.bootcss.com/</a>
BootStrap4: 
<a href="http://v4.bootcss.com/" target='_blank'>http://v4.bootcss.com/</a>

![](http://img.blog.csdn.net/20170117194205281?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170117194242079?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

下载完后解压:
![](http://img.blog.csdn.net/20170117194328940?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

我们一般需要的就是:
CSS
![](http://img.blog.csdn.net/20170117194417504?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
JS
![](http://img.blog.csdn.net/20170117194447240?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

要想使用Bootstrap必须要先加载jquery。

# Bootstrap基本模板

## HTML5文档类型定义

Boostrap的文档是基于HTML5的。因此，要使用HTML5的文档类型定义(DTD)。
```html
&#60;!DOCTYPE html&#62;
```
字符集设置
```html
&#60;meta charset="utf-8"&#62;
```
设置移动设备优先

```html
&#60;meta name="viewport" content="window=device-width,initial-scale=1"&#62;
```
引入CSS和JS文件

```html
&#60;!DOCTYPE html&#62;
&#60;html&#62;
&#60;head&#62;
	&#60;title&#62;BootStrap基础入门&#60;/title&#62;
	&#60;meta charset="utf-8"&#62;
	&#60;meta name="viewport" content="width=device-width,initial-scale=1"&#62;
	&#60;link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css"&#62;
	
	&#60;script type="text/javascript" src="js/jquery.slim.min.js" &#62;&#60;/script&#62;
	&#60;script type="text/javascript" src="bootstrap3/js/bootstrap.min.js" &#62;&#60;/script&#62;
&#60;/head&#62;
&#60;body&#62;&#60;/body&#62;

&#60;/html&#62;
```

好了，上面那个就是一个最简单的模板了，然后你可以直接使用bootstrap的样式了哦。
