package com.xqq.three.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/19 10:51
 * @Description:
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    private Logger logger=LoggerFactory.getLogger(RedisConfiguration.class);
    /**
     * 采用RedisCacheManager作为缓存管理器
     *
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
       /* RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(60);
        Map<String,Long> expiresMap=new HashMap<>();
        expiresMap.put("user",5L);
        cacheManager.setExpires(expiresMap);
        return cacheManager;*/


        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheConfiguration userConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10));
        Map<String,RedisCacheConfiguration> map = new HashMap<>();
        map.put("user",userConfig);
        //设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig,map);
    }


    /**
     * 自定义生成key的规则
     * @return
     */
    @Override
    public KeyGenerator keyGenerator(){
        return  new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb=new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并且追加
                for (Object obj:objects){
                    sb.append(obj.toString());
                }
                logger.info("调用redis缓存key："+sb.toString());
                return sb.toString();
            }
        };
    }
}
