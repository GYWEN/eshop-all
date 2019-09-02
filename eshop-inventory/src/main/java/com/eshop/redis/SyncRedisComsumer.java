package com.eshop.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * 主要作用是进行异步的消费
 * 查看redis队列是否有数据，如果有则消费，否则就等待阻塞
 *
 * 由spring进行监管和处理
 *
 * 其实有一个问题，如何保证让这个最后启动执行，否则启动时就开始进行处理数据了？？？
 *
 * 但现在这个并不是我们目前关注的重点
 */
@Component
public class SyncRedisComsumer {

    public static final String keyQueueName = "reidsSyncQueue";


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 启动执行执行，阻塞查询操作
     */
    @PostConstruct
    public void init(){
        /**
         * 阻塞读，redistemplate阻塞读也是使用pop的方式处理，只不过通过添加一个阻塞时间来进行判断是否是阻塞读
         *
         * 意思是会一直阻塞等待，直到超时或者取到为止
         *
         * 低劣采用先进先出的原则
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    String object = (String) redisTemplate.opsForList().rightPop(keyQueueName, 10000000, TimeUnit.SECONDS);
                    System.err.println(object);
                }
            }
        }).start();

    }
}
