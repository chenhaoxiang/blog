---
layout: post
title: "【BootStrap】图片样式、辅助类样式和CSS组件 -附源码"
date: 2017-01-19 06:55:41 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程,----- ----- BootStrap
tags: [bootstrap,css,图片,class]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先把模板代码上上来:<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
首先把模板代码上上来:&#60;!DOCTYPE html&#62;
&#60;html&#62;
    &#60;head&#62;
        &#60;meta charset="UTF-8"&#62;
        &#60;meta http-equiv="X-UA-Compatible" content="IE=edge"&#62;
&#60;!-- more --&#62;
----------


首先把模板代码上上来:

```html
&#60;!DOCTYPE html&#62;
&#60;html&#62;
	&#60;head&#62;
		&#60;meta charset="UTF-8"&#62;
		&#60;meta http-equiv="X-UA-Compatible" content="IE=edge"&#62;
		&#60;meta name="viewport" content="width=device-width, initial-scale=1"&#62;

		&#60;link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" /&#62;
		&#60;!--判断IE9  用来支持HTML5  
		html5shiv.min.js-没有那个元素，就创建那个元素
		respond.min.js支持响应式布局的
		--&#62;
		&#60;!--[if lt IE 9]&#62; 
      	&#60;script src="js/html5shiv.min.js"&#62;&#60;/script&#62;
      	&#60;script src="js/respond.min.js"&#62;&#60;/script&#62;
    	&#60;![endif]--&#62;
		&#60;title&#62;BootStrap基础入门&#60;/title&#62;
	&#60;/head&#62;

	&#60;body style="background-color: #CCCCCC;"&#62;
		&#60;div class="container" style="background-color: #FFFFFF;"&#62;
		&#60;/div&#62;
		&#60;script type="text/javascript" src="js/jquery.slim.min.js"&#62;&#60;/script&#62;
		&#60;script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"&#62;&#60;/script&#62;
	&#60;/body&#62;

&#60;/html&#62;
```

# 图片样式

.img-responsive：直接为图片添加该样式，可以实现响应式图片。
.center-block：图片居中样式，而不能使用text-center样式。
图片形状样式：.img-rounded(圆角图片)、.img-circle(圆形图片)、.img-thumbnail(边框圆角)

