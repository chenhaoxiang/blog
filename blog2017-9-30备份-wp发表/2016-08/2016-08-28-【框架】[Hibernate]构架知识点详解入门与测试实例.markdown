---
layout: post
title: "【框架】[Hibernate]构架知识点详解入门与测试实例"
date: 2016-08-28 02:52:04 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Hibernate
tags: [hibernate,框架,java,测试]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




Hibernate介绍:

Hibernate是一个开放源码的、非常优秀、成熟的O/R Mapping框架。它提供了强大、高性能的Java对象和关系数据的持久化和查询功能。

O/R Mapping 
对象关系映射（Object Relational Mapping，简称OR 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




Hibernate介绍:

Hibernate是一个开放源码的、非常优秀、成熟的O/R Mapping框架。它提供了强大、高性能的Java对象和关系数据的持久化和查询功能。

O/R Mapping 
对象关系映射（Object Relational Mapping，简称OR
&#60;!-- more --&#62;
----------

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;


#Hibernate介绍:
Hibernate是一个开放源码的、非常优秀、成熟的O/R Mapping框架。它提供了强大、高性能的Java对象和关系数据的持久化和查询功能。

O/R Mapping
对象关系映射（Object Relational Mapping，简称ORM）技术，是通过使用描述对象和数据库之间映射的元数据，将Java程序中的对象自动持久化到关系数据库中。
对象和关系数据是业务实体的两种表现形式，业务实体在内存中表现为对象，在数据库中表现为关系数据。内存中的对象之间存在关联和继承关系，而在数据库中，关系数据无法直接表达多对多关联和继承关系。因此，对象-关系映射(ORM)系统一般以中间件的形式存在，主要实现程序对象到关系数据库数据的映射。

Hibernate 只是一个将持久化类与数据库表相映射的工具，每个持久化类实例均对应于数据库表中的一条数据行。可以使用面向对象的方法操作此持久化类实例，完成对数据库表的插入、删除、修改等操作。

利用Hibernate操作数据库，我们通过应用程序经过Hibernate持久层来访问数据库，其实Hibernate完成了以前JDBC的功能，不过Hibernate使用面向对象的方法操作数据库。

##Hibernate体系结构图:

