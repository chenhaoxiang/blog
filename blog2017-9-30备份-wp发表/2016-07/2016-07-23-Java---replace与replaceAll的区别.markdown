---
layout: post
title: "Java---replace与replaceAll的区别"
date: 2016-07-23 02:07:21 +0800
comments: true
categories:❷ Java大学之行,----- ③、Java知识点及应用
tags: []
keyword: 陈浩翔, 谙忆
description: 乍一看，字面上理解好像replace只替换第一个出现的字符（受javascript的影响），replaceall替换所有的字符，其实大不然，只是替换的用途不一样。




这两者很容易搞混，在这里详细讲述下。




我们先看下JAVA_API的说明：



public String replace(char oldChar,char newChar)

使用指定 
---


乍一看，字面上理解好像replace只替换第一个出现的字符（受javascript的影响），replaceall替换所有的字符，其实大不然，只是替换的用途不一样。




这两者很容易搞混，在这里详细讲述下。




我们先看下JAVA_API的说明：



public String replace(char oldChar,char newChar)

使用指定
&#60;!-- more --&#62;
----------


&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; line-height:25px"&#62;乍一看，字面上理解好像replace只替换第一个出现的字符（受javascript的影响），replaceall替换所有的字符，其实大不然，只是替换的用途不一样。&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; line-height:25px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
这两者很容易搞混，在这里详细讲述下。&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;br&#62;
&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
我们先看下JAVA_API的说明：&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;/p&#62;
&#60;p style="padding-top:0px; padding-bottom:0px; margin-top:0px; margin-bottom:0px; text-indent:2em; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px"&#62;
public String replace(char oldChar,char newChar)&#60;/p&#62;
&#60;p style="padding-top:0px; padding-bottom:0px; margin-top:0px; margin-bottom:0px; text-indent:2em; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px"&#62;
&#60;span style="color:rgb(85,85,85); font-family:'Hiragino Sans GB W3','Hiragino Sans GB',Arial,Helvetica,simsun,u5b8bu4f53; font-size:16px; line-height:28px"&#62;使用指定的字面&#20540;替换序列替换此字符串所有匹配字面&#20540;目标序列的子字符串。该替换从字符串的开头朝末尾执行，例如，用 &quot;b&quot; 替换字符串 &quot;aaa&quot; 中的 &quot;aa&quot; 将生成 &quot;ba&quot; 而不是 &quot;ab&quot;。&#60;/span&#62;&#60;br&#62;
&#60;/p&#62;
&#60;p style="padding-top:0px; padding-bottom:0px; margin-top:0px; margin-bottom:0px; text-indent:2em; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px"&#62;
&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 而生成的。 如 果 oldChar 在此 String 对象表示的字符序列中没有出现，则返回对此 String 对象的引用。否则，创建一个新的 String 对象，用来表示与此 String 对象表示的字符序列相等的字符序列，除了每个出现的 oldChar 都被一个 newChar 替换之外。&#60;/p&#62;
&#60;p style="padding-top:0px; padding-bottom:0px; margin-top:0px; margin-bottom:0px; text-indent:2em; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px"&#62;
&#60;br style="padding:0px; margin:0px"&#62;
&nbsp; &nbsp; &nbsp;public String replaceAll(String regex,String replacement)&#60;/p&#62;
&#60;p style="padding-top:0px; padding-bottom:0px; margin-top:0px; margin-bottom:0px; text-indent:2em; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px"&#62;
&nbsp; 使用给定的 replacement 字符串替换此字符串匹配给定的正则表达式的每个子字符串。此方法调用的 str.replaceAll(regex, repl) 形式产生与以下表达式完全相同的结果：&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;Pattern.compile(regex).matcher(str).replaceAll(repl)&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;参数：&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;regex – 用来匹配此字符串的正则表达式&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;返回：得到的 String&#60;br style="padding:0px; margin:0px"&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;抛出： PatternSyntaxException – 如果正则表达式的语法无效。&#60;/p&#62;
&#60;span style="white-space:pre"&#62;&#60;/span&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:arial,'courier new',courier,宋体,monospace,'Microsoft YaHei'; line-height:24px; white-space:pre-wrap; text-indent:2em; background-color:rgb(243,255,236)"&#62;有一点注意:执行了替换操作后,源字符串的内容是没有发生改变的.
&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;br&#62;
&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
replace的参数是char和CharSequence，即可以支持字符的替换，也支持字符串的替换（CharSequence即字符串序列的意思,说白了也就是字符串）；&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
replaceAll的参数是regex，即基于规则表达式的替换，比如：可以通过replaceAll(&quot;\\d&quot;, &quot;*&quot;)把一个字符串所有的数字字符都换成星号；&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
相同点：都是全部替换，即把源字符串中的某一字符或字符串全部换成指定的字符或字符串；&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
不同点：replaceAll支持正则表达式，因此会对参数进行解析（两个参数均是），如replaceAll(&quot;\\d&quot;, &quot;*&quot;)，而replace则不会，replace(&quot;\\d&quot;,&quot;*&quot;)就是替换&quot;\\d&quot;的字符串，而不会解析为正则。&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:arial,'courier new',courier,宋体,monospace,'Microsoft YaHei'; line-height:24px; white-space:pre-wrap; text-indent:2em; background-color:rgb(243,255,236)"&#62;&#60;strong&#62;&#60;br&#62;
&#60;/strong&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px"&#62;
&#60;span style="text-indent:2em"&#62;&#60;span style="font-size:18px; white-space:pre"&#62;&#60;/span&#62;&#60;span style="font-size:18px"&#62;另外,如果replaceAll()和replaceFirst()所用的参数据不是基于规则表达式的,则与replace()替换字符串的效果是一样的,即这两者也支持字符串的操作;
&#60;/span&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="font-family:Arial; font-size:14px; line-height:26px; text-indent:28px"&#62;用正则表达式仅仅是替换全部或替换第一个的话，用replaceAll或replaceFirst即可。&#60;/span&#62;&#60;br&#62;
&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;br&#62;
&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px"&#62;
&#60;/p&#62;
&#60;pre id="best-content-1870689986" class="best-text mb-10" style="margin-top:0px; margin-bottom:10px; padding:0px; word-wrap:break-word"&#62;&#60;span style="font-size:18px"&#62;&#60;span style="white-space:pre"&#62;	简单&#60;/span&#62;举例如下: 
        
        String src = new String(&quot;ab43a2c43d&quot;); 

        System.out.println(src.replace(&quot;3&quot;,&quot;f&quot;));=&gt;ab4f2c4fd. 
        System.out.println(src.replace('3','f'));=&gt;ab4f2c4fd. 
        System.out.println(src.replaceAll(&quot;\\d&quot;,&quot;f&quot;));=&gt;abffafcffd. 
        System.out.println(src.replaceAll(&quot;a&quot;,&quot;f&quot;));=&gt;fb43fc23d. 
        System.out.println(src.replaceFirst(&quot;\\d,&quot;f&quot;));=&gt;abf32c43d 
        System.out.println(src.replaceFirst(&quot;4&quot;,&quot;h&quot;));=&gt;abh32c43d.&#60;/span&#62;&#60;/pre&#62;
