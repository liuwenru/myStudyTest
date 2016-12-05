package org.ijarvis.EpointTest.SpringMVC.Controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ijarvis on 11/27/16.
 *
 */

@Controller
public class HomeController {
    private  static  final Logger logger=Logger.getLogger(HomeController.class);
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(@RequestHeader("User-Agent") String userAgent){
        logger.debug(userAgent+"----------");
        return  "index";
    }
    @RequestMapping(value = "/weblogic",method = RequestMethod.GET)
    public  String weblogic(@RequestHeader("User-Agent") String userAgent) {
        logger.debug(userAgent+"------------");
        
        return "home";
    }
    
    //使用PathVarible来获取数据
    @RequestMapping(value = "/list/{uuid}",method = RequestMethod.GET)
    public  String listUsers(@PathVariable("uuid") String uuid,Model model){
        logger.debug("I get the paramter {UUID}:"+uuid);
        return  "home";
    }
    //使用RequestPara来获取似数据
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String listUsers(@RequestParam("uuid") int uuuid,Model model){
        logger.debug("I get The GET Paramters UUID"+ uuuid );
        return "home";
    }
    @RequestMapping(value = "adduser",method = RequestMethod.POST)
    public  String addUser(HttpServletRequest request, Model model){
        logger.debug(request.getParameter("name"));
        model.addAttribute("yourname",request.getParameter("name"));
        return  "home";
    }
    @RequestMapping(value = "addusers",method = RequestMethod.POST)
    public  String addUsers(user tmpusers,Model model){
        model.addAttribute("yourname","Epoint");
        logger.debug("********************************");
        logger.debug(tmpusers.getName());
        logger.debug("-------------------------------");
        logger.debug(tmpusers.getPass());
        logger.debug("********************************");
        return "home";
    }

}