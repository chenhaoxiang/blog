---
layout: post
title: "【Redis】Java之Redis工具类"
date: 2017-05-18 10:00:59 +0800
comments: true
categories:❷ Java大学之行,----- ⑤、数据库
tags: [redis,java,spring]
keyword: 陈浩翔, 谙忆
description: 我就不介绍Redis是什么了。 
(一个月前写的工具类，一直忘记分享了，算是比较全的Java-Redis工具类) 
直接上代码吧。先给出在spring 中配置Redis的代码。你在其他类用的时候，直接用注解自动注入就可以了。redis.properties##访问地址
redis.host=127.0.0.1
##访问端口
redis.port=6379
##注意，如果没有password，此处不设 
---


我就不介绍Redis是什么了。 
(一个月前写的工具类，一直忘记分享了，算是比较全的Java-Redis工具类) 
直接上代码吧。先给出在spring 中配置Redis的代码。你在其他类用的时候，直接用注解自动注入就可以了。redis.properties##访问地址
redis.host=127.0.0.1
##访问端口
redis.port=6379
##注意，如果没有password，此处不设
&#60;!-- more --&#62;
----------

---
layout: post
title: "【Redis】Java之Redis工具类"
date: 2017-05-18 21:29:54 +0800
comments: true
categories: java
tags: [Redis,java]
keyword: 陈浩翔, 谙忆, Redis工具类, Redis
description: Java之最全Redis工具类
---

我就不介绍Redis是什么了。
(一个月前写的工具类，一直忘记分享了，算是比较全的Java-Redis工具类)
直接上代码吧。

先给出在spring 中配置Redis的代码。你在其他类用的时候，直接用注解自动注入就可以了。
&#60;!-- more --&#62;
----------java
##redis.properties
```java
##访问地址
redis.host=127.0.0.1
##访问端口
redis.port=6379
##注意，如果没有password，此处不设置值，但这一项要保留
redis.password=你的密码

#最大能够保持idel状态的对象数
redis.maxIdle=150
#连接池的最大数据库连接数。设为0表示无限制 最大分配的对象数
redis.maxActive=300
#连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
redis.blockWhenExhausted=true
#获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
redis.maxWait=10000
#在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
redis.testOnBorrow=true
#jedis调用returnObject方法时，是否进行有效检查 #
redis.testOnReturn=true
#在空闲时检查有效性, 默认false
redis.testWhileIdle=true
#表示idle object evitor两次扫描之间要sleep的毫秒数；
redis.timeBetweenEvictionRunsMillis=30000
#表示一个对象至少停留在idle状态的最短时间，
#然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义；
redis.minEvictableIdleTimeMillis=-1

#连接空闲的最小时间,达到此值后空闲链接将会被移除,且保留“minIdle”个空闲连接数。
#如果minEvictableIdleTimeMillis&#62;0，则此项设置无意义，且只有在timeBetweenEvictionRunsMillis大于0时才有意义；
redis.softMinEvictableIdleTimeMillis=60000
```

