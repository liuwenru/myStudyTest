package org.ijarvis.servletTest;

/*
*   为了测试在多个POST请求下接受数据会不会出现问题
*
*
*
*
 */


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Tomcat7058Servlet extends HttpServlet {
    private static int REQUESTCOUNT=0;     //全局计数经过的请求数
    private static final Logger logger=Logger.getLogger(Tomcat7058Servlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        synchronized ((Object) REQUESTCOUNT){
            REQUESTCOUNT=REQUESTCOUNT+1;
            if(req.getParameter("BiaoDiGuid")==null || "".equals(req.getParameter("BiaoDiGuid"))){
                System.out.println("*&*&*&*&*");
            }
            if(req.getParameter("DanWeiGuid")==null || "".equals(req.getParameter("DanWeiGuid"))){
                System.out.println("*&*&*&*&*");
            }
            if(req.getParameter("isCommondto")==null || "".equals(req.getParameter("isCommondto"))){
                System.out.println("*&*&*&*&*");
            }
            if(req.getParameter("commonDto")==null || "".equals(req.getParameter("commonDto"))){
                System.out.println("*&*&*&*&*");
            }
            if(req.getParameter("cmdParams")==null || "".equals(req.getParameter("cmdParams"))){
                System.out.println("*&*&*&*&*");
            }
            //System.out.println(REQUESTCOUNT+"*"+req.getParameter("BiaoDiGuid")+"*"+req.getParameter("DanWeiGuid")+"*"+req.getParameter("isCommondto")+"*"+req.getParameter("commonDto")+"*"+req.getParameter("cmdParams"));
        }

    }
}
