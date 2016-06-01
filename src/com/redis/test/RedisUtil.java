package com.redis.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 刚刚这里链接失败，果然是因为jar的缺失的原因
 * @author zhengYu
 *
 */

public final class RedisUtil {
	 //Redis服务器IP
    private static String ADDR = "";
    
    //Redis的端口号
    private static int PORT ;
    
    //访问密码
    private static String AUTH = "";
    
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static ShardedJedisPool jedisPool = null;
	
    
    /**
     * 初始化Redis连接池
     */
    static {
        try {
        	 Properties prop = new Properties();   
        	 
        	 InputStream in = RedisUtil.class.getResourceAsStream("/sources/db.properties"); 
             prop.load(in);   
             ADDR = prop.getProperty("redis_addr").trim();   
             PORT = Integer.parseInt(prop.getProperty("redis_port"));   
            JedisPoolConfig config = new JedisPoolConfig();
            
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            config.setMaxTotal(MAX_ACTIVE);
            List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
    		JedisShardInfo infoA=new JedisShardInfo(ADDR, PORT, "master");
    		shards.add(infoA);
    		//infoA.setPassword(AUTH);
            jedisPool = new ShardedJedisPool(config, shards);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static ShardedJedis getJedis() {
        try {
            if (jedisPool != null) {
            	ShardedJedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final ShardedJedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}