##spring.xml中配置redis
```xml
  &#60;!-- S Redis 配置--&#62;
    &#60;!-- scanner redis properties  --&#62;
    &#60;context:property-placeholder location="classpath:redis.properties" ignore-unresolvable="true"/&#62;
    &#60;!--（1）如果你有多个数据源需要通过
    &#60;context:property-placeholder管理，且不愿意放在一个配置文件里，
    那么一定要加上ignore-unresolvable=“true"(每一个都需要加这个属性)--&#62;
    &#60;!--（2）注意新版的（从3.0版本开始弃用）JedisPoolConfig的property name，
    不是maxActive而是maxTotal，而且没有maxWait属性，建议看一下Jedis源码。--&#62;
    &#60;!-- redis连接池 --&#62;
    &#60;bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig"&#62;
        &#60;property name="maxTotal" value="${redis.maxActive}"&#62;&#60;/property&#62;
        &#60;property name="maxIdle" value="${redis.maxIdle}"&#62;&#60;/property&#62;
        &#60;property name="maxWaitMillis" value="${redis.maxWait}"&#62;&#60;/property&#62;
        &#60;property name="testOnBorrow" value="${redis.testOnBorrow}"&#62;&#60;/property&#62;
        &#60;property name="testOnReturn" value="${redis.testOnReturn}"&#62;&#60;/property&#62;
        &#60;property name="blockWhenExhausted" value="${redis.blockWhenExhausted}"&#62;&#60;/property&#62;
        &#60;property name="testWhileIdle" value="${redis.testWhileIdle}"&#62;&#60;/property&#62;
        &#60;property name="timeBetweenEvictionRunsMillis" value="${redis.timeBetweenEvictionRunsMillis}"&#62;&#60;/property&#62;
        &#60;property name="minEvictableIdleTimeMillis" value="${redis.minEvictableIdleTimeMillis}"&#62;&#60;/property&#62;
        &#60;property name="softMinEvictableIdleTimeMillis" value="${redis.softMinEvictableIdleTimeMillis}"&#62;&#60;/property&#62;
    &#60;/bean&#62;
    &#60;!-- redis连接工厂 --&#62;
    &#60;bean id="connectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory"
          p:host-name="${redis.host}" p:port="${redis.port}" p:password="${redis.password}"  p:pool-config-ref="jedisPoolConfig"
          p:usePool="true"/&#62;
    &#60;!-- redis操作模板，这里采用尽量面向对象的模板 --&#62;
    &#60;!--&#60;bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate"&#62;
        使用上句会无法使用模糊匹配
    --&#62;
    &#60;!--
        p:enable-transaction-support="false"
        设置setEnableTransactionSupport(true)，当前线程会强制先 MULTI命令
     --&#62;
    &#60;bean id="redisTemplate" class="org.springframework.data.redis.core.StringRedisTemplate"
          p:enable-transaction-support="true"&#62;
        &#60;property name="connectionFactory" ref="connectionFactory"/&#62;
        &#60;!-- 如果不配置Serializer，那么存储的时候只能使用String，如果用对象类型存储，那么会提示错误 can't cast to String！！！--&#62;
        &#60;property name="keySerializer"&#62;
            &#60;!--对key的默认序列化器。默认值是StringSerializer--&#62;
            &#60;bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/&#62;
        &#60;/property&#62;
        &#60;!--是对value的默认序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。--&#62;
        &#60;property name="valueSerializer"&#62;
            &#60;bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/&#62;
        &#60;/property&#62;
        &#60;!--存储Map时key需要的序列化配置--&#62;
        &#60;property name="hashKeySerializer"&#62;
            &#60;bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/&#62;
        &#60;/property&#62;
        &#60;!--存储Map时value需要的序列化配置--&#62;
        &#60;property name="hashValueSerializer"&#62;
            &#60;bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/&#62;
        &#60;/property&#62;
        &#60;!--开启事务
        系统自动帮我们拿到了事务中绑定的连接。可以在一个方法的多次对Redis增删该查中，始终使用同一个连接。
        --&#62;
        &#60;property name="enableTransactionSupport" value="true"/&#62;
        &#60;!--在Spring中@Transactional 也是可以进行事物控制的。--&#62;
    &#60;/bean&#62;
    &#60;!-- 缓存管理器: 使用redis 当做缓存 --&#62;
    &#60;!--&#60;bean id="cacheManager" class="org.springframework.data.redis.cache.RedisCacheManager"&#62;--&#62;
        &#60;!--&#60;constructor-arg ref="redisTemplate"/&#62;--&#62;
    &#60;!--&#60;/bean&#62;--&#62;
    &#60;!-- cache配置 --&#62;
    &#60;!-- E Redis 配置--&#62;
```

##Redis操作的接口

