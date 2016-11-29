package org.ijarvis.EpointTest.Weblogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class WebLogicLogTest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(WebLogicLogTest.class);
	private static int seq=0;
	public void doGet() throws ServletException, IOException {
		//TODO 测试所有的日志都能够支持显示输出
		int tmp=seq++;
		logger.info("info-----"+tmp);
		logger.debug("debug---"+tmp);
		logger.error("error---"+tmp);
		logger.fatal("fatal---"+tmp);
		System.out.println("this is syso "+tmp);
		System.err.println("this is syserr "+tmp);
		try {
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new ServletException();
	}
}
