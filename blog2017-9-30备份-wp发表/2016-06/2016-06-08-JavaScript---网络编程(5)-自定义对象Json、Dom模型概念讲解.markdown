---
layout: post
title: "JavaScript---网络编程(5)-自定义对象Json、Dom模型概念讲解"
date: 2016-06-08 08:51:47 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,html,w3c,对象,JavaScript]
keyword: 陈浩翔, 谙忆
description: 这节博客主要讲解Dom模型概念~和JSON的简单介绍首先，还是先上out.js的代码：function println(param){
    document.write(param+"<br/>");
}function print(param){
    document.write(param);
}什么是 DOM？DOM 是 W3C（万维网联盟）的标准。 
DOM 定义了访问 HTML 和 
---


这节博客主要讲解Dom模型概念~和JSON的简单介绍首先，还是先上out.js的代码：function println(param){
    document.write(param+"&#60;br/&#62;");
}function print(param){
    document.write(param);
}什么是 DOM？DOM 是 W3C（万维网联盟）的标准。 
DOM 定义了访问 HTML 和
&#60;!-- more --&#62;
----------

这节博客主要讲解Dom模型概念~和JSON的简单介绍

首先，还是先上out.js的代码：

```
function println(param){
	document.write(param+"&#60;br/&#62;");
}

function print(param){
	document.write(param);
}
```

&#60;font color="red"&#62;**什么是 DOM？**&#60;/font&#62;
============

DOM 是 W3C（万维网联盟）的标准。
DOM 定义了访问 HTML 和 XML 文档的标准：
“W3C 文档对象模型 （DOM） 是中立于平台和语言的接口，它允许程序和脚本动态地访问和更新文档的内容、结构和样式。”
W3C DOM 标准被分为 3 个不同的部分：
核心 DOM - 针对任何结构化文档的标准模型
XML DOM - 针对 XML 文档的标准模型
HTML DOM - 针对 HTML 文档的标准模型
HTML DOM 定义了所有 HTML 元素的对象和属性，以及访问它们的方法。
换言之，HTML DOM 是关于如何获取、修改、添加或删除 HTML 元素的标准。

在这里，我们学的是HTML-DOM。


&#60;font color="red"&#62;什么是 JSON ？&#60;/font&#62;
============================
JSON 比 XML 更小、更快，更易解析。
JSON 指的是 JavaScript 对象表示法（JavaScript Object Notation）
JSON 是轻量级的文本数据交换格式
JSON 独立于语言 *，存储和交换文本信息的语法。类似 XML。
JSON 具有自我描述性，更易理解
*	JSON 使用 Javascript语法来描述数据对象，但是 JSON 仍然独立于语言和平台。JSON 解析器和 JSON 库支持许多不同的编程语言。 目前非常多的动态（PHP，JSP，.NET）编程语言都支持JSON。

&#60;font color="red"&#62;**JSON - 转换为 JavaScript 对象**&#60;/font&#62;
JSON 文本格式在语法上与创建 JavaScript 对象的代码相同。
由于这种相似性，无需解析器，JavaScript 程序能够使用内建的 eval() 函数，用 JSON 数据来生成原生的 JavaScript 对象。

* JSON 使用 JavaScript 语法，但是 JSON 格式仅仅是一个文本。
文本可以被任何编程语言读取及作为数据格式传递。

&#60;font color="red"&#62;**JSON 语法规则**&#60;/font&#62;
数据为 键/值 对。
数据由逗号分隔。
大括号保存对象
方括号保存数组

&#60;font color="red"&#62;演示代码：&#60;/font&#62;

