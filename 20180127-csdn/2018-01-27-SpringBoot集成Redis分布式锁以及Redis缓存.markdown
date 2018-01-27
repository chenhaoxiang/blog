---
layout: post
title: "【Redis】SpringBoot集成Redis分布式锁以及Redis缓存"
date: 2018-01-27 00:05:54 +0800
comments: true
categories: Apache
tags: [Apache]
keyword: 陈浩翔, 谙忆, Redis, SpringBoot
description:  SpringBoot集成Redis缓存并使用
---

# 集成Redis

首先在pom.xml中加入需要的redis依赖和缓存依赖    
```xml
<!-- 引入redis依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!-- 缓存的依赖-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-start-cache</artifactId>
</dependency>
```
第二个spring-boot-start-cache的依赖，是使用缓存注解需要的，我在项目中没有引入。
因为我在websocket中已经引入了。 
查询依赖关系 ctrl+shift+alt+u 快捷键(也可以在pom.xml文件上右键->Maven->Show Dependencies...)查询maven包依赖引入关系，ctrl+f搜索包  

SpringBoot的yml配置文件下增加redis的配置:
```xml
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    password: chenhaoxiang
```
输入你自己Redis服务器的地址，端口和密码，没有密码的就不要password了。  

# 实现Redis分布式锁

在类中直接使用如下代码即可注入Redis的操作类
```
@Autowired
private StringRedisTemplate stringRedisTemplate;//可以写很多类型的值
```

## 简单的操作
更多的Redis内容请看: <a href="http://redis.cn/" target='_blank'>http://redis.cn/</a>  

set
```java
//设置key-value和过期时间
stringRedisTemplate.opsForValue().set("key","value",7200, TimeUnit.SECONDS);//key,value,过期时间,时间单位 s
```
使用存储的时候，最后要设置一个过期时间，就算是几年，你也要设置一个过期时间。否则会一直占用存储空间的  

delete
```java
stringRedisTemplate.opsForValue().getOperations().delete("key");//删除key对应的键值对
```

get
```java
stringRedisTemplate.opsForValue().get("key");//获取对应key的value
```
## 分布式锁
接下来就是讲分布式锁了。  
假设在一个活动中，商品的特价出售，限时秒杀场景。比如双11的。  
通常的做法，有乐观锁和悲观锁  
介绍乐观锁和悲观锁是什么我就不介绍了。 
其实这里的Redis分布式锁也算是一种乐观锁。也就是即使资源被锁了，后来的用户不会被阻塞，而是返回异常/信息给你，告诉你操作(在这里是抢购)不成功。  

实现起来很简单。看下面的类:  
```java
package cn.chenhaoxiang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2018/1/26.
 * Time: 下午 10:05.
 * Explain:Redis分布式锁
 */
@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param key productId - 商品的唯一标志
     * @param value  当前时间+超时时间 也就是时间戳
     * @return
     */
    public boolean lock(String key,String value){
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){//对应setnx命令
            //可以成功设置,也就是key不存在
            return true;
        }
		
        //判断锁超时 - 防止原来的操作异常，没有运行解锁操作  防止死锁
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){//currentValue不为空且小于当前时间
            //获取上一个锁的时间value
            String oldValue =stringRedisTemplate.opsForValue().getAndSet(key,value);//对应getset，如果key存在

            //假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentValue=A(get取的旧的值肯定是一样的),两个线程的value都是B,key都是K.锁时间已经过期了。
            //而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的value已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue) ){
                //oldValue不为空且oldValue等于currentValue，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value) ){
                stringRedisTemplate.opsForValue().getOperations().delete(key);//删除key
            }
        } catch (Exception e) {
            log.error("[Redis分布式锁] 解锁出现异常了，{}",e);
        }
    }

}

```
这个是Redis加锁和解锁的工具类   
里面使用的主要是两个命令，SETNX和GETSET。  
SETNX命令  将key设置值为value，如果key不存在，这种情况下等同SET命令。 当key存在时，什么也不做  
GETSET命令  先查询出原来的值，值不存在就返回nil。然后再设置值  
对应的Java方法在代码中提示了。  
注意一点的是，Redis是单线程的！所以在执行GETSET和SETNX不会存在并发的情况。  

下面来看我们使用该类加锁解锁的类：
```java
package cn.chenhaoxiang.service.impl;

import cn.chenhaoxiang.exception.SellException;
import cn.chenhaoxiang.service.RedisLock;
import cn.chenhaoxiang.service.SeckillService;
import cn.chenhaoxiang.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2018/1/26.
 * Time: 下午 9:30.
 * Explain:
 */
@Service
public class SeckillServiceImpl implements SeckillService{

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10*1000;//超时时间 10s

    /**
     * 活动，特价，限量100000份
     */
    static Map<String,Integer> products;//模拟商品信息表
    static Map<String,Integer> stock;//模拟库存表
    static Map<String,String> orders;//模拟下单成功用户表
    static {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
          */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",100000);
        stock.put("123456",100000);
    }

    private String queryMap(String productId){//模拟查询数据库
        return "国庆活动，皮蛋特教，限量"
                +products.get(productId)
                +"份,还剩:"+stock.get(productId)
                +"份,该商品成功下单用户数:"
                +orders.size()+"人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    //解决方法二，基于Redis的分布式锁 http://redis.cn/commands/setnx.html  http://redis.cn/commands/getset.html
    //SETNX命令  将key设置值为value，如果key不存在，这种情况下等同SET命令。 当key存在时，什么也不做
    // GETSET命令  先查询出原来的值，值不存在就返回nil。然后再设置值
    //支持分布式，可以更细粒度的控制
    //多台机器上多个线程对一个数据进行操作的互斥。
    //Redis是单线程的!!!
    @Override
    public void orderProductMocckDiffUser(String productId) {//解决方法一:synchronized锁方法是可以解决的，但是请求会变慢,请求变慢是正常的。主要是没做到细粒度控制。比如有很多商品的秒杀，但是这个把所有商品的秒杀都锁住了。而且这个只适合单机的情况，不适合集群

        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101,"很抱歉，人太多了，换个姿势再试试~~");
        }

        //1.查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if(stockNum==0){
            throw new SellException(100,"活动结束");
        }else {
            //2.下单
            orders.put(KeyUtil.getUniqueKey(),productId);
            //3.减库存
            stockNum =stockNum-1;//不做处理的话，高并发下会出现超卖的情况，下单数，大于减库存的情况。虽然这里减了，但由于并发，减的库存还没存到map中去。新的并发拿到的是原来的库存
            try{
                Thread.sleep(100);//模拟减库存的处理时间
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        //解锁
        redisLock.unlock(productId,String.valueOf(time));

    }
}
```
在上面是用Map来模拟查询数据库的操作了，sleep是为了模拟一些io操作的时间  
你可以用apache ab工具进行高并发模拟。  