```java
package com.uifuture.utils.redis;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/4/10.
 * Time: 上午 12:11.
 * Explain: Redis操作的接口
 */
public interface RedisCommand&#60;K, V&#62; {

    /**
     * 用户排序通过注册时间的 权重值
     * @param date
     * @return
     */
    double getCreateTimeScore(long date);
    /**
     * 获取Redis中所有的键的key
     * @return
     */
    Set&#60;K&#62; getAllKeys();

    /**
     * 获取所有的普通key-value
     * @return
     */
    Map&#60;K,V&#62; getAllString();

    /**
     * 获取所有的Set -key-value
     * @return
     */
    Map&#60;K,Set&#60;V&#62;&#62; getAllSet();
    /**
     * 获取所有的ZSet正序  -key-value 不获取权重值
     * @return
     */
    Map&#60;K,Set&#60;V&#62;&#62; getAllZSetReverseRange();
    /**
     * 获取所有的ZSet倒序  -key-value 不获取权重值
     * @return
     */
    Map&#60;K,Set&#60;V&#62;&#62; getAllZSetRange();

    /**
     * 获取所有的List -key-value
     * @return
     */
    Map&#60;K,List&#60;V&#62;&#62; getAllList();

    /**
     * 获取所有的Map -key-value
     * @return
     */
    Map&#60;K,Map&#60;K,V&#62;&#62; getAllMap();

    /**
     * 添加一个list
     * @param key
     * @param objectList
     */
    void addList(K key, List&#60;V&#62; objectList);
    /**
     * 向list中增加值
     * @param key
     * @param obj
     * @return 返回在list中的下标
     */
    long addList(K key,V obj);
    /**
     *
     * 向list中增加值
     * @param key
     * @param obj
     * @return 返回在list中的下标
     */
    long addList(K key,V ...obj);

    /**
     *
     * 输出list
     * @param key List的key
     * @param s 开始下标
     * @param e 结束的下标
     * @return
     */
    List&#60;V&#62; getList(K key, long s, long e);
    /**
     * 输出完整的list
     * @param key
     */
    List&#60;V&#62; getList(K key);
    /**
     * 获取list集合中元素的个数
     * @param key
     * @return
     */
    long getListSize(K key);
    /**
     * 移除list中某值
     * 移除list中 count个value为object的值,并且返回移除的数量,
     * 如果count为0,或者大于list中为value为object数量的总和,
     * 那么移除所有value为object的值,并且返回移除数量
     * @param key
     * @param object
     * @return 返回移除数量
     */
    long removeListValue(K key,V object);
    /**
     * 移除list中某值
     * @param key
     * @param object
     * @return 返回移除数量
     */
    long removeListValue(K key,V... object);

    /**
     * 批量删除key对应的value
     * @param keys
     */
    void remove(final K... keys);
    /**
     * 删除缓存
     * 根据key精确匹配删除
     * @param key
     */
    void remove(final K key);

    /**
     * 通过分数删除ZSet中的值
     * @param key
     * @param s
     * @param e
     */
    void removeZSetRangeByScore(String key,double s , double e);
    /**
     * 设置Set的过期时间
     * @param key
     * @param time
     * @return
     */
    Boolean setSetExpireTime(String key,Long time);

    /**
     * 设置ZSet的过期时间
     * @param key
     * @param time
     * @return
     */
    Boolean setZSetExpireTime(String key,Long time);
    /**
     * 判断缓存中是否有key对应的value
     * @param key
     * @return
     */
    boolean exists(final K key);

    /**
     * 读取String缓存 可以是对象
     * @param key
     * @return
     */
    V get(final K key);
    /**
     * 读取String缓存 可以是对象
     * @param key
     * @return
     */
    List&#60;V&#62; get(final K... key);
    /**
     * 读取缓存 可以是对象 根据正则表达式匹配
     * @param regKey
     * @return
     */
    List&#60;Object&#62; getByRegular(final K regKey);


    /**
     * 写入缓存 可以是对象
     * @param key
     * @param value
     */
    void set(final K key, V value);

    /**
     * 写入缓存
     * @param key
     * @param value
     * @param expireTime 过期时间 -单位s
     * @return
     */
    void set(final K key, V value, Long expireTime);

    /**
     * 设置一个key的过期时间（单位：秒）
     * @param key
     * @param expireTime
     * @return
     */
    boolean setExpireTime(K key, Long expireTime);

    /**
     * 获取key的类型
     * @param key
     * @return
     */
    DataType getType(K key);

    /**
     * 删除map中的某个对象
     * @param key   map对应的key
     * @param field map中该对象的key
     */
    void removeMapField(K key, V... field);
    /*
     * 获取map对象
     * @param key map对应的key
     * @return
     */
    Map&#60;K,V&#62; getMap(K key);
    /*
     * 获取map对象
     * @param key map对应的key
     * @return
     */
    Long getMapSize(K key);
    /**
     * 获取map缓存中的某个对象
     * @param key map对应的key
     * @param field map中该对象的key
     * @return
     */
    &#60;T&#62; T getMapField(K key, K field);
    /**
     * 判断map中对应key的key是否存在
     * @param key map对应的key
     * @return
     */
    Boolean hasMapKey(K key,K field);

    /**
     * 获取map对应key的value
     * @param key map对应的key
     * @return
     */
    List&#60;V&#62; getMapFieldValue(K key);
    /**
     * 获取map的key
     * @param key map对应的key
     * @return
     */
    Set&#60;V&#62; getMapFieldKey(K key);
    /**
     * 添加map
     * @param key
     * @param map
     */
    void addMap(K key, Map&#60;K,V&#62; map);
    /**
     * 向key对应的map中添加缓存对象
     * @param key   cache对象key
     * @param field map对应的key
     * @param value     值
     */
    void addMap(K key, K field, Object value);
    /**
     * 向key对应的map中添加缓存对象
     * @param key   cache对象key
     * @param field map对应的key
     * @param time 过期时间-整个MAP的过期时间
     * @param value     值
     */
    void addMap(K key, K field, V value,long time);

    /**
     * 向set中加入对象
     * @param key  对象key
     * @param obj  值
     */
    void addSet(K key, V... obj);

    /**
     * 处理事务时锁定key
     * @param key
     */
    void watch(String key);

    /**
     * 移除set中的某些值
     * @param key  对象key
     * @param obj  值
     */
    long removeSetValue(K key, V obj);
    /**
     * 移除set中的某些值
     * @param key  对象key
     * @param obj  值
     */
    long removeSetValue(K key, V... obj);

    /**
     * 获取set的对象数
     * @param key  对象key
     */
    long getSetSize(K key);

    /**
     * 判断set中是否存在这个值
     * @param key  对象key
     */
    Boolean hasSetValue(K key,V obj);
    /**
     * 获得整个set
     * @param key  对象key
     */
    Set&#60;V&#62; getSet(K key);

    /**
     * 获得set 并集
     * @param key
     * @param otherKey
     * @return
     */
    Set&#60;V&#62; getSetUnion(K key,K otherKey);

    /**
     * 获得set 并集
     * @param key
     * @param set
     * @return
     */
    Set&#60;V&#62; getSetUnion(K key,Set&#60;Object&#62; set);

    /**
     * 获得set 交集
     * @param key
     * @param otherKey
     * @return
     */
    Set&#60;V&#62; getSetIntersect(K key,K otherKey);

    /**
     * 获得set 交集
     * @param key
     * @param set
     * @return
     */
    Set&#60;V&#62; getSetIntersect(K key,Set&#60;Object&#62; set);

    /**
     * 模糊移除 支持*号等匹配移除
     * @param blears
     */
    void removeBlear(K... blears);

    /**
     * 修改key名 如果不存在该key或者没有修改成功返回false
     * @param oldKey
     * @param newKey
     * @return
     */
    Boolean renameIfAbsent(String oldKey,String newKey);
    /**
     * 模糊移除 支持*号等匹配移除
     * @param blear
     */
    void removeBlear(K blear);

    /**
     * 根据正则表达式来移除key-value
     * @param blears
     */
    void removeByRegular(String... blears);

    /**
     * 根据正则表达式来移除key-value
     * @param blears
     */
    void removeByRegular(String blears);

    /**
     * 根据正则表达式来移除 Map中的key-value
     * @param key
     * @param blears
     */
    void removeMapFieldByRegular(K key,K... blears);

    /**
     * 根据正则表达式来移除 Map中的key-value
     * @param key
     * @param blear
     */
    void removeMapFieldByRegular(K key,K blear);

    /**
     * 移除key 对应的value
     * @param key
     * @param value
     * @return
     */
    Long removeZSetValue(K key, V... value);
    /**
     * 移除key ZSet
     * @param key
     * @return
     */
    void removeZSet(K key);
    /**
     *删除，键为K的集合，索引start>=index>=end的元素子集
     * @param key
     * @param start
     * @param end
     * @return
     */
    void removeZSetRange(K key,Long start,Long end);

    /**
     * 并集 将key对应的集合和key1对应的集合合并到key2中
     * 如果分数相同的值，都会保留
     * 原来key2的值会被覆盖
     * @param key
     * @param key1
     * @param key2
     */
    void setZSetUnionAndStore(String key,String key1, String key2);

    /**
     * 获取整个有序集合ZSET，正序
     * @param key
     */
    &#60;T&#62; T getZSetRange(K key);

    /**
     * 获取有序集合ZSET
     * 键为K的集合，索引start>=index>=end的元素子集，正序
     * @param key
     * @param start 开始位置
     * @param end 结束位置
     */
    &#60;T&#62; T getZSetRange(K key,long start,long end);
    /**
     * 获取整个有序集合ZSET，倒序
     * @param key
     */
    Set&#60;Object&#62; getZSetReverseRange(K key);

    /**
     * 获取有序集合ZSET
     * 键为K的集合，索引start>=index>=end的元素子集，倒序
     * @param key
     * @param start 开始位置
     * @param end 结束位置
     */
    Set&#60;V&#62; getZSetReverseRange(K key,long start,long end);

    /**
     * 通过分数(权值)获取ZSET集合 正序 -从小到大
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set&#60;V&#62; getZSetRangeByScore(String key, double start, double end);

    /**
     * 通过分数(权值)获取ZSET集合 倒序 -从大到小
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set&#60;V&#62; getZSetReverseRangeByScore(String key, double start, double end);

    /**
     * 键为K的集合，索引start>=index>=end的元素子集
     * 返回泛型接口（包括score和value），正序
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set&#60;ZSetOperations.TypedTuple&#60;V&#62;&#62; getZSetRangeWithScores(K key, long start, long end);
    /**
     * 键为K的集合，索引start>=index>=end的元素子集
     * 返回泛型接口（包括score和value），倒序
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set&#60;ZSetOperations.TypedTuple&#60;V&#62;&#62; getZSetReverseRangeWithScores(K key, long start, long end);

    /**
     * 键为K的集合
     * 返回泛型接口（包括score和value），正序
     * @param key
     * @return
     */
    Set&#60;ZSetOperations.TypedTuple&#60;V&#62;&#62; getZSetRangeWithScores(K key);
    /**
     * 键为K的集合
     * 返回泛型接口（包括score和value），倒序
     * @param key
     * @return
     */
    Set&#60;ZSetOperations.TypedTuple&#60;V&#62;&#62; getZSetReverseRangeWithScores(K key);

    /**
     * 键为K的集合，sMin>=score>=sMax的元素个数
     * @param key
     * @param sMin
     * @param sMax
     * @return
     */
    long getZSetCountSize(K key,double sMin,double sMax);

    /**
     * 获取Zset 键为K的集合元素个数
     * @param key
     * @return
     */
    long getZSetSize(K key);

    /**
     * 获取键为K的集合，value为obj的元素分数
     * @param key
     * @param value
     * @return
     */
    double getZSetScore(K key,V value);

    /**
     * 元素分数增加，delta是增量
     * @param key
     * @param value
     * @param delta
     * @return
     */
    double incrementZSetScore(K key,V value,double delta);

    /**
     * 添加有序集合ZSET
     * 默认按照score升序排列，存储格式K(1)==V(n)，V(1)=S(1)
     * @param key
     * @param score
     * @param value
     * @return
     */
    Boolean addZSet(String key ,double score, Object value);

    /**
     * 添加有序集合ZSET
     * @param key
     * @param value
     * @return
     */
    Long addZSet(K key,TreeSet&#60;V&#62; value);

    /**
     * 添加有序集合ZSET
     * @param key
     * @param score
     * @param value
     * @return
     */
    Boolean addZSet(K key,double[] score, Object[] value);



}


```

