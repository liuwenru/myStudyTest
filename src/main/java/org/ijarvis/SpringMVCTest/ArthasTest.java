package org.ijarvis.SpringMVCTest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Controller
public class ArthasTest {
    static JedisPool jedisPool=new JedisPool(new JedisPoolConfig(),"192.168.188.150",6379,2000,"Gepoint");
    @RequestMapping("/redis")
    public String sleep(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
        Random r=new Random();
        for(int i=0;i<100;i++){
            Jedis jedis1= jedisPool.getResource();
        }
        Jedis jedis2= jedisPool.getResource();
        int closebl= r.nextInt(100);
        if (closebl % 2==0){
            jedis2.close();
        }
        return "hello";
    }
}