# Redis缓存

接下来就讲下缓存了  
首先当然是导入Maven依赖咯  
接下来就是在springboot启动类上加上注解:
```java
@EnableCaching //缓存支持  配置Redis缓存需要的
```
因为我们上面已经在配置文件配置好了 redis的地址，账号。就不需要再配置了。  
下面你就可以使用注解缓存了  

## 在Controller层的使用
```java
//Redis缓存注解  Cacheable第一次访问会访问到方内的内容，方法会返回一个对象，返回对象的时候，会把这个对象存储。下一次访问的时候，不会进去这个方法，直接从redis缓存中拿
@Cacheable(cacheNames = "product",key = "123")
public ResultVO list(){
...
}
```
在这里，product其实就相当于一个命名空间。key的话，在更新缓存，删除缓存的时候用到的。  
注意，方法返回的对象加了缓存注解的，一定要实现序列化!  

然后，我们可以在增删改的地方加上删除缓存，或者更新缓存的注解。  
```java
@CacheEvict(cacheNames = "product",key = "123") //访问这个方法之后删除对应的缓存  对应之前的Redis缓存注解的配置 。key如果不填，默认是空，对应的值应该就是方法的参数的值了.对应BuyerProductController-list方法的缓存
//    @CachePut(cacheNames = "product",key = "123") //对应之前的Redis缓存注解的配置
    //@CachePut 每次还是会执行方法中的内容，每次执行完成后会把返回的内容放到Redis中去.
    // 这种注解和原来对应的返回对象需要是相同的才行，这里返回的是ModelAndView。可以到service层注解或者dao层注解CachePut
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String,Object> map){
 ...
}
```
但是假如我们不想使用CacheEvict删除缓存呢，只希望更新缓存呢，但是这里的返回值是ModelAndView,和前面的ResultVO不一样，而且无法序列化ModelAndView。所以在这里写注解，肯定只能是删除缓存的注解CacheEvict  
其实我们可以去service层写缓存注解的，或者是Dao层，这样，返回对象是受我们控制的了。  

## 在service层使用缓存

在整个类上注解
```java
@CacheConfig(cacheNames = "product") //配置整个类的缓存cacheNames,相当于作用域
```
这样，这个类下的方法就不用再写cacheNames了 。  

```java
@Cacheable(key = "123") //注解缓存
public ProductInfo findOne(String productInfoId) {
    return productInfoDao.findOne(productInfoId);
}
```

```java
@CachePut(key = "123") //和上面findOne的返回对象对应
public ProductInfo save(ProductInfo productInfo) {
    return productInfoDao.save(productInfo);
}
```

## 缓存注解的另外一些值
key我们是可以动态设置的
```java
@Cacheable(cacheNames = "product",key = "#sellerId")//sellerId为方法中的参数名，这样，key就是动态配置了
public ResultVO list(String sellerId){
...
}
```

可以根据参数来进行判断，是否缓存
```java
@Cacheable(cacheNames = "product",key = "#sellerId"，condition = "#sellerId.length() > 3")
public ResultVO list(String sellerId){
...
}
```
这样只有条件成立才会直接返回缓存，结果不成立是不缓存的，即使有缓存，也会运行方法  

还可以根据返回结果来判断是不是缓存这个结果  
```java
@Cacheable(cacheNames = "product",key = "#sellerId"，unless = "#result.getCode() != 0")
public ResultVO list(String sellerId){
...
}
```
依据结果来判断是否缓存 unless = "#result.getCode() != 0",#result其实就是ResultVO，也就是返回的对象  
unless(除什么之外,如果不 的意思) 如果=0就缓存，需要写成!=0。理解起来就是，除了不等于0的情况之外，才缓存，也就是等于0才缓存。  
其实就是，你想要什么条件下缓存，你写在这里面，把条件反过来写就行了  

  
你如果测试缓存的话，你可以在方法内打一个断点进行测试。没有运行那个方法就获取到数据了，证明缓存生效了。  


最后，注意，返回的缓存对象一定要实现序列化！！！

# 项目地址：
<blockquote cite='陈浩翔'>
GITHUB源码下载地址:<strong>【<a href='https://github.com/chenhaoxiang/WeChatOrderSystem' target='_blank'>点我进行访问</a>】</strong>
</blockquote>


本文章由<a href="chenhaoxiang" target='_blank'>[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn/2018/01/27/0104/'><font color="green">http://chenhaoxiang.cn/2018/01/27/0104/</font></a><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>谙忆的博客</a>】</strong></p>
</blockquote>

