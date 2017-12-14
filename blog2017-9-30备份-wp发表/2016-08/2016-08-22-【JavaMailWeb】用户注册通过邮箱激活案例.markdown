---
layout: post
title: "【JavaMailWeb】用户注册通过邮箱激活案例"
date: 2016-08-22 05:49:16 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用,----- ----- JavaMail,----- ①、Java/Web小项目
tags: [博客,javamail,邮箱,注册]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前面刚刚学习了JavaMail技术,现在来应用到项目中试试~网站用户注册：主要实现如下两个功能: 
1、用户在网站上注册完成后给用户发一封邮件。 
2、用户通过邮件激活后才可以登录。思路：首先需要一个思路:用户在前台点击注册，向servlet提交请求，把用户提交过来的信息封装成一个J 
---


转载请注明出处： http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
前面刚刚学习了JavaMail技术,现在来应用到项目中试试~网站用户注册：主要实现如下两个功能: 
1、用户在网站上注册完成后给用户发一封邮件。 
2、用户通过邮件激活后才可以登录。思路：首先需要一个思路:用户在前台点击注册，向servlet提交请求，把用户提交过来的信息封装成一个J
&#60;!-- more --&#62;
----------

&#60;blockquote&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处： &#60;a href='http://blog.csdn.net/qq_26525215'&#62;http://blog.csdn.net/qq_26525215&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href="http://blog.csdn.net/qq_26525215" target="_blank"&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;

前面刚刚学习了JavaMail技术,现在来应用到项目中试试~

#网站用户注册：
主要实现如下两个功能:
1、用户在网站上注册完成后给用户发一封邮件。
2、用户通过邮件激活后才可以登录。

##思路：
首先需要一个思路:

用户在前台点击注册，向servlet提交请求，把用户提交过来的信息封装成一个JavaBean(需要的信息有name,pwd,email这3个是用户填写的,我们帮用户生成的是id和一个邮箱激活链接地址的唯一标识码acode，还要一个用来识别用户是否已经点击链接的变量active)。
servlet调用service层，service层再去调用dao层，dao再去访问数据库，
生成2个uuid分别赋值给id和acode。通过用户是否点击激活链接(url?acode=`******`)新写一个servlet来判断用户是否点击链接激活。

用户点了激活链接后，再自动跳转到登录页面！

【数据库的字段名和JavaBean的成员变量名最好统一，方便自己写代码与查错】

通过下面的图片可以更好的帮你理解：

