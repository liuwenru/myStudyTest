package org.ijarvis;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liuwenru on 2017/2/20.
 */
@Controller
@RequestMapping("/index")
public class Apps {
    private static Logger logger=Logger.getLogger(Apps.class);
    @RequestMapping("/home")
    public String hello(HttpSession session) throws IOException, InterruptedException {
        logger.debug("-------"+session.getAttribute("sec"));
        if (session.getAttribute("sec")==null){
            logger.debug("exec here...........");
            session.setAttribute("sec",1000);
        }
        logger.debug(session.getAttribute("sec"));
        Thread.sleep(Long.parseLong(String.valueOf(Long.parseLong(session.getAttribute("sec").toString()))));
        return "hello";
    }
    @RequestMapping("/sec")
    public String setSec(@RequestParam(value = "sec") String sec,HttpSession session){
        session.setAttribute("sec",sec);
        logger.debug(session.getAttribute("sec"));
        return  "hello";
    }

    @RequestMapping("/exp")
    public void exp() throws IOException {
        throw new IOException();
    }

    @RequestMapping("/redi")
    public  String redic() {
        return "redirect:/index";
    }
    @RequestMapping("/")
    public  String index() {
        return "hello";
    }
}