```html
&#60;h2 class="page-header"&#62;图片样式应用&#60;/h2&#62;
&#60;div&#62;
	&#60;img class="img-responsive img-thumbnail center-block" src="img/011.jpg" /&#62;
	&#60;p&#62;文字文字文字文字文字文字文字文字文字文字文字文字&#60;/p&#62;
&#60;/div&#62;
```
![](http://img.blog.csdn.net/20170119181735579?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


# 辅助类样式

文本颜色类：.text-muted(柔和的)、.text-primary、.text-success、.text-info、.text-warning、.text-danger
背景颜色类：.bg-primary、.bg-success、.bg-info、.bg-warning、.bg-danger
三角符号：&#60;span class = “caret”&#62;&#60;/span&#62;
快速浮动类：.pull-left(左浮动)、.pull-right(右浮动)
清除浮动：为父元素添加 .clearfix 可以清除浮动。
让内容块网页居中：&#60;div class = “center-block”&#62;&#60;/div&#62;

```html
&#60;h2 class="page-header"&#62;清除浮动的应用&#60;/h2&#62;
&#60;div class="clearfix" style="border: 1px solid red;width: 340px;"&#62;
	&#60;ul class="list-unstyled"&#62;
		&#60;li class="pull-left" style="padding: 10px;"&#62;
			&#60;div class="text-center"&#62;
				&#60;a href=""&#62;&#60;img src="img/001.png" /&#62;&#60;/a&#62;&#60;br /&#62;
				&#60;a href=""&#62;文字1&#60;/a&#62;
				&#60;span class="caret"&#62;&#60;/span&#62;
			&#60;/div&#62;
		&#60;/li&#62;
		&#60;li class="pull-left" style="padding: 10px;"&#62;
			&#60;div class="text-center"&#62;
				&#60;a href=""&#62;&#60;img src="img/002.png" /&#62;&#60;/a&#62;&#60;br /&#62;
				&#60;a href=""&#62;文字2&#60;/a&#62;
			&#60;/div&#62;
		&#60;/li&#62;
		&#60;li class="pull-left" style="padding: 10px;"&#62;
			&#60;div class="text-center"&#62;
				&#60;a href=""&#62;&#60;img src="img/003.png" /&#62;&#60;/a&#62;&#60;br /&#62;
				&#60;a href=""&#62;文字3&#60;/a&#62;
			&#60;/div&#62;
		&#60;/li&#62;
		&#60;li class="pull-left" style="padding: 10px;"&#62;
			&#60;div class="text-center"&#62;
				&#60;a href=""&#62;&#60;img src="img/004.png" /&#62;&#60;/a&#62;&#60;br /&#62;
				&#60;a href=""&#62;文字4&#60;/a&#62;
			&#60;/div&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170119181926279?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


# CSS组件

## 下拉菜单

.dropdown将下拉菜单触发器和下拉菜单包含在其中(下拉菜单父元素)。
data-toggle属性：下拉菜单触发器。取值为“dropdown”。
.dropdown-menu：给`&#60;ul&#62;`指定下拉菜单的样式。
.dropup：向上弹出的下拉菜单(下拉菜单父元素)。
下拉菜单对齐方式：.dropdown-menu-left和.dropdown-menu-right
.divider：为下拉菜单添加分隔线，用于将多个链接分组。
.disabled：禁用的菜单项。

```html
&#60;h2 class="page-header"&#62;下拉菜单的应用&#60;/h2&#62;
&#60;div class="dropdown"&#62;
	&#60;button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"&#62;
		Java课 
		&#60;span class="caret"&#62;&#60;/span&#62;
	&#60;/button&#62;
	&#60;ul class="dropdown-menu"&#62;
		&#60;li&#62;
			&#60;a href=""&#62;HTML&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;CSS&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;Java&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="divider"&#62;&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;Maven&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;MySQL&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;Spring&#60;/a&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170119182058186?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 按钮组

.btn-group：按钮组(可以实现将一组按钮放在同一行)。
.btn-toolbar：按钮组工具栏(将多个按钮组放在其中)。
按钮组的尺寸：.btn-group-lg、.btn-group-sm、.btn-group-xs
.btn-group-vertical：垂直排列的按钮组。

```html
&#60;h2 class="page-header"&#62;按钮组的应用&#60;/h2&#62;
&#60;div class="btn-toolbar"&#62;
	&#60;div class="btn-group btn-group-lg "&#62;
		&#60;button type="button" class="btn btn-default"&#62;按钮一&#60;/button&#62;
		&#60;button type="button" class="btn btn-default"&#62;按钮二&#60;/button&#62;
		&#60;button type="button" class="btn btn-default"&#62;按钮三&#60;/button&#62;
		&#60;button type="button" class="btn btn-default"&#62;按钮四&#60;/button&#62;
		&#60;button type="button" class="btn btn-default"&#62;按钮五&#60;/button&#62;
	&#60;/div&#62;
	&#60;div class="btn-group"&#62;
		&#60;button type="button" class="btn btn-danger"&#62;按钮一&#60;/button&#62;
		&#60;button type="button" class="btn btn-danger"&#62;按钮二&#60;/button&#62;
	&#60;/div&#62;
	&#60;div class="btn-group btn-group-sm"&#62;
		&#60;button type="button" class="btn btn-primary"&#62;按钮一&#60;/button&#62;
		&#60;button type="button" class="btn btn-primary"&#62;按钮二&#60;/button&#62;
	&#60;/div&#62;
	&#60;div class="btn-group btn-group-xs btn-group-vertical"&#62;
		&#60;button type="button" class="btn btn-success"&#62;按钮一&#60;/button&#62;
		&#60;button type="button" class="btn btn-success"&#62;按钮二&#60;/button&#62;
		&#60;button type="button" class="btn btn-success"&#62;按钮三&#60;/button&#62;
	&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170119182258858?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 按钮式下拉菜单

```html
&#60;h2 class="page-header"&#62;按钮式下拉菜单的应用&#60;/h2&#62;
&#60;div class="btn-group dropup"&#62;
	&#60;button type="button" class="btn btn-danger" data-toggle="dropdown"&#62;
		按钮 
		&#60;span class="caret"&#62;&#60;/span&#62;
	&#60;/button&#62;
	&#60;ul class="dropdown-menu" style="overflow: auto;height: 100px;"&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="divider"&#62;&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮1&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮1&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮3&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮2&#60;/a&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
	&#60;button type="button" class="btn btn-danger"&#62;
		按钮 
	&#60;/button&#62;
&#60;/div&#62;
&#60;div class="btn-group dropup"&#62;
	&#60;button type="button" class="btn btn-default"&#62;
		按钮 
	&#60;/button&#62;
	&#60;button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"&#62;
		&#60;span class="caret"&#62;&#60;/span&#62;
	&#60;/button&#62;
	&#60;ul class="dropdown-menu"&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="divider"&#62;&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;按钮&#60;/a&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170119182832752?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里呢，如果我们下拉菜单很多，就可以用滚动条来解决！
用overflow: auto;，然后定义一个高度就好。

## 输入框组

.input-group：只能用于文本框`&#60;input&#62;`，不能用于`&#60;select&#62;`和`&#60;textarea&#62;`。
.input-group-addon用于在`&#60;input&#62;`前后添加额外元素，赋给一个`&#60;span&#62;`元素即可。
注意：将.input-group-addon和`&#60;input&#62;`元素包在.input-group之中。
.input-group-lg 和 .input-group-sm 可以改变输入框组的尺寸。
.input-group-btn可以作为额外元素的按钮，应该是作为`&#60;button&#62;`的父元素。

```html
&#60;h2 class="page-header"&#62;输入框组的应用&#60;/h2&#62;
&#60;div class="input-group"&#62;
	&#60;span class="input-group-addon"&#62;$&#60;/span&#62;
	&#60;input type="text" class="form-control" placeholder="username" /&#62;
	&#60;span class="input-group-addon"&#62;.00&#60;/span&#62;
&#60;/div&#62;
&#60;div class="input-group"&#62;
	&#60;span class="input-group-btn"&#62;
		&#60;button class="btn btn-default"&#62;Go!&#60;/button&#62;
	&#60;/span&#62;
	&#60;input type="text" class="form-control" placeholder="username" /&#62;
&#60;/div&#62;
&#60;div class="input-group"&#62;
	&#60;div class="input-group-btn"&#62;
		&#60;button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"&#62;Action &#60;span class="caret"&#62;&#60;/span&#62;&#60;/button&#62;
		&#60;ul class="dropdown-menu" role="menu"&#62;
			&#60;li&#62;
				&#60;a href="#"&#62;Action&#60;/a&#62;
			&#60;/li&#62;
			&#60;li&#62;
				&#60;a href="#"&#62;Another action&#60;/a&#62;
			&#60;/li&#62;
			&#60;li&#62;
				&#60;a href="#"&#62;Something else here&#60;/a&#62;
			&#60;/li&#62;
			&#60;li class="divider"&#62;&#60;/li&#62;
			&#60;li&#62;
				&#60;a href="#"&#62;Separated link&#60;/a&#62;
			&#60;/li&#62;
		&#60;/ul&#62;
	&#60;/div&#62;
	&#60;!-- /btn-group --&#62;
	&#60;input type="text" class="form-control"&#62;
&#60;/div&#62;
&#60;!-- /input-group --&#62;
&#60;div class="input-group"&#62;
	&#60;div class="input-group-btn"&#62;
		&#60;button type="button" class="btn btn-default"&#62;
		按钮 
	&#60;/button&#62;
		&#60;button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"&#62;
		&#60;span class="caret"&#62;&#60;/span&#62;
	&#60;/button&#62;
		&#60;ul class="dropdown-menu"&#62;
			&#60;li&#62;
				&#60;a href=""&#62;按钮&#60;/a&#62;
			&#60;/li&#62;
			&#60;li&#62;
				&#60;a href=""&#62;按钮&#60;/a&#62;
			&#60;/li&#62;
			&#60;li&#62;
				&#60;a href=""&#62;按钮&#60;/a&#62;
			&#60;/li&#62;
			&#60;li class="divider"&#62;&#60;/li&#62;
			&#60;li&#62;
				&#60;a href=""&#62;按钮&#60;/a&#62;
			&#60;/li&#62;
		&#60;/ul&#62;
	&#60;/div&#62;
	&#60;input type="text" class="form-control"&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170119183139381?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 标签页(选项卡)

.nav是标签页的基类
.nav-tabs是标签页类样式
.active是标签页的状态类(当前样式)
.nav-pills胶囊式标签页
.nav-stacked胶囊式标签页堆放排列(垂直排列)

```html
&#60;h2 class="page-header"&#62;选项卡效果&#60;/h2&#62;
&#60;ul class="nav nav-tabs" role="tablist"&#62;
	&#60;li role="presentation" class="active"&#62;
		&#60;a href="#"&#62;Home&#60;/a&#62;
	&#60;/li&#62;
	&#60;li role="presentation"&#62;
		&#60;a href="#"&#62;Profile&#60;/a&#62;
	&#60;/li&#62;
	&#60;li role="presentation"&#62;
		&#60;a href="#"&#62;Messages&#60;/a&#62;
	&#60;/li&#62;
&#60;/ul&#62;
&#60;ul class="nav nav-pills" role="tablist"&#62;
	&#60;li role="presentation" class="active"&#62;
		&#60;a href="#"&#62;Home&#60;/a&#62;
	&#60;/li&#62;
	&#60;li role="presentation"&#62;
		&#60;a href="#"&#62;Profile&#60;/a&#62;
	&#60;/li&#62;
	&#60;li role="presentation"&#62;
		&#60;a href="#"&#62;Messages&#60;/a&#62;
	&#60;/li&#62;
&#60;/ul&#62;
```

![](http://img.blog.csdn.net/20170119183240723?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 路径导航

.breadcrumb：赋给&#60;ol&#62;可以实现面包屑效果。
.active赋给当前栏目，当前栏目不加链接。


```html
&#60;h2 class="page-header"&#62;路径导航效果&#60;/h2&#62;
&#60;ol class="breadcrumb"&#62;
	&#60;li&#62;
		&#60;a href="#"&#62;Home&#60;/a&#62;
	&#60;/li&#62;
	&#60;li&#62;
		&#60;a href="#"&#62;Library&#60;/a&#62;
	&#60;/li&#62;
	&#60;li class="active"&#62;Data&#60;/li&#62;
&#60;/ol&#62;

```

![](http://img.blog.csdn.net/20170119183417776?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 分页

.pagination赋给&#60;ul&#62;元素可以实现分页效果
`&laquo;` 上一页
`&raquo;` 下一页
.disabled禁用状态
.active激活状态
.pagination-lg分页大尺寸
.pagination-sm分页小尺寸
.pager可以实现翻页效果。上一页、下一页效果。

```html
&#60;div class="text-center" style="border: 1px solid red;"&#62;
	&#60;ul class="pagination pagination-lg pager"&#62;
		&#60;li class="previous"&#62;
			&#60;a href="#"&#62;&larr; 上一页&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="disabled"&#62;
			&#60;a href=""&#62;&laquo;&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="active"&#62;
			&#60;a href=""&#62;1&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;2&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;3&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;4&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;5&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;6&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;7&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;8&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;9&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;10&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;&raquo;&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="next"&#62;
			&#60;a href="#"&#62;下一页 &rarr;&#60;/a&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
&#60;/div&#62;
&#60;div class="text-center" style="border: 1px solid red;"&#62;
	&#60;ul class="pagination pagination-lg"&#62;
		&#60;li&#62;
			&#60;a href=""&#62;&laquo;&#60;/a&#62;
		&#60;/li&#62;
		&#60;li class="active"&#62;
			&#60;a href=""&#62;1&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;2&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;3&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;4&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;5&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;6&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;7&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;8&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;9&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;10&#60;/a&#62;
		&#60;/li&#62;
		&#60;li&#62;
			&#60;a href=""&#62;&raquo;&#60;/a&#62;
		&#60;/li&#62;
	&#60;/ul&#62;
&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170119183913284?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 缩略图

.thumbnail赋给`&#60;a&#62;`元素，可以实现缩略图样式。
.caption 可以实现缩略图标题及描述

```html
&#60;h2 class="page-header"&#62;缩略图效果&#60;/h2&#62;
&#60;div class="row"&#62;
	&#60;div class="col-md-2"&#62;
		&#60;a href="" class="thumbnail"&#62;&#60;img src="img/001.png" /&#62;&#60;/a&#62;
		&#60;div class="caption"&#62;
			&#60;h4&#62;图片一&#60;/h4&#62;
		&#60;/div&#62;
	&#60;/div&#62;
	&#60;div class="col-md-4"&#62;
		&#60;a href="" class="thumbnail"&#62;&#60;img src="img/001.png" /&#62;&#60;/a&#62;
		&#60;div class="caption"&#62;
			&#60;h4&#62;图片一&#60;/h4&#62;
		&#60;/div&#62;
	&#60;/div&#62;
	&#60;div class="col-md-6"&#62;
		&#60;a href="" class="thumbnail"&#62;&#60;img src="img/001.png" /&#62;&#60;/a&#62;
		&#60;div class="caption"&#62;
			&#60;h4&#62;图片一&#60;/h4&#62;
		&#60;/div&#62;
	&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170119184221524?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 导航栏

导航栏有一个不同，他不是写在container包含层里面了，而是那个div的上面！

.navbar：导航栏的基类，用于`&#60;nav&#62;`元素。
.navbar-default：导航栏默认样式，用于`&#60;nav&#62;`元素。
.container是`&#60;nav&#62;`的子元素。导航栏内容都放入其中。
.navbar-header：导航栏头部样式。
.navbar-brand：设置品牌图标样式
.collapse是折叠导航栏的样式的基类。
.navbar-collapse是折叠导航栏样式。
.nav是导航栏的链接基类。
.navbar-nav是导航栏的链接样式。
.navbar-from：导航栏表单，可以使表单元素排在同一行。
.navbar-left 或 .navbar-right ：组件排列。导航链接、表单、按钮或文本对齐。
.navbar-btn：对于不在`&#60;form&#62;`中的`&#60;button&#62;`元素，实现垂直对齐。
.navbar-text：对于导航栏的普通文本有了行距和颜色，通常用于`&#60;p&#62;`元素。
.navbar-fixed-top：导航栏固定在顶部，用于`&#60;nav&#62;`元素。需要为`&#60;body&#62;`设置padding-top:70px
.navbar-fixed-bottom：导航栏固定在底部，用于`&#60;nav&#62;`元素。需要为`&#60;body&#62;`设置padding-bottom:70px;
.navbar-static-top：导航栏静止在顶部，用于`&#60;nav&#62;`元素。会随着滚动条移动而消失。
.navbar-inverse：可以实现反色导航栏，用于`&#60;nav&#62;`元素。


```html
	&#60;nav class="navbar navbar-default navbar-static-top"&#62;
		&#60;!--导航栏头部信息--&#62;
		&#60;div class="container"&#62;
			&#60;!--品牌信息--&#62;
			&#60;div class="navbar-header"&#62;
				&#60;a class="navbar-brand" href=""&#62;Brand&#60;/a&#62;
				&#60;p class="navbar-text"&#62;欢迎光临&#60;/p&#62;
			&#60;/div&#62;

			&#60;!--导航栏主链接--&#62;
			&#60;div class="collapse navbar-collapse"&#62;
				&#60;ul class="nav navbar-nav navbar-left"&#62;
					&#60;li class="active"&#62;
						&#60;a href=""&#62;起步&#60;/a&#62;
					&#60;/li&#62;
					&#60;li&#62;
						&#60;a href=""&#62;CSS全局样式&#60;/a&#62;
					&#60;/li&#62;
					&#60;li&#62;
						&#60;a href=""&#62;组件&#60;/a&#62;
					&#60;/li&#62;
					&#60;li&#62;
						&#60;a href=""&#62;插件&#60;/a&#62;
					&#60;/li&#62;
					&#60;li&#62;
						&#60;a href=""&#62;网站案例&#60;/a&#62;
					&#60;/li&#62;
				&#60;/ul&#62;
				&#60;!--表单 搜索框--&#62;
				&#60;form class="navbar-form navbar-left"&#62;
					&#60;div class="form-group"&#62;
						&#60;input type="text" class="form-control" placeholder="搜索"&#62;
					&#60;/div&#62;
					&#60;button type="submit" class="btn btn-default"&#62;搜索&#60;/button&#62;
				&#60;/form&#62;

				&#60;ul class="nav navbar-nav navbar-right"&#62;
					&#60;li&#62;
						&#60;a href=""&#62;Link&#60;/a&#62;
					&#60;/li&#62;
					&#60;li class="dropdown"&#62;
						&#60;a href="" class="dropdown-toggle" data-toggle="dropdown"&#62;
							Dropdown 
							&#60;span class="caret"&#62;&#60;/span&#62;
						&#60;/a&#62;
						&#60;ul class="dropdown-menu"&#62;
							&#60;li&#62;
								&#60;a href="#"&#62;Action&#60;/a&#62;
							&#60;/li&#62;
							&#60;li&#62;
								&#60;a href="#"&#62;Another action&#60;/a&#62;
							&#60;/li&#62;
							&#60;li&#62;
								&#60;a href="#"&#62;Something else here&#60;/a&#62;
							&#60;/li&#62;
							&#60;li class="divider"&#62;&#60;/li&#62;
							&#60;li&#62;
								&#60;a href="#"&#62;Separated link&#60;/a&#62;
							&#60;/li&#62;
						&#60;/ul&#62;
					&#60;/li&#62;
				&#60;/ul&#62;
			&#60;/div&#62;
		&#60;/div&#62;
	&#60;/nav&#62;

	&#60;div class="container" style="background-color: #FFFFFF;"&#62;
	...
	&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170119184611214?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


好了，然后直接上完整的源码:

#完整的源码链接:

<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/BootStrap/tree/master/day3' target='_blank'>点我进行下载</a>】</strong>
</blockquote>

像学后台的，把这个BootStrap学到这里，然后能灵活应用基本就差不多啦~~~
