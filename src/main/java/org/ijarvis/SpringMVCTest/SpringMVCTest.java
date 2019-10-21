package org.ijarvis.SpringMVCTest;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.*;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
    private static ApplicationContext context ;
    private static DruidDataSource dataSource ;
    static {
        context=new ClassPathXmlApplicationContext("file:///opt/application-context.xml");
        dataSource=context.getBean("dataSource", DruidDataSource.class);

    }
    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/getusername")
    public String getusername(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        String username= req.getParameter("username");
        resp.addCookie(new Cookie("path","111111"));
        return "hello";
    }
    @RequestMapping("/sleep")
    public String sleep(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, InterruptedException {
        Thread.sleep(50000);
        return "hello";
    }
    @RequestMapping("/logfile")
    public String request1(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, ServletException {
//        BufferedWriter out=new BufferedWriter(new FileWriter("/tmp/aaa.txt"));
//        out.write("Hello ..........:");
//        out.newLine();
//        //out.close();
        logger.debug("aaaaaaaaaa");
        System.out.println("bbbbbbb");
        return "hello";
    }
    @RequestMapping("/sqlconnections")
    public String request() throws SQLException, InterruptedException {
        dataSource.setTransactionQueryTimeout(10000);
        dataSource.setValidationQueryTimeout(100);
        dataSource.setQueryTimeout(5);
        dataSource.setConnectionProperties("oracle.jdbc.ReadTimeout=10000;oracle.net.CONNECT_TIMEOUT=10000");
        Connection connection=dataSource.getConnection();
        connection.setAutoCommit(false);
        Statement statement=connection.createStatement();
        statement.executeQuery("update x set name='ffffff' where id=1");
        int i=0;
        while (true){
            Thread.sleep(1000);
            i=i+1;
            if(i>=60){
                break;
            }
            System.out.println("Sleep Time "+i+" S");
        }
        connection.commit();
        connection.close();
        return "hello";
    }

}
