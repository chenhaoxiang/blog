---
layout: post
title: "JavaScript---网络编程(10)--DHTML技术演示(3)-多选框"
date: 2016-06-21 07:52:57 +0800
comments: true
categories:❷ Java大学之行,----- ④、Web学习之旅,----- ----- HTML/CSS/JS网络编程
tags: [网络编程,javascript,css,技术,checkbox]
keyword: 陈浩翔, 谙忆
description: 这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。checkbox的使用1：演示代码：<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>DHTML技术演示---checkbox的使用1</title>
    <scrip 
---


这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。checkbox的使用1：演示代码：&#60;html&#62;
    &#60;head&#62;
    &#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
    &#60;title&#62;DHTML技术演示---checkbox的使用1&#60;/title&#62;
    &#60;scrip
&#60;!-- more --&#62;
----------

这节讲述多选框的使用，当然，肯定是结合css和Javascript一起的。

checkbox的使用1：
=============

演示代码：
-----

```
&#60;html&#62;
	&#60;head&#62;
	&#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
	&#60;title&#62;DHTML技术演示---checkbox的使用1&#60;/title&#62;
	&#60;script type="text/javascript"&#62;
		//html中&#60;pre&#62;&#60;/pre&#62;让代码原样输出-小提示
		function getSum(){
			var sum=0;
			var arrChkNode = document.getElementsByName("item");
			for(var x=0;x&#60;arrChkNode.length;x++){
				if(arrChkNode[x].checked){
					sum+=parseInt(arrChkNode[x].value);
				}
			}
			var sVal = sum+"元";
			//字体颜色设置为红色
			//document.getElementById("sumid").innerHTML="&#60;font color='red'&#62;aaa&#60;/font&#62;";
			document.getElementById("sumid").innerHTML=sVal.fontcolor("red");
			
		}
		
		function checkAll(aChkAllNode){
			var arrChkNodes = document.getElementsByName("item");
			for(var x=0;x&#60;arrChkNodes.length;x++){
				//arrChkNodes[x].checked=true;//"true"也可以，但不建议这样使用，因为API中要求的是boolean类型
				arrChkNodes[x].checked= aChkAllNode.checked;
			}
		}
	&#60;/script&#62;
	
	&#60;/head&#62;
	
	&#60;body&#62;
		&#60;input type="checkbox" name="item" value="8000"/&#62;空调:8000元&#60;br/&#62;
		&#60;input type="checkbox" name="item" value="160"/&#62;风扇:160元&#60;br/&#62;
		&#60;input type="checkbox" name="item" value="4500"/&#62;电脑:4500元&#60;br/&#62;
		&#60;input type="checkbox" name="item" value="5000"/&#62;投影仪:5000元&#60;br/&#62;
		&#60;input type="checkbox" onclick="checkAll(this)"/&#62;全选&#60;br/&#62;
		&#60;input type="button" value="总金额是：" onclick="getSum()"&#62;&#60;span id="sumid"&#62; &#60;/span&#62;
	&#60;/body&#62;
&#60;/html&#62;

```

