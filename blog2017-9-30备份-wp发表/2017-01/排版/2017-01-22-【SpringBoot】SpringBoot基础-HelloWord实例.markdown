---
layout: post
title: "【SpringBoot】SpringBoot基础-HelloWord实例"
date: 2017-01-22 05:41:55 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring Boot
tags: [SpringBoot,实例,优化,博客]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
这是我学习SpringBoot的入门系列哦，欢迎阅读。SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。下面直接上实例吧。 
环境配置: 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】
这是我学习SpringBoot的入门系列哦，欢迎阅读。SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。下面直接上实例吧。 
环境配置:
&#60;!-- more --&#62;
----------

这是我学习SpringBoot的入门系列哦，欢迎阅读。

SpringBoot的简介我就不写一个篇章来介绍了，相信大家搜索一下，网上一大堆。

首先，SpringBoot的推出不是用来替代Spirng的，而是精简Spring的配置的。也就是优化Spirng的。

下面直接上实例吧。
环境配置:
win7
Intellij IDEA 使用的是2016 1.2以后的版本
JDK1.8
Maven 3.3.9
Tomcat/8.5.6

# 创建项目工程

使用IDEA新建一个SpringBoot项目。

## 第一种创建方式 -使用Spring Initializr的方式

这种方式很简单。

