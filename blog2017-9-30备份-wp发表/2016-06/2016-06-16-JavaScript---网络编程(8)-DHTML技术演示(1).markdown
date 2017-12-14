---
layout: post
title: "JavaScript---网络编程(8)-DHTML技术演示(1)"
date: 2016-06-16 04:52:27 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,html,技术,css]
keyword: 陈浩翔, 谙忆
description: DHTML技术使用的基本思路： 
         1. 用标签封装数据—html范畴 
         2. 定义样式—css范畴 
         3. 明确事件源、事件和要处理的节点—dom范畴 
         4. 明确具体的操作方式，其实就是事件的处理内容(过程)—js范畴新闻字体第一种方式：html范畴 演示代码：<html>
  <head>
    <title>>DHTML 
---


DHTML技术使用的基本思路： 
         1. 用标签封装数据—html范畴 
         2. 定义样式—css范畴 
         3. 明确事件源、事件和要处理的节点—dom范畴 
         4. 明确具体的操作方式，其实就是事件的处理内容(过程)—js范畴新闻字体第一种方式：html范畴 演示代码：&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;&#62;DHTML
&#60;!-- more --&#62;
----------

DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴

**新闻字体**
====

**第一种方式：html范畴 演示代码：**
---------

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;&#62;DHTML技术演示---新闻字体1&#60;/title&#62;
    &#60;meta http-equiv="content-type" content="text/html; charset=UTF-8"&#62;
	&#60;script type="text/javascript"&#62;
		function changeFont(size,color){
			//alert("aa");
			var oNewsDiv = document.getElementById("newsDiv");
			
			//以下用js+dom来设置下面html方式对应的功能
	        //&#60;div id="newsDiv" style="font-size:28px"&#62;
            //oNewsDiv.style.font-size= "28px"; //左边的方式是html方式中的属性名，不是js中用的属性名
			//oNewsDiv.style.fontSize="28px";//写死了，字体大小用参数更好
			oNewsDiv.stye.fontSize=size;//字体大小
			oNewsDiv.style.color=color;			
		}
		
	&#60;/script&#62;
	
  &#60;/head&#62;
  		&#60;!--DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  		--&#62;
  &#60;body&#62;
		&#60;!--用“#”号可以屏蔽href的默认超链接功能，但有个不足：地址栏中会添加一个"#"号----改用javascript的方式更好！---javascript:void(0)
  	  	&#60;a href="#" onclick="changeFont()"&#62; 大字体&#60;/a&#62;
		--&#62;
		&#60;a href="javascript:void(0)" onclick="changeFont('28px','#aaaaaa')"&#62;大字体&#60;/a&#62;
		&#60;a href="javascript:void(0)" onclick="changeFont('20px','#000000')"&#62;中字体&#60;/a&#62;
		&#60;a href="javascript:void(0)" onclick="changeFont('12px','#ff0000')"&#62;小字体&#60;/a&#62;
		&#60;hr/&#62;
		&#60;!--开始这样先测试下：
			先用html的方式测试一下这样设置字体大小行不行，如果行，再采用API文档右侧栏中的js来实现对应功能
	    	&#60;div id="newsDiv" style="font-size:28px"&#62;
   		 --&#62;
		&#60;div id="newsDiv"&#62;
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。&#60;br/&#62;
（信息科学与工程学院）
		&#60;/div&#62;
  &#60;/body&#62;
&#60;/html&#62;

