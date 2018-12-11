package org.ijarvis.SpringMVCTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/test")
    @ResponseBody
    public String saveTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, LifecycleException {
        logger.debug(req.getParameter("requestid"));
        if("null".equals(req.getParameter("requestid"))|| req.getParameter("requestid")==null){
            throw new NullPointerException();
        }
        Thread.sleep(2000);
        return "hello";
    }

    // 用于测试ModeSecurity的性能问题
    @RequestMapping("/testModesecurity")
    @ResponseBody
    public String AppTest(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException {
        logger.debug(">>>>>>>>>>>>>>>");
        Thread.sleep(500);
        return "hello";
    }


    @RequestMapping("/SleepPerfTest")
    @ResponseBody
    public String SleepPerfTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, LifecycleException {
        logger.debug(req.getParameter("sleep"));
        Thread.sleep(Long.parseLong(req.getParameter("sleep")));
        return "hello";
    }


    @RequestMapping("/getsystemenv")
    public String sysenvTest(){
        String docker =System.getenv("CURRENT_ALPINE_GLIBC_BASE_IMAGE_VER");
        logger.debug("envinfo----"+docker);
        return "hello";
    }
    @RequestMapping("/mkdirtest")
    public String mkdirTest(HttpServletRequest req, HttpServletResponse resp){
        String path=req.getParameter("dirpath");
        File file=new File(path);
        if(! file.exists()){
            logger.debug("mkdir path"+path);
            file.mkdir();
        }
        return "hello";
    }


    @RequestMapping("/addcookies")
    public String addcookies(HttpServletRequest req, HttpServletResponse resp){
        resp.addCookie(new Cookie("ssid","epoint"));
        return "hello";
    }


    @RequestMapping("/delcookies")
    public String delcookies(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies=req.getCookies();
        for(Cookie cookie:cookies)
            if ("ssid".equals(cookie.getName())){
                System.out.println("Cookies is : Domain "+cookie.getDomain()+" MaxAge: "+cookie.getMaxAge()+" name:"+cookie.getName());
                cookie.setMaxAge(0);
                cookie.setValue("");
                resp.addCookie(cookie);
            }
        return "hello";
    }


}
