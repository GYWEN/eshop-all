package com.eshop.controller;

import com.eshop.mapper.UserMapper;
import com.eshop.model.User;
import com.eshop.redis.SyncRedisComsumer;
import com.eshop.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserServiceController {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    UserMapper userMapper;


    @GetMapping("/user123")
    public List<User> getUserList(){
        return userMapper.selectAllList();
    }

    @GetMapping("/redis")
    public String redisTemplate(){
        redisTemplate.opsForList().leftPush(SyncRedisComsumer.keyQueueName,"this is first trem");
        return "Sucess End";
    }

    @GetMapping("/user/inventory/{id}")
    public String redisProperties(@PathVariable("id") String id){
        return "This is user inventory-----" + id;
    }

    @GetMapping("/user/inventory123")
    public String redisProperties(){
        return "This is user inventory-----";
    }
}
