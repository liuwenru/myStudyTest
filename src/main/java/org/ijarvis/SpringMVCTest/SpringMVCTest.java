package org.ijarvis.SpringMVCTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
