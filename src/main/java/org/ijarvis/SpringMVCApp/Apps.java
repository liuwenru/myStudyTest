package org.ijarvis.SpringMVCApp;


import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Apps {
    private static ApplicationContext context ;
    private static DruidDataSource dataSource ;
    Logger logger = LoggerFactory.getLogger(Apps.class);
    @RequestMapping(value = "/loginTest", method = {RequestMethod.POST,RequestMethod.GET})
    public String loginTest(HttpServletRequest request,HttpServletResponse response) throws InterruptedException {
        String account = request.getParameter("userName");
        String password = request.getParameter("password");
        Thread.sleep(500);
        if (account.equals("admin")&&password.equals("1")){
            return "index";
        }else{
            return "login";
        }
    }
}