![](http://img.blog.csdn.net/20170122170532702?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

注意这里的URL是: https://start.spring.io , 这个连接需要网络，用来查询Spring Boot的当前可用版本和组件列表！

然后选择下一步。

![](http://img.blog.csdn.net/20170122170846910?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

注意这些地方的选择！

然后点next。

![](http://img.blog.csdn.net/20170122170935193?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里选择SpringBoot版本和SpringBoot组件！
例如我选择了Web项目组件。

点next

![](http://img.blog.csdn.net/20170122171039274?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

OK，这样就建出了SpringBoot的骨架了！
![](http://img.blog.csdn.net/20170122171201946?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### SpringBootHelloApplication.java

```java
package cn.hncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}
}
```
### pom.xml
它自动生成的SpringBoot！注意，需要的包比较多，如果你以前没有那些包，可能下载需要一定时间，如果中途网络不好什么的，导致包下载不完全，那么解决办法就是把那个包删去，以及pom.xml中对应的语句也删去，然后再重新写到pom.xml中，重新下载对应的包！我就在这里被坑过一次！所以总是出现class找不到！
```xml
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"&#62;
	&#60;modelVersion&#62;4.0.0&#60;/modelVersion&#62;

	&#60;groupId&#62;cn.hncu&#60;/groupId&#62;
	&#60;artifactId&#62;springboothello&#60;/artifactId&#62;
	&#60;version&#62;0.0.1-SNAPSHOT&#60;/version&#62;
	&#60;packaging&#62;jar&#60;/packaging&#62;

	&#60;name&#62;springBoot-Hello&#60;/name&#62;
	&#60;description&#62;SpringBoot�HelloWord&#60;/description&#62;

	&#60;parent&#62;
		&#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
		&#60;artifactId&#62;spring-boot-starter-parent&#60;/artifactId&#62;
		&#60;version&#62;2.0.0.BUILD-SNAPSHOT&#60;/version&#62;
		&#60;relativePath/&#62; &#60;!-- lookup parent from repository --&#62;
	&#60;/parent&#62;

	&#60;properties&#62;
		&#60;project.build.sourceEncoding&#62;UTF-8&#60;/project.build.sourceEncoding&#62;
		&#60;project.reporting.outputEncoding&#62;UTF-8&#60;/project.reporting.outputEncoding&#62;
		&#60;java.version&#62;1.8&#60;/java.version&#62;
	&#60;/properties&#62;

	&#60;dependencies&#62;
		&#60;dependency&#62;
			&#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
			&#60;artifactId&#62;spring-boot-starter-web&#60;/artifactId&#62;
		&#60;/dependency&#62;

		&#60;dependency&#62;
			&#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
			&#60;artifactId&#62;spring-boot-starter-test&#60;/artifactId&#62;
			&#60;scope&#62;test&#60;/scope&#62;
		&#60;/dependency&#62;
	&#60;/dependencies&#62;

	&#60;build&#62;
		&#60;plugins&#62;
			&#60;plugin&#62;
				&#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
				&#60;artifactId&#62;spring-boot-maven-plugin&#60;/artifactId&#62;
			&#60;/plugin&#62;
		&#60;/plugins&#62;
	&#60;/build&#62;

	&#60;repositories&#62;
		&#60;repository&#62;
			&#60;id&#62;spring-snapshots&#60;/id&#62;
			&#60;name&#62;Spring Snapshots&#60;/name&#62;
			&#60;url&#62;https://repo.spring.io/snapshot&#60;/url&#62;
			&#60;snapshots&#62;
				&#60;enabled&#62;true&#60;/enabled&#62;
			&#60;/snapshots&#62;
		&#60;/repository&#62;
		&#60;repository&#62;
			&#60;id&#62;spring-milestones&#60;/id&#62;
			&#60;name&#62;Spring Milestones&#60;/name&#62;
			&#60;url&#62;https://repo.spring.io/milestone&#60;/url&#62;
			&#60;snapshots&#62;
				&#60;enabled&#62;false&#60;/enabled&#62;
			&#60;/snapshots&#62;
		&#60;/repository&#62;
	&#60;/repositories&#62;
	&#60;pluginRepositories&#62;
		&#60;pluginRepository&#62;
			&#60;id&#62;spring-snapshots&#60;/id&#62;
			&#60;name&#62;Spring Snapshots&#60;/name&#62;
			&#60;url&#62;https://repo.spring.io/snapshot&#60;/url&#62;
			&#60;snapshots&#62;
				&#60;enabled&#62;true&#60;/enabled&#62;
			&#60;/snapshots&#62;
		&#60;/pluginRepository&#62;
		&#60;pluginRepository&#62;
			&#60;id&#62;spring-milestones&#60;/id&#62;
			&#60;name&#62;Spring Milestones&#60;/name&#62;
			&#60;url&#62;https://repo.spring.io/milestone&#60;/url&#62;
			&#60;snapshots&#62;
				&#60;enabled&#62;false&#60;/enabled&#62;
			&#60;/snapshots&#62;
		&#60;/pluginRepository&#62;
	&#60;/pluginRepositories&#62;

&#60;/project&#62;
```

## 第二种创建方式-使用创建Maven的方式

这种方式就是需要我们自己手动多写一些代码！

![](http://img.blog.csdn.net/20170122171714214?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

在这里我们选择Maven 的创建方式。在这里不做过多解释了。。。

![](http://img.blog.csdn.net/20170122171931878?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170122171942582?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 现在的pom.xml是这样的

```xml
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"&#62;
    &#60;modelVersion&#62;4.0.0&#60;/modelVersion&#62;

    &#60;groupId&#62;cn.hncu&#60;/groupId&#62;
    &#60;artifactId&#62;springBootHelloM&#60;/artifactId&#62;
    &#60;version&#62;1.0-SNAPSHOT&#60;/version&#62;
    

&#60;/project&#62;
```

### 修改为

```xml
&#60;?xml version="1.0" encoding="UTF-8"?&#62;
&#60;project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"&#62;
    &#60;modelVersion&#62;4.0.0&#60;/modelVersion&#62;

    &#60;groupId&#62;cn.hncu&#60;/groupId&#62;
    &#60;artifactId&#62;springBootHelloM&#60;/artifactId&#62;
    &#60;version&#62;1.0-SNAPSHOT&#60;/version&#62;

    &#60;parent&#62;
        &#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
        &#60;artifactId&#62;spring-boot-starter-parent&#60;/artifactId&#62;
        &#60;version&#62;1.4.2.RELEASE&#60;/version&#62;
    &#60;/parent&#62;

    &#60;dependencies&#62;
        &#60;dependency&#62;
            &#60;groupId&#62;org.springframework.boot&#60;/groupId&#62;
            &#60;artifactId&#62;spring-boot-starter-web&#60;/artifactId&#62;
            &#60;version&#62;1.4.2.RELEASE&#60;/version&#62;
        &#60;/dependency&#62;
    &#60;/dependencies&#62;

&#60;/project&#62;
```
![](http://img.blog.csdn.net/20170122172601153?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
这个不会帮你建好SpringBoot的骨架！所以要自己建

![](http://img.blog.csdn.net/20170122172944845?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### SpringBootHelloApplication

```java
package cn.hncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/1/22.
 * Time: 下午 5:25.
 * Explain:
 */
@SpringBootApplication
public class SpringBootHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class,args);
    }
}

```

使用注解@SpringBootApplication来标注它是一个SpringBoot应用，main方法使它成为了一个主程序。将在应用启动的时候执行！

这main方法里面的SpringBootHelloApplication这个类名，必须是使用了 @SpringBootApplication这个注解的类的类名哦。

### Hello

```java
package cn.hncu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/1/22.
 * Time: 下午 5:27.
 * Explain:
 */
@RestController
public class Hello {
    @RequestMapping("/")
    String home(){
        return "你好，世界";
    }
}

```

这个就是springMvc的注解配置了。

等会就是直接访问:http://localhost:8080/ 然后看网页上的显示。

然后，我们直接运行那个main方法!

![](http://img.blog.csdn.net/20170122173510097?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://img.blog.csdn.net/20170122173534932?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

```java
2017-01-22 17:32:23.270  INFO 19888 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-01-22 17:32:23.322  INFO 19888 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-01-22 17:32:23.334  INFO 19888 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
```

使用的Tomcat的访问端口和版本，都可以在输出的日志中看到！

然后我们访问网址:

http://localhost:8080/

![](http://img.blog.csdn.net/20170122173738676?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


我也是第一次使用SpringBoot，怎么说这个呢，现在给我的感觉就是简单很多了，以前部署Spring-Web项目是需要很多步骤的，现在变得特别简单，难怪现在SpringBoot越来越火了啊。确实感觉，小型项目架一个SpringBoot要省很多事。

我用的是Maven的方式创建的哦。
因为用Spring Initializr方式创建的话，就更简单！pom.xml和SpringBoot的入口程序都不用你写！

我会继续学下去，然后把自己的体验写出来，加油↖(^ω^)↗，谢谢大家支持.

本系列两个项目源码：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/SpringBoot/tree/master/day1' target='_blank'>点我进行下载</a>】</strong>
</blockquote>