&#60;br&#62;
&#60;p&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;br&#62;
&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
另外还有一个不同点：“\”在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println( &quot;\\&quot; ) ;只打印出一个&quot;\&quot;。但是“\”也是正则表达式中的转义字符，需要用两个代表一个。所以：\\\\被java转换成\\，\\又被正则表达式转换成\，因此用replaceAll替换“\”为&quot;\\&quot;，就要用replaceAll(&quot;\\\\&quot;,&quot;\\\\\\\\&quot;)，而replace则replace(&quot;\\&quot;,&quot;\\\\&quot;)。&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
如果只想替换第一次出现的，可以使用replaceFirst()，这个方法也是基于规则表达式的替换，但与replaceAll()不同的是，只替换第一次出现的字符串。&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&nbsp;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;实际应用：&#60;/span&#62;&#60;br style="padding:0px; margin:0px; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;&#60;span style="white-space:pre"&#62;&#60;/span&#62;&#60;/span&#62;&#60;pre code_snippet_id="1779093" snippet_file_name="blog_20160723_1_6222677"  name="code" class="java"&#62;public static void main(String[] arg) throws OgnlException {
		String s =”sdf\\a\\aa”;
		//把s中的反斜杠\ 替换为\\
		System.out.println(s);
		System.out.println(s.replaceAll(“\\\\”, “\\\\\\\\”));
		System.out.println(s.replace(“\\”, “\\\\”));
	}&#60;/pre&#62;&#60;br&#62;
&#60;br style="padding:0px; margin:0px; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;可以看出上面两种都返回相同的替换结果。&#60;/span&#62;&#60;br style="padding:0px; margin:0px; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;这 里的关键是String.replaceAll()是用regular expression 来作为参数的。但是java本身的字符串对于转义符\也有类&#20284;的处理。首先，java会把“\\\\”解释成一个字符串(其中包含两个char)——“\ \”这个就是你在JDK的文档里看到的。&#60;/span&#62;&#60;br style="padding:0px; margin:0px; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;接下来，由于replaceAll是以正则表达式作为参数，所以“\\”被解释成一个regex。对于一个regex来说这就代表着一个字符，就是“\”。对后面的那个8个\来说，最终会被解释成“\\”。&#60;/span&#62;&#60;br style="padding:0px; margin:0px; color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;换言之，假设String.replaceAll()是以普通字符串，而不是regex作为参数，那么这样写代码: String target = source.replaceAll(‘\\’, ‘\\\\’); 就可以了。&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;性能比较：&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px"&#62;
&#60;span style="text-indent:28px"&#62;&#60;span style="font-size:18px"&#62;&nbsp; &nbsp; &nbsp;如果我们能确定字符串替换，用replace性能略好！如果有大量不确定字符串，replaceAll&#43;正则性能会更好！&#60;/span&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
&#60;span style="color:rgb(51,51,51); font-family:Verdana,Arial,Tahoma; font-size:14px; line-height:25px; text-indent:28px"&#62;&#60;span style="color:rgb(254,32,164); font-family:simsun; font-size:14px; line-height:21px; background-color:rgb(234,236,249)"&#62;&#60;br&#62;
&#60;/span&#62;&#60;/span&#62;&#60;/p&#62;
&#60;p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px; text-indent:2em"&#62;
(网上整理来的~)&#60;/p&#62;
