package org.ijarvis.EpointTest.Druid;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;


public class DruidTestInsert extends HttpServlet {
	private static Logger logger = Logger.getLogger(DruidTestInsert.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DruidTestM.druidInsert();
			logger.info("insert success.....");
		} catch (BeansException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
