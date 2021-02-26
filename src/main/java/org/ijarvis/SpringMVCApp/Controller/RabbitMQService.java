package org.ijarvis.SpringMVCApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class RabbitMQService {
    Logger logger = LoggerFactory.getLogger(RabbitMQService.class);
    @RequestMapping(value = "/rabbitmq", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    HashMap<String,String> rabbitmq(Model model, HttpServletRequest request, HttpServletResponse response) {
        HashMap<String,String> rs=new HashMap<String,String>();
        return  rs;
    }
}
