---
layout: post
title: "【Linux】把web项目部署到Linux服务器上"
date: 2016-10-16 02:32:35 +0800
comments: true
categories:❻ 其他,----- Linux/Unix
tags: [eclipse,tomcat,mysql,java,服务器]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


打开eclipse，在已经完成的web项目上面点击右键，选择export，然后选择导出成war包



将项目打包成war-输出路径自己选择:



在Linux服务器中安装java环境，tomcat，和mysql等必须的软件

把之前导出来的项目的war包传输到linux服务器 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


打开eclipse，在已经完成的web项目上面点击右键，选择export，然后选择导出成war包



将项目打包成war-输出路径自己选择:



在Linux服务器中安装java环境，tomcat，和mysql等必须的软件

把之前导出来的项目的war包传输到linux服务器
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

打开eclipse，在已经完成的web项目上面点击右键，选择export，然后选择导出成war包

![](http://img.blog.csdn.net/20160925125411482)

将项目打包成war-输出路径自己选择:

![](http://img.blog.csdn.net/20160925125534014)

在Linux服务器中安装java环境，tomcat，和mysql等必须的软件


把之前导出来的项目的war包传输到linux服务器上自己设定的目录下：

![](http://img.blog.csdn.net/20160925130128320)
选中需要上传的文件。
依次点击add --&#62;ok.
![](http://img.blog.csdn.net/20160925130305541)

上传成功了:
![](http://img.blog.csdn.net/20160925130337182)

把项目的war包通过cp或者mv命令移动到tomcat目录下的webapps目录的下面
```
mv chaojijuhui.war /java/apache-tomcat-7.0.72/webapps/
```
![](http://img.blog.csdn.net/20160925130850611)


加入之后，如果你的tomcat之前是启动的，先停止。
然后再启动。
tomcat会自动把我们的war包解压的。

如果缺少什么包，你可以添加到tomcat的lib目录下。

这样，你就可以通过后面加项目名访问你项目了。


本文章由&#60;a href="https://chenhaoxiang.github.io/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
