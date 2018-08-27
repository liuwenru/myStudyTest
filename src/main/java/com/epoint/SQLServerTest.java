package com.epoint;

import java.sql.*;

public class SQLServerTest {
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://192.168.212.243\\SQL2008;databaseName=test";
        String user = "sa";
        String password = "Gepoint";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功！");
        String sql = "select * from 2";
        Statement com=con.createStatement();
        com.executeQuery(sql);
        System.out.println("11111");
    }
}
