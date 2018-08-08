package org.ijarvis.servletTest;

/*
*   为了测试在多个POST请求下接受数据会不会出现问题
*
*
*
*
 */


import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("aaaaaaa");
//        InputStream is=null;
//        BufferedReader buffer;
//        StringBuffer bs;
//        try {
//            Thread.sleep(1*1000);
//            URL url = new URL("http://www.baidu.com");
//            HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
//            urlcon.connect();         //获取连接
//            is = urlcon.getInputStream();
//            buffer = new BufferedReader(new InputStreamReader(is));
//            bs = new StringBuffer();
//            String l = null;
//            while((l=buffer.readLine())!=null){
//                bs.append(l).append("/n");
//            }
//            System.out.println(bs.toString());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            is.close();
//        }
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=gfWBdedM0bApLPDnh6crlhUH&client_secret=qWcC6ep1Lsn1t9f4hZLYywczUxOdMcq0");
        HttpResponse response1 = httpclient.execute(httpGet);
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        String responseBody = EntityUtils.toString(response1.getEntity());
        System.out.println(StringEscapeUtils.unescapeJava(responseBody));
        resp.getWriter().println("aaaaa -----\n");
        resp.getWriter().println(StringEscapeUtils.unescapeJava(responseBody));
        resp.getWriter().println("aaaaa -----\n");
    }
}
