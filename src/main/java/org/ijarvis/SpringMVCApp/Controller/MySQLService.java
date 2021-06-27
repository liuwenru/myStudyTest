package org.ijarvis.SpringMVCApp.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.ijarvis.SpringMVCApp.Apps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Controller
public class MySQLService {
    @Autowired
    private DruidDataSource dataSource;
    Logger logger = LoggerFactory.getLogger(Apps.class);

    @RequestMapping(value = "/mysql", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    HashMap<String, String> mysql(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT count(*) from employees.employees");
        HashMap<String, String> rs = new HashMap<String, String>();
        if (resultSet.next()) {
            rs.put("numcount", resultSet.getString(1));
        }
        connection.close();
        return rs;
    }
}
