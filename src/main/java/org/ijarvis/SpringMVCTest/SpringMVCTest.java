package org.ijarvis.SpringMVCTest;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;

@Controller
public class SpringMVCTest {
    private static ApplicationContext context ;
    private static DruidDataSource dataSource ;
//    static {
//        context=new ClassPathXmlApplicationContext("application-context.xml");
//        dataSource=context.getBean("dataSource", DruidDataSource.class);
//
//    }
    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/getusername")
    public String getusername(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        return "hello";
    }
    @RequestMapping("/sleep")
    public String sleep(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
        Thread.sleep(Integer.parseInt(req.getParameter("sleeptime")));
        System.out.println("i am over......");
        return "hello";
    }

    static JedisPool jedisPool=new JedisPool(new JedisPoolConfig(),"192.168.188.150",6379,2000,"Gepoint");
    @RequestMapping("/redis")
    public String redis(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
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