##Redis的工具类
```java
package com.uifuture.utils.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/4/10.
 * Time: 上午 12:51.
 * Explain: Redis的工具类
 * 增删改 -不能在这里面抓取异常 -因为可能有事务处理
 */
@Component
public class RedisHandle implements RedisCommand&#60;String, Object&#62; {
    private Logger logger = Logger.getLogger(RedisHandle.class);
    @Autowired
    protected RedisTemplate redisTemplate;
    /**
     * 出异常，重复操作的次数
     */
    private static Integer times = 5;

    @Override
    public double getCreateTimeScore(long date) {
        return date/ 100000.0;
    }

    @Override
    public Set&#60;String&#62; getAllKeys() {
        return redisTemplate.keys("*");
    }

    @Override
    public Map&#60;String, Object&#62; getAllString() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, Object&#62; map = new HashMap&#60;String, Object&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.STRING) {
                map.put(k, get(k));
            }
        }
        return map;
    }

    @Override
    public Map&#60;String, Set&#60;Object&#62;&#62; getAllSet() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, Set&#60;Object&#62;&#62; map = new HashMap&#60;String, Set&#60;Object&#62;&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.SET) {
                map.put(k, getSet(k));
            }
        }
        return map;
    }

    @Override
    public Map&#60;String, Set&#60;Object&#62;&#62; getAllZSetRange() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, Set&#60;Object&#62;&#62; map = new HashMap&#60;String, Set&#60;Object&#62;&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.ZSET) {
                logger.debug("k:"+k);
                map.put(k, getZSetRange(k));
            }
        }
        return map;
    }

    @Override
    public Map&#60;String, Set&#60;Object&#62;&#62; getAllZSetReverseRange() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, Set&#60;Object&#62;&#62; map = new HashMap&#60;String, Set&#60;Object&#62;&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.ZSET) {
                map.put(k, getZSetReverseRange(k));
            }
        }
        return map;
    }

    @Override
    public Map&#60;String, List&#60;Object&#62;&#62; getAllList() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, List&#60;Object&#62;&#62; map = new HashMap&#60;String, List&#60;Object&#62;&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.LIST) {
                map.put(k, getList(k));
            }
        }
        return map;
    }

    @Override
    public Map&#60;String, Map&#60;String, Object&#62;&#62; getAllMap() {
        Set&#60;String&#62; stringSet = getAllKeys();
        Map&#60;String, Map&#60;String, Object&#62;&#62; map = new HashMap&#60;String, Map&#60;String, Object&#62;&#62;();
        Iterator&#60;String&#62; iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            if (getType(k) == DataType.HASH) {
                map.put(k, getMap(k));
            }
        }
        return map;
    }

    @Override
    public void addList(String key, List&#60;Object&#62; objectList) {
        for (Object obj : objectList) {
            addList(key, obj);
        }
    }

    @Override
    public long addList(String key, Object obj) {
        return redisTemplate.boundListOps(key).rightPush(obj);
    }

    @Override
    public long addList(String key, Object... obj) {
        return redisTemplate.boundListOps(key).rightPushAll(obj);
    }

    @Override
    public List&#60;Object&#62; getList(String key, long s, long e) {
        return redisTemplate.boundListOps(key).range(s, e);
    }

    @Override
    public List&#60;Object&#62; getList(String key) {
        return redisTemplate.boundListOps(key).range(0, getListSize(key));
    }

    @Override
    public long getListSize(String key) {
        return redisTemplate.boundListOps(key).size();
    }

    @Override
    public long removeListValue(String key, Object object) {
        return redisTemplate.boundListOps(key).remove(0, object);
    }

    @Override
    public long removeListValue(String key, Object... objects) {
        long r = 0;
        for (Object object : objects) {
            r += removeListValue(key, object);
        }
        return r;
    }

    @Override
    public void remove(String... key) {
        if (key != null && key.length &#62; 0) {
            if (key.length == 1) {
                remove(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    @Override
    public void removeBlear(String... blears) {
        for (String blear : blears) {
            removeBlear(blear);
        }
    }

    @Override
    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    @Override
    public void removeBlear(String blear) {
        redisTemplate.delete(redisTemplate.keys(blear));
    }

    @Override
    public void removeByRegular(String... blears) {
        for (String blear : blears) {
            removeBlear(blear);
        }
    }

    @Override
    public void removeByRegular(String blear) {
        Set&#60;String&#62; stringSet = getAllKeys();
        for (String s : stringSet) {
            if (Pattern.compile(blear).matcher(s).matches()) {
                redisTemplate.delete(s);
            }
        }
    }

    @Override
    public void removeMapFieldByRegular(String key, String... blears) {
        for (String blear : blears) {
            removeMapFieldByRegular(key, blear);
        }
    }

    @Override
    public void removeMapFieldByRegular(String key, String blear) {
        Map&#60;String, Object&#62; map = getMap(key);
        Set&#60;String&#62; stringSet = map.keySet();
        for (String s : stringSet) {
            if (Pattern.compile(blear).matcher(s).matches()) {
                redisTemplate.boundHashOps(key).delete(s);
            }
        }
    }

    @Override
    public Long removeZSetValue(String key, Object... value) {
        return redisTemplate.boundZSetOps(key).remove(value);
    }

    @Override
    public void removeZSet(String key) {
        removeZSetRange(key, 0L, getZSetSize(key));
    }

    @Override
    public void removeZSetRange(String key, Long start, Long end) {
        redisTemplate.boundZSetOps(key).removeRange(start, end);
    }

    @Override
    public void setZSetUnionAndStore(String key,String key1, String key2) {
        redisTemplate.boundZSetOps(key).unionAndStore(key1,key2);
    }

    @Override
    public Set&#60;Object&#62; getZSetRange(String key) {
        return getZSetRange(key, 0, getZSetSize(key));
    }

    @Override
    public Set&#60;Object&#62; getZSetRange(String key, long s, long e) {
        return redisTemplate.boundZSetOps(key).range(s, e);
    }

    @Override
    public Set&#60;Object&#62; getZSetReverseRange(String key) {
        return getZSetReverseRange(key, 0, getZSetSize(key));
    }

    @Override
    public Set&#60;Object&#62; getZSetReverseRange(String key, long start, long end) {
        return redisTemplate.boundZSetOps(key).reverseRange(start, end);
    }

    @Override
    public Set&#60;Object&#62; getZSetRangeByScore(String key, double start, double end) {
        return redisTemplate.boundZSetOps(key).rangeByScore(start, end);
    }
    @Override
    public Set&#60;Object&#62; getZSetReverseRangeByScore(String key, double start, double end) {
        return redisTemplate.boundZSetOps(key).reverseRangeByScore(start, end);
    }

    @Override
    public Set&#60;ZSetOperations.TypedTuple&#60;Object&#62;&#62; getZSetRangeWithScores(String key, long start, long end) {
        return redisTemplate.boundZSetOps(key).rangeWithScores(start, end);
    }

    @Override
    public Set&#60;ZSetOperations.TypedTuple&#60;Object&#62;&#62; getZSetReverseRangeWithScores(String key, long start, long end) {
        return redisTemplate.boundZSetOps(key).reverseRangeWithScores(start, end);
    }

    @Override
    public Set&#60;ZSetOperations.TypedTuple&#60;Object&#62;&#62; getZSetRangeWithScores(String key) {
        return getZSetRangeWithScores(key, 0, getZSetSize(key));
    }

    @Override
    public Set&#60;ZSetOperations.TypedTuple&#60;Object&#62;&#62; getZSetReverseRangeWithScores(String key) {
        return getZSetReverseRangeWithScores(key, 0, getZSetSize(key));
    }

    @Override
    public long getZSetCountSize(String key, double sMin, double sMax) {
        return redisTemplate.boundZSetOps(key).count(sMin, sMax);
    }

    @Override
    public long getZSetSize(String key) {
        return redisTemplate.boundZSetOps(key).size();
    }

    @Override
    public double getZSetScore(String key, Object value) {
        return redisTemplate.boundZSetOps(key).score(value);
    }

    @Override
    public double incrementZSetScore(String key, Object value, double delta) {
        return redisTemplate.boundZSetOps(key).incrementScore(value, delta);
    }

    @Override
    public Boolean addZSet(String key, double score, Object value) {
        return redisTemplate.boundZSetOps(key).add(value, score);
    }

    @Override
    public Long addZSet(String key, TreeSet&#60;Object&#62; value) {
        return redisTemplate.boundZSetOps(key).add(value);
    }

    @Override
    public Boolean addZSet(String key, double[] score, Object[] value) {
        if (score.length != value.length) {
            return false;
        }
        for (int i = 0; i &#60; score.length; i++) {
            if (addZSet(key, score[i], value[i]) == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void remove(String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public void removeZSetRangeByScore(String key,double s , double e) {
        redisTemplate.boundZSetOps(key).removeRangeByScore(s,e);
    }

    @Override
    public Boolean setSetExpireTime(String key, Long time) {
        return redisTemplate.boundSetOps(key).expire(time, TimeUnit.SECONDS);
    }

    @Override
    public Boolean setZSetExpireTime(String key, Long time) {
        return redisTemplate.boundZSetOps(key).expire(time, TimeUnit.SECONDS);
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    @Override
    public List&#60;Object&#62; get(String... keys) {
        List&#60;Object&#62; list = new ArrayList&#60;Object&#62;();
        for (String key : keys) {
            list.add(get(key));
        }
        return list;
    }

    @Override
    public List&#60;Object&#62; getByRegular(String regKey) {
        Set&#60;String&#62; stringSet = getAllKeys();
        List&#60;Object&#62; objectList = new ArrayList&#60;Object&#62;();
        for (String s : stringSet) {
            if (Pattern.compile(regKey).matcher(s).matches() && getType(s) == DataType.STRING) {
                objectList.add(get(s));
            }
        }
        return objectList;
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.boundValueOps(key).set(value);
    }

    @Override
    public void set(String key, Object value, Long expireTime) {
        redisTemplate.boundValueOps(key).set(value, expireTime, TimeUnit.SECONDS);
    }

    @Override
    public boolean setExpireTime(String key, Long expireTime) {
        return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }


    @Override
    public DataType getType(String key) {
        return redisTemplate.type(key);
    }


    @Override
    public void removeMapField(String key, Object... field) {
        redisTemplate.boundHashOps(key).delete(field);
    }

    @Override
    public Long getMapSize(String key) {
        return redisTemplate.boundHashOps(key).size();
    }

    @Override
    public Map&#60;String, Object&#62; getMap(String key) {
        return redisTemplate.boundHashOps(key).entries();
    }

    @Override
    public &#60;T&#62; T getMapField(String key, String field) {
        return (T) redisTemplate.boundHashOps(key).get(field);
    }

    @Override
    public Boolean hasMapKey(String key, String field) {
        return redisTemplate.boundHashOps(key).hasKey(field);
    }

    @Override
    public List&#60;Object&#62; getMapFieldValue(String key) {
        return redisTemplate.boundHashOps(key).values();
    }

    @Override
    public Set&#60;Object&#62; getMapFieldKey(String key) {
        return redisTemplate.boundHashOps(key).keys();
    }

    @Override
    public void addMap(String key, Map&#60;String, Object&#62; map) {
        redisTemplate.boundHashOps(key).putAll(map);
    }

    @Override
    public void addMap(String key, String field, Object value) {
        redisTemplate.boundHashOps(key).put(field, value);
    }

    @Override
    public void addMap(String key, String field, Object value, long time) {
        redisTemplate.boundHashOps(key).put(field, value);
        redisTemplate.boundHashOps(key).expire(time, TimeUnit.SECONDS);
    }

    @Override
    public void watch(String key) {
        redisTemplate.watch(key);
    }

    @Override
    public void addSet(String key, Object... obj) {
        redisTemplate.boundSetOps(key).add(obj);
    }

    @Override
    public long removeSetValue(String key, Object obj) {
        return redisTemplate.boundSetOps(key).remove(obj);
    }

    @Override
    public long removeSetValue(String key, Object... obj) {
        if (obj != null && obj.length &#62; 0) {
            return redisTemplate.boundSetOps(key).remove(obj);
        }
        return 0L;
    }

    @Override
    public long getSetSize(String key) {
        return redisTemplate.boundSetOps(key).size();
    }

    @Override
    public Boolean hasSetValue(String key, Object obj) {
        Boolean boo = null;
        int t =0;
        while (true){
            try {
                boo = redisTemplate.boundSetOps(key).isMember(obj);
                break;
            } catch (Exception e) {
                logger.error("key[" + key + "],obj[" + obj + "]判断Set中的值是否存在失败,异常信息:" + e.getMessage());
                t++;
            }
            if(t&#62;times){
                break;
            }
        }
        logger.info("key[" + key + "],obj[" + obj + "]是否存在,boo:" + boo);
        return boo;
    }

    @Override
    public Set&#60;Object&#62; getSet(String key) {
        return redisTemplate.boundSetOps(key).members();
    }

    @Override
    public Set&#60;Object&#62; getSetUnion(String key, String otherKey) {
        return redisTemplate.boundSetOps(key).union(otherKey);
    }

    @Override
    public Set&#60;Object&#62; getSetUnion(String key, Set&#60;Object&#62; set) {
        return redisTemplate.boundSetOps(key).union(set);
    }

    @Override
    public Set&#60;Object&#62; getSetIntersect(String key, String otherKey) {
        return redisTemplate.boundSetOps(key).intersect(otherKey);
    }

    @Override
    public Set&#60;Object&#62; getSetIntersect(String key, Set&#60;Object&#62; set) {
        return redisTemplate.boundSetOps(key).intersect(set);
    }

}


```
这个是我当时写一个Web项目的时候，慢慢整合而成的，比较完整的Redis操作工具类，基本上可以满足你操纵Redis的绝大多数需要了。

因为不是个什么完整的项目，就没有上传到github上为大家提供这几个代码的下载了，只能麻烦需要的朋友直接拷贝下了。
