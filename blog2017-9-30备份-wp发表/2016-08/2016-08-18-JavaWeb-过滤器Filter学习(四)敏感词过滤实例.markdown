---
layout: post
title: "JavaWeb-过滤器Filter学习(四)敏感词过滤实例"
date: 2016-08-18 05:29:18 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,实例,敏感词过滤]
keyword: 陈浩翔, 谙忆
description: 通过Filter来实现留言板的敏感词过滤…思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。代码演示:index.jsp:<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib ur 
---


通过Filter来实现留言板的敏感词过滤…思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。代码演示:index.jsp:&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib ur
&#60;!-- more --&#62;
----------

通过Filter来实现留言板的敏感词过滤...

思路很简单，我们这里的敏感词是直接先放进去的，实际项目中，肯定是存在数据库中。在Filter 过滤器中，我们先拿到用户提交的留言，如果出现了敏感词，我们就用*号来替换。

#代码演示:

##index.jsp:

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	 &#60;title&#62;过滤器应用示例---敏感词过滤&#60;/title&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
     &#60;h2&#62;过滤器应用示例---敏感词过滤&#60;/h2&#62;
     &#60;form action="&#60;c:url value='/NoteServlet'/&#62;" method="post"&#62;
     	用户名:&#60;input type="text" name="name" /&#62;&#60;br/&#62;&#60;br/&#62;
		&#60;fieldset&#62;
			&#60;legend&#62;留言板&#60;/legend&#62;
			&#60;textarea name="note" rows="10" cols="20"&#62;&#60;/textarea&#62;
		&#60;/fieldset&#62;
		&#60;input type="submit" value="留言" /&#62;     
     &#60;/form&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

##WordsUtil.java:敏感词集合:

```
package cn.hncu.pubs;

import java.util.ArrayList;
import java.util.List;

public class WordsUtil {
	private static List&#60;String&#62; list = new ArrayList&#60;String&#62;();
	static{
		//这里应该从数据库中导入敏感词的，我在这里就直接用词来模拟了
		list.add("骂人");
		list.add("sb");
	}
	public static List&#60;String&#62; getWords(){
		return list;
	}
	public static void reBuild(){
	   //把list中的内容存储到数据库---每一段时间存储一次
	}
}

```
##NoteServlet.java

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("不支持GET方式留言");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("&#60;!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"&#62;");
		out.println("&#60;HTML&#62;");
		out.println("  &#60;HEAD&#62;&#60;TITLE&#62;A Servlet&#60;/TITLE&#62;&#60;/HEAD&#62;");
		out.println("  &#60;BODY&#62;");
		
		String name = request.getParameter("name");
		if(name==null || name.trim().length()>=0){
			out.println("名字不能为空!!!");
		}else{
			String words = request.getParameter("note");
			out.println("&#60;br/&#62;"+name+"的留言是:&#60;br/&#62;"+ words);
		}
		out.println("  &#60;/BODY&#62;");
		out.println("&#60;/HTML&#62;");
		out.flush();
		out.close();
	}

}

```

##WordFilter.java:敏感词过滤

```
package cn.hncu.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import cn.hncu.pubs.WordsUtil;

public class WordFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		//在过滤器中用装饰模式把 原装request的功能增强了
		//---拦截后台调用的getParamter()方法
		MyRequest req = new MyRequest((HttpServletRequest)request);
		
		chain.doFilter(req, response);//放行
	}

	@Override
	public void destroy() {
	}
}

class MyRequest extends HttpServletRequestWrapper{
	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String str = super.getParameter(name);
		List&#60;String&#62; list = WordsUtil.getWords();
		for(String word : list){
			str = str.replaceAll(word, "*");
		}
		return str;
	}
	
	
	
}

```

##配置web.xml

```
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"&#62;
  &#60;display-name&#62;&#60;/display-name&#62;
  &#60;filter&#62;
  	&#60;filter-name&#62;wordFilter&#60;/filter-name&#62;
  	&#60;filter-class&#62;cn.hncu.filter.WordFilter&#60;/filter-class&#62;
  &#60;/filter&#62;
  &#60;filter-mapping&#62;
  	&#60;filter-name&#62;wordFilter&#60;/filter-name&#62;
  	&#60;url-pattern&#62;/*&#60;/url-pattern&#62;
  &#60;/filter-mapping&#62;
  
  
  &#60;servlet&#62;
    &#60;servlet-name&#62;NoteServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlet.NoteServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;

  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;NoteServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/NoteServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;	
  &#60;welcome-file-list&#62;
    &#60;welcome-file&#62;index.jsp&#60;/welcome-file&#62;
  &#60;/welcome-file-list&#62;
&#60;/web-app&#62;

```



#演示结果:

![](http://img.blog.csdn.net/20160818171941959)

##过滤后的效果:

![](http://img.blog.csdn.net/20160818171948787)


#完整项目链接:

https://github.com/chenhaoxiang/Java/tree/master/myWordsFilterWeb
myWordsFilterWeb.zip


转载请附上原文博客链接：

http://blog.csdn.net/qq_26525215
