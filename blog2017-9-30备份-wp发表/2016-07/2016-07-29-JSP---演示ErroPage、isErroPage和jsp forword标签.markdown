---
layout: post
title: "JSP---演示ErroPage、isErroPage和jsp forword标签"
date: 2016-07-29 01:19:54 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [session,java,jsp]
keyword: 陈浩翔, 谙忆
description: 属性说明：language – 示例：language=“java”import  -如：  (注意多个引用之间使用逗号分开。)
<%@ page import=“java.util.*,java.sql.*”%> contentType – 指定响应结果的MIME类型。默认为text/html;charset=ISO-8859-1session = true | false –指定jsp页面是否使 
---


属性说明：language – 示例：language=“java”import  -如：  (注意多个引用之间使用逗号分开。)
&#60;%@ page import=“java.util.*,java.sql.*”%&#62; contentType – 指定响应结果的MIME类型。默认为text/html;charset=ISO-8859-1session = true | false –指定jsp页面是否使
&#60;!-- more --&#62;
----------



属性说明：
=====

```
language – 示例：language=“java”

import  -如：  (注意多个引用之间使用逗号分开。)
&#60;%@ page import=“java.util.*,java.sql.*”%&#62; 

contentType – 指定响应结果的MIME类型。默认为text/html;charset=ISO-8859-1

session = true | false –指定jsp页面是否使用session.

errorPage = url – 指定当发生异常时转发到哪一个页面。

isErrorPage = true|false, - 表示此页是处理异常的页面。
 
pageEncoding – 设置页面的编码方式，此编码方式，会自动应用到contentType中的charset上，如果没有设置content-Type的话。
显示时以content-Type为准。建议这两个值应该设置一个或至少应该一致。
建议设置content-Type
buffer = none | 8kb | sizeb – 设置页面缓冲区大小。-建议不要修改此值。

```

演示errorPage和isErrorPage属性：：
=============

指定当发生异常时转发到哪一个页面。

这个技术就是如果当前访问的servlet出现了异常错误，不会跳转到500页面去了，而是跳转到我们自己指定的页面！

在这里，我们把错误写成分母为0.

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;演示jsp中的2个属性&#60;/title&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h1&#62;演示JSP技术中ErroPage,isErropage&#60;/h1&#62;
  	&#60;%
		int a=100/0;
		//除数唯0，肯定会导致异常的  	
  	 %&#62;
  	&#60;br/&#62;&#60;br&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

这个我们没有设置ErroPage属性，我们来看下访问结果：

![](http://img.blog.csdn.net/20160729124215664)


设置errorPage属性和isErrorPage属性：
-------------------
index2.jsp:

```
&#60;%@ page language="java" 
import="java.util.*" 
pageEncoding="UTF-8"
errorPage="jsps/error.jsp"
%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;演示jsp中的2个属性&#60;/title&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h1&#62;演示JSP技术中ErroPage,isErropage&#60;/h1&#62;
  	&#60;%
		int a=100/0;
		//除数为0，肯定会导致异常的  	
  	 %&#62;
  	&#60;br/&#62;&#60;br&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

error.jsp:
----------

```
&#60;%@ page language="java" 
import="java.util.*" 
pageEncoding="UTF-8"
isErrorPage="true"
%&#62;
&#60;%--上面添加了isErrorPage属性并设置值为true，那么当前页面就可以使用exception对象,否则不能 --%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h1&#62;这是error.jsp页面&#60;/h1&#62;
  	&#60;%
		out.println(exception);
  	 %&#62;
  	&#60;br/&#62;&#60;br&#62;
  &#60;/body&#62;
&#60;/html&#62;

```


结果页面：
-----

![](http://img.blog.csdn.net/20160729130807096)

自动跳转到了错误页面，又因为用了isErrorPage="true"所以，我们也能输出错误信息、


jsp:forword:
============

其实这个用法很简单，我就不全部演示了，解释一下这个是干嘛的。
其实就是一个转发！！！

```
&#60;h1&#62;演示JSP技术中jsp:forward标签&#60;/h1&#62;
  	&#60;jsp:forward page="index.jsp"&#62;&#60;/jsp:forward&#62;
  	&#60;h2&#62;因为有上面的jsp:forward，所以这些文字是不会显示的，因为页面已经转到别的地方去了。&#60;/h2&#62;
```

```
源组件还可以通过&#60;jsp:param/&#62;向目标组件添加额外的参数：
   &#60;jsp:forward path=“target.jsp”&#62;
           &#60;jsp:param name=“name1” value=“name1”/&#62;
           &#60;jsp:param name=“name2” value=“name2”/&#62;
   &#60;/jsp:forward&#62;

```

```
JSP通过&#60;jsp:forward/&#62;标签来实现请求转发。
转发的目标可以是jsp,servlet或html.
注意：之前在转请求转发时，在转发之后的代码也会被执行，而jsp源组件中&#60;jsp:forward/&#62;在转发以后的代码不会被执行。因为当你在写了&#60;jsp:forward/&#62;，翻译以后源代码如下：
if (true) {
        _jspx_page_context.forward("/index.jsp");
        return;
}
&#60;jsp:forward path = url /&#62;中的url即可以以/开头也可以不以/开头，以/开头表示绝对路径。 如：
helloapp/dir1/source.jsp
helloapp/dir1/dir2/target.jsp
可以通过以下两种方式从souce.jsp转到target.jsp
&#60;jsp:forward path=“dir2/target.jsp”/&#62;
&#60;jsp:forward path=“/dir1/dir2/target.jsp”/&#62;

```



演示结果：
-----



![](http://img.blog.csdn.net/20160729131750350)

根据这个我们可以知道，客户端只请求了一次，所以，这个转发肯定是转发了request和response过去的(共享同一个)。

理解成servlet的转发就好了！