```

360浏览器8.1 演示结果：
---------------
大字体：
![](http://img.blog.csdn.net/20160616153151750)
中字体：
![](http://img.blog.csdn.net/20160616153220504)
小字体：
![](http://img.blog.csdn.net/20160616153228769)




**第二种方式：css范畴 演示代码：**
---------

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;&#62;DHTML技术演示---新闻字体1&#60;/title&#62;
    &#60;meta http-equiv="content-type" content="text/html; charset=UTF-8"&#62;
	&#60;style type="text/css"&#62;
		.max{
			color:#808080;
			font-size:28px;
			background-color:#9ce9b4;/*背景色*/
		}
		.norm{
	 		color:#000000;
			font-size:20px;
			background-color:#cdd8d0;
	 	}
	 	.min{
	 		color:#ff0000;
			font-size:16px;
			background-color:#f9fac2;
	 	}
	&#60;/style&#62;
	&#60;script type="text/javascript"&#62;
		function changeFont(sClass){
			var oNewsDiv = document.getElementById("newsDiv") ;
			//利用js+dom的方式来更改节点的样式---class属性
			oNewsDiv.className = sClass;
		}
	&#60;/script&#62;
	
  &#60;/head&#62;
  		&#60;!--DHTML技术使用的基本思路：
  		 1. 用标签封装数据---html范畴
   		 2. 定义样式---css范畴
  		 3. 明确事件源、事件和要处理的节点---dom范畴
   		 4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  		--&#62;
  &#60;body&#62;
  		&#60;a href="javascript:void(0)" onclick="changeFont('max')" &#62; 大字体 &#60;/a&#62;
  		&#60;a href="javascript:void(0)" onclick="changeFont('norm')" &#62; 中字体 &#60;/a&#62;
  		&#60;a href="javascript:void(0)" onclick="changeFont('min')" &#62; 小字体 &#60;/a&#62;
		
		&#60;!--先用html的方式测试一下，然后再用js+dom
	  		&#60;div id="newsDiv" class="norm"&#62;
		--&#62;
		&#60;div id="newsDiv"&#62;
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。&#60;br/&#62;
（信息科学与工程学院）
		&#60;/div&#62;
  &#60;/body&#62;
&#60;/html&#62;

```


