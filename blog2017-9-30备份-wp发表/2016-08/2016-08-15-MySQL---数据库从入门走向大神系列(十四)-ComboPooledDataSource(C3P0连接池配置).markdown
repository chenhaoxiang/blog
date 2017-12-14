---
layout: post
title: "MySQL---数据库从入门走向大神系列(十四)-ComboPooledDataSource(C3P0连接池配置)"
date: 2016-08-15 04:33:08 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [数据库,mysql,c3p0]
keyword: 陈浩翔, 谙忆
description: 需要准备的jar包：MySQL的jar包mysql-connector-java-5.1.39-bin目前是5.1.39版本：  
http://dev.mysql.com/downloads/connector/j/C3p0的2个包： 
https://sourceforge.net/projects/c3p0/ 
c3p0-0.9.1.2.jar和c3p0-sources-0.9.1.2.jar 
---


需要准备的jar包：MySQL的jar包mysql-connector-java-5.1.39-bin目前是5.1.39版本：  
http://dev.mysql.com/downloads/connector/j/C3p0的2个包： 
https://sourceforge.net/projects/c3p0/ 
c3p0-0.9.1.2.jar和c3p0-sources-0.9.1.2.jar
&#60;!-- more --&#62;
----------

需要准备的jar包：

MySQL的jar包mysql-connector-java-5.1.39-bin目前是5.1.39版本： 
http://dev.mysql.com/downloads/connector/j/

C3p0的2个包：
https://sourceforge.net/projects/c3p0/
c3p0-0.9.1.2.jar和c3p0-sources-0.9.1.2.jar

配置文件：c3p0-config.xml
名字必须为这个！

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


#演示代码：

```
package cn.hncu.C3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Demo {

	@Test
	// 纯Java方法使用c3p0
	public void C3p0Demo() throws PropertyVetoException, SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setUser("root");// 用户姓名
		pool.setPassword("1234");// 用户密码
		pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=utf-8");// MySQL数据库连接url
		pool.setDriverClass("com.mysql.jdbc.Driver");

		// pool可以调用set方法进行Connection池的配置

		// 连接关闭之后，内存会被释放，下次取时会重新开(内存地址不共用)
		for (int i = 0; i &#60; 20; i++) {
			Connection con = pool.getConnection();
			System.out.println(i + ":" + con);
			if (i % 2 == 0) {
				con.close();
			}
		}
	}

	@Test
	// 演示采用配置文件的方式使用c3p0
	public void C3p0PropertyDemo() throws SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();//空参，自动到classpath目录下面加载“c3p0-config.xml”配置文件---配置文件的存储位置和名称必须是这样，且使用“默认配置”
		//ComboPooledDataSource pool = new ComboPooledDataSource("demo");//加载“c3p0-config.xml”文件中定义的“demo”这个配置元素
		 for(int i=0;i&#60;25;i++){
			   Connection con = pool.getConnection();
			   System.out.println(i+":"+ con.hashCode());
		   }
	}

}

```


#包装一下C3P0的Connection池

```
package cn.hncu.C3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Pool {
	//我们的这个包装，只是为了把c3p0池做成让每个线程(客户端)获得的是同一个连接，方便做b/s框架下的事务
	private static DataSource pool;
	private static ThreadLocal&#60;Connection&#62; t = new ThreadLocal&#60;Connection&#62;();
	static{
		pool = new ComboPooledDataSource("demo");
		//这里的参数视你的配置文件而定，也可以不写，用默认的配置
	}
	
	public static DataSource getDataSource(){
		return pool;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = t.get();
		if(con==null){
			con=pool.getConnection();
			t.set(con);
		}
		return con;
	}
}

```

转载请附上原文博客链接： 
http://blog.csdn.net/qq_26525215