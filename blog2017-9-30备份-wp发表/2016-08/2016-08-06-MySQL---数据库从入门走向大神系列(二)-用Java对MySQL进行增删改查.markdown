---
layout: post
title: "MySQL---数据库从入门走向大神系列(二)-用Java对MySQL进行增删改查"
date: 2016-08-06 03:03:34 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,mysql,SQL,java]
keyword: 陈浩翔, 谙忆
description: 上节已经学会对MySQL进行简单的增删改查了，那么，我们如何实现用Java来对数据库操作增删改呢。
本节将用Java演示对MySQL进行增删改查。
简单的来说，分为4个步骤：
1、加载连接器(驱动)   通过Driver类 (最好用类反射来加载，更加灵活)
2、建立与数据库的连接
3、获取语句对象
4、对数据库进行操作(增删改查)


其实第一步现在可以不用写了，高版本的MySQ 
---


上节已经学会对MySQL进行简单的增删改查了，那么，我们如何实现用Java来对数据库操作增删改呢。
本节将用Java演示对MySQL进行增删改查。
简单的来说，分为4个步骤：
1、加载连接器(驱动)   通过Driver类 (最好用类反射来加载，更加灵活)
2、建立与数据库的连接
3、获取语句对象
4、对数据库进行操作(增删改查)


其实第一步现在可以不用写了，高版本的MySQ
&#60;!-- more --&#62;
----------


&#60;p&#62;&#60;span style="font-size:14px"&#62;上节已经学会对MySQL进行简单的增删改查了，那么，我们如何实现用Java来对数据库操作增删改呢。&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;本节将用Java演示对MySQL进行增删改查。&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;简单的来说，分为4个步骤：&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;1、加载连接器(驱动) &nbsp; 通过Driver类 (最好用类反射来加载，更加灵活)&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;2、建立与数据库的连接&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;3、获取语句对象&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;4、对数据库进行操作(增删改查)&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;其实第一步现在可以不用写了，高版本的MySQL已经在内部帮我们写好了第一步，但是，为了兼容性更好(兼容低版本的MySQL)我们最好还是写上第一步。&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#33cc00"&#62;我们先看一下原数据库表：&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;img src="http://img.blog.csdn.net/20160806111408052" alt=""&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;用Java对数据库进行增删改：&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;br&#62;
&#60;/p&#62;
&#60;pre code_snippet_id="1812867" snippet_file_name="blog_20160806_1_634143"  code_snippet_id="1812867" snippet_file_name="blog_20160806_1_634143" name="code" class="java"&#62;package cn.hncu.sqlHello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//import com.mysql.jdbc.Driver;

public class dbAccess {
	
