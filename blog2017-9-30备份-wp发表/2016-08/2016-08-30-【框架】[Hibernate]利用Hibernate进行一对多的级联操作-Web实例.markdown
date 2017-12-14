---
layout: post
title: "【框架】[Hibernate]利用Hibernate进行一对多的级联操作-Web实例"
date: 2016-08-30 05:24:16 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,框架,存储,实例]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。 
在此： 
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。 
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】


准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。 
在此： 
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。 
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

准备两个表，学生表，和学院表，它们的关系是一对多，一个学生对应一个学院，一个学院可以对应多个学生。
在此：
1、演示利用一对多关系进行级联查询，也就是，只查询某个学院，同时将学院中的所有学生查询出来。
2、演示利用一对多关系进行级联存储，也就是说，只存储学院，但是同时将学生信息存储进学生表。

#准备的数据库数据:
```
create database hib charset=utf8;
use hib;
create table students(
    sId varchar(8) primary key,
    sName varchar(40),
    sAge int,
    deptId varchar(8)
);

create table depts(
  dId varchar(8) primary key,
  dName varchar(40)
);

alter table students add(constraint fk_stu_dept foreign key(deptId) references dept(dId));
//为students-deptId添加外键-dept(dId)

insert into depts(dId,dName) values('D001','信息科学与工程学院');
insert into depts(dId,dName) values('D002','土木工程学院');
insert into depts(dId,dName) values('D003','数学与计算机学院');
insert into depts(dId,dName) values('D004','通信学院');

insert into students(sId,sName,sAge,deptId) values('S001','Jack',23,'D001');
insert into students(sId,sName,sAge,deptId) values('S002','Tom',25,'D001');
insert into students(sId,sName,sAge,deptId) values('S003','张三',43,'D001');
insert into students(sId,sName,sAge,deptId) values('S004','李四',55,'D001');
insert into students(sId,sName,sAge,deptId) values('S005','Jack',23,'D002');
insert into students(sId,sName,sAge,deptId) values('S006','Tom',25,'D003');
insert into students(sId,sName,sAge,deptId) values('S007','张三',43,'D002');
insert into students(sId,sName,sAge,deptId) values('S008','李四',55,'D002');
```

这些数据是为了等会自己演示的时候方便。

students表数据如下:

