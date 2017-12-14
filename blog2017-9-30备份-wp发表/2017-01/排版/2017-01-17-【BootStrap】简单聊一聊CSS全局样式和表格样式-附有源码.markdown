---
layout: post
title: "【BootStrap】简单聊一聊CSS全局样式和表格样式-附有源码"
date: 2017-01-17 10:47:40 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,css,源码]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




CSS全局样式



1、布局容器类样式：.container 和 .container-fluid

.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。

这2个class是直接在body标签下建立一个div标签，c 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




CSS全局样式



1、布局容器类样式：.container 和 .container-fluid

.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。

这2个class是直接在body标签下建立一个div标签，c
&#60;!-- more --&#62;
----------


# CSS全局样式

## 1、布局容器类样式：.container 和 .container-fluid
```css
.container 固定宽度并且具有响应式。
.container-fluid 自由宽度(100%宽度)。
```
这2个class是直接在body标签下建立一个div标签，class等于这2个中的一个。
然后其他内容全部写在这个div标签中即可！
例如:

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
&#60;body&#62;
	&#60;div class="container"&#62;
		&#60;h1&#62;标题H1&#60;/h1&#62;
		&#60;p&#62;正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文正文&#60;/p&#62;
	&#60;/div&#62;
&#60;/body&#62;
&#60;/html&#62;
```

![](http://img.blog.csdn.net/20170117204421502?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

再看.container-fluid：
只修改了这里，其他地方不变
```css
&#60;div class="container-fluid"&#62;
```
![](http://img.blog.csdn.net/20170117204538190?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

也就是说，container-fluid这个是和页面两边是没有间隔的。
而container是有一定间隔的，而且左右两边的间隔相等。


## 2、标题样式：`&#60;h1&#62;到&#60;h6&#62;`、.h1 ~ .h6 

`&#60;h1&#62;~&#60;h6&#62;`样式重写了，基本上做到了兼容性。
（如未加说明，则新代码是接在上面的代码后面）
下面的代码在上面代码的p标签后
```css
&#60;h1&#62;标题H1&#60;/h1&#62;
&#60;font class="h1"&#62;标题H1&#60;/font&#62;
```

