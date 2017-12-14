---
layout: post
title: "JavaWeb-过滤器Filter学习(三)实现用户的自动登录与IP黑名单过滤"
date: 2016-08-18 04:23:16 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅
tags: [filter,cookie,过滤器,自动登录]
keyword: 陈浩翔, 谙忆
description: 实现用户的自动登录： 
解决方案： 
设置一个全站拦截的过虑器。 
在此过虑器中，读取用户带过来的Cookie信息，然后从中读取用户的用户名和密码，自动帮助用户登录。 
即可实现自动登录功能。



用Filter验证用户是否已经登录过。已经登录过了，我们就根据他选择的自动登录来选择让他在多久内能自动登录。

IP黑名单过滤就很简单了，只要在Filter过滤器防范一下就OK。 
在init方法中， 
---


实现用户的自动登录： 
解决方案： 
设置一个全站拦截的过虑器。 
在此过虑器中，读取用户带过来的Cookie信息，然后从中读取用户的用户名和密码，自动帮助用户登录。 
即可实现自动登录功能。



用Filter验证用户是否已经登录过。已经登录过了，我们就根据他选择的自动登录来选择让他在多久内能自动登录。

IP黑名单过滤就很简单了，只要在Filter过滤器防范一下就OK。 
在init方法中，
&#60;!-- more --&#62;
----------

实现用户的自动登录：
解决方案：
设置一个全站拦截的过虑器。
在此过虑器中，读取用户带过来的Cookie信息，然后从中读取用户的用户名和密码，自动帮助用户登录。
即可实现自动登录功能。

