---
layout: post
title: "Web---JSTL(Java标准标签库)-Core核心标签库、I18N国际化、函数库"
date: 2016-08-01 04:21:59 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [国际化,java,JSTL,JSP,Web]
keyword: 陈浩翔, 谙忆
description: 前面为JSTL中的常用EL函数，后面的为具体演示实例！JSTL简介：JSTL(Java Standard Tag Library) –Java标准标签库。 
SUN公司制定的一套标准标签库的规范。 
 JSTL标签库，是由一些Java类组成的。JSTL组成：JSTL –Core 核心标签库。 重点 
JSTL – I18N － 国际化标签库。Internationalization-    I18N 
---


前面为JSTL中的常用EL函数，后面的为具体演示实例！JSTL简介：JSTL(Java Standard Tag Library) –Java标准标签库。 
SUN公司制定的一套标准标签库的规范。 
 JSTL标签库，是由一些Java类组成的。JSTL组成：JSTL –Core 核心标签库。 重点 
JSTL – I18N － 国际化标签库。Internationalization-    I18N
&#60;!-- more --&#62;
----------

前面为JSTL中的常用EL函数，后面的为具体演示实例！

JSTL简介：
=======

JSTL(Java Standard Tag Library) –Java标准标签库。
SUN公司制定的一套标准标签库的规范。
 JSTL标签库，是由一些Java类组成的。


JSTL组成：
-------

JSTL –Core 核心标签库。 重点
JSTL – I18N － 国际化标签库。Internationalization-    I18N
JSTL – SQL – 数据库操作标签(有悖于MVC设计模式),现在都不用这个。
JSTL － Functions – 函数库。
JSTL － XML ，对XML的操作(同SQL标签-有悖于MVC设计模式)，现在都不用这个。


JSTL核心标签库：
==========

使用JSTL核心标签：
如果你的Web项目是基于JavaEE2.5或以上的。可以在你项目的任意页面上通过&#60;%@ taglib 指令使用JSTL的核心标签库。

```
&#60;%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%&#62;
```

uri是引用标签库的资源定位符，并不代表一个实际的地址。
Prefix是自定义的前缀。

如果你的项目是JavaEE2.5以下的项目，必须在在你项目中的lib目录下，存在以下两个jar文件为：
Jstl.jar、standard.jar
在上面的包中，存在着jstl的tld文件，用于描述jstl标签的属性、名称、资源等信息。
程序就是通过这个tld文件找到相关java类以供运行的。
然后再在任意的JSP页面通过指令导入jstl.


JSTL-Core一共包含以下几个子标签：
---------------------


```
&#60;c:out&#62; ${name}	输出标签
&#60;c:set&#62;   		pageContext.setAttirbute(key,value,scope);	声明标签
C:remove		删除某个范畴内的数据
&#60;c:if&#62;			判断c:else,c:elsfif
&#60;c:choose&#62;&#60;c:when&#62;&#60;c:otherwise&#62;	判断分枝c:if,c:else if c:
&#60;c:forEach&#62;		遍历
&#60;c:forTokens&#62;	分隔
&#60;c:import&#62;		导入其他资源,相当于动态包含共享同一个request
&#60;c:url&#62;  - 		重写url
&#60;c:redirect&#62;	重定向  response.sendRedirect(‘’..)
```

JSTL标签－out：

```
属性名			可选值							 说明
value	EL表达式、java表达式、或直接字符串	需要输出的内容
escapeXml	 true | false	  是否将html转成&lt;&gt;&quat;等输出。
default	       默认值       	如果value内容不存在时则输出默认值
```

```
&#60;c:out  value=…/&#62;用于在页面上输出结果。
&#60;c:out value=“${requestScope.name}”/&#62; -将request中的name值输出
&#60;c:out value=“${param.username}”/&#62; - 用于将参数输出到页面上。
&#60;c:out value=“${name}” default=“hello”/&#62;从page到application开始查找，如果没有找到，就显示默认值hello.
另一种设置默认值的方式：
&#60;c:out value=“${name}”&#62;
Default-value-默认值。
&#60;/c:out&#62;
只有当要求的信息为null或不存在时才会输出默认值。
excapeXml属性：默认值为true,用于将html等标签转换成&lt;等转换元素，示例：
 &#60;%
     String name="&#60;font color='red'&#62;Red&#60;/font&#62;";
      pageContext.setAttribute("name",name);
  %&#62;
&#60;c:out value=“${name}” escapeXml=“false”&#62;&#60;/c:out&#62; 不对xml或html进行转换，直接输出，这样就会在页面上看到红色的Red字符，因为浏览器会解析html数据。
```


