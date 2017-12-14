---
layout: post
title: "Web---JSP注册技术的演绎(3代)-JSP EJB Servlet POJO JavaBean"
date: 2016-07-30 07:20:03 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- JSP/XML知识点
tags: [servlet,java,javabean,技术,ejb]
keyword: 陈浩翔, 谙忆
description: 我们可以这么理解JSP注册技术的发展过程： 
第一代JSP技术：纯JSP开发。 
第二代JSP技术：JSP+EJB开发。 
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。) 
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架) 
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))其实EJB—可理解成企业级的JavaBe 
---


我们可以这么理解JSP注册技术的发展过程： 
第一代JSP技术：纯JSP开发。 
第二代JSP技术：JSP+EJB开发。 
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。) 
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架) 
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))其实EJB—可理解成企业级的JavaBe
&#60;!-- more --&#62;
----------

我们可以这么理解JSP注册技术的发展过程：
第一代JSP技术：纯JSP开发。
第二代JSP技术：JSP+EJB开发。
(EJB简单来说就是把已经编写好的程序（即：类）打包放在服务器上执行。)
第三代JSP技术：JSP+Servlet+POJO开发。(**MVC框架)
(POJO其实就是简单的JAVA类，也是简单的JavaBean(特殊的值对象封装))

其实EJB---可理解成企业级的JavaBean(相对于简单的JavaBean增加了一些业务处理方法)

现在还有更新的技术，目前还没学到，学到后会第一时间写博客的。


演示纯JSP开发技术：
===========

regPurJsp.jsp:
--------------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  &#60;h2&#62;纯JSP开发的注册&#60;/h2&#62;
  	&#60;form action="doReg.jsp" method="post"&#62;
  		Name:&#60;input type="text" name="name" /&#62;&#60;br/&#62;
  		Password:&#60;input type="password" name="pwd"/&#62;&#60;br/&#62;
  		&#60;input type="submit" value="注册"/&#62;
  	&#60;/form&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

doReg.jsp:
----------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  &#60;body&#62;
  	&#60;%
  		request.setCharacterEncoding("utf-8");
  		String name = request.getParameter("name");
  		if(name!=null && name.trim().length()&#62;0 && name.startsWith("hncu") ){
  			//访问后台
  			session.setAttribute("user", name);
  			out.println("success..."+name);
  			//其实还可以跳转到其他登录成功的jsp页面的，这里就省略了；
  			//request.getRequestDispatcher("success.jsp").forward(request, response);
  		}else{
  			out.println("failuer..."+name);
  			//可以跳转到其他登录失败的jsp页面的，这里就省略了；
  			//request.getRequestDispatcher("failure.jsp").forward(request, response);
  		}
  	%&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

演示结果就不演示了，相信大家一眼就能看出运行结果，不过是2个jsp页面跳转而已(后台数据库没写)，中间有一些java代码罢了。


JSP+EJB开发
=========

regEjbJsp.jsp:
----------------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  &#60;body&#62;
  	&#60;form action="doRegEjb.jsp" method="post"&#62;
  		Name:&#60;input type="text" name="name"/&#62;&#60;br/&#62;
  		Age:&#60;input type="text" name="age"/&#62; &#60;br/&#62;
  		&#60;input type="submit" value="注册"/&#62;
  	&#60;/form&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

User.java:
----------

```
package cn.hncu.jspEjb.ejb;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private Integer age;
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//在POJO(JavaBean)的基础上增加一些业务处理方法，就变成企业级JavaBean---EJB
	public boolean reg(){
		//可以再去调用DAO层。我这里简化了
		//UserDAO dao = UserDaoFactory.getUserDAO();
		//dao.reg(this.name,this.age);
		if(name.startsWith("hncu") && age&#62;20){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @return 功能，返回所有的User
	 */
	public List&#60;User&#62; getAll(){
		return null;
	}
}

```



doRegEjb.jsp:
-------------

```
&#60;%@page import="cn.hncu.jspEjb.ejb.User"%&#62;
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;%
  		request.setCharacterEncoding("utf-8");
  		String name = request.getParameter("name");
  		String strAge = request.getParameter("age");
  		//下面这一句强转需要再防范一下！！
  		int age = Integer.parseInt(strAge);
  		User user = new User();
  		user.setName(name);
  		user.setAge(age);
  		boolean boo = user.reg();
  		
  		if(boo){
  			//访问后台。。。
  			session.setAttribute("user",name);
  			out.print("success..."+name);
  			//也可以再写一个登录成功页面
  			//request.getRequestDispatcher("success.jsp").forward(request, response);
  		}else{
  			out.print("failure..."+name);
  			//也可以再写一个登录失败页面
  			//request.getRequestDispatcher("failure.jsp").forward(request, response);
  		}
  		
  		
  	
  	%&#62;
  
  &#60;/body&#62;
&#60;/html&#62;

```


JSP(V)+Servlet(C)+POJO(M)开发的注册---MVC
====================================

这里把业务逻辑层从JavaBean分离开了！

user.java:
----------

```
package cn.hncu.regServletPojo.domain;

public class User {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}

```

RegServlet.java:
----------------

```
package cn.hncu.regServletPojo.servlets;

import java.util.List;

import cn.hncu.regServletPojo.domain.User;

public class RegServlet {
	
	public boolean reg(User user){
		//再分一个DAO
		//UserDAO dao = UserDaoFactory.getUserDAO();
		//dao.reg(user);
		//要去数据库校验数据！！！！
		if(user.getName().startsWith("hncu") && user.getAge()&#62;20 ){
			return true;
		}else{
			return false;
		}
	}
	
	//查询所有的User
	public List&#60;User&#62; getAll(){
		return null;
	}
}

```


regServletJsp.jsp:
------------------

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;h2&#62;JSP(V)+Servlet(C)+POJO(M)开发的注册---MVC&#60;/h2&#62;
  	&#60;form action="/myJspDemo2/RegServletPOJO" method="post"&#62;
  		Name:&#60;input type="text" name="name"/&#62;&#60;br/&#62;
  		age:&#60;input type="text" name="age"/&#62;&#60;br/&#62;
  		&#60;input type="submit" value="注册"/&#62;
  	&#60;/form&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

web.xml:
--------

```
&#60;servlet&#62;
    &#60;servlet-name&#62;RegServletPOJO&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.reg.servlet.RegServletPOJO&#60;/servlet-class&#62;
  &#60;/servlet&#62;
  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;RegServletPOJO&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/RegServletPOJO&#60;/url-pattern&#62;
  &#60;/servlet-mapping&#62;	
```

RegServletPOJO.java:
--------------------

```
package cn.hncu.reg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.regServletPojo.domain.User;
import cn.hncu.regServletPojo.servlets.RegServlet;

public class RegServletPOJO extends HttpServlet {
	
	//注入servlet
	RegServlet service = new RegServlet();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		//下面的解析需要防范
		int age = Integer.parseInt(strAge);
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		boolean boo = service.reg(user);
		
		if(boo){
			//访问后台。。
			request.getSession().setAttribute("user", name);
			out.print("success..."+name);
			//可以转发到另外的成功页面
			//request.getRequestDispatcher("sussess.jsp").forward(request, response);
		}else{
			out.print("failure..."+name);
			//可以转发到另外的失败页面
			//request.getRequestDispatcher("failure.jsp").forward(request, response);
		}
		
	}

}

```

JavaBean简介：
===========

JavaBean是一种可重用的软件组件。
一个JavaBean具有以下标准：
1、必须是一个公共的类。
2、必须有一个公开的无参的构造。
3、必须有getXxx和setXxx方法。
