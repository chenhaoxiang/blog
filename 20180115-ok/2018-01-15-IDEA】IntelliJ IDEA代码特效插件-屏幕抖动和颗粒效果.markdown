---
layout: post
title: "【IDEA】IntelliJ IDEA代码特效插件-屏幕抖动和颗粒效果"
date: 2018-01-15 23:05:54 +0800
comments: true
categories: IDEA
tags: [IDEA]
keyword: 陈浩翔, 谙忆, IDEA, 特效
description:  IntelliJ IDEA代码特效插件-屏幕抖动和颗粒效果
---

之前用atom的时候，发现atom上的一个插件在写代码的时候很酷炫，就安装了用了用。  
也就是activate-power-mode atom package ，这个直接在atom上搜索安装即可  

但是没办法，用atom开发JavaWeb项目肯定是不太方便的，强大的IDEA有没有类似的效果插件呢  

用搜索引擎搜了下，果然发现有。  

而且还是同一款插件，在IDEA的Plugins 里面搜索： activate-power-mode 

![](https://i.imgur.com/ZMqQxWy.png)  

点击Install的绿色按钮，下载安装即可。安装完成后重启，写代码的时候就会看到特效了。    

但是该插件的屏幕抖动效果无法关闭，用久了会不舒服，推荐用下面的另一个插件  

也就是Power Mode插件，也是在Plugins 里面搜索，直接搜索:Power Mode  

![](https://i.imgur.com/TwyDuY6.png)  

在这里，我因为安装了，没有那个绿色的安装按钮，你没安装过的，直接点击Install按钮下载安装，重启即可  

这款插件可以设置一些东西，看下图  

![](https://i.imgur.com/5WMNoJp.png) 

建议把抖动给关了，影响检索的性能，而且眼花~  

后面还有几个设置：  
spark count - 颗粒数量  
spark life[ms] 生存时间，单位毫秒  
spark size[px] 小碎片的像素大小  
spark velocity factor % 小碎片的运动速率  
spark gravity factor % 重力大小-重力越大，小碎片漂浮高度越小，下沉速度越快，重力小于0时碎片往上漂浮  

我也就开启了颗粒，因为开多了会影响IDEA智能补全的速度。  
开启一个，稍稍增加点不一样的感觉，哈哈 调节下心情吧  