```
&#60;html&#62;
    &#60;head&#62;
        &#60;title&#62;自定义对象--json的用法演示&#60;/title&#62;
        &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
    &#60;/head&#62;
    &#60;body&#62;
        &#60;script type="text/javascript" src="out.js"&#62;
        &#60;/script&#62;
        &#60;!-- 用js来描述我们自己的对象，如类似java当中的Person类 --&#62;
        &#60;!-- 方式3 --&#62;
        &#60;script type="text/javascript"&#62;
            //json---在JavaScript中封装数据对象
            //map
            var pp = {
                //"name":"张三","age":"23", //key:value
                name: "张三",
                age: "23",//这句和上面一句等效---key的名称可以省略引号
                getName: function(){
                    //"getName":function(){//这句和上面一句等效
                    return this.name;
                }
            };
            
            println(pp.name + "," + pp.age);
            println(pp["name"] + "," + pp["age"]);//表示可以访问pp对象中的“name”和“age”属性
            //注意这里属性是名称而不是变量，所以必须用引用
            
            println(pp.getName());//调用函数
            println(pp["getName"]);//显示出函数的代码
            println(pp["getName"]());//调用函数
            var map = {
                8: "张三",
                3: "李四",
                5: "Jack"
            };
            println(map["8"]); //原理同前。json中冒号前面的那个是key，后面的是value
            println(map[8]); //8是数字，不可能是变量名，因此引号省略照样能解析出来
        &#60;/script&#62;
        &#60;script type="text/javascript"&#62;
        	
			var myObj = {
				name:"张三丰",age:23
			};
			println(myObj.name+","+myObj["age"]);//分别用了两种读取属性的方式
        &#60;/script&#62;
		
		&#60;script type="text/javascript"&#62;
			var myMap={
				names:["Jack1","Jack2","Tom1","Tom2"],
				nums:[10,20,30,40]
			}
			
			println(myMap.names[1]+","+myMap.nums[1]);
			
			var myMap={
				names:[{name:"Jack111"},{name:"Jack222"},{name:"Jack333"}]   
			}
			
			println(myMap.names[1].name);
			println(myMap.names[1]["name"]);//与上面的访问一样的
			
			
			
		&#60;/script&#62;
		
    &#60;/body&#62;
&#60;/html&#62;

```

&#60;font color="red"&#62;360浏览器8.1 演示结果：&#60;/font&#62;

