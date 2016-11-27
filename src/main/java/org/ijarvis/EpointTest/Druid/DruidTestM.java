package org.ijarvis.EpointTest.Druid;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTestM {
	private static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	private static DruidDataSource datasource= (DruidDataSource) context.getBean("dataSource");
	public static void GetUrlinfo(){
	}
	public static void druidInsert() throws BeansException, SQLException{
		Connection connection=datasource.getConnection();
		Statement command=connection.createStatement();
		command.execute("insert into testinfo(name,pass) values('"+(UUID.randomUUID().toString())+"','"+UUID.randomUUID().toString()+"')");
		connection.close();
	}

}
