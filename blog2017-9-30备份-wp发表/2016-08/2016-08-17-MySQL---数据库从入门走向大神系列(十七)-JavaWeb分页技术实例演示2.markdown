---
layout: post
title: "MySQL---数据库从入门走向大神系列(十七)-JavaWeb分页技术实例演示2"
date: 2016-08-17 03:46:29 +0800
comments: true
categories:❷ Java大学之行,----- ①、Java/Web小项目,----- ⑤、数据库
tags: [数据库,servlet,分页,技术,实例]
keyword: 陈浩翔, 谙忆
description: 分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。

本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，并且只显示10个页码。增加查询功能，并且查询后的页面也进行分页。页码也进行分页 ！

查询功能的实现，需要我们在servlet向后台传输一个p 
---


分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。

本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，并且只显示10个页码。增加查询功能，并且查询后的页面也进行分页。页码也进行分页 ！

查询功能的实现，需要我们在servlet向后台传输一个p
&#60;!-- more --&#62;
----------

分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。

本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，并且只显示10个页码。增加查询功能，并且查询后的页面也进行分页。页码也进行分页 ！

查询功能的实现，需要我们在servlet向后台传输一个person,封装我们的查询条件


相关算法(技术):


```
总行数(num): select count(1) from stud;

每页显示的行数(n): 固定值---已知的一个常量

页数: pageSize= num/n +( (num%n==0)?0:1 )

当前页号: currentPage

当前要显示的页面数据的起始行号和终止行号
startN: (currentPage-1)*pageSize

如何显示从startN开始的pageSize条记录
select * from stud limit startN, pageSize;

增加了：
开始的页码：
showStart
结束的页码：
showEnd
```

