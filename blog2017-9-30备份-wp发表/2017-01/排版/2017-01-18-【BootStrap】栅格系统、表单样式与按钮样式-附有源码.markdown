---
layout: post
title: "【BootStrap】栅格系统、表单样式与按钮样式-附有源码"
date: 2017-01-18 09:03:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- BootStrap
tags: [bootstrap,表单,移动设备,响应式]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
栅格系统1、栅格系统介绍Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。Bootstrap的栅格系统，由一个行(.row)和多个列构成。栅格系统用于通过一系列的行（row）与列（column）的组 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
栅格系统1、栅格系统介绍Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。Bootstrap的栅格系统，由一个行(.row)和多个列构成。栅格系统用于通过一系列的行（row）与列（column）的组
&#60;!-- more --&#62;
----------

# 栅格系统
## 1、栅格系统介绍

Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。

Bootstrap的栅格系统，由一个行(.row)和多个列构成。

栅格系统用于通过一系列的行（row）与列（column）的组合来创建页面布局，你的内容就可以放入这些创建好的网页布局中。具体的数据(文字、图片等都可以)放入列当中。

注意：栅格系统，必须放在.container（固定宽度）或.container-fluid（100% 宽度）中，以便为其赋予合适的排列（aligment）和内补（padding）。

如果一“行（row）”中包含了的“列（column）”大于 12，多余的“列（column）”所在的元素将被作为一个整体另起一行排列。

## 2、栅格系统参数

