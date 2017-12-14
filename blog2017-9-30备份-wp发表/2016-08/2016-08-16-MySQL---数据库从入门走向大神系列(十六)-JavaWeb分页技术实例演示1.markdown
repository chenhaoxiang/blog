---
layout: post
title: "MySQL---数据库从入门走向大神系列(十六)-JavaWeb分页技术实例演示1"
date: 2016-08-16 05:22:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库,----- ①、Java/Web小项目
tags: [数据库,分页,技术,实例]
keyword: 陈浩翔, 谙忆
description: 分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。 
相关算法(技术):
总行数(num): select count(1) from stud;每页显示的行数(n): 
---


分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。 
相关算法(技术):
总行数(num): select count(1) from stud;每页显示的行数(n):
&#60;!-- more --&#62;
----------

分页,是一种将所有数据分段展示给用户的技术.用户每次看到的不 是全部数据,而是其中的一部分,如果在其中没有找到自己想要的内容,用户可以通过指定页码或是点上/下一页的方式进行翻页。

本例演示静态分页，也就是先设置好每页显示10行，再根据总行数，来算出总页数，将所有页数的页号都显示出来。
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
```


像这样：
![](http://img.blog.csdn.net/20160816164228895)

点击哪一页就显示哪一页的内容。

#数据库数据：
数据库的表和数据在这一篇博客中已经准备好了：
http://blog.csdn.net/qq_26525215/article/details/52212571
```
create table person(
    id varchar(30) primary key,
    name varchar(30),
    address varchar(30),
    age int
);
```
![](http://img.blog.csdn.net/20160816170504138)



#DAO层：

##接口：
```
package cn.hncu.dao;

import java.sql.SQLException;
import java.util.Map;

public interface IPageDAO {
	public Map&#60;String, Object&#62; query(Integer pageNo) throws NumberFormatException, SQLException;
}

```

##实现类：

```
package cn.hncu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.hncu.pubs.C3p0Pool;

public class PageJdbc implements IPageDAO {
	
	//每页显示的行数
	private final int pageSize = 10;
	
	@Override
	public Map&#60;String, Object&#62; query(Integer pageNo) throws NumberFormatException, SQLException {
		Map&#60;String, Object&#62; result = new HashMap&#60;String, Object&#62;();
		
		//获取总页数 pageCount = rows/pageSize + ((rows%pageSize==0)?0:1)
		//总行数 rows
		String sql = "select count(1) from person";
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		
		int rows =Integer.parseInt(""+run.query(sql, new ScalarHandler())); 
		
		//总页数
		int pageCount = rows/pageSize +  ((rows%pageSize==0)?0:1);
		result.put("pageCount", pageCount);
		
		//分页后的当前页面内容datas
		//起始行号
		int startN = (pageNo-1)*pageSize;
		sql = "select * from person limit "+startN+" , "+pageSize;
		List&#60;Map&#60;String, Object&#62;&#62; datas = run.query(sql, new MapListHandler());
		result.put("datas", datas);//封装到result
		
