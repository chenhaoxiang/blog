---
layout: post
title: "JavaScript---网络编程(9-2)--DHTML技术演示(2-2)-表格加强"
date: 2016-06-20 04:19:15 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,技术,dhtml,javaScript,web]
keyword: 陈浩翔, 谙忆
description: 对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：



html>
  head>
    title>DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示title>
    meta http-equiv="content-type" content="text/html; charset=UTF-8">
    style type="t 
---


对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：



html&#62;
  head&#62;
    title&#62;DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示title&#62;
    meta http-equiv="content-type" content="text/html; charset=UTF-8"&#62;
    style type="t
&#60;!-- more --&#62;
----------

对上篇博客的最后那个表格隔行高亮显示加了个功能，鼠标监听和年龄从小到大排序。

演示代码：

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示&#60;/title&#62;
    &#60;meta http-equiv="content-type" content="text/html; charset=UTF-8"&#62;
	&#60;style type="text/css"&#62;
		@import url(table.css);
		.one{
			background:#00ff00;
		}
		.two{
			background:rgb(210,0,0);
		}
		.over{
			background-color:#ffff00;
		}	
	&#60;/style&#62;
	&#60;script type="text/javascript"&#62;
		function trColor(){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;//rows为表格属性，返回所以的行
			for(var x=1;x&#60;arrTrs.length; x++){
				if(x%2==1){
					arrTrs[x].className="one";
				}else{
					arrTrs[x].className="two";
				}
				//为每一行动态注册事件处理方法
				var oldClassName;
				arrTrs[x].onmouseover=function(){
					//监听鼠标-移动到那一行
					oldClassName=this.className;
					this.className="over";
				};
				arrTrs[x].onmouseout=function(){
					//鼠标监听-移开
					this.className=oldClassName;
				};
				
			}
			
		}
		//onload = trColor();//这种方式赋值就是执行(本例中，这一句没有效果，因为table对象还没出来。
		//但如果把该段代码放在&#60;table&#62;之后则有效果)，而且只能执行这一个方法
		
		onload=function(){
			trColor();
			//还可以在这里写其它代码，甚至调用其它函数
		};
		//这种方式只是给onload事件注册响应函数，解析该句代码时函数并没有执行
		//而是在该事件发生时才会调用。并且可以在function()中调用多个函数.
		
	&#60;/script&#62;
	
	
	&#60;script type="text/javascript"&#62;
		function sortTable(){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;
			//思路：用一个新的容器来存放表格的行对象数组，并在新数组中进行排序,把排序后的每个元素(行对象)依次添加到表格对象中
			
			//放到新容器arrTrs2中
			var arrTrs2 = [];
			for (var x = 1; x &#60; arrTrs.length; x++) {
				arrTrs2[x - 1] = arrTrs[x];
			}
			//arrTrs2数组可以看成arrTrs数组的引用
			
			//对容器arrTrs2中的元素进行排序	
			mySort(arrTrs2);
			
			//把排序后的行对象重新加到表格中
			for (var x = 0; x &#60; arrTrs2.length; x++) {
				//arrTrs2[x].parentNode.nodeName//TBODY
				arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
				//arrTrs2数组可以看成arrTrs数组的引用
			}
			
		}
		
		function mySort(arr){
			for(var x=0;x&#60;arr.length-1;x++){
				for(var y=x+1;y&#60;arr.length;y++){
					if(parseInt(arr[x].cells[1].innerText) &#62; parseInt(arr[y].cells[1].innerText)){
						var temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					}
				}
			}
		}
		
	&#60;/script&#62;
	
		
  &#60;/head&#62;
  
  &#60;body&#62;
  		&#60;table id="dataTable"&#62;
  			&#60;tr&#62;
  				&#60;th&#62;姓名&#60;/th&#62; &#60;th&#62;&#60;a href="javascript:void(0)" onclick="sortTable()"&#62;年龄&#60;/a&#62;&#60;/th&#62; &#60;th&#62;地址&#60;/th&#62;
  			&#60;/tr&#62;
			
			&#60;tr&#62;
				&#60;td&#62;张三&#60;/td&#62; &#60;td&#62;23&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
			&#60;td&#62;李四&#60;/td&#62; &#60;td&#62;24&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;王五&#60;/td&#62; &#60;td&#62;53&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;65&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;13&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;8&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;73&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;29&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;20&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
  		&#60;/table&#62;
	
  &#60;/body&#62;
&#60;/html&#62;