![](http://img.blog.csdn.net/20160827222841712)


#Hibernate构架入门步骤
第1步： 先建一个Java工程导入使用Hibernate最小必要包。
一般在解压后的lib目录下的
![](http://img.blog.csdn.net/20160827224843692)
required目录下。
可以到官方网站 http://hibernate.org/orm/downloads/ 下载Hibernate最新的zip压缩包。
如果访问数据库，则还需要导入数据库的驱动包。
mysql-connector-java-5.1.39 .zip下载地址:
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;&#60;a href='https://github.com/chenhaoxiang/Java/blob/master/Database-support-package/mysql-connector-java-5.1.39%20.zip'&#62;&#60;font color="red"&#62;--&gt;点击下载数据库5.1.39驱动包--&#60;/font&#62;&#60;/a&#62;&#60;br&#62;
&#60;/blockquote&#62;
第2步：在src创建配置文件hibernate.cfg.xml，放置在src目录下。

第3步：编写一个会话工厂类。通过会话工厂类产生一个会话Session对象。Session对象是Hibernate的核心。任何对数据库操作都在会话中进行的。

对于熟悉C3P0的朋友，可以按下面的理解:
(配置文件hibernate.cfg.xml可以类比c3p0.properties的配置文件，HibernateSessionFactory可以类比C3p0Pool，SessionFactory可以类比C3p0中的DataSource，Session可以类比Connection去理解)

第4步：编写POJO类以及映射文件。
POJO(POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans)

第5步：编写测试文件


##hibernate.cfg.xml配置文件详解

hibernate.cfg.xml其实这个名字自己可以随便取的，但是大家都这么取名，于是形成了一个习惯了！！！
```
&#60;?xml version='1.0' encoding='UTF-8'?&#62;
&#60;!--标准的XML文件的起始行，version='1.0'表明XML的版本，encoding='UTF-8'表明XML文件的编码方式 --&#62;

&#60;!--表明解析本XML文件的DTD文档位置，DTD是Document Type Definition 的缩写,即文档类型的定义,
XML解析器使用DTD文档来检查XML文件的合法性。
hibernate.sourceforge.net/hibernate-configuration-3.0dtd可以在Hibernate3.1.3软件包中的
src\org\hibernate目录中找到此文件--&#62;   
&#60;!DOCTYPE hibernate-configuration PUBLIC
          "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
          "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd"&#62;

&#60;!--声明Hibernate配置文件的开始 --&#62;
&#60;hibernate-configuration&#62;
	
	&#60;!--表明以下的配置是针对session-factory配置的，SessionFactory是Hibernate中的一个类，
	这个类主要负责保存HIbernate的配置信息，以及对Session的操作--&#62;   
	&#60;session-factory&#62;
		&#60;!--配置数据库的驱动程序，Hibernate在连接数据库时，需要用到数据库的驱动程序-必须 --&#62;
		&#60;property name="connection.driver_class"&#62;
			com.mysql.jdbc.Driver
		&#60;/property&#62;
		&#60;!--设置数据库的连接url:jdbc:mysql://127.0.0.1:3306/hib,其中127.0.0.1表示mysql服务器名称,
		3306是连接端口，此处为本机,hib是数据库名-必须 --&#62;
		&#60;property name="connection.url"&#62;
			jdbc:mysql://127.0.0.1:3306/hib
		&#60;/property&#62;
		&#60;!-- 设置数据库的用户名 -必须 --&#62;
		&#60;property name="connection.username"&#62;root&#60;/property&#62;
		&#60;!-- 设置数据库的密码 -必须 --&#62;
		&#60;property name="connection.password"&#62;1234&#60;/property&#62;
		&#60;!--数据库连接池的大小 --&#62;
		&#60;!-- &#60;property name="connection.pool.size"&#62;20 &#60;/property&#62; 与下句是一样的 --&#62;
		&#60;property name="hibernate.connection.pool.size"&#62;20 &#60;/property&#62;
		
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
          
        &#60;!--connection.useUnicode连接数据库时是否使用Unicode编码--&#62;   
        &#60;property name="connection.useUnicode"&#62;true&#60;/property&#62;   
        &#60;!--connection.characterEncoding连接数据库时数据的传输字符集编码方式--&#62;   
    	&#60;property name="connection.characterEncoding"&#62;utf-8&#60;/property&#62; 
		

&#60;!--hibernate.dialect 只是Hibernate使用的数据库方言,就是要用Hibernate连接那种类型的数据库服务器。--&#62;   
		&#60;!--这句不用管，照写就是 -必须 --&#62;
		&#60;property name="dialect"&#62;
			org.hibernate.dialect.MySQLDialect
		&#60;/property&#62;
	
		&#60;!-- 指定映射文件为“cn/hncu/domain/Student.hbm.xml”，可以有多个 -用到了就必须 --&#62;
		&#60;mapping resource="cn/hncu/domain/Student.hbm.xml" /&#62;
	&#60;/session-factory&#62;

&#60;/hibernate-configuration&#62;
```
简单配置版:

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

	&#60;mapping resource="cn/hncu/domain/Student.hbm.xml"/&#62;
&#60;/session-factory&#62;

&#60;/hibernate-configuration&#62;
```



##Hibernate核心接口

###(1)  Configuration接口
Configuration 接口负责管理Hibernate 的配置信息。为了能够连上数据库必须配置一些属性，这些属性包括： 
数据库URL                                  
数据库用户                                      
数据库用户密码                                                
数据库JDBC驱动类
数据库dialect，用于对特定数据库提供支持，其中包含了针对特定数据库特性的实现。 

```
 /*创建一个配置对象，读取配置文件*/
 Configuration config = new Configuration();
 config.configure("/hibernate.cfg.xml");

```

###(2)  SessionFactory接口

应用程序从SessionFactory（会话工厂）里获得Session(会话)实例。
这里用到了一个设计模式即工厂模式，用户程序从工厂类SessionFactory中取得Session的实例。
SessionFactory不是轻量级的。它占的资源比较多，所以它应该能在整个应用中共享。
一个项目通常只需要一个SessionFactory就够了，但是当项目要操作多个数据库时，必须为每个数据库指定一个SessionFactory。
会话工厂缓存了生成的SQL语句和Hibernate在运行时使用的映射元数据。它也保存了在一个工作单元中读入的数据并且可能在以后的工作单元中被重用（只有类和集合映射指定了使用这种二级缓存时才会如此）Session类。
```
/*通过配置对象产生一个会话工厂*/
	SessionFactory factory=config.buildSessionFactory();

```
###(3)  Session接口

该接口是Hibernate使用最多的接口。Session不是线程安全的，它代表与数据库之间的一次操作。
Session是持久层操作的基础，相当于JDBC中的Connection。然而在Hibernate中，实例化的Session是一个轻量级的类，创建和销毁它都不会占用很多资源。
Session通过SessionFactory打开，在所有的工作完成后，需要关闭。但如果在程序中，不断地创建以及销毁Session对象，则会给系统带来不良影响。所以有时需要考虑session的管理合理的创建合理的销毁。

```
/*通过工厂产生一个会话*/
	 Session session=factory.openSession();

```

###(4)  Query类

Query类可以很方便地对数据库及持久对象进行查询，它可以有两种表达方式：查询语句使用HQL(面向"值对象"，HQL语言) （HQL是Hibernate Query Lanaguage简称是Hibernate配备了一种非常强大的查询语言，类似于SQL）或者本地数据库的SQL语句(面向"数据表"，SQL语言)编写。

```
/*通过会话产生一个查询对象*/
		Query query = session.createQuery("from Student");//Student是POJO类，需要在配置文件中设置好映射
		/*通过查询对象查询数据库，返回集合*/
		List list = query.list();
		for (int i = 0; i &#60; list.size(); i++) {
			Student student= (Student) list.get(i);
			System.out.println(Student.getDname());
		}
```

###(5)  Transaction接口
 如果你向数据库中增加数据或修改数据时，需要使用事务处理，这时你需要Transaction接口。
 Transaction接口是对实际事务实现的一个抽象，该接口可以实现JDBC的事务、JTA中的UserTransaction、甚至可以是CORBA事务等跨容器的事务。
 之所以这样设计是能让开发者能够使用一个统一事务的操作界面，使得自己的项目可以在不同的环境和容器之间方便地移值。

##一个完整示例,显示了Hibernate编程基本思路

###首先，准备好实例数据库：
```
create database hib charset=utf8;
use hib;
create table students(
	sId varchar(8) primary key,
	sName varchar(40),
	sAge int
);
insert into students(sId,sName,sAge) values('S001','Jack',23);
insert into students(sId,sName,sAge) values('S002','Tom',25);
insert into students(sId,sName,sAge) values('S003','张三',43);
insert into students(sId,sName,sAge) values('S004','李四',55);
```

准备好必要的jar包。

###接下来配置好hibernate.cfg.xml文件:

前面有的，就不重复了，配个图好了。
![](http://img.blog.csdn.net/20160828021537041)

###POJO类:

```
package cn.hncu.domain;

public class Student {
	private String sId;
	private String sName;
	private Integer sAge;
	
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
				+ "]";
	}
}

```

###cn/hncu/domain/Student.hbm.xml映射文件

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
		&#60;/id&#62;
		&#60;property name="sName" type="java.lang.String"&#62;
			&#60;column name="sName" length="40" /&#62;
		&#60;/property&#62;
		&#60;property name="sAge" type="java.lang.Integer"&#62;
			&#60;column name="sAge" /&#62;
		&#60;/property&#62;
	&#60;/class&#62;

&#60;/hibernate-mapping&#62;
```
###HibernateSessionFactory

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
		   /*创建一个配置对象，读取配置文件*/
		   config.configure(configFile);
		   /*通过配置对象产生一个会话工厂类*/
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
		   /*通过会话工厂类产生一个会话实例*/
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

###TestHib

```
package cn.hncu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.hncu.domain.Student;
import cn.hncu.hib.HibernateSessionFactory;

public class TestHib {

	public static void main(String[] args) {
		/*创建一个配置对象，读取配置文件*/
		String configfile="/hibernate.cfg.xml";
		Configuration config=new Configuration();
		config.configure(configfile);
		/*通过配置对象产生一个会话工厂类*/
	    SessionFactory sessionfactory=config.buildSessionFactory();
		/*通过会话工厂类产生一个会话实例*/
		Session session=sessionfactory.openSession();
		/*通过会话产生一个查询对象Query*/
		Query query=session.createQuery("from Student");
		/*进行查询返回一个集合List*/
		List&#60;Student&#62; studs=query.list();
		for(Student s:studs){
		   System.out.println(s);
		}
		
		session = HibernateSessionFactory.getSession();
		query = session.createQuery("from Student");
		List&#60;Student&#62; students = query.list();
		for(Student s: students){
			System.out.println(s);
		}
	}
}

```

###测试结果:

![](http://img.blog.csdn.net/20160828022344667)

##完整实例代码:
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;&#60;a href='https://github.com/chenhaoxiang/Java/blob/master/Hibernate/myHibWebDemo/myHibWebDemo.zip'&#62;&#60;font color="red"&#62;--&gt;点击访问本实例源码--&#60;/font&#62;&#60;/a&#62;&#60;br&#62;
&#60;/blockquote&#62;

&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://blog.csdn.net/qq_26525215'&#62;&#60;font color="green"&#62;http://blog.csdn.net/qq_26525215&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://blog.csdn.net/qq_26525215' target='_blank'&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;