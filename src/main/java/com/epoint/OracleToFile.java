package com.epoint;

import java.sql.*;

public class OracleToFile {


    public static  void main() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:" + "thin:@192.168.186.36:1521:orcl";
        String user = "epoint";
        String password = "11111";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功！");
        String sql = "select * from CAR_HAILING2";
        Statement com= con.createStatement();
        com.executeQuery(sql);
    }
}
