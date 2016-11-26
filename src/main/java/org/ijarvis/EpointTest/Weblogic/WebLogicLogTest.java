package org.ijarvis.EpointTest.Weblogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class WebLogicLogTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(WebLogicLogTest.class);
	private static int seq=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			// TODO: handle exception
			e.printStackTrace();
		}
		throw new ServletException();
	}
}