![](http://img.blog.csdn.net/20160818142803387)

用Filter验证用户是否已经登录过。已经登录过了，我们就根据他选择的自动登录来选择让他在多久内能自动登录。

IP黑名单过滤就很简单了，只要在Filter过滤器防范一下就OK。
在init方法中，我们先把黑名单的IP加载进Set`&#60;String&#62;` set集合，
Set集合有如下特点:
```
Java.util.HashSet类实现了Java.util.Set接口。
1 它不允许出现重复元素；
2 不保证和政集合中元素的顺序
3 允许包含值为null的元素，但最多只能有一个null元素。

contains方法:

当且仅当 本set包含一个元素 e，并且满足(o==null ? e==null : o.equals(e))条件时,contains()方法才返回true. 

因此 contains()方法 必定使用equals方法来检查是否相等.

需要注意的是: set 中是可以包含 null值的(常见的集合类都可以包含null值). 
所以如果添加了null,然后判断是否包含null,将会返回true
```

#黑名单IP过滤:

```
package cn.hncu.pubs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter{
	private String charset;
	//黑名单
	private Set&#60;String&#62; set = new HashSet&#60;String&#62;();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("charset");
		
		//到数据库中把黑名单加载进来，这里简单模拟一下
		set.add("192.168.31.168");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		
		//以下演示黑名单过滤技术
		String ip = request.getRemoteAddr();;//获得客户端的IP
		if(set.contains(ip)){
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().println("你已被列入黑名单!");
		}else{//放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}
   
}

```

##配置web.xml：

```
&#60;filter&#62;
  	&#60;filter-name&#62;character&#60;/filter-name&#62;
  	&#60;filter-class&#62;cn.hncu.pubs.CharacterFilter&#60;/filter-class&#62;
  	&#60;init-param&#62;
		&#60;param-name&#62;charset&#60;/param-name&#62;
		&#60;param-value&#62;utf-8&#60;/param-value&#62;  	
  	&#60;/init-param&#62;
  &#60;/filter&#62;
  &#60;filter-mapping&#62;
  	&#60;filter-name&#62;character&#60;/filter-name&#62;
  	&#60;url-pattern&#62;/*&#60;/url-pattern&#62;
  &#60;/filter-mapping&#62;
```
这样就可以防止IP在黑名单的用户访问我们的网站了！


#用户的自动登录

##User值对象:

```
package cn.hncu.domain;

/**
 * @author 陈浩翔
 *
 * 2016-8-18
 */
public class User {
	private String name;
	private String pwd;
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}

```

##LoginServlet.java：

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从页面接收登录信息
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String time = request.getParameter("time");
		
		//System.out.println(name+","+pwd+","+time);
		
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		
		if(name!=null && name.trim().length()!=0 && pwd!=null){
			if(name.equals(pwd)){//按理应该到后台去验证登录是否成功，这里直接以用户名和密码相同为登录成功
				request.getSession().setAttribute("user", user);
				//登录成功，就往客户端写一个cookie,将用户名和密码存到cookie中-应该进行加密!
				//为了能够兼容中文，要进行编码
				name = URLEncoder.encode(name, "utf-8");
				pwd = URLEncoder.encode(pwd, "utf-8");
				
				Cookie cookie = new Cookie("autoLogin", name+"#!#"+pwd);
				cookie.setPath(request.getContextPath());//权限：本项目中的类都可以访问该cookie
				//有效期
				cookie.setMaxAge( 60 * Integer.parseInt(time) );
				response.addCookie(cookie);//存储到客户端
			}else{
				request.getSession().setAttribute("error", "密码错误!");
			}
		}else{
			request.getSession().setAttribute("error", "请输入用户名!");
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}

```

##index.jsp:

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;演示利用Filter实现自动登录&#60;/title&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h2&#62;主页-演示利用Filter实现自动登录&#60;/h2&#62;
  	&#60;c:if test="${!empty sessionScope.error}"&#62;
  		&#60;font color="red"&#62;${sessionScope.error}&#60;/font&#62;
  		&#60;c:remove var="error" scope="session"/&#62;
  	&#60;/c:if&#62;
  	
  	&#60;c:if test="${empty sessionScope.user}" var="boo"&#62;
  		&#60;form action="&#60;c:url value='/LoginServlet'/&#62;" method="post"&#62;
  			Name:&#60;input type="text" name="name"&#62;&#60;br/&#62;&#60;br/&#62;
            &#60;!-- 这里为了演示清楚，就直接用text了 --&#62;
            &nbsp;Pwd:&#60;input type="text" name="pwd"&#62;&#60;br/&#62;
            &#60;fieldset&#62;
            	&#60;legend&#62;自动登录&#60;/legend&#62;
            	&#60;input type="radio" name="time" value="0" checked="checked"&#62;不自动登录&#60;br/&#62;
           		&#60;input type="radio" name="time" value="1" &#62;1分钟&#60;br/&#62;
           		&#60;input type="radio" name="time" value="60" &#62;1小时&#60;br/&#62;
           		&#60;input type="radio" name="time" value="86400" &#62;1天&#60;br/&#62;
           		&#60;input type="radio" name="time" value="604800" &#62;1周&#60;br/&#62;
            	&#60;input type="radio" name="time" value="2592000" &#62;一个月&#60;br/&#62;
            &#60;/fieldset&#62;
            	&#60;input type="submit" value="登录"&#62;
		&#60;/form&#62;  		
  	&#60;/c:if&#62;
  	&#60;c:if test="${!boo}"&#62;
  		${user.name},欢迎回来。
  		&#60;a href="&#60;c:url value='/CancelAutoLoginServlet'/&#62;"&#62;取消自动登录&#60;/a&#62;
  		
  	&#60;/c:if&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

##CancelAutoLoginServlet.java-取消自动登录：

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelAutoLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取消自动登录，其实就是删除Cookie
		Cookie cookie = new Cookie("autoLogin", "");
		cookie.setPath(request.getContextPath());//这个路径必须和原来的设置为一样，否则没用的
		cookie.setMaxAge(0);//有效期为0即是删除
		response.addCookie(cookie);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}

```


##AutoLoginFilter.java-自动登录:

```
package cn.hncu.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.hncu.domain.User;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("user")==null){//还没有登录，帮你自动登录
			Cookie cs[] = req.getCookies();
			if(cs!=null){
				for(Cookie c :cs){//找"autoLogin"这个cookie
					if(c.getName().equals("autoLogin")){
						String str = c.getValue();
						String vals[] = str.split("#!#");
						String name = URLDecoder.decode(vals[0], "utf-8");
						String pwd = URLDecoder.decode(vals[1], "utf-8");
						
						//...
						//这里应该再去后台数据库验证是否登录能够成功,这里我就直接以两者相等来判断
						if(name.equals(pwd)){//如果成功则返回一个user对象
							User user = new User();
							user.setName(name);
							user.setPwd(pwd);
							req.getSession().setAttribute("user", user);
							break;
						}
					}
				}
			}
			
		}
		chain.doFilter(req, response);//放行
	}
	@Override
	public void destroy() {
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
  	&#60;filter-name&#62;character&#60;/filter-name&#62;
  	&#60;filter-class&#62;cn.hncu.pubs.CharacterFilter&#60;/filter-class&#62;
  	&#60;init-param&#62;
		&#60;param-name&#62;charset&#60;/param-name&#62;
		&#60;param-value&#62;utf-8&#60;/param-value&#62;  	
  	&#60;/init-param&#62;
  &#60;/filter&#62;
  &#60;filter&#62;
  	&#60;filter-name&#62;autoLogin&#60;/filter-name&#62;
  	&#60;filter-class&#62;cn.hncu.filter.AutoLoginFilter&#60;/filter-class&#62;
  &#60;/filter&#62;
  
  
  &#60;filter-mapping&#62;
  	&#60;filter-name&#62;character&#60;/filter-name&#62;
  	&#60;url-pattern&#62;/*&#60;/url-pattern&#62;
  &#60;/filter-mapping&#62;
  &#60;filter-mapping&#62;
  	&#60;filter-name&#62;autoLogin&#60;/filter-name&#62;
  	&#60;url-pattern&#62;/*&#60;/url-pattern&#62;
  &#60;/filter-mapping&#62;
  
  
  &#60;servlet&#62;
    &#60;servlet-name&#62;CancelAutoLoginServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlet.CancelAutoLoginServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;
  &#60;servlet&#62;
    &#60;servlet-name&#62;LoginServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlet.LoginServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;


  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;CancelAutoLoginServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/CancelAutoLoginServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;
  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;LoginServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/LoginServlet&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;
  
  &#60;welcome-file-list&#62;
    &#60;welcome-file&#62;index.jsp&#60;/welcome-file&#62;
  &#60;/welcome-file-list&#62;
&#60;/web-app&#62;

```

代码里面都有注释!

实现的功能就是自动登录和取消自动登录。

主要利用了过滤器。还有用到cookie技术。

完整项目链接:
https://github.com/chenhaoxiang/Java/tree/master/myAutoLoginWeb
myAutoLoginWeb.zip文件


转载请附上原文博客链接：

http://blog.csdn.net/qq_26525215

