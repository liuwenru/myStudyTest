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

    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/printmsg")
    public String sleep(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
        System.out.println(req.getParameter("msg"));
        return "hello";
    }
}
