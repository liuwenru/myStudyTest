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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tomcat7058Servlet extends HttpServlet {
    private static int REQUESTCOUNT=0;     //全局计数经过的请求数
    private static final Logger logger=Logger.getLogger(Tomcat7058Servlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
//        synchronized ((Object) REQUESTCOUNT){
//            REQUESTCOUNT=REQUESTCOUNT+1;
//            if(req.getParameter("BiaoDiGuid")==null || "".equals(req.getParameter("BiaoDiGuid"))){
//                System.out.println("*&*&*&*&*");
//            }
//            if(req.getParameter("DanWeiGuid")==null || "".equals(req.getParameter("DanWeiGuid"))){
//                System.out.println("*&*&*&*&*");
//            }
//            if(req.getParameter("isCommondto")==null || "".equals(req.getParameter("isCommondto"))){
//                System.out.println("*&*&*&*&*");
//            }
//            if(req.getParameter("commonDto")==null || "".equals(req.getParameter("commonDto"))){
//                System.out.println("*&*&*&*&*");
//            }
//            if(req.getParameter("cmdParams")==null || "".equals(req.getParameter("cmdParams"))){
//                System.out.println("*&*&*&*&*");
//            }
//
//            //System.out.println(REQUESTCOUNT+"*"+req.getParameter("BiaoDiGuid")+"*"+req.getParameter("DanWeiGuid")+"*"+req.getParameter("isCommondto")+"*"+req.getParameter("commonDto")+"*"+req.getParameter("cmdParams"));
//        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaaaaaa");
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URL url = new URL("http://www.swsg.lnjst.gov.cn/GetFvalidDateServiceV2.asmx?wsdl");
        HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
        urlcon.connect();         //获取连接
        InputStream is = urlcon.getInputStream();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
        StringBuffer bs = new StringBuffer();
        String l = null;
        while((l=buffer.readLine())!=null){
            bs.append(l).append("/n");
        }
        System.out.println(bs.toString());
    }
}
