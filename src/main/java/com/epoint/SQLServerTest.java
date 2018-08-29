package com.epoint;

import java.sql.*;

public class SQLServerTest {
    public static  void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        while (true) {
            String url = "jdbc:sqlserver://192.168.212.243\\SQL2008;databaseName=test";
            String user = "sa";
            String password = "Gepoint";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");
            String sql = "select  1";
            Statement com = con.createStatement();
            com.executeQuery(sql);
            System.out.println("11111");

            Thread.sleep(2000);
        }
    }
}
