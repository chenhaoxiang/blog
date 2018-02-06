---
layout: post
title: "【Druid】Druid监控SSM项目性能-配置与实例"
date: 2018-02-06 21:05:54 +0800
comments: true
categories: Druid
tags: [Druid]
keyword: 陈浩翔, 谙忆, Druid, Druid监控SSM项目
description:  Druid监控SSM项目
---

# 介绍 
以前弄项目的时候，也没配置druid性能监控，但是随着用户的增多，有的时候网站访问慢了，就想知道哪个地方遇到了性能问题，然后好对方法以及sql进行优化，该加索引的加索引，该缓存的去缓存。    

Druid是阿里巴巴开源平台上一个数据库连接池实现(网上都说这个是目前java最好的连接池)。Druid还能够提供强大的监控和扩展功能。 
Druid是一个开源项目，源码托管在github上，源代码仓库地址是 :   
<a href="https://github.com/alibaba/druid" target='_blank'>https://github.com/alibaba/druid</a> 
  
能做到精度在方法级的监控,方便你找出在哪个方法上，哪个sql语句上花费的时间最多，然后做出针对性优化      

# maven配置druid
```java
<!-- 添加druid连接池包 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.0</version>
</dependency>
```
在Maven仓库的地址，自己配置另外的版本:   
<a href="http://www.mvnrepository.com/artifact/com.alibaba/druid" target='_blank'>http://www.mvnrepository.com/artifact/com.alibaba/druid</a> 

# 打开Druid的监控统计功能

在spring的配置文件中，数据源的配置  

```java
...
    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          init-method="init" destroy-method="close"
          p:driverClassName="${driverClassName}"
          p:url="${jdbc_url}"
          p:username="${jdbc_username}"
          p:password="${jdbc_password}"
          p:initialSize="${jdbc_init}"
          p:minIdle="${jdbc_minIdle}"
          p:maxActive="${jdbc_maxActive}"
          p:filters="${druid_filters}"
    >
    </bean>
...
```
p:filters 配置值为:stat,wall,log4j
监控统计用的filter:stat    
日志用的filter:log4j   
防御sql注入的filter:wall  
你可以自己选择配置，多个配置之间用英文逗号隔开  

# web.xml增加配置
```java
...

    <!--start 数据库性能监控  p:filters="stat -->
    <!--spring中配置数据源  p:filters="stat,wall,log4j"   stat和wall。一个是用于监控，一个是用于防火墙。如果想使用sql防火墙，必须加上wall-->
    <servlet>
        <servlet-name>DruidStatView</servlet-name>
        <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
        <!--<init-param>-->
             <!--白名单 -->
            <!--<param-name>allow</param-name>-->
        <!--如果是限定指定的子网里的所有ip都可以访问，那就是ip/子网掩码数。例如 192.168.1.120/24 就相当于192.168.1.*-->
            <!--<param-value>192.168.1.120/24,127.0.0.1</param-value>-->
        <!--</init-param>-->
        <init-param>
            <!-- 用户名 -->
            <param-name>loginUsername</param-name>
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <!-- 密码 -->
            <param-name>loginPassword</param-name>
            <param-value>chenhaoxiang</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>DruidStatView</servlet-name>
        <url-pattern>/druid/*</url-pattern>
    </servlet-mapping>
    <!--end 数据库性能监控 -->
...
```
可以配置用户名和密码，也可以配置白名单。如果不配置用户名密码，就是任何人都可以访问了。  
# 如何访问