	@Test
	public void hello() throws ClassNotFoundException, SQLException {
		//1、加载连接器(驱动)  Driver 
		Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
		//用类反射加载，更灵活
		
		//2、建立连接
		//String url = &quot;jdbc:mysql://127.0.0.1:3306/hncu&quot;;//这一句是采用默认编码
		String url = &quot;jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&amp;characterEncoding=utf-8&quot;;//采用指定编码连接
		
		Connection con  = DriverManager.getConnection(url, &quot;root&quot;, &quot;1234&quot;);
		//这3个参数是:连接串、用户名、密码
		
		//3、获取语句对象
		Statement st = con.createStatement();
		//对表格hncu增加一行数据
		
		////4 对数据库进行操作(增删改）
		String sql = &quot;insert into stud values(&#39;1010&#39;,&#39;杨过&#39;,26,&#39;武侠&#39;)&quot;;
		//String sql = &quot;insert into stud values(&#39;1010&#39;,&#39;杨过&#39;,26,&#39;武侠&#39;);&quot;;//sql语句加上分号也是一样的。
		//但是注意！！！不能一次添加多条语句运行！(中间用分号隔也不行)
		st.execute(sql);//增删改用:st.excute()方法
	}
}

&#60;/pre&#62;&#60;br&#62;
&#60;p&#62;&#60;/p&#62;
&#60;span style="font-size:14px"&#62;&#60;br&#62;
如果要运行多条语句怎么办，那就像这样的，运行多次第4步，可以达到相同的效果：&#60;br&#62;
例：&#60;/span&#62;&#60;br&#62;
&#60;pre code_snippet_id="1812867" snippet_file_name="blog_20160806_2_1713938"  code_snippet_id="1812867" snippet_file_name="blog_20160806_2_1713938" name="code" class="java"&#62;sql = &quot;insert into stud values(&#39;1011&#39;,&#39;杨过1&#39;,26,&#39;武侠&#39;);&quot;;
st.execute(sql);
sql = &quot;insert into stud values(&#39;1011&#39;,&#39;杨过1&#39;,26,&#39;武侠&#39;);&quot;;
st.execute(sql);&#60;/pre&#62;&#60;br&#62;
&#60;br&#62;
&#60;p&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;运行之后的stud表：&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;img src="http://img.blog.csdn.net/20160806143807320" alt=""&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;&#60;strong&#62;删除和修改也是和增加一样的，只要把sql那个字符串换一下就可以了(sql那个字符串为SQL操作语句)。&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;&#60;strong&#62;查询有所不同！&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;Java查询SQL数据库语句代码如下：&#60;/span&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;/span&#62;&#60;/p&#62;
&#60;pre code_snippet_id="1812867" snippet_file_name="blog_20160806_9_126363"  code_snippet_id="1812867" snippet_file_name="blog_20160806_9_126363" name="code" class="java"&#62;package cn.hncu.sqlHello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//import com.mysql.jdbc.Driver;

public class dbAccess {
	
	@Test
	public void hello() throws ClassNotFoundException, SQLException {
		//1、加载连接器(驱动)  Driver 
		Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
		//用类反射加载，更灵活
		
		//2、建立连接
		//String url = &quot;jdbc:mysql://127.0.0.1:3306/hncu&quot;;//这一句是采用默认编码
		String url = &quot;jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&amp;characterEncoding=utf-8&quot;;//采用指定编码连接
		
		Connection con  = DriverManager.getConnection(url, &quot;root&quot;, &quot;1234&quot;);
		//这3个参数是:连接串、用户名、密码
		
		//3、获取语句对象
		Statement st = con.createStatement();
		//对表格hncu增加一行数据
		
		//4 对数据库进行操作(查询）
		String sql = &quot;select * from stud where sname like &#39;%三%&#39; or sname like &#39;%四%&#39;;&quot;;
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()){
			//为什么不用hasNext呢，因为rs就像一个指针，rs最开始的位置并不是指向第一个数据，
			//而是指向开头地址,所以不能用hasNext来判断，而必须跳过第一个不读.
			String sno = rs.getString(1);//指定列号的方式读取。第一列的序号为1。
			
			String sname = rs.getString(&quot;sname&quot;);//指定列名的方式来读取
			int age = rs.getInt(&quot;age&quot;);
			String saddress = rs.getString(4);
			System.out.println(sno+&quot;,&quot;+sname+&quot;,&quot;+age+&quot;,&quot;+saddress);
		}
	}
}
&#60;/pre&#62;
&#60;p&#62;&#60;/p&#62;
&#60;p&#62;&#60;span style="font-size:14px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
此处是查询sname带有三，或者带有四的数据。
&#60;p&#62;&#60;img src="http://img.blog.csdn.net/20160806150145210" alt=""&#62;&#60;br&#62;
&#60;/p&#62;
&#60;p&#62;&#60;strong&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/strong&#62;&#60;/p&#62;
&#60;p&#62;&#60;strong&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;其他的都是这样，改掉sql语句就可以进行对应的增删改查了！&#60;/span&#62;&#60;/strong&#62;&#60;/p&#62;
&#60;p&#62;&#60;strong&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/strong&#62;&#60;/p&#62;
&#60;p&#62;&#60;strong&#62;&#60;span style="font-size:14px; color:#ff0000"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/strong&#62;&#60;/p&#62;
