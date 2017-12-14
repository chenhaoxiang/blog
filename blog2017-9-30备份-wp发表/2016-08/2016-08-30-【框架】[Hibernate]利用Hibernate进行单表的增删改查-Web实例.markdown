---
layout: post
title: "【框架】[Hibernate]利用Hibernate进行单表的增删改查-Web实例"
date: 2016-08-30 03:21:32 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,框架,实例]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前面两篇博客已经将Hibernate的基础知识讲解得差不多了，差不多到写实例的时候了。本篇只用hibernate进行单表的增删改查、应用Hibernate，对students表进行增删改查。 
service层和DAO层，我都是直接写实现类了(因为这里主要是演示一下Hibernate的 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前面两篇博客已经将Hibernate的基础知识讲解得差不多了，差不多到写实例的时候了。本篇只用hibernate进行单表的增删改查、应用Hibernate，对students表进行增删改查。 
service层和DAO层，我都是直接写实现类了(因为这里主要是演示一下Hibernate的
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

前面两篇博客已经将Hibernate的基础知识讲解得差不多了，差不多到写实例的时候了。

本篇只用hibernate进行单表的增删改查、

应用Hibernate，对students表进行增删改查。
service层和DAO层，我都是直接写实现类了(因为这里主要是演示一下Hibernate的使用)，如果是开发项目，注意一定要写接口！

##准备数据库:
首先准备一个students表:

```
create database hib charset=utf8;
use hib;
create table students(
    sId varchar(8) primary key,
    sName varchar(40),
    sAge int,
    deptId varchar(8)
);

```

插入数据:

```

insert into students(sId,sName,sAge,deptId) values('S001','Jack',23,'D001');
insert into students(sId,sName,sAge,deptId) values('S002','Tom',25,'D001');
insert into students(sId,sName,sAge,deptId) values('S003','张三',43,'D001');
insert into students(sId,sName,sAge,deptId) values('S004','李四',55,'D001');
insert into students(sId,sName,sAge,deptId) values('S005','Jack',23,'D002');
insert into students(sId,sName,sAge,deptId) values('S006','Tom',25,'D003');
insert into students(sId,sName,sAge,deptId) values('S007','张三',43,'D002');
insert into students(sId,sName,sAge,deptId) values('S008','李四',55,'D002');
```
![](http://img.blog.csdn.net/20160830143453330)

##需要的Jar包

数据库连接包以及hibernate必须包，这些包在项目的WEBROOT/WEBINF的bin目录下都有。
![](http://img.blog.csdn.net/20160830144238553)
链接:
https://github.com/chenhaoxiang/Java/blob/master/Hibernate/myHibWeb/myHibWeb.zip


##部分核心源码:

###Student.java:

```
package cn.hncu.domain;

public class Student {
	private String sId;
	private String sName;
	private Integer sAge;
	
	private String deptId;
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Student() {
		super();
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsAge() {
		return sAge;
	}
	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sAge=" + sAge
				+ ", deptId=" + deptId + "]";
	}
}

```

###hibernate.cfg.xml

```
&#60;?xml version='1.0' encoding='UTF-8'?&#62;
&#60;!DOCTYPE hibernate-configuration PUBLIC
          "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
          "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd"&#62;
&#60;hibernate-configuration&#62;
	&#60;!-- 这是最简单的配置版！！！ --&#62;
	&#60;session-factory&#62;
		&#60;property name="connection.driver_class"&#62;
			com.mysql.jdbc.Driver
		&#60;/property&#62;
		&#60;property name="connection.url"&#62;
			jdbc:mysql://127.0.0.1:3306/hib
		&#60;/property&#62;
		&#60;property name="connection.username"&#62;root&#60;/property&#62;
		&#60;property name="connection.password"&#62;1234&#60;/property&#62;

		&#60;property name="dialect"&#62;
			org.hibernate.dialect.MySQLDialect
		&#60;/property&#62;
		
		  &#60;!--是否在后台显示Hibernate用到的SQL语句，开发时设置为true，便于查错，
        程序运行时可以在Eclipse的控制台显示Hibernate的执行Sql语句。
        项目部署后可以设置为false，提高运行效率--&#62;   
        &#60;property name="hibernate.show_sql"&#62;true &#60;/property&#62;   
        
        &#60;!--jdbc.fetch_size是指Hibernate每次从数据库中取出并放到JDBC的Statement中的记录条数。
        Fetch Size设的越大，读数据库的次数越少，速度越快，Fetch Size越小，读数据库的次数越多，速度越慢--&#62;   
        &#60;property name="jdbc.fetch_size"&#62;50 &#60;/property&#62; 
          
        &#60;!--jdbc.batch_size是指Hibernate批量插入,删除和更新时每次操作的记录数。
        Batch Size越大，批量操作的向数据库发送Sql的次数越少，速度就越快，同样耗用内存就越大--&#62;   
        &#60;property name="jdbc.batch_size"&#62;23 &#60;/property&#62;  
         
        &#60;!--jdbc.use_scrollable_resultset是否允许Hibernate用JDBC的可滚动的结果集。
        对分页的结果集。对分页时的设置非常有帮助--&#62;   
        &#60;property name="jdbc.use_scrollable_resultset"&#62;false &#60;/property&#62; 
		
		&#60;!--connection.useUnicode连接数据库时是否使用Unicode编码 --&#62;
		&#60;property name="connection.useUnicode"&#62;true&#60;/property&#62;
		&#60;!--connection.characterEncoding连接数据库时数据的传输字符集编码方式 --&#62;
		&#60;property name="connection.characterEncoding"&#62;utf-8&#60;/property&#62;

		&#60;mapping resource="cn/hncu/domain/Student.hbm.xml" /&#62;
	&#60;/session-factory&#62;

&#60;/hibernate-configuration&#62;
```


###Student.hbm.xml

```
&#60;?xml version="1.0" encoding="utf-8"?&#62;
&#60;!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd"&#62;

&#60;hibernate-mapping package="cn.hncu.domain"&#62;
	
	&#60;!--name指的是POJO类的类名，table是数据库的表名，catalog是数据库的名称  --&#62;
	&#60;class name="Student" table="students" catalog="hib"&#62;
		&#60;!--id表示此字段为数据库的主键，这里也可以用property来写，name为Student类的成员变量名，type为类型的包全名  --&#62;
		&#60;id name="sId" type="java.lang.String"&#62;
			&#60;!--column表示映射的数据库的字段，name表示数据库中字段名，length表示varchar/char型的长度  --&#62;
			&#60;column name="sId" length="8"&#62;&#60;/column&#62;
			&#60;generator class="assigned"&#62;&#60;/generator&#62;			
		&#60;/id&#62;
		&#60;property name="sName" type="java.lang.String"&#62;
			&#60;column name="sName" length="40" /&#62;
		&#60;/property&#62;
		&#60;property name="sAge" type="java.lang.Integer"&#62;
			&#60;column name="sAge" /&#62;
		&#60;/property&#62;
		&#60;property name="deptId" type="java.lang.String"&#62;
        &#60;column name="deptId" length="8" /&#62;
     &#60;/property&#62;
	&#60;/class&#62;

&#60;/hibernate-mapping&#62;
```


###BaseServlet.java

```
package cn.hncu.utils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cmd = req.getParameter("cmd");
		if (null == cmd || cmd.trim().equals("")) {
			cmd = "execute";
		}
		try {
			Method method = this.getClass().getMethod(cmd,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("没有此方法：" + e.getMessage(), e);
		}catch(InvocationTargetException e){
			throw new RuntimeException("目标方法执行失败：" + e.getMessage(), e);
		}catch(IllegalAccessException e){
			throw new RuntimeException("你可能访问了一个私有的方法：" + e.getMessage(), e);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	public abstract void execute(HttpServletRequest req,
			HttpServletResponse resp) throws Exception;
}

```


###HibernateSessionFactory.java

```
package cn.hncu.hib;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
   private static String configFile = "/hibernate.cfg.xml";
   private static Configuration config = new Configuration();
   private static SessionFactory sessionFactory =null;
   
   private static final ThreadLocal&#60;Session&#62; t = new ThreadLocal&#60;Session&#62;();
   
   static{
	   try {
		   config.configure(configFile);
		   sessionFactory = config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
   }
   
   public static Session getSession() throws HibernateException{
	   Session session = t.get();
	   if(session == null || !session.isOpen()){
		   if(sessionFactory==null){
			   rebuildSessionFactory();
		   }
		   session = (sessionFactory!=null) ? sessionFactory.openSession() : null;
		   t.set(session);
	   }
	   return session;
   }

   private static void rebuildSessionFactory() {
	   try {
		   config.configure(configFile);
		   sessionFactory = config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
   }
   
   //关闭与数据库的会话
   public static void closeSession() throws HibernateException{
	   Session session = t.get();
	   t.set(null);
	   if(session!=null){
		   session.close();
	   }
   }
   
   
}

```


###DemoServlet.java

```
package cn.hncu.demo;


import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.demo.service.DemoServiceImpl;
import cn.hncu.domain.Student;
import cn.hncu.utils.BaseServlet;

public class DemoServlet extends BaseServlet {
	DemoServiceImpl service = new DemoServiceImpl();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		List&#60;Student&#62; list = service.queryAllStudents();
		req.getSession().setAttribute("list", list);
		
		req.getRequestDispatcher("/jsps/demo.jsp").forward(req, resp);
	}
	
	public void delStudent(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String studId = req.getParameter("studId");
		Student stud = new Student();
		
		stud.setsId(studId);
		
		service.delStudent(stud);
		
		resp.sendRedirect(getServletContext().getContextPath()+"?time="+(new Date().getTime()));
	}
	
	public void addStudent(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String studId = req.getParameter("studId");
		String studName = req.getParameter("studName");
		String strAge = req.getParameter("age");
		Integer age = Integer.valueOf(strAge);
		String deptId = req.getParameter("deptId");
		Student stud = new Student();
		stud.setsId(studId);
		
		//System.out.println(studName);//正常汉字
		
		stud.setsName(studName);
		stud.setsAge(age);
		stud.setDeptId(deptId);
		
		service.addStudent(stud);
		
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
	public void queryStudents(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String studId = req.getParameter("studId");
		String studName = req.getParameter("studName");
		String deptId = req.getParameter("deptId");
		Student stud = new Student();
		stud.setsId(studId);
		stud.setsName(studName);
		stud.setDeptId(deptId);
		
		List&#60;Student&#62; qlist = service.queryStudents(stud);
		req.getSession().setAttribute("qlist", qlist);
		PrintWriter out = resp.getWriter();
		out.print("1"); //坑:不能使用out.println("1")
	}

}

```

###DemoJdbcDao.java

```
package cn.hncu.demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hncu.domain.Student;
import cn.hncu.hib.HibernateSessionFactory;

public class DemoJdbcDao {
	public List&#60;Student&#62; queryAllStudents() {
		Session s = HibernateSessionFactory.getSession();
		Query query = s.createQuery("from Student");
		List&#60;Student&#62; list = query.list();
		return list;
	}

	public void delStudent(Student stud) {
		Session s = HibernateSessionFactory.getSession();
			try {
				Transaction tran = s.beginTransaction();
				System.out.println("stud:"+stud);
				s.delete(stud);
//				Student stud2 = new Student();
//				stud2.setStudId("S001");
//				s.save(stud2);
				tran.commit();
			} catch (HibernateException e) {
				//tran.rollback();//可以不写，内部会进行回滚
				System.out.println("抓到异常...");
			}
		
	}
	
	public void addStudent(Student stud) {
		Session s = HibernateSessionFactory.getSession();
		Transaction tran = s.beginTransaction();
		try {
			System.out.println(stud.getsName());
			s.saveOrUpdate(stud);
			tran.commit();
		} catch (HibernateException e) {
		}
	}

	public List&#60;Student&#62; queryStudents(Student stud) {
		System.out.println(stud);
		boolean f1=false,f2=false,f3=false;
		Session s = HibernateSessionFactory.getSession();
		String hql = "from Student s where 1=1";
		
		if(stud.getsId()!=null && stud.getsId().trim().length()&#62;0){
			hql = hql + " and s.sId=:sId";
			f1=true;
		}
		if(stud.getsName()!=null && stud.getsName().trim().length()&#62;0){
			hql = hql + " and s.sName like :sName";
			f2=true;
		}
		if(stud.getDeptId()!=null && stud.getDeptId().trim().length()&#62;0){
			hql = hql + " and s.deptId=:deptId";
			f3=true;
		}
		
		Query query = s.createQuery(hql);
		if(f1){
			query.setParameter("sId", stud.getsId().trim());
		}
		if(f2){
			query.setParameter("sName", "%"+stud.getsName().trim()+"%");
		}
		if(f3){
			query.setParameter("deptId", stud.getDeptId().trim());
		}
		return query.list();
	}
	
}

```

###ajax.js

```
String.prototype.trim=function(){
	var p = /^\s*/;
	//\s 匹配任何空白字符，包括空格、制表符、换页符等等
	var str = this.replace(p, "");
	p=/\s*$/;
	str = str.replace(p, "");
	return str;
};

function Ajax(){
	var xmlhttp;
	//1 创建一个ajax对象
	if(window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//url为请求的链接或文件。
	//succ是status返回为200后运行的函数。
	//failure是status返回不为200后运行的函数。
	
	this.get=function(url,succ,failure){
		//2 设置通讯方式和地址
		xmlhttp.open("GET", url, true);//异步--多线程
		//3 设置访问成功后的 js对象(回调函数)
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4){//服务器的响应消息接收完毕
				if(xmlhttp.status==200){//服务器正常响应
					var txt = xmlhttp.responseText;//后台的响应信息
					succ(txt);
				}else{
	 				if(failure){
	  				    failure(xmlhttp.status);
	  				 }
	 			}
			}
		};
		//4发送---Get方式，没有参数(请求体) ---数据在请求地址中
		xmlhttp.send();
	};
	
	this.post= function(url,data,succ, failure){
		//2 设置通讯方式和地址
	 	xmlhttp.open("POST",url,true);//异步--多线程
	 	//3 设置访问成功后的 js对象(回调函数)
	 	xmlhttp.onreadystatechange=function(){
	 		if(xmlhttp.readyState==4){//服务器的响应消息接收完毕
	 			if(xmlhttp.status==200){//服务器正常响应
	 				var txt = xmlhttp.responseText;//后台的响应信息
	 				succ(txt);
	 			}else{
	 				if(failure){
	  				    failure(xmlhttp.status);
	  				 }
	 			}
	 		}
	 	};
	 	//4设置请求头
	 	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	 	
	 	//5发送---Post方式，有参数(请求体) &#60;---数据 ※
	 	xmlhttp.send(data);
	};
	
}
```

###demo.jsp

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
&#60;head&#62;
&#60;title&#62;利用Hibernate进行单表的增删改查&#60;/title&#62;
&#60;style type="text/css"&#62;
table {
	border: 1px solid gray;
	border-collapse: collapse;
	width: 60%;
}

td {
	border: 1px solid gray;
	padding: 5px;
}
&#60;/style&#62;

&#60;script type="text/javascript" src="&#60;c:url value='/js/ajax.js'/&#62;"&#62;&#60;/script&#62;

&#60;script type="text/javascript"&#62;
	var path = "&#60;c:url value='/'/&#62;";
&#60;/script&#62;

&#60;script type="text/javascript"&#62;
	var d = new Date();
	function query() {
		var studId = document.getElementsByName("studId")[1].value;
		studId = studId.trim();
		var studName = document.getElementsByName("studName")[1].value;
		studName = studName.trim();
		var deptId = document.getElementsByName("deptId")[1].value;
		deptId = deptId.trim();

		//ajax提交
		var ajax = new Ajax();
		var url = path + "/DemoServlet";
		var params = "cmd=queryStudents&studId=" + studId + "&studName="
				+ studName + "&deptId=" + deptId;
		ajax.post(url, params, function(data) {
			if (data == "1") {
				//这个返回来输出的页面的是子页面！
				window.parent.window.location.href = path + "?time="
						+ d.getTime();
			}
		});
	}
&#60;/script&#62;


&#60;/head&#62;

&#60;body&#62;
	&#60;table&#62;
		&#60;tr&#62;
			&#60;td&#62;学号&#60;/td&#62;
			&#60;td&#62;姓名&#60;/td&#62;
			&#60;td&#62;年龄&#60;/td&#62;
			&#60;td&#62;学院编号&#60;/td&#62;
			&#60;td&#62;操作&#60;/td&#62;
		&#60;/tr&#62;
		&#60;c:forEach items="${list}" var="stud"&#62;
			&#60;tr&#62;
				&#60;td&#62;${stud.sId}&#60;/td&#62;
				&#60;td&#62;${stud.sName}&#60;/td&#62;
				&#60;td&#62;${stud.sAge}&#60;/td&#62;
				&#60;td&#62;${stud.deptId}&#60;/td&#62;
				&#60;td&#62;&#60;a
					href="&#60;c:url value='/DemoServlet?cmd=delStudent&studId=${stud.sId}'/&#62;"&#62;删除&#60;/a&#62;
				&#60;/td&#62;
			&#60;/tr&#62;
		&#60;/c:forEach&#62;
	&#60;/table&#62;

	&#60;h3&#62;添加一个学生信息&#60;/h3&#62;
	&#60;form action="&#60;c:url value='/DemoServlet?cmd=addStudent'/&#62;"
		method="post"&#62;
		&#60;table&#62;
			&#60;tr&#62;
				&#60;td&#62;学号&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="studId"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;姓名&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="studName"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;年龄&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="age"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;学院编号&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="deptId"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td colspan="2" align="center"&#62;&#60;input type="submit"
					value="添加/修改"&#62;&#60;/td&#62;
			&#60;/tr&#62;
		&#60;/table&#62;
	&#60;/form&#62;


	&#60;hr /&#62;
	&#60;h3&#62;学生查询&#60;/h3&#62;
	&#60;table&#62;
		&#60;tr&#62;
			&#60;td&#62;学号&#60;/td&#62;
			&#60;td&#62;&#60;input type="text" name="studId"&#62;&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td&#62;姓名&#60;/td&#62;
			&#60;td&#62;&#60;input type="text" name="studName"&#62;&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td&#62;学院编号&#60;/td&#62;
			&#60;td&#62;&#60;input type="text" name="deptId"&#62;&#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td colspan="2" align="center"&#62;&#60;input type="button"
				onclick="query();" value="查询"&#62;&#60;/td&#62;
		&#60;/tr&#62;
	&#60;/table&#62;

	&#60;c:if test="${!empty sessionScope.qlist }"&#62;
		&#60;h3&#62;查询结果&#60;/h3&#62;
		&#60;table&#62;
			&#60;tr&#62;
				&#60;td&#62;学号&#60;/td&#62;
				&#60;td&#62;姓名&#60;/td&#62;
				&#60;td&#62;年龄&#60;/td&#62;
				&#60;td&#62;学院编号&#60;/td&#62;
				&#60;td&#62;操作&#60;/td&#62;
			&#60;/tr&#62;
			&#60;c:forEach items="${qlist}" var="stud"&#62;
				&#60;tr&#62;
					&#60;td&#62;${stud.sId}&#60;/td&#62;
					&#60;td&#62;${stud.sName}&#60;/td&#62;
					&#60;td&#62;${stud.sAge}&#60;/td&#62;
					&#60;td&#62;${stud.deptId}&#60;/td&#62;
					&#60;td&#62;
						&#60;a href="&#60;c:url value='/DemoServlet?cmd=delStudent&studId=${stud.sId}'/&#62;"&#62;删除&#60;/a&#62;
					&#60;/td&#62;
				&#60;/tr&#62;
			&#60;/c:forEach&#62;
		&#60;/table&#62;
	&#60;/c:if&#62;


&#60;/body&#62;
&#60;/html&#62;

```

###演示结果:

####显示所有:

![](http://img.blog.csdn.net/20160830150946326)

####添加学生:

![](http://img.blog.csdn.net/20160830151010514)

![](http://img.blog.csdn.net/20160830151020034)

####查询学生:

![](http://img.blog.csdn.net/20160830151037378)

##完整项目链接：

https://github.com/chenhaoxiang/Java/blob/master/Hibernate/myHibWeb/myHibWeb.zip


&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;