```



table.css:

```
table {
	border:#ff80ff 1px solid;
	/*solid  :　 实线边框 */
	width:800px;
	border-collapse:collapse;
	/*separate  :　 默认值。边框独立（标准HTML） 
	collapse  :　 相邻边被合并 
	*/	
}
table td{/*table 下面的td*/
	border:#0000ff 1px solid;
	padding:5px;/*内补丁*/
}
table th{
	border:#ff80ff 1px solid;
	padding:5px;
	background-color:#c0c0c0;
}
```

演示结果：
鼠标监听：
![](http://img.blog.csdn.net/20160620160018328)

点一下年龄：实现表格按年龄从小到大排序
![](http://img.blog.csdn.net/20160620160028887)


现在我们觉得上面的不好，只能从小到大排序，而且排序后颜色也变了。不好看，现在我们来对它进行改进。

代码演示：

```
&#60;html&#62;
  &#60;head&#62;
    &#60;title&#62;DHTML技术演示---表格中页面中的显示操纵--行间隔高亮显示&#60;/title&#62;
    &#60;meta http-equiv="content-type" content="text/html; charset=UTF-8"&#62;
	&#60;style type="text/css"&#62;
		@import url(table.css);
		.one{
			background:#00ff00;
		}
		.two{
			background:rgb(210,0,0);
		}
		.over{
			background-color:#ffff00;
		}	
		a{
			text-decoration:none;/*装饰-去掉下划线*/
		}
	&#60;/style&#62;
	&#60;script type="text/javascript"&#62;
		function trColor(){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;//rows为表格属性，返回所以的行
			for(var x=1;x&#60;arrTrs.length; x++){
				if(x%2==1){
					arrTrs[x].className="one";
				}else{
					arrTrs[x].className="two";
				}
				//为每一行动态注册事件处理方法
				var oldClassName;
				arrTrs[x].onmouseover=function(){
					//监听鼠标-移动到那一行
					oldClassName=this.className;
					this.className="over";
				};
				arrTrs[x].onmouseout=function(){
					//鼠标监听-移开
					this.className=oldClassName;
				};
				
			}
			
		}
		//onload = trColor();//这种方式赋值就是执行(本例中，这一句没有效果，因为table对象还没出来。
		//但如果把该段代码放在&#60;table&#62;之后则有效果)，而且只能执行这一个方法
		
		onload=function(){
			trColor();
			//还可以在这里写其它代码，甚至调用其它函数
		};
		//这种方式只是给onload事件注册响应函数，解析该句代码时函数并没有执行
		//而是在该事件发生时才会调用。并且可以在function()中调用多个函数.
		
	&#60;/script&#62;
	
	
	&#60;script type="text/javascript"&#62;
		var flag=true;
		function sortTable(aNode){
			var oTableNode = document.getElementById("dataTable");
			var arrTrs = oTableNode.rows;
			//思路：用一个新的容器来存放表格的行对象数组，并在新数组中进行排序,把排序后的每个元素(行对象)依次添加到表格对象中
			
			//放到新容器arrTrs2中
			var arrTrs2 = [];
			for (var x = 1; x &#60; arrTrs.length; x++) {
				arrTrs2[x - 1] = arrTrs[x];
			}
			//arrTrs2数组可以看成arrTrs数组的引用
			
			//对容器arrTrs2中的元素进行排序	
			mySort(arrTrs2);
			
			//把排序后的行对象重新加到表格中
			if(flag){
				for (var x = 0; x &#60; arrTrs2.length; x++) {
					//arrTrs2[x].parentNode.nodeName//TBODY
					arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
					//arrTrs2数组可以看成arrTrs数组的引用
				}
				aNode.innerHTML="年龄↑";
			}else{
				for(var x=arrTrs2.length-1;x>=0;x--){
					arrTrs2[x].parentNode.appendChild(arrTrs2[x]);
				}
				aNode.innerHTML="年龄↓";
			}
			flag = !flag;
			trColor();
		}
		
		function mySort(arr){
			for(var x=0;x&#60;arr.length-1;x++){
				for(var y=x+1;y&#60;arr.length;y++){
					if(parseInt(arr[x].cells[1].innerText) &#62; parseInt(arr[y].cells[1].innerText)){
						var temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					}
				}
			}
		}
		
	&#60;/script&#62;
	
		
  &#60;/head&#62;
  
  &#60;body&#62;
  		&#60;table id="dataTable"&#62;
  			&#60;tr&#62;
  				&#60;th&#62;姓名&#60;/th&#62; &#60;th&#62;&#60;a href="javascript:void(0)" onclick="sortTable(this)"&#62;年龄&#60;/a&#62;&#60;/th&#62; &#60;th&#62;地址&#60;/th&#62;
  			&#60;/tr&#62;
			
			&#60;tr&#62;
				&#60;td&#62;张三&#60;/td&#62; &#60;td&#62;23&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
			&#60;td&#62;李四&#60;/td&#62; &#60;td&#62;24&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;王五&#60;/td&#62; &#60;td&#62;53&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;65&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;13&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;8&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;73&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Jack&#60;/td&#62; &#60;td&#62;29&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;Rose&#60;/td&#62; &#60;td&#62;20&#60;/td&#62; &#60;td&#62;湖南长沙&#60;/td&#62;
			&#60;/tr&#62;
  		&#60;/table&#62;
	
  &#60;/body&#62;
&#60;/html&#62;

```

演示结果：

![](http://img.blog.csdn.net/20160620161718879)

![](http://img.blog.csdn.net/20160620161726648)

![](http://img.blog.csdn.net/20160620161733024)