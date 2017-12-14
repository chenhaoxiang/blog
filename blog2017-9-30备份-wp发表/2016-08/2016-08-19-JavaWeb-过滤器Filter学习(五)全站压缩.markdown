---
layout: post
title: "JavaWeb-过滤器Filter学习(五)全站压缩"
date: 2016-08-19 03:51:10 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,java,数据压缩,数据]
keyword: 陈浩翔, 谙忆
description: 全站压缩，最大的好久就是帮客户端节省流量。 
数据压缩，我们需要用到二个Java类，也就是java.util.zip 中的 
类 GZIPOutputStream 
此类为使用 GZIP 文件格式写入压缩数据实现流过滤器。 java.io  
类 ByteArrayOutputStream 
此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 t 
---


全站压缩，最大的好久就是帮客户端节省流量。 
数据压缩，我们需要用到二个Java类，也就是java.util.zip 中的 
类 GZIPOutputStream 
此类为使用 GZIP 文件格式写入压缩数据实现流过滤器。 java.io  
类 ByteArrayOutputStream 
此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 t
&#60;!-- more --&#62;
----------

全站压缩，最大的好久就是帮客户端节省流量。
数据压缩，我们需要用到二个Java类，也就是java.util.zip 中的
类 GZIPOutputStream
此类为使用 GZIP 文件格式写入压缩数据实现流过滤器。 

java.io 
类 ByteArrayOutputStream
此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。 


我们利用GZIPOutputStream(OutputStream out) 使用默认缓冲区大小创建新的输出流。
再用write(byte[] b)将 b.length 个字节写入此输出流。 
也就是把数据压缩后写入ByteArrayOutputStream。

然后通过内存流输出到客户端。

#简单演示:

也就是在一个servlet这样写：

```
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		String str = "网页压缩数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuhdncu网页压缩数据hncuhdncu";

		System.out.println("原大小:" + str.getBytes("utf-8").length);

		// 压缩输出--把源数据压缩输出到baout内存流中
		ByteArrayOutputStream baout = new ByteArrayOutputStream();

		GZIPOutputStream gout = new GZIPOutputStream(baout);
		gout.write(str.getBytes("utf-8"));
		gout.close();

		// 从baout内存流中把压缩后的数据取出来，输出到客户端
		byte dest[] = baout.toByteArray();
		System.out.println("压缩后的大小:" + dest.length);
		
		//输出之前告诉客户端:我们的数据是gzip格式，然后输出
		response.setHeader("Content-Encoding", "gzip");
		response.setContentLength(dest.length);
		OutputStream out = response.getOutputStream();
		out.write(dest);
		out.close();
	}
```
![](http://img.blog.csdn.net/20160819113417380)

这样可以实现压缩，但是每次我们有一个servlet就要写一大长串的代码，很臃肿，也很麻烦，毕竟代码是一样的。而且还无法压缩jsp和html字符文件。

这个时候，我们就需要用到过滤器了。只要拦截所有的servlet和jsp/html就ok。只要写一次！很方便。


#全站压缩实例:

##index.jsp：

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;过滤器应用示例---全站压缩&#60;/title&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
    &#60;h2&#62;过滤器应用示例---全站压缩&#60;/h2&#62;
    &#60;a href="&#60;c:url value='/servlet/SecondServlet'/&#62;"&#62;请求第二个servlet--用过滤器压缩输出字节流数据&#60;/a&#62;&#60;br/&#62;&#60;br/&#62;
    &#60;a href="&#60;c:url value='/servlet/ThirdServlet'/&#62;"&#62;请求第三个servlet--用过滤器压缩输出字符流数据&#60;/a&#62;&#60;br/&#62;&#60;br/&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

##SecondServlet.java

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String str = "网页压缩数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuhdncu网页压缩数据hncuhdncu";
		System.out.println("原大小:" + str.getBytes("utf-8").length);
		
		OutputStream out = response.getOutputStream();
		out.write(str.getBytes("utf-8"));
		//注意，虽然MyEclipse环境设置的是utf-8编码，但本句“str.getBytes()”却是以gbk方式编码---应该是Tomcat中的JVM采用的方式
	}
}