		return result;
	}
	
	@Test
	public void test() {
		try {
			Map&#60;String, Object&#62; map = query(5);
			System.out.println(map);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

```

#C3p0配置文件c3p0-config.xml:

```
&#60;c3p0-config&#62;
	&#60;!-- 默认配置，如果没有指定则使用这个配置 --&#62;
	&#60;default-config&#62;
		&#60;property name="driverClass"&#62;com.mysql.jdbc.Driver&#60;/property&#62;
		&#60;property name="jdbcUrl"&#62;
			&#60;![CDATA[jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=UTF-8]]&#62;
		&#60;/property&#62;
		&#60;property name="user"&#62;root&#60;/property&#62;
		&#60;property name="password"&#62;1234&#60;/property&#62;
		&#60;!-- 初始化池大小 --&#62;
		&#60;property name="initialPoolSize"&#62;2&#60;/property&#62;
		&#60;!-- 最大空闲时间 --&#62;
		&#60;property name="maxIdleTime"&#62;30&#60;/property&#62;
		&#60;!-- 最多有多少个连接 --&#62;
		&#60;property name="maxPoolSize"&#62;10&#60;/property&#62;
		&#60;!-- 最少几个连接 --&#62;
		&#60;property name="minPoolSize"&#62;2&#60;/property&#62;
		&#60;!-- 每次最多可以执行多少个批处理语句 --&#62;
		&#60;property name="maxStatements"&#62;50&#60;/property&#62;
	&#60;/default-config&#62; 
	&#60;!-- 命名的配置 --&#62;
	&#60;named-config name="demo"&#62;
		&#60;property name="driverClass"&#62;com.mysql.jdbc.Driver&#60;/property&#62;
		&#60;property name="jdbcUrl"&#62;&#60;![CDATA[jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=UTF-8]]&#62;&#60;/property&#62;
		&#60;property name="user"&#62;root&#60;/property&#62;
		&#60;property name="password"&#62;1234&#60;/property&#62;
		&#60;property name="acquireIncrement"&#62;5&#60;/property&#62;&#60;!-- 如果池中数据连接不够时一次增长多少个 --&#62;
		&#60;property name="initialPoolSize"&#62;100&#60;/property&#62;
		&#60;property name="minPoolSize"&#62;50&#60;/property&#62;
		&#60;property name="maxPoolSize"&#62;1000&#60;/property&#62;
		&#60;property name="maxStatements"&#62;0&#60;/property&#62;
		&#60;property name="maxStatementsPerConnection"&#62;5&#60;/property&#62; &#60;!-- he's important, but there's only one of him --&#62;
	&#60;/named-config&#62;
&#60;/c3p0-config&#62; 

```

#C3p0数据库连接池：

```
package cn.hncu.pubs;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Pool {
	private static DataSource pool;
	private static ThreadLocal&#60;Connection&#62; t = new ThreadLocal&#60;Connection&#62;();
	static{
		pool = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return pool;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con=t.get();
		if(con==null){
			con = pool.getConnection();
			t.set(con);
		}
		return con;
	}
	
}

```

#service层：

##接口：
```
package cn.hncu.service;

import java.sql.SQLException;
import java.util.Map;

public interface IPageService {
	public Map&#60;String, Object&#62; query(Integer pageNo) throws NumberFormatException, SQLException;
}


```

##实现类

```
package cn.hncu.service;

import java.sql.SQLException;
import java.util.Map;

import cn.hncu.dao.IPageDAO;
import cn.hncu.dao.PageJdbc;

public class PageServiceImpl implements IPageService{
	//注入dao
	IPageDAO dao = new PageJdbc();
	
	@Override
	public Map&#60;String, Object&#62; query(Integer pageNo) throws NumberFormatException, SQLException {
		return dao.query(pageNo);
	}
}

```

#index.jsp:

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;

&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;c:redirect url="/PageServlet"&#62;&#60;/c:redirect&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

#show.jsp:

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;

&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;演示数据分页显示&#60;/title&#62;
  	&#60;link rel="stylesheet" href="&#60;c:url value='/css/table.css' /&#62;" /&#62;
  	
  	&#60;script type="text/javascript"&#62;
  		function sub(obj){
  			window.location.href="&#60;c:url value='/PageServlet?page=' /&#62;"+obj.value;
  		}
  	&#60;/script&#62;
  	
  &#60;/head&#62;
  	
  &#60;body&#62;
  	&#60;h3&#62;当前页的内容:&#60;/h3&#62;
  	&#60;table&#62;
  		&#60;tr&#62;&#60;th&#62;学号&#60;/th&#62;&#60;th&#62;姓名&#60;/th&#62;&#60;/tr&#62;
  		&#60;c:forEach items="${result.datas}" var="map"&#62;
  			&#60;tr&#62;
  				&#60;td&#62;${map.id}&#60;/td&#62;
  				&#60;td&#62;${map.name}&#60;/td&#62;
  			&#60;/tr&#62;
  		&#60;/c:forEach&#62;
  	&#60;/table&#62;
  	
  	
  	&#60;c:if test="${result.currentPage!=1}"&#62;
  		&#60;span class="pc"&#62;
  			&#60;a href='&#60;c:url value="/PageServlet?page=${result.currentPage-1}"&#62;&#60;/c:url&#62;'&#62;上一页&#60;/a&#62;
  		&#60;/span&#62;
  	&#60;/c:if&#62;
  	
  	&nbsp;&nbsp;
  	&#60;c:forEach begin="1" end="${result.pageCount}" var="idx"&#62;
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

#table.css:

```
body{
	text-align: center;
}
table{
	border: 1px solid blue;
	width: 500px;
	border-collapse: collapse;/*为表格设置合并边框模型：*/
	margin: auto;
}
td,th,tr{
	border:  1px solid blue;
}
.pc{
    width: 30px;
    height: 30px;
    border: 1px solid #e1e2e3;
    border-top-color: rgb(225, 226, 227);
    border-top-style: solid;
    border-top-width: 1px;
    border-right-color: rgb(225, 226, 227);
    border-right-style: solid;
    border-right-width: 1px;
    border-bottom-color: rgb(225, 226, 227);
    border-bottom-style: solid;
    border-bottom-width: 1px;
    border-left-color: rgb(225, 226, 227);
    border-left-style: solid;
    border-left-width: 1px;
}
.now {
    display: block;
}
```

#web.xml:

```
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;web-app version="3.0" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"&#62;
  &#60;display-name&#62;&#60;/display-name&#62;
  &#60;servlet&#62;
    &#60;servlet-name&#62;PageServlet&#60;/servlet-name&#62;
    &#60;servlet-class&#62;cn.hncu.servlet.PageServlet&#60;/servlet-class&#62;
  &#60;/servlet&#62;

  &#60;servlet-mapping&#62;
    &#60;servlet-name&#62;PageServlet&#60;/servlet-name&#62;
    &#60;url-pattern&#62;/PageServlet&#60;/url-pattern&#62;
    &#60;!-- 这里的/代表项目根目录下 --&#62;
  &#60;/servlet-mapping&#62;	
  &#60;welcome-file-list&#62;
    &#60;welcome-file&#62;index.jsp&#60;/welcome-file&#62;
  &#60;/welcome-file-list&#62;
&#60;/web-app&#62;

```

#PageServlet.java:

```
package cn.hncu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.service.IPageService;
import cn.hncu.service.PageServiceImpl;

public class PageServlet extends HttpServlet {
	//注入service
		IPageService service = new PageServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	String pageNo = request.getParameter("page");
			
			if(pageNo==null || pageNo.trim().length()>=0){
				pageNo="1";
			}
			
			Integer iPageNo=1;
			try {
				iPageNo = Integer.parseInt(pageNo);
			} catch (NumberFormatException e) {
				iPageNo=1;
			}
			
			try {
				Map&#60;String, Object&#62; result = service.query(iPageNo);
				
				//给结果集补一个数据:currentPage
				result.put("currentPage", iPageNo);
				
				//###注意，一定要把结果集放入容器中
				request.setAttribute("result", result);
				
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

#演示结果：

![](http://img.blog.csdn.net/20160816172339834)


#需要的第三方扩展包：

![](http://img.blog.csdn.net/20160816171705988)

链接：
https://github.com/chenhaoxiang/Java/tree/master/Database-support-package



#完整项目代码链接：

https://github.com/chenhaoxiang/Java/tree/master/myPagesDividedWeb


转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215