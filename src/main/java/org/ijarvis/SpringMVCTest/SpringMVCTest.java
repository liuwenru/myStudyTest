package org.ijarvis.SpringMVCTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
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
    @RequestMapping("/openfile")
    public String request1(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, ServletException {
        BufferedWriter out=new BufferedWriter(new FileWriter("/tmp/aaa.txt"));
        out.write("Hello ..........:");
        out.newLine();
        //out.close();
        return "hello";
    }
}