```

##ThirdServlet.java

```
package cn.hncu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String str="网页压缩数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuhdncu网页压缩数据hncuhdncu";
		System.out.println("原大小:"+ str.getBytes("utf-8").length);
		
		PrintWriter out = response.getWriter();
		//out.write(str);
		out.println(str);
		out.close();
	}

}

```


##GzipFilter.java

```
package cn.hncu.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		MyResponse resp = new MyResponse((HttpServletResponse) response);
		// 用增强版的resp放行到servlet中去用(让后台把数据 写到 baout中 )

		chain.doFilter(request, resp);// 放行--让后台去写

		// 从增强版的resp的baout中(存放的是源字节数据)，把数据取出来进行压缩，
		// 然后再压缩后的数据用原生的response输出到客户端
		ByteArrayOutputStream baout = resp.getBaout();
		byte bs[] = baout.toByteArray();// 源字节数据
		System.out.println("压缩前大小:" + bs.length);
		
		ByteArrayOutputStream baout2 = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(baout2);
		gout.write(bs);// 把数据压缩到baout中
		gout.close();
		
		bs = baout2.toByteArray();
		System.out.println("压缩后大小:" + bs.length);
		// 输出之前告诉客户端:我们的数据是gzip格式，然后输出
		HttpServletResponse httpResp = (HttpServletResponse) response;
		httpResp.setHeader("Content-Encoding", "gzip");
		httpResp.setContentLength(bs.length);
		OutputStream out = httpResp.getOutputStream();
		out.write(bs);
		
	}

	@Override
	public void destroy() {
	}

}

class MyResponse extends HttpServletResponseWrapper {
	private ByteArrayOutputStream baout = new ByteArrayOutputStream();

	public MyResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyOutputStream(baout);
	}

	public ByteArrayOutputStream getBaout() {
		if(pw!=null){
			pw.flush();
			//这里很重要，如果不flush或close，不把字符流刷出去，baout中是不会有数据的.
		}
		return baout;
	}
	
	private PrintWriter pw;
	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(baout, "utf-8"),true);
		return pw;
	}

}

class MyOutputStream extends ServletOutputStream {
	private ByteArrayOutputStream baout = null;

	public MyOutputStream(ByteArrayOutputStream baout) {
		this.baout = baout;
	}

	@Override
	public void write(int b) throws IOException {
		baout.write(b);
	}
}

```

##web.xml:

```
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"&#62;
  &#60;display-name&#62;&#60;/display-name&#62;
  
  &#60;filter&#62;
  	&#60;filter-name&#62;gzip&#60;/filter-name&#62;
  	&#60;filter-class&#62;cn.hncu.filter.GzipFilter&#60;/filter-class&#62;
  &#60;/filter&#62;
  &#60;filter-mapping&#62;
  	&#60;filter-name&#62;gzip&#60;/filter-name&#62;
  	&#60;url-pattern&#62;/*&#60;/url-pattern&#62;
  &#60;/filter-mapping&#62;
  
  &#60;servlet&#62;
    &#60;servlet-name&#62;FirstGzipServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlets.FirstGzipServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;
  &#60;servlet&#62;
    &#60;servlet-name&#62;SecondServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlets.SecondServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;
  &#60;servlet&#62;
    &#60;servlet-name&#62;ThirdServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlets.ThirdServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;



  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;FirstGzipServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/FirstGzipServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;
  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;SecondServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/servlet/SecondServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;
  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;ThirdServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/servlet/ThirdServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;	
  &#60;welcome-file-list&#62;
    &#60;welcome-file&#62;index.jsp&#60;/welcome-file&#62;
  &#60;/welcome-file-list&#62;
&#60;/web-app&#62;

```


用过滤器来做全站压缩，无论你怎么增加servlet，jsp，html，还是照原来的写，不用你增加代码，我们只要在过滤器中对你的数据进行压缩发送到前台去就可以了！！！

注意，过滤器中用了装饰模式。

#完整项目源码：
https://github.com/chenhaoxiang/Java/tree/master/myGzipWeb

myGzipWeb.zip


转载请附上原文博客链接：

http://blog.csdn.net/qq_26525215