![](http://img.blog.csdn.net/20160608200254557)

&#60;font color="red"&#62;Dom模型概念讲解&#60;/font&#62;
=========

&#60;font color="green"&#62;**DOM: Document Object Model 文档对象模型**&#60;/font&#62;
               主要用来将标记型文档(html,xml)封装成对象,并将标记型文档中的所有内容(标签、文本、属性等)都封装成对象
               既然都封装成了对象，那么就可以通过这些对象很方便地操作这些文档内容，达到操作页面内容--页面显示。
    
&#60;font color="green"&#62;**DOM树中的几个名词：**&#60;/font&#62;
               结点(节点)：dom树中的标签、文本和属性等都称为结点(节点).
               元素：dom树中的标签。
               子节点  父节点(元素) 兄弟 
       父结点
               主要用来将标记型文档(html,xml)封装成对象,并将标记型文档中的所有内容(标签、文本、属性等)都封装成对象
               既然都封装成了对象，那么就可以通过这些对象很方便地操作这些文档内容，达到操作页面内容--页面显示。
    
&#60;font color="green"&#62;**DHTML技术：**&#60;/font&#62;
动态的HTML ----html + css + dom +javascript 配合使用，来做动态html页面
       HTML---负责提供标签，同时用标签封装数据
       CSS----负责显示样式
       dom----把整个页面中的标签、属性和文字内容封装成对象。
       js-----提供程序设计语言，for,while,if
    
我们可以通过这个对象树来加深对DOM的了解。

&#60;font color="green"&#62;**（最下面部分未画出）对象树如下：**&#60;/font&#62;
代码随便写写哒、
![](http://img.blog.csdn.net/20160608201533183)

&#60;font color="green"&#62;**代码：**&#60;/font&#62;

```
&#60;html&#62;
  &#60;head&#62;
     &#60;title&#62;湖南城院&#60;/title&#62;
  &#60;/head&#62;
  &#60;body&#62;
      &#60;div&#62;div区域&#60;/div&#62;
      &#60;dl&#62;
         &#60;dt&#62;上层项目&#60;/dt&#62;
         &#60;dd&#62;下层项目&#60;/dd&#62;
      &#60;/dl&#62;
      &#60;table&#62;
         &#60;tr&#62; &#60;th&#62;姓名&#60;/th&#62; &#60;/tr&#62;
         &#60;tr&#62; &#60;td&#62;张三&#60;/td&#62; &#60;/tr&#62;
      &#60;/table&#62;
      &#60;form&#62;
         &#60;input type="text"&#62;
      &#60;/form&#62;
      &#60;a href="1.html"&#62;查看&#60;/a&#62;
  &#60;/body&#62;
&#60;/html&#62;
```

&#60;font color="red"&#62;**window对象中的对象**&#60;/font&#62;
------------
window 对象:
代表浏览器中一个打开的窗口。


&#60;font color="green"&#62;**navigator 对象**&#60;/font&#62;
包含关于 Web 浏览器的信息。

属性--- 描述 
appCodeName--- 获取浏览器的代码名称。 
appMinorVersion--- 获取应用程序的次版本值。 
appName ---获取浏览器的名称。 
appVersion ---获取浏览器运行的平台和版本。 
browserLanguage ---获取浏览器的当前语言。 
cookieEnabled--- 获取客户端的永久 cookie 是否在浏览器中启用。永久 
cookies--- 是储存在客户端计算机上的。 
cpuClass--- 获取指示 CPU 等级的字符串。 
onLine ---获取表明系统是否处于全局脱机模式的值。 
platform ---获取用户的操作系统名称。 
systemLanguage--- 获取操作系统适用的默认语言。 
userAgent ---获取等同于 HTTP 用户代理请求头的字符串。 
userLanguage ---获取操作系统的自然语言设置。


&#60;font color="green"&#62;演示代码： &#60;/font&#62;

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;Bom模型演示----window对象中的对象&#60;/title&#62;
    &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;!--
	   window中的所有对象在调用时，可以省略: window.
	--&#62;
	
  	&#60;script type="text/javascript" src="out.js"&#62;
  	&#60;/script&#62;
	
  	&#60;script type="text/javascript"&#62;
  		function windowObjDemo(){
		   	var name = window.navigator.appName;//获取浏览器的名称。
			//var version = window.navigator.appVersion;
			var version = navigator.appVersion;//获取浏览器运行的平台和版本。
			println(name+"----"+version);
		   	var pro = location.protocol; //设置或获取 URL 的协议部分。
			println(pro);
			var addr = location.href;//设置或获取整个 URL 为字符串。
			println(addr);
		}  	
  		function windowObjDemo2(){
			//location.href ="http://www.baidu.com";//点击按钮，跳转到百度
			location.href ="5a.html";
		}  	
  		function windowObjDemo3(){
			history.forward();//从历史列表中装入下一个 URL。//相对定位-相对的下一个-相当于浏览器中的前进按钮
		}  	
  	&#60;/script&#62;
    &#60;input type="button" value="演示window中的对象1" onclick="windowObjDemo()" /&#62;
    &#60;input type="button" value="演示window中的对象2" onclick="windowObjDemo2()" /&#62;
    &#60;input type="button" value="演示window中的对象3" onclick="windowObjDemo3()" /&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

&#60;font color="green"&#62;**5a.html:**&#60;/font&#62;

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;aa&#60;/title&#62;
    &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
  &#60;/head&#62;
  
  &#60;body&#62;
  	&#60;script type="text/javascript"&#62;
  		function windowObjDemo(){
			history.back();//从历史列表中装入前一个 URL。---相对定位，相对的前一个。-相当于浏览器中的后退按钮
		}  	
  	&#60;/script&#62;
    &#60;input type="button" value="演示window中的对象" onClick="windowObjDemo()" /&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

这里很简单，就不贴浏览器演示结果图片了。