访问地址：   
http://127.0.0.1:8080/项目名称/druid/index.html  
![](https://i.imgur.com/bbLdoOF.png)  

输入账号密码登录之后  
![](https://i.imgur.com/HauwdMY.png)  

访问 http://localhost:8080/insert?name=chx  
插入数据  
![](https://i.imgur.com/mQI5SOe.png)  
可以看到sql语句执行的性能  

## SQL执行时间分布  
比如说，某个SQL执行了1000次，其中0~1毫秒区间50次，1~10毫秒800次，10~100毫秒100次，100~1000毫秒30次，1~10秒15次，10秒以上5次。通过耗时区间分布，能够非常清楚知道SQL的执行耗时情况  

现在还只能看数据源和SQL监控，SQL防火墙，Web应用，URL监控，Session监控，Spring监控未开启  

# 开启URL监控,Session监控,Web应用
web.xml中配置 
```java
    <!--Start 开启druid的URL监控 - druid url monitor setting start -->
    <filter>
        <filter-name>DruidWebStatFilter</filter-name>
        <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
        <init-param>
            <param-name>exclusions</param-name>
            <!--忽略资源,不监听这些资源-->
            <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
        </init-param>
        <init-param>
            <param-name>profileEnable</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>DruidWebStatFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!--End druid url monitor setting end -->
```

![](https://i.imgur.com/JRv2D74.png)  

# 开启Spring监控
既然是Spring项目，肯定要监控一下Spring的Bean啦  
结合spring的AOP特性对代码的运行效果进行监控，druid可以做到方法级别的监控，这个功能可以让你发现方法的调用频率及方法的运行时间，及时做出调整和修正使得项目更健壮。  

spring配置文件
```java
...

    <!--Start druid开启spring的监控 需要引入aspectjweaver包-->
    <!--p:filters="stat,wall,log4j"   stat和wall。一个是用于监控，一个是用于防火墙。如果想使用sql防火墙，必须加上wall-->
    <!--druid spring monitor setting-->
    <bean id="druid-stat-interceptor" class="com.alibaba.druid.support.spring.stat.DruidStatInterceptor" />
    <bean id="druid-stat-pointcut" class="org.springframework.aop.support.JdkRegexpMethodPointcut" scope="prototype">
        <property name="patterns">
            <list>
                <!-- 配置监听的bean路径 支持方法名的拦截 -->
                <value>com.uifuture.user.service.*</value>
                <value>com.uifuture.user.dao.*</value>
            </list>
        </property>
    </bean>
    <!-- 基于AspectJ的自动代理.使用AnnotationAwareAspectJAutoProxyCreator  -->
    <aop:aspectj-autoproxy proxy-target-class="true"/>
    <aop:config>
        <aop:advisor advice-ref="druid-stat-interceptor"
                     pointcut-ref="druid-stat-pointcut" />
        <!-- pointcut-ref="druid-stat-pointcut"在idea中报Cannot resolve Spring Pointcut 'druid-stat-pointcut'  不用管它 -->
    </aop:config>
    <!--End druid开启spring的监控 -->
...

```

![](https://i.imgur.com/HpdfD1k.png)  

# 配置SQL慢查询的日志 
在SQL监控中，有一项关于sql执行最慢执行时间的统计，但是只有一个值，就是一条sql语句最慢的执行时间记录。我们可以对执行在时间超过某个时间的sql语句进行日志输出，方便进行性能优化  

## spring配置文件增加拦截器
修改数据源配置:  
```java
    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          init-method="init" destroy-method="close"
          p:driverClassName="${driverClassName}"
          p:url="${jdbc_url}"
          p:username="${jdbc_username}"
          p:password="${jdbc_password}"
          p:initialSize="${jdbc_init}"
          p:minIdle="${jdbc_minIdle}"
          p:maxActive="${jdbc_maxActive}"
          p:filters="${druid_filters}"
    >
        <property name="proxyFilters">
            <list>
                <ref bean="stat-filter" />
                <ref bean="log-filter" />
            </list>
        </property>
    </bean>
```

配置慢sql时间及日志拦截器  
```java
    <!--Start 慢SQL记录  数据源配置p:proxyFilters="stat-filter,log-filter"-->
    <bean id="stat-filter" class="com.alibaba.druid.filter.stat.StatFilter">
        <!-- 慢sql时间设置,即执行时间大于1秒的都是慢sql -->
        <property name="slowSqlMillis" value="1000"/>
        <property name="logSlowSql" value="true"/>
    </bean>
    <bean id="log-filter" class="com.alibaba.druid.filter.logging.Log4jFilter">
        <property name="dataSourceLogEnabled" value="true" />
        <property name="statementExecutableSqlLogEnable" value="true" />
    </bean>
    <!--end 慢SQL记录 -->
```
在这里，因为我是在本地进行，数据量又小，我将时间设置为了5ms，以方便测试  

修改log4j配置文件，增加慢sql日志的输出策略  
```java
#####配置根元素
log4j.rootLogger=INFO,console,file,error,druid
...

# Druid 慢查询记录日志
log4j.logger.druid.sql=WARN,druid
log4j.logger.druid.sql.DataSource=WARN,druid
log4j.logger.druid.sql.Connection=WARN,druid
log4j.logger.druid.sql.Statement=WARN,druid

log4j.appender.druid=org.apache.log4j.DailyRollingFileAppender
log4j.appender.druid.layout=org.apache.log4j.PatternLayout
log4j.appender.druid.layout.ConversionPattern= [%p] %d{yyyy-MM-dd HH\:mm\:ss} [%l] -> %m [%t] [chx]%n
log4j.appender.druid.datePattern='.'yyyy-MM-dd
log4j.appender.druid.Threshold = WARN
log4j.appender.druid.append=true
log4j.appender.druid.File=${catalina.home}/logs/druid_spring_config/druid-slow-sql.log
# ${catalina.home}是在tomcat的目录下
```

![](https://i.imgur.com/BMi0gbs.png)  
由于设置了慢sql的时间为大于5毫秒，所以执行时间大于5毫秒的都会被红色标注。  

再看日志文件:  
![](https://i.imgur.com/VlLc8Tj.png)  
已经将查询慢的sql打印了出来  


如果你在使用过程中遇到其他无法解决的druid问题，或者想配置另外的东西，可以访问下面的地址，官方的文档都在这里    
<a href="https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98" target='_blank'>https://github.com/alibaba/druid/wiki/常见问题</a> 


最后，写的这个小测试druid的项目就上传一下了。需要源码的朋友可以去下载看一下  

## 项目地址：
<blockquote cite='陈浩翔'>
GITHUB源码地址:<strong>【<a href='https://github.com/chenhaoxiang/Java/tree/master/druid_spring_config' target='_blank'>点我进行访问</a>】</strong>
</blockquote>


本文章由<a href="chenhaoxiang" target='_blank'>[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn/2018/02/06/2255/'><font color="green">http://chenhaoxiang.cn/2018/02/06/2255/</font></a><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>谙忆的博客</a>】</strong></p>
</blockquote>

