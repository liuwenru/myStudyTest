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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
    Logger logger = LoggerFactory.getLogger(SpringMVCTest.class);
    @RequestMapping("/getusername")
    public String getusername(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        return "hello";
    }

}
