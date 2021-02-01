package org.ijarvis.SpringMVCApp;


import FilesystemApps.Fallocate;
import com.alibaba.druid.pool.DataSourceClosedException;
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
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class Apps {
    private static int a=2;
    private static ApplicationContext context ;
    @Autowired
    private DruidDataSource dataSource ;
    Logger logger = LoggerFactory.getLogger(Apps.class);
    @RequestMapping(value = "/loginTest", method = {RequestMethod.POST,RequestMethod.GET})
    public String loginTest(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        Connection connection= dataSource.getConnection();
        ResultSet resultSet= connection.createStatement().executeQuery("SELECT count(*) from employees.employees");

        connection.close();
        try {
            if (a==2){
                throw  new MyException("heigei");
            }
        }catch (Exception e){
            System.out.println("heihei");
        }
        return "index";
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