360浏览器8.1 演示结果：
---------------
大字体：
![](http://img.blog.csdn.net/20160616155451669)
中字体：
![](http://img.blog.csdn.net/20160616155501965)
小字体：
![](http://img.blog.csdn.net/20160616155510606)

**第三种方式：dom，js范畴 演示代码：**
---------
1.css：

```
.max {
    color: #808080;
    font-size: 28px;
    background-color: #9ce9b4;
}

.norm {
    color: #000000;
    font-size: 20px;
    /*background-color:#cdd8d0;*/
}

.min {
    color: #ff0000;
    font-size: 16px;
    background-color: #f9fac2;
}

```
2.css:

```
.max {
    color: #808080;
    font-size: 28px;
   	background-image:url(img/back1.jpg);
}

.norm {
    color: #000000;
    font-size: 20px;
    background-image: url(img/back2.jpg);
}

.min {
    color: #ff0000;
    font-size: 16px;
    background-image: url(img/back3.jpg);
}
```
html：

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;DHTML技术演示---新闻字体3--换套装&#60;/title&#62;
     &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
	 &#60;link rel="stylesheet" type="text/css" href="1.css" id="linkChgSuit"&#62;
	 
	 &#60;style type="text/css"&#62;
	 	span:hover{
	 		background-color:#ff0000;
			cursor:hand;/*鼠标移到那时，显示小手形状*/
	 	}
	 &#60;/style&#62;
	 &#60;script type="text/javascript"&#62;
	 	//更改类样式
		function changeFont(sClass){
			var oNewsDiv = document.getElementById("newsDiv");
			//利用js+dom的方式来更改节点的样式---class属性
			oNewsDiv.className = sClass;
		}
		//换套装
		function changeSuit(sNum){
			var oLink = document.getElementById("linkChgSuit");
			oLink.href = sNum+".css";
		}
		
		
	 &#60;/script&#62;
	 
  &#60;/head&#62;
  &#60;!--DHTML技术使用的基本思路：
   1. 用标签封装数据---html范畴
   2. 定义样式---css范畴
   3. 明确事件源、事件和要处理的节点---dom范畴
   4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  --&#62;
  
  &#60;body&#62;
  	&#60;a href="javascript:void(0)" onClick="changeFont('max')"&#62; 大字体&#60;/a&#62;
  	&#60;a href="javascript:void(0)" onClick="changeFont('norm')"&#62;  中字体&#60;/a&#62;
  	&#60;a href="javascript:void(0)" onClick="changeFont('min')"&#62; 小字体&#60;/a&#62;
  	&#60;br/&#62;
	&#60;span onClick="changeSuit('1')"&#62;风格1&#60;/span&#62;
	&#60;span onClick="changeSuit('2')"&#62;风格2&#60;/span&#62;
	&#60;hr/&#62;
	&#60;!--先用html的方式测试一下，然后再用js+dom
	  &#60;div id="newsDiv" class="norm"&#62;
	--&#62;
	&#60;div id="newsDiv"&#62;
       5月31日下午14：30，副校长何振在电信楼视频会议室，为学生处、团委、计划财务处、信息科学与工程学院和体育学院全体师生党员上了一堂题为“讲政治，有信念，做合格党员”的党课。
何振阐述了“讲政治，有信念”的重要性，并讲述了如何才能把握“讲政治，有信念”。他认为，党员应当从把握“讲政治，有信念”的深刻内涵、核心要义和方法路径这三个方面入手。他指出，践行“讲政治，有信念”，必须将其与高校管理、教学、科研相结合，运用到实践当中去，“办人民满意的大学”，并结合学校具体情况进行了深入的分析。&#60;br/&#62;
（信息科学与工程学院）
    &#60;/div&#62;

  &#60;/body&#62;
  
&#60;/html&#62;

```

360浏览器8.1 演示结果：
---------------

风格2大字体：
![](http://img.blog.csdn.net/20160616162510276)
风格2中字体：
![](http://img.blog.csdn.net/20160616162517946)
风格1大字体：
![](http://img.blog.csdn.net/20160616162525415)
风格1中字体：
![](http://img.blog.csdn.net/20160616162532540)


菜单列表：
=====
代码演示：

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;DHTML技术演示---菜单列表1&#60;/title&#62;
     &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
	 &#60;style type="text/css"&#62;
		/*老版本的IE支持，新版本不支持了
		dl{
			height:18px;
			overflow:hidden;
		}*/
		
		/*
block  :　 CSS1  块对象的默认值。将对象强制作为块对象呈递，为对象之后添加新行
none  :　 CSS1  隐藏对象。与 visibility 属性的hidden值不同，其不为被隐藏的对象保留其物理空间  
		ul{
			//display:none;//不显示
			display:block;//块显示
		}
		*/
		table {
			border:#ff80ff;
			width:80px;
		}
		
		table ul{
			list-style:none;
			margin:0px;/*外补丁*/
			padding:0px;/*内补丁*/
			background-color:#ff8000;
			display:none;
		}
		table td{
			border:#0000ff 1px solid;
			background:#80ff00;
		}
		
		table td a:link, table td a:visited{
			color:#8080c0;
			text-decoration:none;
		}
		table td a:hover{
			color:#0000ff;;
		}
		
		.open{
			display:block;
		}
		.close{
			display:none;
		}
		
		
	 &#60;/style&#62;
	 
	 &#60;script type="text/javascript"&#62;
	 	function list(node){
			var oTdNode = node.parentNode;
			//alert( oTdNode.nodeName);//TD
			var oUlNode = oTdNode.getElementsByTagName("ul")[0];
			//alert( oUlNode.nodeName);//UL
			if( oUlNode.className =="open"){
				oUlNode.className ="close";
			}else{
				oUlNode.className ="open";
			}
		}
	 
	 &#60;/script&#62;
  &#60;/head&#62;
  &#60;!--DHTML技术使用的基本思路：
   1. 用标签封装数据---html范畴
   2. 定义样式---css范畴
   3. 明确事件源、事件和要处理的节点---dom范畴
   4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
  --&#62;
  
  &#60;body&#62;
	&#60;table&#62;
		&#60;tr&#62;
			&#60;td&#62;
				&#60;a href="javascript:void(0)" onclick="list(this)"&#62;文件菜单&#60;/a&#62;
				&#60;ul&#62;
					&#60;li&#62;菜单项一&#60;/li&#62;
					&#60;li&#62;菜单项二&#60;/li&#62;
					&#60;li&#62;菜单项三&#60;/li&#62;
					&#60;li&#62;菜单项四&#60;/li&#62;
				&#60;/ul&#62;
		    &#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td&#62;
				&#60;a href="javascript:void(0)" onclick="list(this)"&#62;编辑菜单&#60;/a&#62;
				&#60;ul&#62;
					&#60;li&#62;菜单项一&#60;/li&#62;
					&#60;li&#62;菜单项二&#60;/li&#62;
					&#60;li&#62;菜单项三&#60;/li&#62;
					&#60;li&#62;菜单项四&#60;/li&#62;
				&#60;/ul&#62;
		    &#60;/td&#62;
		&#60;/tr&#62;
		&#60;tr&#62;
			&#60;td&#62;
				&#60;a href="javascript:void(0)" onclick="list(this)"&#62;调试菜单&#60;/a&#62;
				&#60;ul&#62;
					&#60;li&#62;菜单项一&#60;/li&#62;
					&#60;li&#62;菜单项二&#60;/li&#62;
					&#60;li&#62;菜单项三&#60;/li&#62;
					&#60;li&#62;菜单项四&#60;/li&#62;
				&#60;/ul&#62;
		    &#60;/td&#62;
		&#60;/tr&#62;
	&#60;/table&#62;
	
  &#60;/body&#62;
  
&#60;/html&#62;

```

360 8.1 演示结果;
![](http://img.blog.csdn.net/20160616164857175)


下面就是只能点开一个菜单（点一个菜单时，把其他菜单全部关闭）：

```
&#60;html&#62;
    &#60;head&#62;
        &#60;title&#62;DHTML技术演示---菜单列表2&#60;/title&#62;
        &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
        &#60;style type="text/css"&#62;
            /*老版本的IE支持，新版本不支持了
             dl{
             height:18px;
             overflow:hidden;
             }*/
            /*
             ul{
             //display:none;//不显示
             display:block;//块显示
             }
             */
            table {
                border: #ff80ff;
                width: 80px;
            }
            
            table ul {
                list-style: none;
                margin: 0px;
                padding: 0px;
                background-color: #ff8000;
                display: none;
            }
            
            table td {
                border: #0000ff 1px solid;
                background: #80ff00;
            }
            
            table td a:link, table td a:visited {
                color: #8080c0;
                text-decoration: none;
            }
            
            table td a:hover {
                color: #0000ff;;
            }
            
            .open {
                display: block;
            }
            
            .close {
                display: none;
            }
        &#60;/style&#62;
        &#60;script type="text/javascript"&#62;
            function list(node){
                var oTdNode = node.parentNode;
                //alert( oTdNode.nodeName);//TD
                var oUlNode = oTdNode.getElementsByTagName("ul")[0];
                //alert( oUlNode.nodeName);//UL
                
                var oNode = document.getElementsByName("men");
                for (x = 0; x &#60; oNode.length; x++) {
					var ulNode = oNode[x].parentNode.getElementsByTagName("ul")[0];
                    if (oNode[x].innerText == node.innerText) {
                        if (ulNode.className == "open") {
                            ulNode.className = "close";
                        }
                        else {
                            ulNode.className = "open";
                        }
                    }
                    else 
                        if (ulNode.className == "open") {
                            ulNode.className = "close";
                        }
                }
                
            }
        &#60;/script&#62;
    &#60;/head&#62;
    &#60;!--DHTML技术使用的基本思路：
    1. 用标签封装数据---html范畴
    2. 定义样式---css范畴
    3. 明确事件源、事件和要处理的节点---dom范畴
    4. 明确具体的操作方式，其实就是事件的处理内容(过程)---js范畴
    --&#62;
    &#60;body&#62;
        &#60;table&#62;
            &#60;tr&#62;
                &#60;td&#62;
                    &#60;a href="javascript:void(0)" onclick="list(this)" name="men"&#62;文件菜单&#60;/a&#62;
                    &#60;ul&#62;
                        &#60;li&#62;
                            菜单项一
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项二
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项三
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项四
                        &#60;/li&#62;
                    &#60;/ul&#62;
                &#60;/td&#62;
            &#60;/tr&#62;
            &#60;tr&#62;
                &#60;td&#62;
                    &#60;a href="javascript:void(0)" onclick="list(this)" name="men"&#62;编辑菜单&#60;/a&#62;
                    &#60;ul&#62;
                        &#60;li&#62;
                            菜单项一
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项二
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项三
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项四
                        &#60;/li&#62;
                    &#60;/ul&#62;
                &#60;/td&#62;
            &#60;/tr&#62;
            &#60;tr&#62;
                &#60;td&#62;
                    &#60;a href="javascript:void(0)" onclick="list(this)" name="men"&#62;调试菜单&#60;/a&#62;
                    &#60;ul&#62;
                        &#60;li&#62;
                            菜单项一
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项二
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项三
                        &#60;/li&#62;
                        &#60;li&#62;
                            菜单项四
                        &#60;/li&#62;
                    &#60;/ul&#62;
                &#60;/td&#62;
            &#60;/tr&#62;
        &#60;/table&#62;
    &#60;/body&#62;
&#60;/html&#62;

```

演示结果：

![](http://img.blog.csdn.net/20160616165209879)