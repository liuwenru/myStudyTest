package org.ijarvis.SpringMVCApp.Controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Controller
public class RESTfulservice {
    Logger logger = LoggerFactory.getLogger(RESTfulservice.class);
    private static final Collection<Object> leak = new ArrayList<>();
    private static volatile Object sink;
    @RequestMapping(value = "/printmsg", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    HashMap<String, String> printmsg(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InterruptedException {
        System.out.println("appprintmsg  request:"+System.identityHashCode(request)+" response:"+System.identityHashCode(response)+ " "+ response.toString() + "   "+ Thread.currentThread().getName());
        HashMap<String, String> rs = new HashMap<String, String>();
        rs.put("content", request.getParameter("p"));
        logger.debug(request.getParameter("p"));
        //System.out.print(request.getParameter("p"));
        Thread.sleep(Integer.parseInt(request.getParameter("sleeptime")));
        return rs;
    }

    @RequestMapping(value = "/downloadfile")
    public void sendUploadVoice(HttpServletResponse response, HttpServletRequest request) {
        try {
            //接收请求
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream");
            //获取文件
            String fileName = request.getParameter("filename");
            //获取文件输入流  localFileDir是服务端存储文件的路径
            File file = new File("/opt/tomcat" + File.separator + fileName);
            response.setContentLength((int) file.length());
            response.setHeader("Accept-Ranges", "bytes");
            InputStream in = new BufferedInputStream(new FileInputStream(file), 4096);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());

            byte[] bytes = new byte[4096];
            int i = 0;
            while ((i = in.read(bytes)) > 0) {
                os.write(bytes, 0, i);
            }
            os.flush();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getserviceall", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    HashMap<String, String> getserviceall(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap<String, String> rs = new HashMap<String, String>();
        rs.put("redisinfo", dowebrequest("http://localhost:8080/intelliq-web/spring/redis"));
        rs.put("mysqlinfo", dowebrequest("http://localhost:8080/intelliq-web/spring/mysql"));
        return rs;
    }

    public String dowebrequest(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            System.out.println("Executing request " + httpget.getRequestLine());
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            return responseBody;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            httpclient.close();
        }
    }

    @RequestMapping(value = "/print", method = {RequestMethod.POST, RequestMethod.GET})
    public void TestMessage(HttpServletRequest request,HttpServletResponse response) throws IOException, InterruptedException {
        response.getWriter().println("1111");
        response.getWriter().flush();
//        String a="1";
//        for(int i=0;i<100000;i++){
//            a=a+"11";
//        }
        Thread.sleep(5*1000);
        response.getWriter().println("2222");
    }

    @RequestMapping(value = "/fullgctest", method = {RequestMethod.POST, RequestMethod.GET})
    public void fullgctest(HttpServletRequest request,HttpServletResponse response) throws IOException, InterruptedException {
        logger.debug("Start..........");
        while(true) {
            try {
                Long start = System.currentTimeMillis();
                leak.add(new byte[1024 * 1024]);
                sink = new byte[1024 * 1024];
                Long end = System.currentTimeMillis();
                if ((end-start)/1000.0>1){
                    logger.debug(end+" spend:"+(end-start)/1000.0);
                }
            } catch(OutOfMemoryError e) {
                leak.clear();
                break;
            }
        }
        response.getWriter().println("Exec Successs.............");
        logger.debug("End..........");
    }


}