![](http://img.blog.csdn.net/20160822141624297)


#实例：

##源代码

###创建users表：
先准备好数据库hncu:
创建一个表：

```
create table users(
	id varchar(32) primary key,
	name varchar(30),
	pwd varchar(32),
	email varchar(80),
	active char(1),
	acode varchar(32)
);
```

###需要准备的JAR包
链接:-如果链接失效-可以私信我
https://github.com/chenhaoxiang/Java/tree/master/myMailWeb/WebRoot/WEB-INF/lib

###发送邮件的线程：MySendMailThread

必须用线程来做，否则网站的效率会很差。

可以想象，如果不用线程，直接servlet 中在用户请求注册后给他发邮件，然后再跳转页面，这明显很慢吧，我们需要去请求邮箱的服务器，然后邮箱的服务器需要向令一个邮箱请求，然后最后才能返回到我们这里，才能页面返回内容，这样，用户岂不是要等很久。我们如果用多线程，只要把那个线程new出来就可以了，要怎么去发邮件是那个线程的事，与我这个主线程没关系，我负责直接通知用户邮件发送成功就可以了，这样速度显然快多了。

```
package cn.hncu.reg.sendMail;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import cn.hncu.domain.User;

public class MySendMailThread extends Thread {

	private User user = null;

	public MySendMailThread(User user) {
		this.user = user;
	}

	@Override
	public void run() {

		// 跟smtp服务器建立一个连接
		Properties p = new Properties();
		// 设置邮件服务器主机名
		p.setProperty("mail.host", "smtp.qq.com");// 指定邮件服务器，默认端口 25
		// 发送服务器需要身份验证
		p.setProperty("mail.smtp.auth", "true");// 要采用指定用户名密码的方式去认证
		// 发送邮件协议名称
		p.setProperty("mail.transport.protocol", "smtp");

		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.socketFactory", sf);

		// 开启debug调试，以便在控制台查看
		// session.setDebug(true);也可以这样设置
		// p.setProperty("mail.debug", "true");

		// 创建session
		Session session = Session.getDefaultInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名可以用QQ账号也可以用邮箱的别名
				PasswordAuthentication pa = new PasswordAuthentication(
						"chenhaoxiang0117", "jnj***********ab");
				// 后面的字符是授权码，用qq密码不行！！
				return pa;
			}
		});

		session.setDebug(true);// 设置打开调试状态

		try {
			// 声明一个Message对象(代表一封邮件),从session中创建
			MimeMessage msg = new MimeMessage(session);
			// 邮件信息封装
			// 1发件人
			msg.setFrom(new InternetAddress("61******29@qq.com"));
			// 2收件人
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			// 3邮件内容:主题、内容
			msg.setSubject(user.getName() + ",欢迎注册***账号,请点击链接激活账号");

			// StringBuilder是线程不安全的,但是速度快，这里因为只会有这个线程来访问，所以可以用这个
			StringBuilder sbd = new StringBuilder();
			sbd.append(user.getName() + "&#60;br/&#62;欢迎！请确认此邮件地址以激活您的账号。&#60;br/&#62;");
			sbd.append("&#60;font color='red'&#62;&#60;a href='http://192.168.1.102:8080/myMailWeb/ActiveServlet?acode="
					+ user.getAcode() + "' target='_blank'");
			sbd.append("&#62;立即激活&#60;/a&#62;&#60;/font&#62;&#60;br/&#62;");
			sbd.append("或者点击下面链接:&#60;br/&#62;");
			sbd.append("http://192.168.1.102:8080/myMailWeb/ActiveServlet?acode="
					+ user.getAcode() + "&#60;br/&#62;");
			sbd.append("这是一封自动发送的邮件；如果您并未要求但收到这封信件，您不需要进行任何操作。");

			msg.setContent(sbd.toString(), "text/html;charset=utf-8");// 发html格式的文本

			// 发送动作
			Transport.send(msg);
			
			System.out.println("给" + user.getEmail() + "发送邮件成功。");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

```

###index.jsp:

主页，表单提交通过按钮点击事件监听来提交表单。

然后分别设置表单的action值，这样一个表单可以实现访问多个servlet。

如果要做好一点，可以添加ajax格式实时验证和验证码验证

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
  	&#60;title&#62;带邮箱激活的注册模块&#60;/title&#62;
  	
  	&#60;script type="text/javascript"&#62;
  		function reg(){
  			 //省略: 表单数据格式校验--还有ajax实现的验证码
  			 document.forms[0].action="&#60;c:url value='RegServlet'/&#62;";
  			 document.forms[0].submit();
  		}
  		function login(){
  			 document.forms[0].action="&#60;c:url value='LoginServlet'/&#62;";
  			 document.forms[0].submit();
  		}
  	&#60;/script&#62;
  	
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;c:if test="${!empty sessionScope.error}"&#62;
  		登录失败!
  		&#60;c:remove var="error" scope="session"/&#62;
  	&#60;/c:if&#62;
  	
  	&#60;c:if test="${empty sessionScope.user}" var="boo"&#62;
  		&#60;form action="" method="post"&#62;
	  		姓名:&#60;input type="text" name="name" /&#62; &#60;br/&#62;
            密码:&#60;input type="password" name="pwd" /&#62; &#60;br/&#62;
            邮箱:&#60;input type="text" name="email" /&#62;-登录不用填写邮箱 &#60;br/&#62;
            &#60;input type="button" value="注册" onclick="reg();"/&#62; &nbsp;
         	&#60;input type="button" value="登录" onclick="login();"/&#62; &nbsp; 
        	&#60;input type="reset" value="重置"/&#62; 
  		&#60;/form&#62;
  	&#60;/c:if&#62;
  	&#60;c:if test="${!boo}"&#62;
  		登录成功&#60;br/&#62;
  		欢迎你，亲爱的${user.name}
  	&#60;/c:if&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

###c3p0线程池配置文件:

这个配置没啥好讲的，大家都是按这个格式来的。

注意取名，一定要取：c3p0-config.xml
否则无法读取的。

还有路径：需要在你项目的bin目录下，当然，你放src目录下也是可以的，因为myeclipse会自动把src目录下不是.java后缀的文件原样拷贝到对应的bin文件夹下面，src目录下对应的就是bin目录。

```
&#60;c3p0-config&#62;
	&#60;!-- 默认配置，如果没有指定则使用这个配置 --&#62;
	&#60;default-config&#62;
		&#60;property name="driverClass"&#62;com.mysql.jdbc.Driver&#60;/property&#62;
		&#60;property name="jdbcUrl"&#62;
			&#60;![CDATA[jdbc:mysql://127.0.0.1:3306/hncu?useUnicode=true&characterEncoding=utf-8]]&#62;
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
&#60;/c3p0-config&#62; 

```

###过滤器-实现全站编码

过滤器，很强悍的一个技术。这个必须要会。


```
package cn.hncu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter{
	
	private String charset=null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset = filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}

```

###点击邮件激活地址后的页面:result.jsp

这个就是点击注册链接后的返回页面。

根据DAO层的不同返回值，实现了分别对用户显示不同的提示。

添加了网页自动跳转！

```
&#60;%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%&#62;
&#60;%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&#62;
&#60;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"&#62;
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;带邮箱激活的注册模块&#60;/title&#62;
    
    &#60;script type="text/javascript"&#62;
		var tm;    	
		var i=5;
		function time(){
			i--;
			div1.innerHTML = i+"秒钟以后，自动去登录!";
			if(i&#60;1){
				window.clearInterval(tm);//将定时器清除
				window.location.href="&#60;c:url value='index.jsp'/&#62;";		
			}
		}
		    	
    	onload=function(){
    		tm = window.setInterval(time, 1000);
    	};
    &#60;/script&#62;

  &#60;/head&#62;
  
  &#60;body&#62;
   &#60;c:if test="${count==-1}"&#62;
             服务器异常，请重新激活！&#60;br/&#62;
      &#60;a href="&#60;c:url value='/index.jsp'/&#62;"&#62;登录&#60;/a&#62;
      &#60;br/&#62;
      &#60;div id="div1"&#62;
      &#60;/div&#62;
   &#60;/c:if&#62;   
   &#60;c:if test="${count==0}"&#62;
             激活地址错误，请使用正确的激活地址！&#60;br/&#62;
      &#60;a href="&#60;c:url value='/index.jsp'/&#62;"&#62;登录&#60;/a&#62;
      &#60;br/&#62;
      &#60;div id="div1"&#62;
      &#60;/div&#62;
   &#60;/c:if&#62;   
   &#60;c:if test="${count==1}"&#62;
            你已经激活过，请勿重复激活！&#60;br/&#62;
      &#60;a href="&#60;c:url value='/index.jsp'/&#62;"&#62;登录&#60;/a&#62;
      &#60;br/&#62;
      &#60;div id="div1"&#62;
      &#60;/div&#62;
   &#60;/c:if&#62;   
   &#60;c:if test="${count==2}"&#62;
            激活成功，欢迎去登录！&#60;br/&#62;
      &#60;a href="&#60;c:url value='/index.jsp'/&#62;"&#62;登录&#60;/a&#62;
      &#60;br/&#62;
      &#60;div id="div1"&#62;
      &#60;/div&#62;
   &#60;/c:if&#62;   
  &#60;/body&#62;
&#60;/html&#62;

```
###LoginDaoJdbc-用户登录DAO实现类

这里用到了c3p0和dbutils，在query方法中，new BeanHandler`&#60;User&#62;`(User.class) 此句可以直接给我们返回一个User对象！

```
package cn.hncu.login.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.hncu.domain.User;
import cn.hncu.pubs.C3p0Pool;

public class LoginDaoJdbc implements LoginDAO{
    public User login(User u){
    	String sql = "select * from users where name=? and pwd=? and active='1' ";
    	QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
    	try {
			User user = run.query(sql, new BeanHandler&#60;User&#62;(User.class) , u.getName(),u.getPwd());
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}

```


还有很多代码，就不一一列出了，
项目应用MVC框架思想，注意分层。

###演示结果:

![](http://img.blog.csdn.net/20160822232338173)

激活的原理很简单，我们链接后面向我们的ActiveServlet传递了一个acode参数，用这个参数的值(UUID生成的)到后台去校验，以让用户通过验证！


##完整的项目源代码链接:

https://github.com/chenhaoxiang/Java/tree/master/myMailWeb


&#60;blockquote&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处： &#60;a href='http://blog.csdn.net/qq_26525215'&#62;http://blog.csdn.net/qq_26525215&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href="http://blog.csdn.net/qq_26525215" target="_blank"&#62;大学之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
