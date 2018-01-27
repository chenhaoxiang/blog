---
layout: post
title: "【Apache】Apache ab压力测试工具Window下载和用法详解"
date: 2018-01-26 20:44:54 +0800
comments: true
categories: Apache
tags: [Apache]
keyword: 陈浩翔, 谙忆, 压力测试, Apache, ab
description:  Apache ab压力测试工具Window下载和用法详解
---

ab是apache自带的网站压力测试工具。    
使用起来非常的简单和方便。
不仅仅是可以apache服务器进行网站访问压力测试，还可以对其他类型的服务器进行压力测试。  
比如nginx,tomcat，IIS等  

首先当然是下载安装了。  
在这里只讲window下在下载安装  
官方下载地址：,<a href="https://www.apachehaus.com/cgi-bin/download.plx" tager="_blank">(https://www.apachehaus.com/cgi-bin/download.plx)</a>

![](https://i.imgur.com/BTlqvNq.png)  

下载完成后解压  
我就直接解压到d盘的apacheab中去了 
修改解压根目录下的conf/httpd.conf文件的端口配置，默认是80端口，应该是被占用了，无法安装，可以自行修改为其他，我在这里修改为8088端口 

![](https://i.imgur.com/qU37yg3.png)  

然后输入命令安装：  
```java
httpd -k install
```

![](https://i.imgur.com/DioBUk8.png)  

第一次安装错误是因为端口没有改，被占用了，应该是被iis占用的。  

接下来就是测试了  

# 开始测试 

如果你需要在命令行的任意路径下可以输入ab测试，可以把bin目录路径加到环境变量的path中去  

我是在bin目录下打开命令行的  
注意，下面的是错误的，因为需要在域名后加上/path
```
ab -n 100 -c 10 http://www.baidu.com
``` 
报错信息如下:
```
ab: invalid URL
Usage: ab [options] [http://]hostname[:port]/path
```
必须要接有path  
所以我换一下测试命令:
```
ab -n 100 -c 10 http://www.baidu.com/s
```
-n 表示请求数，-c 表示并发数.  
s为path，表示指定测试地址，不指定可能会报"ab: invalid url" 错误.  
另外还有-t 表示多少s内并发和请求  


测试出来的数据如下:
```
D:\apacheab\Apache24\bin>ab -n 100 -c 10 http://www.baidu.com/s
This is ApacheBench, Version 2.3 <$Revision: 1807734 $> 
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking www.baidu.com (be patient).....done


Server Software:        BWS/1.1   
##服务器软件和版本
Server Hostname:        www.baidu.com  
##请求的地址/域名
Server Port:            80   
##端口

Document Path:          /s  
##请求的路径
Document Length:        112435 bytes  
##页面数据/返回的数据量

Concurrency Level:      10   
##并发数
Time taken for tests:   4.764 seconds  
##共使用了多少时间 
Complete requests:      100  
##请求数 
Failed requests:        99  
##失败请求  百度为什么失败这么多，应该是百度做了防范  
   (Connect: 0, Receive: 0, Length: 99, Exceptions: 0)
Total transferred:      11342771 bytes  
##总共传输字节数，包含http的头信息等 
HTML transferred:       11247622 bytes  
##html字节数，实际的页面传递字节数 
Requests per second:    20.99 [#/sec] (mean) 
 ##每秒多少请求，这个是非常重要的参数数值，服务器的吞吐量 
Time per request:       476.427 [ms] (mean)   
##用户平均请求等待时间 
Time per request:       47.643 [ms] (mean, across all concurrent requests)  
##服务器平均处理时间，也就是服务器吞吐量的倒数 
Transfer rate:          2325.00 [Kbytes/sec] received
 ##每秒获取的数据长度

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:       22   41  12.4     39      82
##连接的最小时间，平均值，中值，最大值
Processing:   113  386 211.1    330    1246
##处理时间
Waiting:       25   80  43.9     73     266
##等待时间
Total:        152  427 210.1    373    1283
##合计时间

Percentage of the requests served within a certain time (ms)
  50%    373   
## 50%的请求在373ms内返回 
  66%    400   
## 60%的请求在400ms内返回 
  75%    426
  80%    465
  90%    761
  95%    930
  98%   1192
  99%   1283
 100%   1283 (longest request)
```

因为ab工具消耗小，所以有些人也用来进行ddos攻击，算一种ddos攻击工具 

本文章由<a href="chenhaoxiang" target='_blank'>[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn/2018/01/26/0920-2/'><font color="green">http://chenhaoxiang.cn/2018/01/26/0920-2/</font></a><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>谙忆的博客</a>】</strong></p>
</blockquote>
 