&#60;font color="red"&#62;360浏览器8.1 演示结果:&#60;/font&#62;
---------------
![](http://img.blog.csdn.net/20160620165128347)

![](http://img.blog.csdn.net/20160620165138024)

![](http://img.blog.csdn.net/20160620165147050)




checkbox的使用2：
=============
仿邮件选择的方式做多选框
table.css:

```
table{
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
.one{
	background-color:#80ff00;
}
.two{
	background-color:#ff80ff;
}
.over{
	background-color:#ffff00;
}

```

第一种方式：
代码：

```
&#60;html&#62;
	&#60;head&#62;
	&#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
	&#60;title&#62;DHTML技术演示---checkbox的使用2&#60;/title&#62;
	&#60;style type="text/css"&#62;
		@import url(table.css);
	&#60;/style&#62;
	
	&#60;script type="text/javascript"&#62;
		var name;
		function trColor(){
			var oTableNode = document.getElementById("mailTable");
			var collTrNodes = oTableNode.rows;//得到表格的所有行对象-返回数组
			for(var x=1; x&#60;collTrNodes.length;x++ ){
				if(x%2==1){
					collTrNodes[x].className="one";
				}else{
					collTrNodes[x].className="two";
				}
				collTrNodes[x].onmouseover=function(){
					name=this.className;
					this.className="over";
					/*下面这种注册事件的方式也可以
					this.onmouseout=function(){
						this.className=name;
					}
					*/
				}
				collTrNodes[x].onmouseout=function(){
					this.className=name;
				}
			}
		}
		onload = function(){
			trColor();
		}
		
		function checkAll(aChkboxNode){
			var collChkboxAllNodes = document.getElementsByName("all");
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x&#60;collMailNodes.length;x++){
				collMailNodes[x].checked = aChkboxNode.checked;
			}
			collChkboxAllNodes[0].checked = aChkboxNode.checked;
			collChkboxAllNodes[1].checked = aChkboxNode.checked;
		}
		
		function checkAllByBtn1(flag){
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x&#60;collMailNodes.length;x++){
				collMailNodes[x].checked = flag;
			}
			var collChkboxAllNodes = document.getElementsByName("all");
			collChkboxAllNodes[0].checked = flag;
			collChkboxAllNodes[1].checked = flag;
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
		}
		
		function checkAllByBtn2(){
			var collMailNodes = document.getElementsByName("mail");
			var n=0;
			for(var x=0;x&#60;collMailNodes.length;x++ ){
				collMailNodes[x].checked = !collMailNodes[x].checked;
				if( collMailNodes[x].checked ){
					n++;
				}
			}
			var collChkboxAllNodes = document.getElementsByName("all");
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			if(n==0){
				collChkboxAllNodes[0].checked = false;
				collChkboxAllNodes[1].checked = false;
			}else if(n==collMailNodes.length){
				collChkboxAllNodes[0].checked = true;
				collChkboxAllNodes[1].checked = true;
			}else{//部分选中时的显示样式
				collChkboxAllNodes[0].indeterminate=true;
				collChkboxAllNodes[1].indeterminate=true;
			}
		}
		
		function deleteMail(){
			if(!confirm("你真的要删除所选邮件吗？")){//弹出确认对话框
				return;
			}
			
			//获取所有的邮件
			var collMailChkNodes = document.getElementsByName("mail");
			for(var x=0;x&#60;collMailChkNodes.length;x++){
				if (collMailChkNodes[x].checked) {//选中，则删除
					//先拿到tr对象
					var oTrNode = collMailChkNodes[x].parentNode.parentNode;
					oTrNode.parentNode.removeChild(oTrNode);
					//bug:节点容器中，remove之后，长度会变。
					x--;//长度修正--还有一种解决方案是：从后往前删
				}
			}
			trColor();			
		}
		
		
	&#60;/script&#62;
	
	
	&#60;/head&#62;
	
	&#60;body&#62;
		&#60;h2&#62;邮件列表&#60;/h2&#62;
		&#60;table id="mailTable"&#62;
			&#60;tr&#62;
				&#60;th&#62;&#60;input type="checkbox" name="all" onclick="checkAll(this)"/&#62;全选&#60;/th&#62;
				
				&#60;th&#62;发件人&#60;/th&#62; &#60;th&#62;邮件标题&#60;/th&#62; &#60;th&#62;时间&#60;/th&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张三&#60;/td&#62;  &#60;td&#62;邮件标题11&#60;/td&#62; &#60;td&#62;2016年6月16日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;李四&#60;/td&#62;  &#60;td&#62;邮件标题22&#60;/td&#62; &#60;td&#62;2016年6月15日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张四&#60;/td&#62;  &#60;td&#62;邮件标题33&#60;/td&#62; &#60;td&#62;2016年6月14日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;Jack&#60;/td&#62;  &#60;td&#62;邮件标题44&#60;/td&#62; &#60;td&#62;2016年6月18日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;Rose&#60;/td&#62;  &#60;td&#62;邮件标题55&#60;/td&#62; &#60;td&#62;2016年6月25日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张六&#60;/td&#62;  &#60;td&#62;邮件标题66&#60;/td&#62; &#60;td&#62;2016年6月16日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="all" onClick="checkAll(this)"/&#62;全选&#60;/td&#62;
				
				&#60;td colspan="3"&#62;
				&#60;!--colspan=3-表示这一列占3列 --&#62;
				&#60;input type="button" value="全选" onclick="checkAllByBtn1(true)"&#62;
			  	&#60;input type="button" value="取消全选" onclick="checkAllByBtn1(false)"&#62;
			  	&#60;input type="button" value="反选" onclick="checkAllByBtn2()"&#62;
				
				&#60;input type="button" value="删除所选邮件" onClick="deleteMail()"&#62;
				&#60;/td&#62;
			&#60;/tr&#62;
			
			
		&#60;/table&#62;
		
	&#60;/body&#62;
&#60;/html&#62;

```

第二中方式：把2个方法合并为一个方法：

```
&#60;html&#62;
	&#60;head&#62;
	&#60;meta http-equiv="Content-Type" content="text/html; charset=utf-8" /&#62;
	&#60;title&#62;DHTML技术演示---checkbox的使用2&#60;/title&#62;
	&#60;style type="text/css"&#62;
		@import url(table.css);
	&#60;/style&#62;
	
	&#60;script type="text/javascript"&#62;
		var name;
		function trColor(){
			var oTableNode = document.getElementById("mailTable");
			var collTrNodes = oTableNode.rows;//得到表格的所有行对象-返回数组
			for(var x=1; x&#60;collTrNodes.length;x++ ){
				if(x%2==1){
					collTrNodes[x].className="one";
				}else{
					collTrNodes[x].className="two";
				}
				collTrNodes[x].onmouseover=function(){
					name=this.className;
					this.className="over";
					/*下面这种注册事件的方式也可以
					this.onmouseout=function(){
						this.className=name;
					}
					*/
				}
				collTrNodes[x].onmouseout=function(){
					this.className=name;
				}
			}
		}
		onload = function(){
			trColor();
		}
		
		function checkAll(aChkboxNode){
			var collChkboxAllNodes = document.getElementsByName("all");
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var collMailNodes = document.getElementsByName("mail");
			for(var x=0;x&#60;collMailNodes.length;x++){
				collMailNodes[x].checked = aChkboxNode.checked;
			}
			collChkboxAllNodes[0].checked = aChkboxNode.checked;
			collChkboxAllNodes[1].checked = aChkboxNode.checked;
		}
		
		//合并的方法：
		function checkAllByBtn(num){
			//获得邮件的所有多选框对象
			var collMailNodes = document.getElementsByName("mail");
			
			var collChkboxAllNodes = document.getElementsByName("all");//获得那2个全选的多选框
			//取消部分选中时的显示样式
			collChkboxAllNodes[0].indeterminate=false;
			collChkboxAllNodes[1].indeterminate=false;
			
			var n=0;
			//遍历所有的邮件多选框
			for(var x=0;x&#60;collMailNodes.length;x++){
				if(num&#62;1){//反选
				  collMailNodes[x].checked = !collMailNodes[x].checked;
				}else{
				   collMailNodes[x].checked = num;
				}
				if(collMailNodes[x].checked){
					n++;
				}
			}
			
			if(n==0){
				collChkboxAllNodes[0].checked = false;
				collChkboxAllNodes[1].checked = false;
			}else if(n==collMailNodes.length){
				collChkboxAllNodes[0].checked = true;
				collChkboxAllNodes[1].checked = true;
			}else{//部分选中时的显示样式
				collChkboxAllNodes[0].indeterminate=true;
				collChkboxAllNodes[1].indeterminate=true;
			}
			
		}
		
		
		
		function deleteMail(){
			if(!confirm("你真的要删除所选邮件吗？")){//弹出确认对话框
				return;
			}
			
			//获取所有的邮件
			var collMailChkNodes = document.getElementsByName("mail");
			for(var x=0;x&#60;collMailChkNodes.length;x++){
				if (collMailChkNodes[x].checked) {//选中，则删除
					//先拿到tr对象
					var oTrNode = collMailChkNodes[x].parentNode.parentNode;
					oTrNode.parentNode.removeChild(oTrNode);
					//bug:节点容器中，remove之后，长度会变。
					x--;//长度修正--还有一种解决方案是：从后往前删
				}
			}
			trColor();			
		}
		
		
	&#60;/script&#62;
	
	
	&#60;/head&#62;
	
	&#60;body&#62;
		&#60;h2&#62;邮件列表&#60;/h2&#62;
		&#60;table id="mailTable"&#62;
			&#60;tr&#62;
				&#60;th&#62;&#60;input type="checkbox" name="all" onclick="checkAll(this)"/&#62;全选&#60;/th&#62;
				
				&#60;th&#62;发件人&#60;/th&#62; &#60;th&#62;邮件标题&#60;/th&#62; &#60;th&#62;时间&#60;/th&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张三&#60;/td&#62;  &#60;td&#62;邮件标题11&#60;/td&#62; &#60;td&#62;2016年6月16日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;李四&#60;/td&#62;  &#60;td&#62;邮件标题22&#60;/td&#62; &#60;td&#62;2016年6月15日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张四&#60;/td&#62;  &#60;td&#62;邮件标题33&#60;/td&#62; &#60;td&#62;2016年6月14日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;Jack&#60;/td&#62;  &#60;td&#62;邮件标题44&#60;/td&#62; &#60;td&#62;2016年6月18日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;Rose&#60;/td&#62;  &#60;td&#62;邮件标题55&#60;/td&#62; &#60;td&#62;2016年6月25日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="mail" /&#62;&#60;/td&#62;
				&#60;td&#62;张六&#60;/td&#62;  &#60;td&#62;邮件标题66&#60;/td&#62; &#60;td&#62;2016年6月16日&#60;/td&#62;
			&#60;/tr&#62;
			&#60;tr&#62;
				&#60;td&#62;&#60;input type="checkbox" name="all" onClick="checkAll(this)"/&#62;全选&#60;/td&#62;
				
				&#60;td colspan="3"&#62;
				&#60;!--colspan=3-表示这一列占3列 --&#62;
				 &#60;input type="button" value="全选" onClick="checkAllByBtn(1)"&#62;
			 	 &#60;input type="button" value="取消全选" onClick="checkAllByBtn(0)"&#62;
			  	 &#60;input type="button" value="反选" onClick="checkAllByBtn(2)"&#62;
			  	 &#60;input type="button" value="删除所选邮件" onClick="deleteMail()"&#62;
				&#60;/td&#62;
			&#60;/tr&#62;
			
			
		&#60;/table&#62;
		
	&#60;/body&#62;
&#60;/html&#62;

```

360浏览器8.1演示结果：

![](http://img.blog.csdn.net/20160621195201173)

![](http://img.blog.csdn.net/20160621195209833)

![](http://img.blog.csdn.net/20160621195217536)

