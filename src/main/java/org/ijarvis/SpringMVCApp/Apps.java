package org.ijarvis.SpringMVCApp;


import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class Apps {
    private static ApplicationContext context ;
    @Autowired
    private DruidDataSource dataSource ;
    Logger logger = LoggerFactory.getLogger(Apps.class);
    @RequestMapping(value = "/loginTest", method = {RequestMethod.POST,RequestMethod.GET})
    public String loginTest(HttpServletRequest request,HttpServletResponse response) throws InterruptedException, SQLException {
        String account = request.getParameter("userName");
        String password = request.getParameter("password");
        Connection connection= dataSource.getConnection();
        connection.createStatement().executeQuery("SELECT * from employees.employees");
        if (account.equals("admin")&&password.equals("1")){
            return "index";
        }else{
            return "login";
        }
    }
    @RequestMapping(value = "/printmsg", method = {RequestMethod.POST,RequestMethod.GET})
    public String PrintMsg(HttpServletRequest request,HttpServletResponse response) throws InterruptedException {
        String msg = request.getParameter("msg");

        System.out.println(msg);
        return "hello";
    }
    @RequestMapping(value = "/sleepbyparam", method = {RequestMethod.POST,RequestMethod.GET})
    public String sleepbyparam(HttpServletRequest request,HttpServletResponse response) throws InterruptedException {
        String time = request.getParameter("time");
        System.out.println(time);
        Thread.sleep(Long.parseLong(time));
        return "hello";
    }
}
