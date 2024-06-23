package com.exam.spring.project.service.impl;

import com.exam.spring.project.entity.PersonInfo;
import com.exam.spring.project.mapper.PersonInfoMapper;
import com.exam.spring.project.service.DemoService;
import com.exam.spring.project.service.PersonInfoService;
import com.google.common.collect.ImmutableList;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private PersonInfoService personInfoService;

    /**
     * 查询所有
     */
    @Override
    public List<PersonInfo> getAll() {
        return personInfoService.query().list();
    }

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public String login(String username, String password) {
        if (null == username || null == password){
            return "账号密码非法";
        }
//        // 1.查询手机号登录次数
//        Object value = redisTemplate.opsForValue().get("123456");
//        int count;
//        if (null == value){
//            count = 1;
//            redisTemplate.opsForValue().set("123456", String.valueOf(count), Duration.ofSeconds(30));
//        }else {
//            count = Integer.parseInt(String.valueOf(value));
//            count += 1;
//            redisTemplate.opsForValue().set("123456", String.valueOf(count), Duration.ofSeconds(30));
//
//        }
//        // 2.验证账号密码
//        if (count > 5){
//            return "登录次数超过最大五次";
//        }


//        ImmutableList<String> keys = ImmutableList.of("rate_limit_user123_192.168.1.1");
//        String luaScript = buildLuaScript();
//        RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
//        Number count = redisTemplate.execute(redisScript, keys, 5, 30);

        Long count = this.executeLuaScript("ip_123456",10);


        if (count != null && count <= 5) {
//            return point.proceed();
        } else {
            return "接口访问超出次数";
        }


        if ("zhangsan".equals(username) && "123".equals(password)){
            return "登陆成功";
        }
        return "账号或密码错误";
    }


    /**
     * 限流脚本
     * 调用的时候不超过阈值，则直接返回并执行计算器自加。
     *
     * @return lua脚本
     */
    public Long executeLuaScript(String key ,int expireTimeInSeconds) {
        /**
         * java中写一个lua脚本,要求根据指定的key去查找value,value是次数,如果查询结果不为null，
         * 则根据指定的key添加一条数据，value设置为1，如果查询的结果存在，
         * 则value自动+1，key和value都是string类型数据，并写出java如何操作这个lua脚本发到redis中执行
         */

        String luaScript = "local count = redis.call('get', KEYS[1])\n" +
                "if count then\n" +
                "    count = tonumber(count) + 1\n" +
                "else\n" +
                "    count = 1\n" +
                "end\n" +
                "redis.call('set', KEYS[1], count)\n" +
                "redis.call('expire', KEYS[1], ARGV[1])\n" +
                "return count";

        RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
        List<String> keys = Collections.singletonList(key);
        List<String> args = Collections.singletonList(String.valueOf(expireTimeInSeconds));
        return redisTemplate.execute(redisScript, keys,args.toArray()); // 执行脚本并返回结果
    }
}