JSTL-Core的演示：(通常命名为c命名空间)
---------------------

-----jstl.jsp:
---------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
	  &#60;h1&#62;JSTL技术演示&#60;/h1&#62;

  	  &#60;!-- c:out --&#62;
  	  &#60;%
  	  	pageContext.setAttribute("name", "Tom");
  	  	pageContext.setAttribute("name2", "&#60;font color='red'&#62;Tom&#60;/font&#62;");
  	  %&#62;
	  &#60;c:out value="${name}"&#62;&#60;/c:out&#62;&#60;br/&#62;
	  
	  ${name}&#60;br/&#62;
	  
	  &#60;c:out value="${name2}" escapeXml="true" /&#62;&#60;br/&#62;
	  ${name2}&#60;br/&#62;
	  	
	  &#60;!-- c:if --&#62;
	  &#60;c:if test="${20&#62;10}" var="boo" scope="session"&#62;
	  	OKOK&#60;br/&#62;
	  &#60;/c:if&#62;
	  &#60;!-- 想要用if-else 就这样再用一句 --&#62;
  	  &#60;c:if test="${!boo}"&#62;
  	  	NONO&#60;br/&#62;
  	  &#60;/c:if&#62;
  	  
  	  &#60;br/&#62;&#60;!-- 用El中的问号表达式能输出简单的if-else --&#62;
  	  ${ 20&#62;10?"yes":"no" }&#60;br/&#62;
  	  
  	  &#60;hr/&#62;
  	  &#60;!-- forEach --&#62;
  	  &#60;%
	  	List list = new ArrayList();
	 	list.add("aaaaa111");
	 	list.add("bbbbb222");
	 	list.add(200);
	 	list.add(100);
	  	request.setAttribute("list", list);
	  %&#62;
	  &#60;table border="1px"&#62;
	 	&#60;c:forEach items="${list}" var="li"&#62;
	  		&#60;tr&#62; &#60;td&#62;:: ${li}&#60;/td&#62;  &#60;/tr&#62;
	  	&#60;/c:forEach&#62;
  	  &#60;/table&#62;
  	  
  	  &#60;%
  	  	Map&#60;String,Object&#62; map = new HashMap&#60;String,Object&#62;();
  	  	map.put("name", "Pose");
  	  	map.put("age", 55);
  	  	map.put("tel", "12345678911");
		pageContext.setAttribute("map", map);  	  
  	  %&#62;
  	  &#60;br/&#62;
  	  &#60;c:forEach items="${map}" var="m"&#62;
  	  	${m.key} = ${m.value}&#60;br/&#62;
  	  &#60;/c:forEach&#62;
  	  
  	  &#60;%
  	  	String strs[] = {"aaa","bbb","ccc","ddd"};
  	  	pageContext.setAttribute("strs", strs);
  	  %&#62;
  	  &#60;br/&#62;
  	  &#60;c:forEach items="${strs}" var="str"&#62;
		${str},  	  
  	  &#60;/c:forEach&#62;
  	  &#60;br/&#62;
  	  
  	  &#60;h3&#62;看看forEach标签中的varStatus属性---idx.index是输出元素的下标(从begin开始的)，idx.count是元素的计数(从1开始)&#60;/h3&#62;
  	  &#60;c:forEach items="${strs}" var="str" varStatus="idx"&#62;
		${str}---index = ${idx.index} --- count=${idx.count}&#60;br/&#62;  	  	
  	  &#60;/c:forEach&#62;
  	  
  	  &#60;!-- forEach的普通循环功能 --&#62;
  	  &#60;c:forEach begin="20" end="40" var="i" step="2" varStatus="idx"&#62;
  	  	${i} -- ${idx.index} -- ${idx.count}&#60;br/&#62;
  	  &#60;/c:forEach&#62;
  	  
  	  &#60;br/&#62;
  	  &#60;!-- c:set设置属性，默认作用域：pageScope --&#62;
  	  &#60;c:set var="aa" value="abc123" /&#62;
  	  &#60;c:set var="aa" value="cccc222" scope="request"/&#62;
  	  ${aa},${requestScope.aa}&#60;br/&#62;
  	  
  	  &#60;br/&#62;
  	  
  	  &#60;!-- c:remove 删除属性，默认作用域:pageScope,request等4个容器！ --&#62;
  	  &#60;!-- 也就是，如果不设置作用域(scope属性),则那4个容器中的属性都会被清除，如果写了，则只清除指定作用域的属性 --&#62;
  	  &#60;c:remove var="aa" scope="request"/&#62;
  	  ${aa},${requestScope.aa}&#60;br/&#62;
  	  
  	  &#60;!-- c:choose,c:when,c:otherwise  --&#62;
  	  &#60;!-- 类似Java中的switch-case-default而且每项自动带break --&#62;
  	  &#60;c:set var="score" value="98"&#62;&#60;/c:set&#62;
  	  &#60;c:choose&#62;
  	  	&#60;c:when test="${score>=90}"&#62;
  	  		优秀
  	  	&#60;/c:when&#62;
  	  	&#60;c:when test="${score>=80}"&#62;
  	  		良好
  	  	&#60;/c:when&#62;
  	  	&#60;c:when test="${score>=70}"&#62;
  	  		中等
  	  	&#60;/c:when&#62;
  	  	&#60;c:otherwise&#62;
			不合格  	  	
  	  	&#60;/c:otherwise&#62;
  	  &#60;/c:choose&#62;
  	  
  	  &#60;br/&#62;
  	  &#60;!-- c:forTokens 用分隔符去拆分字符串 --&#62;
  	  &#60;c:forTokens items="aa,ds,sdf,df,dddd,sss" delims="," var="str"&#62;
  	  	${str}&nbsp;
  	  &#60;/c:forTokens&#62;
  	  &#60;br/&#62;
  	  
  	  &#60;!-- c:import 导入资源，相当于动态包含，共享同一个request，但是在不同的类 --&#62;
  	  &#60;c:import url="/jsps/b.jsp"&#62;&#60;/c:import&#62;
  	  &#60;br/&#62;
  	  
  	  &#60;!-- c:redirect 重定向，相当于response.sendRedirect(...) --&#62;
      &#60;%-- 
      &#60;c:redirect url="/jsps/a.jsp"&#62;&#60;/c:redirect&#62;
  	  --%&#62;
  	  
  	  
  	  &#60;br/&#62;&#60;br/&#62;&#60;br/&#62;&#60;br/&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

-----b.jsp:
------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h3&#62;这是被动态导入的页面内容...b.jsp...&#60;/h3&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

a.jsp就不写出来了，那个只是为了演示一些JSTL的重定向。a.jsp的源码没意义。


-----演示结果：
-----

![](http://img.blog.csdn.net/20160801021002701)





JSTL中的国际化--I18N:
================

在演示JSTL的国际化之前，我们先用java的国际化过渡下~

首先在src目录下配好这3个文件:

![](http://img.blog.csdn.net/20160801023224139)

依次设置值：(空行表示是另外一个文件中了，一共3文件)
```
welcome=welcome you---US
time=this time is:---US

welcome=\u6B22\u8FCE\u4F60---CN
time=\u73B0\u5728\u65F6\u95F4\u662F\uFF1A---CN

welcome=welcome
time=this time is:
```



I18nDemo.java
-------------

```
package cn.hncu.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nDemo {
	
	public static void main(String[] args){
		//参数是：baseName--本例指的是资源文件名是：msg.*.properties
		//ResourceBundle rd = ResourceBundle.getBundle("msg");//输出：欢迎你---CN:::现在时间是：---CN   //读取的是:msg_zh_CN.properties
		//ResourceBundle rd = ResourceBundle.getBundle("msg",Locale.US);//输出：welcome you---US:::this time is:---US   //读取的是:msg_en_US.properties
		ResourceBundle rd = ResourceBundle.getBundle("msg",Locale.CANADA);////输出：欢迎你---CN:::现在时间是：---CN   //读取的是:msg_zh_CN.properties
		//因为我们的是中文系统.如果没找到对应语种的资源文件(如果不存在时，会根据系统的国家语种再找一遍,如果还没有)，则是读取默认的:msg.properties
		System.out.println(rd.getString("welcome")+":::"+rd.getString("time"));
	}
}

```


通过上面Java的演示我们应该猜得到，SJTL的国际化应该和这个其实差不了多少的，毕竟jsp最后是翻译成Java的。


I18N标签简介：
---------

I18N是Internationalization的简称，因为I到N之间有18个字符所以叫i18n。

```
在java的核心库当中，提供了对i18n的支持，java.util.Locale类是最重要的i18n相关类。
首先介绍一下Locale类：
获取Locale类的实例，有以下几种方式：
Locale ch = new Locale(“zh”,”CN”);
Locale ch = Locale.CHINA;
或获取默认值：
Locale zh = Locale.getDefault();
然后可以通过以下方法输出语言和国家：
getLanguage
getCountry
```
Java.util.ResourceBundle类，用于管理和Locale相关的资源的功能。
ResourceBundle类提供了两个方法，用于创建ResourceBundle对像的静态工厂方法：
getBundle(String baseName)—通过此方法获取资源文件的名称
getBundle(String baseName,Locale locale);
参数中的baseName是资源文件的名称，资源文件通常以properties为扩展名。

资源文件的命名规则如下：
默认资源文件：resources.properties
英文资源文件：resources_en_US.properties
中文资源文件：resources_zh_CN.properties

演示代码：
---

再准备2个资源文件：
![](http://img.blog.csdn.net/20160801034406507)

里面分别只设：

```
address=beijing

address=\u5317\u4EAC
```

i18n.jsp:
---------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;fmt:setLocale value="zh_CN"/&#62;
  	&#60;fmt:setBundle basename="msg"/&#62;
  	&#60;!-- 如果是真正的搞国际化，应该把要设置Locale和Bundle的代码放在head标签中，页面只负责显示 --&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	张三，&#60;fmt:message key="welcome"&#62;&#60;/fmt:message&#62;
  	&#60;fmt:message key="time" /&#62; 2016-**-**
  	&#60;br/&#62;&#60;hr/&#62;
  	&#60;!-- 相比上面的版本，把国家语种用参数来进行传递了 --&#62;
  	&#60;a href="?loc=en_US"&#62;English&#60;/a&#62;&#60;!-- 这里href="?***" 直接加问号，就表示当前页面 --&#62;
  	&#60;a href="?loc=zh_CN"&#62;中文&#60;/a&#62;
  	&#60;fmt:setLocale value="${param.loc}"/&#62;
  	&#60;fmt:setBundle basename="msg"/&#62;
  	张三，&#60;fmt:message key="welcome"&#62;&#60;/fmt:message&#62;
  	&#60;fmt:message key="time" /&#62; 2016-**-**
  	
  	&#60;br/&#62;&#60;hr/&#62;
  	&#60;!-- 再演示一下多个资源的情况，第二个资源及以后都必须取别名(变量名)。前面没取变量名的那个叫默认资源 --&#62;
  	&#60;fmt:setBundle basename="a" var="aaa" scope="session"/&#62;
  	&#60;!-- 如果有多个页面需要使用这个,那么把作用域设置成session就可以了 --&#62;
  	
  	张三，&#60;fmt:message key="welcome"&#62;&#60;/fmt:message&#62;
  	&#60;fmt:message key="time" /&#62; 2016-**-**
  	&#60;br/&#62;&#60;br/&#62;
  	&#60;%-- 如果从非默认的资源中读取，那么得指定资源的别名这里是：aaa,得设置成：bundle="${aaa}"。如果没有指定名称，那么就是从默认的资源读取 --%&#62;
  	&#60;fmt:message key="address" bundle="${aaa}"&#62;&#60;/fmt:message&#62;
  	&#60;br/&#62;&#60;br/&#62;
  	
  	&#60;a href='&#60;c:url value="/jsps/c.jsp"&#62;&#60;/c:url&#62;'&#62;到网站的其他页面去看看~&#60;/a&#62;
  
  &#60;/body&#62;
&#60;/html&#62;

```

c.jsp:
------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;!-- 从作用域是session的资源中读取 --&#62;
  	&#60;fmt:message key="address" bundle="${aaa}"&#62;&#60;/fmt:message&#62;
  	&#60;!-- i18n中aaa设的loc是什么这里就显示那个国家语言的资源文件 --&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

演示结果：
-----

选择中文：

![](http://img.blog.csdn.net/20160801034651305)

选择中文：

![](http://img.blog.csdn.net/20160801034659024)


当然，现在很多网站都不是这样来做国际化的，而是准备多套版本的网站，你点什么语言，我就给你跳到对应语言的网站去。
这样有一个很明显的不好，如果语种很多呢？难道准备那么多套网站，显然是不合理的，而用I18N只需要我们有一个网站模板，读取属性，配置对应的语种资源文件就可以了。在语种很多的情况下方便很多，架构当然无论是什么情况下，都是这个好些的。



JSTL中的常用EL函数
============

由于在JSP页面中显示数据时，经常需要对显示的字符串进行处理，SUN公司针对于一些常见处理定义了一套EL函数库供开发者使用。
这些EL函数在JSTL开发包中进行描述，因此在JSP页面中使用SUN公司的EL函数库，需要导入JSTL开发包，并在页面中导入EL函数库，
如下所示：(我们完全可以将JSTLl理解成EL函数库)
在页面中使用JSTL定义的EL函数：
```
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%&#62;
```

fn:toLowerCase
--------------
fn:toLowerCase函数将一个字符串中包含的所有字符转换为小写形式，并返回转换后的字符串，它接收一个字符串类型的参数，例如
fn:toLowerCase("Www.IT315.org") 的返回值为字符串“www.it315.org”
fn:toLowerCase("")的返回值为空字符串


fn:toUpperCase
--------------

fn:toUpperCase函数将一个字符串中包含的所有字符转换为大写形式，并返回转换后的字符串，它接收一个字符串类型的参数。例如：
fn:toUpperCase("Www.IT315.org") 的返回值为字符串“WWW.IT315.ORG”
fn:toUpperCase("")的返回值为空字符串


fn:trim
-------

fn:trim函数删除一个字符串的首尾的空格，并返回删除空格后的结果字符串，它接收一个字符串类型的参数。需要注意的是，fn:trim函数不能删除字符串中间位置的空格。
例如，fn:trim("   www.it  315.org  ") 的返回值为字符串“www.it  315.org”。


fn:length
---------

fn:length函数返回一个集合或数组对象中包含的元素的个数，或返回一个字符串中包含的字符的个数，返回值为int类型。

fn:length函数接收一个参数，这个参数可以是`&#60;c:forEach&#62;`标签的items属性支持的任何类型，包括任意类型的数组、java.util.Collection、java.util.Iterator、java.util.Enumeration、java.util.Map等类的实例对象和字符串。

如果fn:length函数的参数为null或者是元素个数为0的集合或数组对象，则函数返回0；如果参数是空字符串，则函数返回0。 


fn:split
--------

fn:split函数以指定字符串作为分隔符，将一个字符串分割成字符串数组并返回这个字符串数组。

fn:split函数接收两个字符串类型的参数，第一个参数表示要分割的字符串，第二个参数表示作为分隔符的字符串。

例如，fn:split("www.it315.org", ".")[1]的返回值为字符串“it315”。


fn:join
-------

fn:join函数以一个字符串作为分隔符，将一个字符串数组中的所有元素合并为一个字符串并返回合并后的结果字符串。fn:join函数接收两个参数，第一个参数是要操作的字符串数组，第二个参数是作为分隔符的字符串。

如果fn:join函数的第二个参数是空字符串，则fn:join函数的返回值直接将元素连接起来。
例如：
假设stringArray是保存在Web域中的一个属性，它表示一个值为{"www","it315","org"}的字符串数组，则fn:join(stringArray, “.")返回字符串“www.it315.org”
fn:join(fn:split("www,it315,org", ","), ".") 的返回值为字符串“www.it315.org”


fn:indexOf
----------

fn:indexOf函数返回指定字符串在一个字符串中第一次出现的索引值，返回值为int类型。
fn:indexOf函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，那么，不管第二个参数字符串在第一个参数字符串中出现几次，fn:indexOf函数总是返回第一次出现的索引值；
如果第一个参数中不包含第二个参数，则fn:indexOf函数返回-1。
如果第二个参数为空字符串，则fn:indexOf函数总是返回0。
例如：
fn:indexOf("www.it315.org","t3") 的返回值为5


fn:contains
-----------

fn:contains函数检测一个字符串中是否包含指定的字符串，返回值为布尔类型。

fn:contains函数在比较两个字符串是否相等时是大小写敏感的。
fn:contains函数接收两个字符串类型的参数，如果第一个参数字符串中包含第二个参数字符串，则fn:contains函数返回true，否则返回false。

如果第二个参数的值为空字符串，则fn:contains函数总是返回true。实际上，fn:contains(string, substring)等价于fn:indexOf(string, substring) != -1。

如果想用忽略大小的EL函数：
那么就用：fn:containsIgnoreCase --参数和fn:contains函数一样


fn:startsWith
-------------

fn:startsWith函数用于检测一个字符串是否是以指定字符串开始的，返回值为布尔类型。

fn:startsWith函数接收两个字符串类型的参数，如果第一个参数字符串以第二个参数字符串开始，则函数返回true，否则函数返回false。如果第二个参数为空字符串，则fn:startsWith函数总是返回true。例如：

fn:startsWith("www.it315.org","it315")的返回值为false

与之对应的EL函数：fn:endsWith 



fn:replace
----------

fn:replace函数将一个字符串中包含的指定子字符串替换为其它的指定字符串，并返回替换后的结果字符串。fn:replace方法接收三个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示源字符串中要被替换的子字符串，第三个参数表示要被替换成的字符串。例如：

fn:replace("www it315 org", " ", ".")的返回值为字符串“www.it315.org”


fn:substring
------------


fn:substring函数用于截取一个字符串的子字符串并返回截取到的子字符串。fn:substring函数接收三个参数，
第一个参数是用于指定要操作的源字符串，
第二个参数是用于指定截取子字符串开始的索引值，
第三个参数是用于指定截取子字符串结束的索引值，第二个参数和第三个参数都是int类型，其值都从0开始。例如：

fn:substring("www.it315.org", 4, 9) 的返回值为字符串“it315”


fn:substringAfter
-----------------

fn:substringAfter函数用于截取并返回一个字符串中的指定子字符串第一次出现之后的子字符串。fn:substringAfter函数接收两个字符串类型的参数，第一个参数表示要操作的源字符串，第二个参数表示指定的子字符串，例如：

fn:substringAfter(“www.it315.org”, “.”)的返回值为字符串“it315.org”。

与之对应的EL函数为：fn:substringBefore 


这里我只演示几个常用的函数：

演示代码：
---

fn.jsp:
-------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;c:set value="hello word function" var="str"&#62;&#60;/c:set&#62;
  	${fn:indexOf(str,"wor")}&#60;br/&#62;&#60;br/&#62;
  	${fn:contains(str,"Func")}&#60;br/&#62;&#60;br/&#62;
  	${fn:containsIgnoreCase(str,"Func")}&#60;br/&#62;&#60;br/&#62;
  	${fn:trim(str).length()}&#60;br/&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

演示结果：
-----

![](http://img.blog.csdn.net/20160801041600631)

	${fn:indexOf(str,"wor")}  //从0开始第6个开始匹配上了wor，所以输出是：6
  	${fn:contains(str,"Func")} //区别大小写，str中不包含字符串"Func" ,输出为：false
  	${fn:containsIgnoreCase(str,"Func")}//不区分大小写，str中包含字符串"func"，输出位：true
  	${fn:trim(str).length()} //trim()返回去掉字符串首尾的空格length()返回字符串的长度"hello word function"---19