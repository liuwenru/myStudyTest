package org.ijarvis.SpringMVCTest;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

@Controller
public class SpringMVCTest {
    private static ApplicationContext context ;
    private static DruidDataSource dataSource ;
    private static Charset CHARSET = Charset.forName("utf-8");
//    static {
//        context=new ClassPathXmlApplicationContext("application-context.xml");
//        dataSource=context.getBean("dataSource", DruidDataSource.class);
//
//    }
public String decrypt(String text, String sessionKey) {
    byte [] aesKey = Base64.decodeBase64(sessionKey + "=");
    byte[] original = new byte[0];
    try {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        byte[] encrypted = Base64.decodeBase64(text);
        original = cipher.doFinal(encrypted);
    } catch (Exception e) {
        System.out.println("111");
    }
    String xmlContent="";
    String fromClientId;
    try {
        // 去除补位字符
        byte[] bytes = PKCS7Encoder.decode(original);
        // 分离16位随机字符串,网络字节序和ClientId
        byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
        int xmlLength = recoverNetworkBytesOrder(networkOrder);
        xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
        fromClientId = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CHARSET);
    } catch (Exception e) {
        System.out.println("111");
    }
    return xmlContent;
}
    /**
     * 还原4个字节的网络字节序
     *
     * @param orderBytes 字节码
     *
     * @return sourceNumber
     */
    private int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        int length = 4;
        int number = 8;
        for (int i = 0; i < length; i++) {
            sourceNumber <<= number;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }
    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/getusername")
    public String getusername(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        return "hello";
    }
    @RequestMapping("/sleep")
    public String sleep(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
        Thread.sleep(50000);
        return "hello";
    }
    @RequestMapping("/logfile")
    public String request1(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, ServletException {
        logger.debug("aaaaaaaaaa");
        System.out.println("bbbbbbb");
        return "hello";
    }
    @RequestMapping("/jcetest")
    public String jcetest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, ServletException {
        String dy = "OpCoJgs7RrVgaMNDixIvaCIyV2SFDBNLivgkVqtzq2GC10egsn+PKmQ/+5q+chT8xzldLUog2haTItyIkKyvzvmXonBQLIMeq54axAu9c3KG8IhpFD6+ymHocmx07ZKi7eED3t0KyIxJgRNSDkFk5RV1ZP2mSWa7ZgCXXcAbP0RsiUcvhcJfrSwlpsm0E1YJzKpYy429xrEEGvK+gfL+Cw==";

        String sessionKey = "1df09d0a1677dd72b8325aec59576e0c";

        SpringMVCTest demo = new SpringMVCTest();
        String dd = demo.decrypt(dy, sessionKey);
        System.out.println(dd);
        return "hello";
    }
}
