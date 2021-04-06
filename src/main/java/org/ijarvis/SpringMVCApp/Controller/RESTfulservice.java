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
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class RESTfulservice {
    Logger logger = LoggerFactory.getLogger(RedisService.class);

    @RequestMapping(value = "/printmsg", method = {RequestMethod.POST,RequestMethod.GET})
    public void printmsg(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap<String,String> rs=new HashMap<String,String>();


//        rs.put("printmsg",request.getParameter("msg"));
//        rs.put("userid",request.getHeader("userid").toString());
        String str="11111111111111111111111111111111111111111111111111111111111111111111111";
        response.setContentLength((int)str.length()+2);
        response.getWriter().write(str);

        request.getRequestDispatcher("index.html").forward(request,response);
        return;
    }

    @RequestMapping(value = "/getserviceall", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    HashMap<String,String> getserviceall(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap<String,String> rs=new HashMap<String,String>();
        rs.put("redisinfo",dowebrequest("http://localhost:8080/intelliq-web/spring/redis"));
        rs.put("mysqlinfo",dowebrequest("http://localhost:8080/intelliq-web/spring/mysql"));
        return  rs;
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
                        final HttpResponse response) throws ClientProtocolException, IOException {
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
        }  catch (IOException e) {
            e.printStackTrace();
            return  "";
        } finally {
            httpclient.close();
        }
    }
}
