---
layout: post
title: "【问题解决】SSM-@Transactional注解事务无效探讨"
date: 2017-08-21 09:40:40 +0800
comments: true
categories:----- ⑤、数据库,----- ----- MyBatis
tags: [数据库,sql server,spring,mysql,事务]
keyword: 陈浩翔, 谙忆
description: Spring SpringMVC MyBatis框架中-@Transactional注解事务无效解决方法SpringMVC-Spring-MyBatis框架 
数据库:SQL SERVER 2008 
以前都是用的MySQL数据库，没有出现这个问题，现在换成sql server了，结果事务没有起作用了。  经过一番测试： 
排除以下几个问题: 
1.数据库原因，不存在的。MySQL中只有InnoDB 
---


Spring SpringMVC MyBatis框架中-@Transactional注解事务无效解决方法SpringMVC-Spring-MyBatis框架 
数据库:SQL SERVER 2008 
以前都是用的MySQL数据库，没有出现这个问题，现在换成sql server了，结果事务没有起作用了。  经过一番测试： 
排除以下几个问题: 
1.数据库原因，不存在的。MySQL中只有InnoDB
&#60;!-- more --&#62;
----------

---
layout: post
title: "【问题解决】SSM-@Transactional注解事务无效探讨"
date: 2017-07-10 13:38:54 +0800
comments: true
categories: Java
tags: [Java, Transactional]
keyword: 陈浩翔, 谙忆, Java, Transactional
description: Spring SpringMVC MyBatis框架中-@Transactional注解事务无效解决方法
---

Spring SpringMVC MyBatis框架中-@Transactional注解事务无效解决方法

&#60;!-- more --&#62;
----------

SpringMVC-Spring-MyBatis框架  
数据库:SQL SERVER 2008  
以前都是用的MySQL数据库，没有出现这个问题，现在换成sql server了，结果事务没有起作用了。  

经过一番测试：  
排除以下几个问题:
1.数据库原因，不存在的。MySQL中只有InnoDB引擎支持事务。SqlServer2008的企业版作为收费数据库，不可能不支持事务操作。  
2.异常类型不是unchecked异常，我写的异常是1/0，为了保险起见，我还抛出RuntimeException试了，结果也是没有回滚。  
3.是不是配置文件的没配置好，比如Bean，比如:
```
    &#60;!-- 配置事物管理类 --&#62;
    &#60;bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager"&#62;
        &#60;property name="dataSource" ref="dynamicDataSource" /&#62;
    &#60;/bean&#62;
    &#60;!-- 开启注解式事物扫描 --&#62;
    &#60;tx:annotation-driven transaction-manager="transactionManager"  /&#62;
```
检查几遍，排除这个原因。
4.还有一种情况，因为我以前写的都是对一个数据库的操作，现在是一个数据源多个数据库操作，当时有点怀疑我是不是少配置了什么，导致多数据库时无法启动事务，于是便还原到一个数据库，结果事务还是无效，排除此问题  

经过一番折腾，在网上找到一篇文章，说原因是applicationContext.xml的父容器先于Servlet的子容器生效，将Service提前加载了。  

于是验证了一下，首先去掉Service实现类的@Service注解，在spring.xml(也就是applicationContext.xml，我起名是spring.xml)，配置该类的Bean:
```
&#60;bean id="sysUserServiceImp" class="cn.kx59.user.service.imp.SysUserServiceImp"&#62;&#60;/bean&#62;
```
结果运行之后，事务起作用了。

原因如下:  
Spring容器优先加载由ServletContextListener（对应applicationContext.xml，我这里是spring.xml）产生的父容器，而SpringMVC（对应spring-mvc.xml）产生的是子容器。  
子容器Controller进行扫描装配时装配的@Service注解的实例是没有经过事务加强处理，即没有事务处理能力的Service，而父容器进行初始化的Service是保证事务的增强处理能力的。如果不在子容器中将Service exclude掉，此时得到的将是原样的无事务处理能力的Service。
所以我们要在扫描的时候在子容器中将Service exclude掉就好了。  

也就是在spring-mvc.xml中进行如下修改:
```
    &#60;!--扫描Controller--&#62;
    &#60;context:component-scan base-package="cn.kx59"&#62;
        &#60;context:include-filter type="annotation"
                                expression="org.springframework.stereotype.Controller" /&#62;
        &#60;!--下面这个是防止事务没起作用，spring.xml的父容器先于Servlet的子容器生效，将Service提前加载了。这里不用再进行加载装配--&#62;
        &#60;context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service" /&#62;
    &#60;/context:component-scan&#62;
```

注意: 请将@Transactional注解写在实现类的方法或类上！不建议写在接口类中！    
Spring团队的建议是你在具体的类（或类的方法）上使用 @Transactional 注解，而不要使用在类所要实现的任何接口上。你当然可以在接口上使用 @Transactional 注解，但是这将只能当你设置了基于接口的代理时它才生效。因为注解是不能继承的，这就意味着如果你正在使用基于类的代理时，那么事务的设置将不能被基于类的代理所识别，而且对象也将不会被事务代理所包装（将被确认为严重的）。因此，请接受Spring团队的建议并且在具体的类上使用 @Transactional 注解。

在以上解决方法中，若将@Transactional 注解写在接口上，则无法实现事务。所以请将 @Transactional 注解写在实现类中！


本文章由&#60;a href="http://chenhaoxiang.cn/"&#62;[谙忆]&#60;/a&#62;编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
&#60;blockquote cite='陈浩翔'&#62;
&#60;p background-color='#D3D3D3'&#62;转载请注明出处：&#60;a href='http://chenhaoxiang.cn'&#62;&#60;font color="green"&#62;http://chenhaoxiang.cn&#60;/font&#62;&#60;/a&#62;&#60;br&#62;&#60;br&#62;
本文源自&#60;strong&#62;【&#60;a href='http://chenhaoxiang.cn' target='_blank'&#62;人生之旅_谙忆的博客&#60;/a&#62;】&#60;/strong&#62;&#60;/p&#62;
&#60;/blockquote&#62;
