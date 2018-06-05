package org.ijarvis.SpringMVCTest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SpringMVCTest {
    @RequestMapping("/test")
    @ResponseBody
    public void saveTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException {
        System.out.println(req.getParameter("requestid"));
        if("null".equals(req.getParameter("requestid"))|| req.getParameter("requestid")==null){
            throw new NullPointerException();
        }
        //Thread.sleep(10000);
        resp.getWriter().println("Ep1111oint..*****..................");
    }
}
