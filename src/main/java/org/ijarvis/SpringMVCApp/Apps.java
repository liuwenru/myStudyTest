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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class Apps {
    @Autowired
    private DruidDataSource dataSource ;
    Logger logger = LoggerFactory.getLogger(Apps.class);
    @RequestMapping(value = "/loginTest", method = {RequestMethod.POST,RequestMethod.GET})
    public String loginTest(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        Connection connection= dataSource.getConnection();
        ResultSet resultSet= connection.createStatement().executeQuery("SELECT count(*) from employees.employees");
        connection.close();
        return "index";
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
    public String index(Model model,HttpServletRequest request,HttpServletResponse response){
        model.addAttribute("text", "This is MyTest page with Thymeleaf!");
        model.addAttribute("name", request.getParameter("name"));
        return "index.html";
    }
}