![](http://img.blog.csdn.net/20160830164627202)

depts表数据如下:

![](http://img.blog.csdn.net/20160830164657811)

因为代码比较多，只演示部分代码，完整代码在后面会给出链接。
需要的JAR包，也全部在项目中，下载完整项目即可。


#index.jsp:

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
&#60;head&#62;
&#60;title&#62;Hibernate中表之间的一对多关系&#60;/title&#62;
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
&#60;/head&#62;

&#60;body&#62;
	&#60;h3&#62;通过学院id查询学院表，把该学院的学生信息也同时输出来&#60;/h3&#62;
	&#60;form action="&#60;c:url value='/DemoServlet?cmd=queryDeptById'/&#62;"
		method="post"&#62;
		&#60;table&#62;
			&#60;tr&#62;
				&#60;td&#62;学院编号&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="deptId"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td colspan="2" align="center"&#62;&#60;input type="submit" value="查询"&#62;
				&#60;/td&#62;
			&#60;/tr&#62;
		&#60;/table&#62;
	&#60;/form&#62;

	&#60;c:if test="${!empty sessionScope.map }"&#62;
		&#60;h3&#62;查询结果&#60;/h3&#62;
		  学院名称:${map.deptName}
		  &#60;table&#62;
			&#60;tr&#62;
				&#60;td&#62;学号&#60;/td&#62;
				&#60;td&#62;姓名&#60;/td&#62;
				&#60;td&#62;年龄&#60;/td&#62;
				&#60;td&#62;学院编号&#60;/td&#62;
			&#60;/tr&#62;
			&#60;c:forEach items="${map.qlist}" var="stud"&#62;
				&#60;tr&#62;
					&#60;td&#62;${stud.sId}&#60;/td&#62;
					&#60;td&#62;${stud.sName}&#60;/td&#62;
					&#60;td&#62;${stud.sAge}&#60;/td&#62;
					&#60;td&#62;${stud.dept.dId}&#60;/td&#62;
				&#60;/tr&#62;
			&#60;/c:forEach&#62;
		&#60;/table&#62;
		&#60;c:remove var="map"/&#62;
	&#60;/c:if&#62;
	
	&#60;h3&#62;添加学生/学院&#60;/h3&#62;
	&#60;form action="&#60;c:url value='/DemoServlet?cmd=addDept'/&#62;" method="post"&#62;
		&#60;table&#62;
			&#60;tr&#62;
				&#60;td&#62;学院编号&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="deptId"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;学院名称
				&#60;/td&#62;
				&#60;td&#62;&#60;input type="text" name="deptName"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td align="center"&#62;学生学号&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td align="center"&#62;&#60;input type="text" name="studId"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td align="center"&#62;学生姓名&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td align="center"&#62;&#60;input type="text" name="studName"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td align="center"&#62;学生年龄&#60;font color="red"&#62;*&#60;/font&#62;
				&#60;/td&#62;
				&#60;td align="center"&#62;&#60;input type="text" name="studAge"&#62;&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td colspan="2" align="center"&#62;&#60;input type="submit" value="存储"&#62;&#60;/td&#62;
			&#60;/tr&#62;
		&#60;/table&#62;
	&#60;/form&#62;

&#60;/body&#62;
&#60;/html&#62;

```


#DemoJdbcDao.java

数据层。

```
package cn.hncu.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hncu.domain.Dept;
import cn.hncu.domain.Student;
import cn.hncu.hib.HibernateSessionFactory;

public class DemoJdbcDao {
	public Dept queryDeptById(Dept dept) {
		Session s = HibernateSessionFactory.getSession();
		String hql = "from Dept d where d.dId=?";
		//String hql = "from Dept";
		Query query = s.createQuery(hql);
		query.setParameter(0, dept.getdId());
		//根据部门ID去查的，只会有一个查询结果
		Dept resDept = (Dept) query.list().get(0);
		return resDept;
	}

	public void addDept(Dept dept) {
		Session s = HibernateSessionFactory.getSession();
		if(dept.getdName()==null){
			Query query = s.createQuery("from Dept d where d.dId=?");
			query.setParameter(0, dept.getdId());
			//对于学院存在的，如果没有填写学院名称，为其补上
			dept.setdName( ((Dept) query.list().get(0)).getdName() );
		}
		s.clear();//把之前的session信息清空，因为不允许一个session对象进行几个操作
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(dept);
		tx.commit();
	}
	
}

```

#DemoServlet

servlet层

```
package cn.hncu.demo;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.demo.service.DemoServiceImpl;
import cn.hncu.domain.Dept;
import cn.hncu.domain.Student;
import cn.hncu.utils.BaseServlet;

public class DemoServlet extends BaseServlet {
	DemoServiceImpl service = new DemoServiceImpl();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
	}
	
	public void queryDeptById(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String deptId = req.getParameter("deptId");
		if(deptId==null||deptId.trim().length()==0){
			resp.sendRedirect(getServletContext().getContextPath());
			return;
		}
		Dept dept = new Dept();
		dept.setdId(deptId);
		dept = service.queryDeptById(dept);
		Map&#60;String, Object&#62; map = new HashMap&#60;String, Object&#62;();
		
		map.put("deptName", dept.getdName());
		map.put("qlist", dept.getStudents());
		
		req.getSession().setAttribute("map", map);
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
	public void addDept(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String deptId = req.getParameter("deptId");
		String deptName = req.getParameter("deptName");
		if(deptName==null||deptName.trim().equals("")){
			deptName=null;
		}
		String studId = req.getParameter("studId");
		String studName = req.getParameter("studName");
		String studAge = req.getParameter("studAge");
		int age = Integer.parseInt(studAge);
		
		Dept dept = new Dept();
		dept.setdId(deptId);
		dept.setdName(deptName);
		
		Student s1 = new Student();
		s1.setsId(studId);
		s1.setsName(studName);
		s1.setsAge(age);
		s1.setDept(dept);//多方进行设置外键
		
		//把多方添加到一方的集合中
		dept.getStudents().add(s1);
		
		service.addDept(dept);
		
		resp.sendRedirect(getServletContext().getContextPath());
	}
	
}

```


#演示结果：

开始显示页面:

![](http://img.blog.csdn.net/20160830165721503)

查询D002学院:

![](http://img.blog.csdn.net/20160830165756394)

为D002学院添加学生:

![](http://img.blog.csdn.net/20160830170254542)

结果:
![](http://img.blog.csdn.net/20160830170313991)

添加D005学院-科技学院

![](http://img.blog.csdn.net/20160830170336746)

结果

![](http://img.blog.csdn.net/20160830170347992)


#完整的项目链接:

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;&#60;a href='https://github.com/chenhaoxiang/Java/tree/master/Hibernate/myHibWeb2'&#62;&#60;font color="red"&#62;--&gt;点击访问本系列源码以及JAR包&#60;/font&#62;&#60;/a&#62;&#60;br&#62;
&#60;/blockquote&#62;

#小小的总结:

此项目，我写的时候比较急，因为马上要学Spring框架了，有些方面没考虑到，有兴趣的可以自己取完善一下。例如，在增加学院和学生的时候，增加一个按钮，添加学生。再比如，把service,DAO层完善一下，写好接口，最好再写个过滤器，全站压缩，编码啥的。哈哈，自己可以加功能的。

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;