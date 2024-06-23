import com.exam.spring.SpringDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringDemoApplication.class)
public class DemoTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        //mq消息发送方法
        rabbitTemplate.convertAndSend("dircet.exchange","aaa", "库存不足,请及时补货");
    }


    @Test
    public void test02(){
        redisTemplate.opsForValue().set("key" ,"value");
        String key = String.valueOf(redisTemplate.opsForValue().get("key"));
        System.out.println(key);
    }
}