![](http://img.blog.csdn.net/20170118200605929?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 实例：从堆叠到水平排列

使用单一的一组 .col-md-* 栅格类，就可以创建一个基本的栅格系统，在手机和平板设备上一开始是堆叠在一起的（超小屏幕到小屏幕这一范围），在桌面（中等）屏幕设备上变为水平排列。所有“列（column）必须放在 ” .row 内。

```html
&#60;div class="row"&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
  &#60;div class="col-md-1"&#62;.col-md-1&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-md-8"&#62;.col-md-8&#60;/div&#62;
  &#60;div class="col-md-4"&#62;.col-md-4&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-md-4"&#62;.col-md-4&#60;/div&#62;
  &#60;div class="col-md-4"&#62;.col-md-4&#60;/div&#62;
  &#60;div class="col-md-4"&#62;.col-md-4&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-md-6"&#62;.col-md-6&#60;/div&#62;
  &#60;div class="col-md-6"&#62;.col-md-6&#60;/div&#62;
&#60;/div&#62;
```

![](http://img.blog.csdn.net/20170118200731775?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 实例：移动设备和桌面屏幕

是否不希望在小屏幕设备上所有列都堆叠在一起？那就使用针对超小屏幕和中等屏幕设备所定义的类吧，即 .col-xs-* 和 .col-md-*。请看下面的实例，研究一下这些是如何工作的。

```html
&#60;!-- Stack the columns on mobile by making one full-width and the other half-width --&#62;
&#60;div class="row"&#62;
  &#60;div class="col-xs-12 col-md-8"&#62;.col-xs-12 .col-md-8&#60;/div&#62;
  &#60;div class="col-xs-6 col-md-4"&#62;.col-xs-6 .col-md-4&#60;/div&#62;
&#60;/div&#62;

&#60;!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop --&#62;
&#60;div class="row"&#62;
  &#60;div class="col-xs-6 col-md-4"&#62;.col-xs-6 .col-md-4&#60;/div&#62;
  &#60;div class="col-xs-6 col-md-4"&#62;.col-xs-6 .col-md-4&#60;/div&#62;
  &#60;div class="col-xs-6 col-md-4"&#62;.col-xs-6 .col-md-4&#60;/div&#62;
&#60;/div&#62;

&#60;!-- Columns are always 50% wide, on mobile and desktop --&#62;
&#60;div class="row"&#62;
  &#60;div class="col-xs-6"&#62;.col-xs-6&#60;/div&#62;
  &#60;div class="col-xs-6"&#62;.col-xs-6&#60;/div&#62;
&#60;/div&#62;

```
![](http://img.blog.csdn.net/20170118201001636?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 实例：手机、平板、桌面

在上面案例的基础上，通过使用针对平板设备的 .col-sm-* 类，我们来创建更加动态和强大的布局吧。

```html
&#60;div class="row"&#62;
  &#60;div class="col-xs-12 col-sm-6 col-md-8"&#62;.col-xs-12 .col-sm-6 .col-md-8&#60;/div&#62;
  &#60;div class="col-xs-6 col-md-4"&#62;.col-xs-6 .col-md-4&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-xs-6 col-sm-4"&#62;.col-xs-6 .col-sm-4&#60;/div&#62;
  &#60;div class="col-xs-6 col-sm-4"&#62;.col-xs-6 .col-sm-4&#60;/div&#62;
  &#60;!-- Optional: clear the XS cols if their content doesn't match in height --&#62;
  &#60;div class="clearfix visible-xs-block"&#62;&#60;/div&#62;
  &#60;div class="col-xs-6 col-sm-4"&#62;.col-xs-6 .col-sm-4&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118201157777?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

##实例：多余的列（column）将另起一行排列

如果在一个 .row 内包含的列（column）大于12个，包含多余列（column）的元素将作为一个整体单元被另起一行排列。

```html
&#60;div class="row"&#62;
  &#60;div class="col-xs-9"&#62;.col-xs-9&#60;/div&#62;
  &#60;div class="col-xs-4"&#62;.col-xs-4&#60;br&#62;Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.&#60;/div&#62;
  &#60;div class="col-xs-6"&#62;.col-xs-6&#60;br&#62;Subsequent columns continue along the new line.&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118201240559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 列偏移

使用 .col-md-offset-* 类可以将列向右侧偏移。这些类实际是通过使用 * 选择器为当前元素增加了左侧的边距（margin）。例如，.col-md-offset-4 类将 .col-md-4 元素向右侧偏移了4个列（column）的宽度。

```html
&#60;div class="row"&#62;
  &#60;div class="col-md-4"&#62;.col-md-4&#60;/div&#62;
  &#60;div class="col-md-4 col-md-offset-4"&#62;.col-md-4 .col-md-offset-4&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-md-3 col-md-offset-3"&#62;.col-md-3 .col-md-offset-3&#60;/div&#62;
  &#60;div class="col-md-3 col-md-offset-3"&#62;.col-md-3 .col-md-offset-3&#60;/div&#62;
&#60;/div&#62;
&#60;div class="row"&#62;
  &#60;div class="col-md-6 col-md-offset-3"&#62;.col-md-6 .col-md-offset-3&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118201906180?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 嵌套列
列嵌套：就是在某个栏中，再嵌套一个完整的栅格系统。

为了使用内置的栅格系统将内容再次嵌套，可以通过添加一个新的 .row 元素和一系列 .col-sm-* 元素到已经存在的 .col-sm-* 元素内。被嵌套的行（row）所包含的列（column）的个数不能超过12（其实，没有要求你必须占满12列）。
![](http://img.blog.csdn.net/20170118202733035?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```html
&#60;div class="row"&#62;
  &#60;div class="col-sm-9"&#62;
    Level 1: .col-sm-9
    &#60;div class="row"&#62;
      &#60;div class="col-xs-8 col-sm-6"&#62;
        Level 2: .col-xs-8 .col-sm-6
      &#60;/div&#62;
      &#60;div class="col-xs-4 col-sm-6"&#62;
        Level 2: .col-xs-4 .col-sm-6
      &#60;/div&#62;
    &#60;/div&#62;
  &#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118202017494?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 列排序

通过使用 .col-md-push-* 和 .col-md-pull-* 类就可以很容易的改变列（column）的顺序。
.col-md-push-n 向右移n列！
 .col-md-pull-n 向左移n列！
 注意！！！这个是绝对定位，也就是其他列不动！这个列会和其他列重叠！
```html
&#60;div class="row"&#62;
  &#60;div class="col-md-9 col-md-push-3"&#62;.col-md-9 .col-md-push-3&#60;/div&#62;
  &#60;div class="col-md-3 col-md-pull-9"&#62;.col-md-3 .col-md-pull-9&#60;/div&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118202054718?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 看一个完整的实例:

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
			&#60;div class="row"&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党国中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
			&#60;/div&#62;

			&#60;div class="row"&#62;
				&#60;div class="col-md-8" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
			&#60;/div&#62;

			&#60;div class="row"&#62;
				&#60;div class="col-md-9" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-6" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
			&#60;/div&#62;
			&#60;!-- --           	
				作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列向右偏移
            --&#62;
			&#60;div class="row"&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-offset-4 col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
			&#60;/div&#62;

			&#60;!--
            	作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列嵌套
            --&#62;
			&#60;div class="row"&#62;
				&#60;div class="col-md-4" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人中央委员会总书记、中华人、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
				&#60;/div&#62;
				&#60;div class="col-md-8" style="border: 1px solid #D9534F;"&#62;
					应中国共产党中央委员会总书记、中华人民共和国主席习近平的邀请，越南共产党中央委员会总书记阮富仲于2015年4月7日至10日对中华人民共和国进行正式访问。访问期间，中共中央总书记、国家主席习近平与阮富仲总书记举行会谈。中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声分别会见阮富仲总书记。达成广泛共识。也对促进本地区和世界的和平、稳定、合作与发展产生了积极影响。续发挥好中越双边合作指导委员会等两党两国间交流合作机制的作用，统筹推进合作，协调解决问题，服务于两国人民利益。实施好《落实中越全面战略合作伙伴关系行动计划》，推动两国各领域务实合作取得新进展。
					&#60;!--
                    	作者：chenhaoxiang@chaojijuhui.com
                    	时间：2017-01-18
                    	描述：嵌套栅格系统
                    --&#62;
					&#60;div class="row"&#62;
						&#60;div class="col-md-6" style="background-color: #204D74;height: 150px;"&#62;&#60;/div&#62;
						&#60;div class="col-md-6" style="background-color: #31B0D5;height: 100px;"&#62;&#60;/div&#62;
					&#60;/div&#62;
				&#60;/div&#62;
			&#60;/div&#62;

			&#60;!--
            	作者：chenhaoxiang@chaojijuhui.com
            	时间：2017-01-18
            	描述：列排序
            --&#62;
			&#60;div class="row"&#62;
				&#60;div class="col-md-6 col-md-push-5" style="background-color: #204D74;height: 150px;"&#62;&#60;/div&#62;
				&#60;div class="col-md-6" style="background-color: #31B0D5;height: 100px;"&#62;&#60;/div&#62;
			&#60;/div&#62;

		&#60;/div&#62;

		&#60;script type="text/javascript" src="js/jquery.slim.min.js"&#62;&#60;/script&#62;
		&#60;script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"&#62;&#60;/script&#62;
	&#60;/body&#62;

&#60;/html&#62;
```
整个效果都在：
![](http://img.blog.csdn.net/20170118202605955?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

# 表单样式
## 说明

.form-group表单组样式：将`&#60;label&#62;`和表单元素包含其中，可以获得更好的排列。
.form-control表单元素样式：常用于`&#60;input&#62;`、`&#60;textarea&#62;`、`&#60;select&#62;`元素。
.form-inline内联表单样式(用于form元素)：可以使元素一行排列。
.checkbox复选框样式
.radio单选框样式
.disabled可以禁用单选框或复选项的文本。 disabled="disabled"
.form-horizontal水平排列的表单(用于form元素，类似row)。
.sr-only：可以用于隐藏元素。
.checkbox-inline 控制多个复选框元素在同一行显示。
.radio-inline控制多个单选框元素在同一行显示。

## 添加额外的图标
你还可以针对校验状态为输入框添加额外的图标。只需设置相应的 .has-feedback 类并添加正确的图标即可。

反馈图标只处理带 `&#60;input class="form-control"&#62;` 这个class的input


图标、label 和输入控件组

对于不带有 label 标签的输入框以及右侧带有附加组件的输入框组，需要手动为其图标定位。为了让所有用户都能访问你的网站，我们强烈建议为所有输入框添加 label 标签。如果你不希望将 label 标签展示出来，可以通过添加 sr-only 类来实现。如果的确不能添加 label 标签，请调整图标的 top 值。对于输入框组，请根据你的实际情况调整 right 值。

```html
&#60;div class="form-group has-success has-feedback"&#62;
  &#60;label class="control-label" for="inputSuccess2"&#62;Input with success&#60;/label&#62;
  &#60;input type="text" class="form-control" id="inputSuccess2"&#62;
  &#60;span class="glyphicon glyphicon-ok form-control-feedback"&#62;&#60;/span&#62;
&#60;/div&#62;
&#60;div class="form-group has-warning has-feedback"&#62;
  &#60;label class="control-label" for="inputWarning2"&#62;Input with warning&#60;/label&#62;
  &#60;input type="text" class="form-control" id="inputWarning2"&#62;
  &#60;span class="glyphicon glyphicon-warning-sign form-control-feedback"&#62;&#60;/span&#62;
&#60;/div&#62;
&#60;div class="form-group has-error has-feedback"&#62;
  &#60;label class="control-label" for="inputError2"&#62;Input with error&#60;/label&#62;
  &#60;input type="text" class="form-control" id="inputError2"&#62;
  &#60;span class="glyphicon glyphicon-remove form-control-feedback"&#62;&#60;/span&#62;
&#60;/div&#62;

```

![](http://img.blog.csdn.net/20170118204525433?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


## 实例

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
			&#60;form class="form-horizontal"&#62;
				&#60;!--表单中的栅栏系统用form-horizontal，其他的用row --&#62;
				&#60;h1&#62;用户注册表单&#60;/h1&#62;
				&#60;div class="form-group"&#62;
					&#60;!--control-label控制label和input之间的水平距离 --&#62;
					&#60;label class="col-md-2 control-label" for="username"&#62;用户名&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;input type="text" class="form-control" id="username" placeholder="请输入用户名" disabled="disabled"/&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;div class="form-group"&#62;
					&#60;label class="col-md-2 control-label" for="password"&#62;密码&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;input type="password" class="form-control" id="password" placeholder="请输入密码" /&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;!--
                	作者：chenhaoxiang@chaojijuhui.com
                	时间：2017-01-18
                	描述：sr-only -隐藏元素
                --&#62;
				&#60;div class="form-group sr-only"&#62;
					&#60;label class="col-md-2 control-label" for="email"&#62;邮箱&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;input type="email" class="form-control" id="email" placeholder="请输入邮箱" /&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;div class="form-group"&#62;
					&#60;label class="col-md-2 control-label"&#62;上传图片&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
					&#60;input type="file" /&#62;
					&#60;!--
                    	作者：chenhaoxiang@chaojijuhui.com
                    	时间：2017-01-18
                    	描述：class="help-block" 帮助信息以块显示- 间距变长了点，颜色变淡了。
                    --&#62;
					&#60;p class="help-block"&#62;上传的图片类型只能是:.jpg/.gif/.png&#60;/p&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;div class="form-group"&#62;
					&#60;label class="col-md-2 control-label"&#62;兴趣爱好:&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;label class="checkbox-inline"&#62;
							&#60;input type="checkbox" value="画画" /&#62;画画
						&#60;/label&#62;
						&#60;label class="checkbox-inline"&#62;
							&#60;input type="checkbox" value="音乐" /&#62;音乐
						&#60;/label&#62;
						&#60;label class="checkbox-inline"&#62;
							&#60;input type="checkbox" value="体育" /&#62;体育
						&#60;/label&#62;
						&#60;label class="checkbox-inline"&#62;
							&#60;input type="checkbox" value="唱歌" /&#62;唱歌
						&#60;/label&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;div class="form-group"&#62;
					&#60;label class="col-md-2 control-label"&#62;学历:&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;label class="radio-inline"&#62;
							&#60;input type="radio" name="xueli"/&#62;小学
						&#60;/label&#62;
						&#60;label class="radio-inline"&#62;
							&#60;input type="radio" name="xueli"/&#62;初中
						&#60;/label&#62;
						&#60;label class="radio-inline"&#62;
							&#60;input type="radio" name="xueli"/&#62;高中
						&#60;/label&#62;
						&#60;label class="radio-inline"&#62;
							&#60;input type="radio" name="xueli"/&#62;大专
						&#60;/label&#62;
						&#60;label class="radio-inline"&#62;
							&#60;input type="radio" name="xueli"/&#62;本科
						&#60;/label&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				
				&#60;div class="form-group"&#62;
					&#60;label class="col-md-2 control-label"&#62;个人简介:&#60;/label&#62;
					&#60;div class="col-md-10"&#62;
						&#60;textarea class="form-control" rows="5" placeholder="请输入你的个人简介信息"&#62;&#60;/textarea&#62;
					&#60;/div&#62;
				&#60;/div&#62;
				&#60;div class="col-md-10 col-md-offset-2"&#62;
					&#60;button type="button" class="btn btn-default btn-lg"&#62;提交表单&#60;/button&#62;
				&#60;/div&#62;
			&#60;/form&#62;

		&#60;/div&#62;

		&#60;script type="text/javascript" src="js/jquery.slim.min.js"&#62;&#60;/script&#62;
		&#60;script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"&#62;&#60;/script&#62;
	&#60;/body&#62;

&#60;/html&#62;
```

![](http://img.blog.csdn.net/20170118204609824?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

# 按钮样式

```css
可作为按钮使用的元素：&#60;a&#62;、&#60;input&#62;、&#60;button&#62;
.btn：按钮的全局样式。&#60;input type = “button” class = “btn”&#62;
预定义样式：.btn-default、.btn-primary、.btn-success、.btn-info、.btn-warning、.btn-danger、.btn-link
.active按钮激活状态、.disabled按钮禁用状态
按钮尺寸：.btn-lg(大按钮)、.btn-sm(小按钮)、.btn-xs(超小按钮)
.btn-block：将按钮拉伸到撑满整个父元素。
```
## 预定义样式
```html
&#60;!-- Standard button --&#62;
&#60;button type="button" class="btn btn-default"&#62;Default&#60;/button&#62;

&#60;!-- Provides extra visual weight and identifies the primary action in a set of buttons --&#62;
&#60;button type="button" class="btn btn-primary"&#62;Primary&#60;/button&#62;

&#60;!-- Indicates a successful or positive action --&#62;
&#60;button type="button" class="btn btn-success"&#62;Success&#60;/button&#62;

&#60;!-- Contextual button for informational alert messages --&#62;
&#60;button type="button" class="btn btn-info"&#62;Info&#60;/button&#62;

&#60;!-- Indicates caution should be taken with this action --&#62;
&#60;button type="button" class="btn btn-warning"&#62;Warning&#60;/button&#62;

&#60;!-- Indicates a dangerous or potentially negative action --&#62;
&#60;button type="button" class="btn btn-danger"&#62;Danger&#60;/button&#62;

&#60;!-- Deemphasize a button by making it look like a link while maintaining button behavior --&#62;
&#60;button type="button" class="btn btn-link"&#62;Link&#60;/button&#62;
```
![](http://img.blog.csdn.net/20170118203444991?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 尺寸

按钮尺寸：.btn-lg(大按钮)、.btn-sm(小按钮)、.btn-xs(超小按钮)

通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素。

## 激活状态

```css
当按钮处于激活状态时，其表现为被按压下去（底色更深、边框夜色更深、向内投射阴影）。对于 &#60;button&#62; 元素，是通过 :active 状态实现的。对于 &#60;a&#62; 元素，是通过 .active 类实现的。然而，你还可以将 .active 应用到 &#60;button&#62; 上，并通过编程的方式使其处于激活状态。
```

### button 元素

由于 :active 是伪状态，因此无需额外添加，但是在需要让其表现出同样外观的时候可以添加 .active 类。

```css
&#60;button type="button" class="btn btn-primary btn-lg active"&#62;Primary button&#60;/button&#62;
&#60;button type="button" class="btn btn-default btn-lg active"&#62;Button&#60;/button&#62;
```
![](http://img.blog.csdn.net/20170118204807689?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


### 链接（`&#60;a&#62;`）元素
可以为基于 `&#60;a&#62;` 元素创建的按钮添加 .active 类。
这里的role="button"  ， role是无障碍设计里的标签（属性role的存在，是为了告诉Accessibility类应用（比如屏幕朗读程序，为盲人提供的访问网络的便利程序），这是一个按钮。在html5元素内，标签本身就是有语义的，因此role是不必添加的，至少是不推荐的，但是bootstrap的案例内很多都是有类似的属性和声明的，目的是为了兼容老版本的浏览器（用户代理））
```html
&#60;a href="#" class="btn btn-primary btn-lg active" role="button"&#62;Primary link&#60;/a&#62;
&#60;a href="#" class="btn btn-default btn-lg active" role="button"&#62;Link&#60;/a&#62;
```
显示效果和上面的图片一样！

## 禁用状态

为 `&#60;button&#62;` 元素添加 disabled 属性，使其表现出禁用状态。

```html
&#60;button type="button" class="btn btn-lg btn-primary" disabled="disabled"&#62;Primary button&#60;/button&#62;
&#60;button type="button" class="btn btn-default btn-lg" disabled="disabled"&#62;Button&#60;/button&#62;

```

为基于 `&#60;a&#62;` 元素创建的按钮添加 .disabled 类。

```html
&#60;a href="#" class="btn btn-primary btn-lg disabled" role="button"&#62;Primary link&#60;/a&#62;
&#60;a href="#" class="btn btn-default btn-lg disabled" role="button"&#62;Link&#60;/a&#62;

```

# 两个完整实例源码链接:

<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/BootStrap/tree/master/day2' target='_blank'>点我进行下载</a>】</strong>
</blockquote>
