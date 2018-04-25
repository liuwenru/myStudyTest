package org.ijarvis.SpringMVCTest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
//@RequestMapping("/jvm")
//public class OOMTest {
//    static class OOMObject{
//        private String name="aaaaaaaaaaaaaaaaaaaaaaaaa";
//    }
//    @RequestMapping("/oom")
//    public String oom(){
//        List<OOMObject> list=new ArrayList<OOMObject>();
//        while (true){
//            list.add(new OOMObject());
//        }
//    }
//
//}
@Controller
public class SpringMVCTest {
    @RequestMapping("/test")
    @ResponseBody
    public void saveTest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getParameter("requestid"));
        if("null".equals(req.getParameter("requestid"))|| req.getParameter("requestid")==null){
            throw new NullPointerException();
        }
        resp.getWriter().println("Epoint....................");
    }

}