![](http://img.blog.csdn.net/20170117211214000?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 3、行内文本样式：

```css
&#60;b&#62;：加粗
&#60;strong&#62;加粗
&#60;i&#62;：斜体
&#60;em&#62;斜体，HTML5新标记
&#60;del&#62;删除线，HTML5新标记。
&#60;s&#62;删除线
```
这几个就不演示了，你自己简单的用一个就懂了。

## 4、文本对齐样式：.text-left、.text-center、.text-right、.text-justify

```css
.text-left：文本左对齐
.text-right：右对齐
.text-center：居中对齐
.text-justify：两端对齐
```

```html
		&#60;div class="text-left"&#62;左对齐:正文正正文正文正文正文正&#60;/div&#62;
		&#60;div class="text-right"&#62;右对齐:正文正正文正文正文正文正&#60;/div&#62;
		&#60;div class="text-center"&#62;居中对齐:正文正文正文正文正&#60;/div&#62;
		&#60;div class="text-justify"&#62;两端对齐:正正文正文正文正正&#60;/div&#62;
```
![](http://img.blog.csdn.net/20170117212440927?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 5、列表样式：

```css
.list-unstyled(无符号)：去掉前面的符号。
.list-inline(行内块)
```
![](http://img.blog.csdn.net/20170117212715319?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
普通的列表样式：首先是前面有一定的空隙，不是和文本同间隔的。
另外的就是有小圆点，当然，你可以改这个符号。

在BootStrap中，我们只需要在ul上加一个class就可以解决这个问题。

在这里，我发现BootStrap4不支持ul在一行显示，也就是添加class="list-inline"是无效的。
所以，我在这里就改用bootstrap3了。

```html
&#60;ul class="list-unstyled"&#62;
			&#60;li&#62;HTML&#60;/li&#62;
			&#60;li&#62;Java&#60;/li&#62;
			&#60;li&#62;JavaScript&#60;/li&#62;
		&#60;/ul&#62;
		&#60;ul class="list-inline"&#62;
			&#60;li&#62;在一行&#60;/li&#62;
			&#60;li&#62;HTML&#60;/li&#62;
			&#60;li&#62;Java&#60;/li&#62;
			&#60;li&#62;JavaScript&#60;/li&#62;
		&#60;/ul&#62;
```

![](http://img.blog.csdn.net/20170117220634372?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


# 表格样式

## 1、.table ：表格全局样式(少量padding和水平方向的分割线)。

```html
			&#60;table class="table"&#62;
				&#60;tr&#62;
					&#60;td&#62;编号&#60;/td&#62;
					&#60;td&#62;新闻标题&#60;/td&#62;
					&#60;td&#62;发布者&#60;/td&#62;
					&#60;td&#62;发布时间&#60;/td&#62;
				&#60;/tr&#62;
				&#60;tr&#62;
					&#60;td&#62;001&#60;/td&#62;
					&#60;td&#62;A&#60;/td&#62;
					&#60;td&#62;CHX&#60;/td&#62;
					&#60;td&#62;2017&#60;/td&#62;
				&#60;/tr&#62;
				&#60;tr&#62;
					&#60;td&#62;002&#60;/td&#62;
					&#60;td&#62;B&#60;/td&#62;
					&#60;td&#62;ANYI&#60;/td&#62;
					&#60;td&#62;2017&#60;/td&#62;
				&#60;/tr&#62;
			&#60;/table&#62;

```

![](http://img.blog.csdn.net/20170117221032502?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 2、.table-striped：有条纹的背景色行(隔行变色)

```css
&#60;table class="table table-striped"&#62;
...
&#60;/table&#62;
```
![](http://img.blog.csdn.net/20170117221158754?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
颜色很浅，不知道你们能不能看清。

## 3、.table-bordered：带边框的表格

```css
&#60;table class="table table-striped table-bordered"&#62;
...
&#60;/table&#62;
```

![](http://img.blog.csdn.net/20170117221315184?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 4、.table-hover：鼠标悬停效果(放上变色、离开恢复)

```css
&#60;table class="table table-striped table-bordered table-hover"&#62;
...
&#60;/table&#62;
```

![](http://img.blog.csdn.net/20170117221540447?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 5、.table-condensed：紧凑的表格(单元格内补会减半)

```css
&#60;table class="table table-striped table-bordered table-hover table-condensed"&#62;
...
&#60;/table&#62;
```
![](http://img.blog.csdn.net/20170117222421876?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 6、行或单元格背景色：

注意：只能给tr或td添加类样式。

```css
.active：当前样式
.success 
.info
.warning
.danger
```
success ：![](http://img.blog.csdn.net/20170117222754573?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
info：![](http://img.blog.csdn.net/20170117222904403?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
warning：![](http://img.blog.csdn.net/20170117222935395?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
danger：![](http://img.blog.csdn.net/20170117222943911?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
html
```
&#60;tr class="active"&#62;
	&#60;td&#62;编号&#60;/td&#62;
	&#60;td&#62;新闻标题&#60;/td&#62;
	&#60;td&#62;发布者&#60;/td&#62;
	&#60;td&#62;发布时间&#60;/td&#62;
&#60;/tr&#62;
&#60;tr class="success"&#62;
	&#60;td&#62;001&#60;/td&#62;
	&#60;td&#62;A&#60;/td&#62;
	&#60;td&#62;CHX&#60;/td&#62;
	&#60;td&#62;2017&#60;/td&#62;
&#60;/tr&#62;
&#60;tr class="info"&#62;
	&#60;td&#62;002&#60;/td&#62;
	&#60;td&#62;B&#60;/td&#62;
	&#60;td class="warning"&#62;ANYI&#60;/td&#62;
	&#60;td class="danger"&#62;2017&#60;/td&#62;
&#60;/tr&#62;
```

![](http://img.blog.csdn.net/20170117222651806?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 7、响应式表格： 

将.table元素包裹在.table-responsive元素内，即可创建响应式表格
当屏幕宽度小于768px时，表格会出现滚动条。
当屏幕宽度大于768px时，表格的滚动条自然消失。

也就是在table标签外再创一个div标签，div的class设置为table-responsive即可。

```html
&#60;div class="table-responsive"&#62;
	&#60;table class="table table-striped table-bordered table-hover table-condensed"&#62;
		&#60;tr class="active"&#62;
			&#60;td&#62;编号&#60;/td&#62;
			&#60;td&#62;新闻标题&#60;/td&#62;
			&#60;td&#62;发布者&#60;/td&#62;
			&#60;td&#62;发布时间&#60;/td&#62;
			&#60;td&#62;发布者&#60;/td&#62;
			&#60;td&#62;发布时间&#60;/td&#62;
			&#60;td&#62;发布者&#60;/td&#62;
			&#60;td&#62;发布时间&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr class="success"&#62;
			&#60;td&#62;001&#60;/td&#62;
			&#60;td&#62;A&#60;/td&#62;
			&#60;td&#62;CHX&#60;/td&#62;
			&#60;td&#62;2017&#60;/td&#62;
			&#60;td&#62;CHX&#60;/td&#62;
			&#60;td&#62;2017&#60;/td&#62;
			&#60;td&#62;CHX&#60;/td&#62;
			&#60;td&#62;2017&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr class="info"&#62;
			&#60;td&#62;002&#60;/td&#62;
			&#60;td&#62;B&#60;/td&#62;
			&#60;td class="warning"&#62;ANYI&#60;/td&#62;
			&#60;td class="danger"&#62;2017&#60;/td&#62;
			&#60;td&#62;CHX&#60;/td&#62;
			&#60;td&#62;2017&#60;/td&#62;
			&#60;td&#62;CHX&#60;/td&#62;
			&#60;td&#62;2017&#60;/td&#62;
		&#60;/tr&#62;
	&#60;/table&#62;
&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170117223435881?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


本节源码:

<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/BootStrap/tree/master/OneDay' target='_blank'>点我进行下载</a>】</strong>
</blockquote>
