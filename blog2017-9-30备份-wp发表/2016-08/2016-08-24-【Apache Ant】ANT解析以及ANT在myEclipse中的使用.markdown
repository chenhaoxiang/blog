---
layout: post
title: "【Apache Ant】ANT解析以及ANT在myEclipse中的使用"
date: 2016-08-24 03:14:51 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具
tags: [apache,java,ant,myeclipse]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
维基百科上对Ant的介绍:Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个< 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
维基百科上对Ant的介绍:Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个&#60;
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

#维基百科上对Ant的介绍:

Apache Ant，是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。

由Apache软件基金会所提供。默认情况下，它的buildfile(XML文件)名为build.xml。每一个buildfile含有一个`&#60;project&#62;`和至少一个预设的`&#60;target&#62;`，这些targets包含许多task elements。每一个task element有一个用来被参考的id，此id必须是唯一的。

##`&#60;project&#62;`标签 
default表示默认的执行目标,必须有的。 
basedir-是工作的根目录   .号代表项目根目录，必须有的。
name表示项目名称。 

##`&#60;property&#62;`标签 

```
&#60;property name="src" value="cn.hncu"/&#62;
```

变量名为src，值为cn.hncu.
在其他标签中用${src}-引用src的值,cn.hncu.


##`&#60;target&#62;`标签 

一个项目`&#60;project&#62;`标签下可以有一个或多个target标签,
一个target标签可以依赖其他target标签,(被依赖的标签先执行)
target所有属性如下所示： 

name表示这个标签的名字,这个属性是必须的。 
depends表示依赖的目标target标签的name。 

Ant的depends属性指定了target的执行顺序,Ant会依照depends属性中target标签出现顺序依次执行每个target,在执行之前首先执行它所依赖的target标签

if表示仅当属性设置时才执行。 
unless表示当属性没有设置时才执行。 
description表示项目的描述(或者是对这个标签的作用进行表述)。 


##`&#60;mkdir&#62;`标签 
该标签用于创建目录,它有一个属性dir用户指定所创建的目录.

```
&#60;target name="md"&#62;
	&#60;mkdir dir="d:/a/a1"/&#62;
&#60;/target&#62;
```
表示在D盘下创建a文件夹，a文件夹下创建a1文件夹。


##`&#60;delete&#62;`标签

该标签用于删除目录,它有一个属性dir用户指定删除的目录.

```
&#60;target name="del"&#62;
	  &#60;delete dir="d:/a/a1"&#62;&#60;/delete&#62;
&#60;/target&#62;
```
表示删除d盘的a目录下的a1文件夹以及a1文件夹下的所有文件。


##`&#60;jar&#62;`标签 

该标签用来生成一个JAR包

```
&#60;target name="jar"&#62;
	&#60;jar basedir="." destfile="d:/a/mail.jar"&#62;
	&#60;/jar&#62;
&#60;/target&#62;
```
basedir表示被归档成jar的文件目录。
destfile表示压缩成jar输出到那个目录，名字为啥。
includes表示被归档的文件模式。 
exchudes表示被排除的文件模式。
manifest属性指定自己的META-INF/MANIFEST.MF文件，而不是由系统生成
 


##`&#60;echo&#62;`标签 

该标签用来在控制台输出信息,其输入如下： 
message表示输入的内容。 

```
&#60;target name="hello2" depends="hello1" description="输出"&#62;
	&#60;echo message="Hello222"&#62;&#60;/echo&#62;
&#60;/target&#62;
	
&#60;target name="hello1" &#62;
	&#60;echo message="Hello111"&#62;&#60;/echo&#62;
&#60;/target&#62;
```
先输出Hello111再输出Hello222，因为hello2依赖hello1(depends)


##&#60;javadoc&#62;标签
效果图:

![](http://img.blog.csdn.net/20160824144528926)

```
&#60;target name="jdoc"&#62;
	   &#60;javadoc sourcepath="src"
	   	destdir="d:/a/a"
	   	packagenames="cn.hncu.*"
	   	encoding="utf-8"
	   	docencoding="gbk"&#62;
	   &#60;/javadoc&#62;
	&#60;/target&#62;
```
sourcepath-指定查找输入源文件的位置-src表示src下的所有源文件(.java)输入
destdir-输出的文件位置
packagenames-包名
encoding-源java文件的编码
docencoding-输出文件的编码


##简单的例子:

```
&#60;?xml version="1.0" encoding="utf-8"?&#62;
&#60;project basedir="." name="myMailWeb" default="hello2" &#62;
	&#60;property name="src" value="src"/&#62;
	
	&#60;target name="hello2" depends="hello1" description="输出"&#62;
       &#60;echo message="Hello222"&#62;&#60;/echo&#62;
    &#60;/target&#62;
	
	&#60;target name="hello1" &#62;
		&#60;echo message="Hello111"&#62;&#60;/echo&#62;
	&#60;/target&#62;
	
	&#60;target name="jar"&#62;
		&#60;jar jarfile="mal.jar" basedir="." destfile="d:/a/mail.jar"&#62;
		&#60;/jar&#62;
	&#60;/target&#62;
	
	&#60;target name="jdoc"&#62;
	   &#60;javadoc sourcepath="src"
	   	destdir="d:/a/a"
	   	packagenames="cn.hncu.*"
	   	encoding="utf-8"
	   	docencoding="gbk"&#62;
	   &#60;/javadoc&#62;
	&#60;/target&#62;
	
	&#60;target name="md"&#62;
	  &#60;mkdir dir="d:/a/a1"/&#62;
	&#60;/target&#62;
	
	&#60;target name="del"&#62;
	  &#60;delete dir="d:/a/a1" &#62;&#60;/delete&#62;
	&#60;/target&#62;
	
&#60;/project&#62;

```

#在myEclipse中的运行:

![](http://img.blog.csdn.net/20160824145708738)

选第一个是上次运行的targets标签，如果上次没运行，就是默认的。

选第二个Ant Build....就是让我们自己选运行哪个或者哪几个。

![](http://img.blog.csdn.net/20160824150459226)

description就是运行时有提示的那个。


ant的知识点太多了，其实只是一个辅助我们的工具，个人觉得完全没必要去很熟练的使用所有的，但是打jar包，输出Javadoc等常用的，还是必须熟练。


&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;