package org.ijarvis.SpringMVCTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
    @RequestMapping("/test")
    @ResponseBody
    public void saveTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, LifecycleException {
        System.out.println(req.getParameter("requestid"));
        if("null".equals(req.getParameter("requestid"))|| req.getParameter("requestid")==null){
            throw new NullPointerException();
        }
    }
}
