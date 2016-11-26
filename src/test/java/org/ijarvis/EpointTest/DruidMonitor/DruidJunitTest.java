package org.ijarvis.EpointTest.DruidMonitor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.ijarvis.EpointTest.Druid.DruidTestM;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;


public class DruidJunitTest {
	@Ignore
	@Test
	public void DruidTest() throws BeansException, SQLException{
//		DruidTestM.druidInsert();
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		DruidDataSource datasource= (DruidDataSource) context.getBean("dataSource");
		Connection connection=datasource.getConnection();
		Statement command=connection.createStatement();
		command.execute("insert into testinfo(name,pass) values('"+(UUID.randomUUID().toString())+"','"+UUID.randomUUID().toString()+"')");
		connection.close();
	}
}