像这样：
![](http://img.blog.csdn.net/20160817151850332)


#数据库数据：

创建的数据库表，还有需要准备的jar包，请看本篇博客：

http://blog.csdn.net/qq_26525215/article/details/52222472


#源码：

##PageJdbc.java

```
package cn.hncu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.hncu.domain.Person;
import cn.hncu.pubs.C3p0Pool;

public class PageJdbc implements IPageDAO {
	private final int pageSize = 10;// 每页显示的行数

	@Override
	public Map&#60;String, Object&#62; query(Integer pageNo, Person person)
			throws NumberFormatException, SQLException {
		Map&#60;String, Object&#62; result = new HashMap&#60;String, Object&#62;();

		// 获取总页数 pageCount = rows/pageSize + ( (rows%pageSize==0)?0:1 )
		// 总行数rows
		String sql = "select count(1) from person where 1=1 ";// 用来查总行数

		String sql2 = "select * from person where 1=1 ";// 用来查表内容

		if (person.getId() != null && person.getId().trim().length() != 0) {
			sql = sql + "and id like '%" + person.getId() + "%'";
			sql2 = sql2 + "and id like '%" + person.getId() + "%'";
		}
		if (person.getName() != null && person.getName().trim().length() != 0) {
			sql = sql + "and name like '%" + person.getName() + "%'";
			sql2 = sql2 + "and name like '%" + person.getName() + "%'";
		}
		//System.out.println(sql2);
		
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		int rows = Integer.parseInt("" + run.query(sql, new ScalarHandler()));

		// 总页数
		int pageCount = rows / pageSize + ((rows % pageSize == 0) ? 0 : 1);
		result.put("pageCount", pageCount);// 封装到result
		// 分页页面内容datas
		// 起始行号
		int startN = (pageNo - 1) * pageSize;
		sql2 = sql2+ " limit "+startN+", "+pageSize;
		
		List&#60;Map&#60;String, Object&#62;&#62; datas = run.query(sql2, new MapListHandler());
		result.put("datas", datas);//封装到result
			
		return result;
	}

}

```

##PageServlet.java

```
package cn.hncu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.domain.Person;
import cn.hncu.service.IPageService;
import cn.hncu.service.PageServiceImpl;

public class PageServlet extends HttpServlet {
	//注入servlet
	IPageService service = new PageServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String pageNo = request.getParameter("page");
		if(pageNo==null || pageNo.trim().length()==0){
			pageNo = "1";
		}
		Integer iPageNo =1;
		try {
			iPageNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request, response);
		}
		
		Person person =null;
		//区分是Post还是GET方式请求，前者是新的查询，后者是原查询结果中进行翻页
		if(request.getMethod().equalsIgnoreCase("get")){//翻页
			//从session中把旧的查询条件值对象取出来
			person = (Person) request.getSession().getAttribute("person");
			if(person==null){//没有进行第一次查询之前，person就是需要我们new出来一个空的
				person = new Person();
			}
		}else{//POST方式---新的查询
			//收集模糊查询的输入参数
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			person = new Person();
			person.setId(id);
			person.setName(name);
			//放入session,这样下一次翻页才能读取出来
			request.getSession().setAttribute("person", person);
		}
		
		
		try {
			Map&#60;String, Object&#62; result = service.query(iPageNo, person);
			
			//给结果集补一个数据:currentPage --当前页号
			result.put("currentPage", iPageNo);
			
			//把结果集放入容器中
			request.setAttribute("result", result);
			
			//分页后的分页--向前端多传送两个数据(起始和末尾页号)：showStart和showEnd
			int showSize=10;//每页显示几行
			int showStart=0;//从第几个页号开始显示
			int showEnd=0;//显示到第几个页号
			
			//pageCount---总页数
			//如果所有页码不足showSize:  showStart=1,showEnd=pageCount
			int pageCount = Integer.parseInt(""+result.get("pageCount"));
			
			if(pageCount>=showSize){//不需要二次分页
				showStart=1;
				showEnd=pageCount;
			}else{//需要二次分页
				//如果当前页号iPageNo>=showSize/2时，showStart=1
				if(iPageNo>=showSize/2){
					showStart=1;
					showEnd=showSize;
				}else{
					showStart = iPageNo - showSize/2;
					showEnd = showStart + showSize-1;
				}
				
				if(showEnd&#62;pageCount){
					showEnd=pageCount;
					showStart = showEnd-showSize-1;
				}
				
			}
			
			//存储showStart和showEnd
			request.setAttribute("showStart", showStart);
			request.setAttribute("showEnd", showEnd);
			
			//转到结果页面
			request.getRequestDispatcher("/jsps/show.jsp").forward(request, response);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

```



##show.jsp

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;演示数据分页&#60;/title&#62;
  	&#60;link rel="stylesheet" href="&#60;c:url value='/css/table.css' /&#62;" /&#62;
  	
  	&#60;script type="text/javascript"&#62;
  		function sub(obj){
  			window.location.href="&#60;c:url value='/PageServlet?page=' /&#62;"+obj.value;
  		}
  	&#60;/script&#62;
  	
  &#60;/head&#62;
  	
  &#60;body&#62;
  	 &#60;h3&#62;数据查询&#60;/h3&#62;
  	 &#60;form action="&#60;c:url value='/PageServlet'/&#62;" method="post"&#62;
     		ID:&#60;input type="text" name="id" value="${person.id }"&#62; &nbsp;
            姓名:&#60;input type="text" name="name" value="${person.name }" &#62; &nbsp;&nbsp;
     		&#60;input type="submit" value="模糊查询"&#62;
 	 &#60;/form&#62;
  
  	&#60;h3&#62;当前页的内容:&#60;/h3&#62;
  	&#60;table&#62;
  		&#60;tr&#62;&#60;th&#62;学号&#60;/th&#62;&#60;th&#62;姓名&#60;/th&#62;&#60;th&#62;地址&#60;/th&#62;&#60;th&#62;年龄&#60;/th&#62;&#60;/tr&#62;
  		&#60;c:forEach items="${result.datas}" var="map"&#62;
  			&#60;tr&#62;
  				&#60;td&#62;${map.id}&#60;/td&#62;
  				&#60;td&#62;${map.name}&#60;/td&#62;
  				&#60;td&#62;${map.address}&#60;/td&#62;
  				&#60;td&#62;${map.age}&#60;/td&#62;
  			&#60;/tr&#62;
  		&#60;/c:forEach&#62;
  	&#60;/table&#62;
  	
  	
  	&#60;c:if test="${result.currentPage!=1}"&#62;
  		&#60;span class="pc"&#62;
  			&#60;a href='&#60;c:url value="/PageServlet?page=${result.currentPage-1}"&#62;&#60;/c:url&#62;'&#62;上一页&#60;/a&#62;
  		&#60;/span&#62;
  	&#60;/c:if&#62;
  	
  	&nbsp;&nbsp;
  	&#60;c:forEach begin="${showStart}" end="${showEnd}" var="idx"&#62;
		&#60;c:if test="${idx==result.currentPage}" var="isNow"&#62;
			&#60;span class=now&#62;${idx}&#60;/span&#62;
		&#60;/c:if&#62;  		
  		&#60;c:if test="${!isNow }"&#62;
  			&#60;span class="pc"&#62;
  				&#60;a href='&#60;c:url value="/PageServlet?page=${idx}"&#62;&#60;/c:url&#62;'&#62;${idx}&#60;/a&#62;
  			&#60;/span&#62;
  		&#60;/c:if&#62;
  		&nbsp;&nbsp;
  	&#60;/c:forEach&#62;
  	
  	&#60;c:if test="${result.currentPage!=result.pageCount}"&#62;
  		&#60;span class="pc"&#62;
  			&#60;a href="&#60;c:url value='/PageServlet?page=${result.currentPage+1}'&#62;&#60;/c:url&#62;"&#62;下一页&#60;/a&#62;
  		&#60;/span&#62;
  	&#60;/c:if&#62;
  	&#60;br/&#62;&#60;br/&#62;
  	
  	&#60;!-- 复选框 --&#62;
  	&#60;select onchange="sub(this)"&#62;
  		&#60;c:forEach begin="1" end="${result.pageCount}" var="idx"&#62;
  			&#60;option &#60;c:if test="${idx==result.currentPage}"&#62;selected="selected"&#60;/c:if&#62; value="${idx}" &#62;
  				第${idx}页
  			&#60;/option&#62;
  		&#60;/c:forEach&#62;
  	&#60;/select&#62;
  	
  &#60;/body&#62;
&#60;/html&#62;

```

#演示结果：
![](http://img.blog.csdn.net/20160817153653097)


#整个项目源码链接：

https://github.com/chenhaoxiang/Java/tree/master/myPagesDividedWeb2
myPagesDividedWeb2.zip文件


转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215