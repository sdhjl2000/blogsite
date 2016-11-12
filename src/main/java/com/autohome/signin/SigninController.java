package com.autohome.signin;

import com.autohome.account.Account;
import com.autohome.account.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
    @Autowired
    private RedisTemplate<String, Account> redisTemplate;
    @Autowired
    private RedisTemplate<String, Department> redisdTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "signin")
    public String signin() {

        ValueOperations<String, Account> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("1111", new Account("11", "222", "role"));
        Account account = valueOperations.get("1111");

        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("2222", "22222");
        String result = operations.get("2222");

        HashOperations<String, String, Department> hashOperations = redisdTemplate.opsForHash();
        hashOperations.put("3333", "1111", new Department("333", 11));
        Department account1 = hashOperations.get("3333", "1111");
        return "signin/signin";
    }
}
