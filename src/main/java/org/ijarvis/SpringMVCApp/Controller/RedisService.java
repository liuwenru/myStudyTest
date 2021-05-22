package org.ijarvis.SpringMVCApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class RedisService {
    Logger logger = LoggerFactory.getLogger(RedisService.class);

    @RequestMapping(value = "/redis", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    HashMap<String, String> redis(Model model, HttpServletRequest request, HttpServletResponse response) {
        Jedis jedis = new Jedis("192.168.188.150", 6379);
        jedis.auth("Infra5_Gep0int");
        String redisinfo = jedis.info();
        HashMap<String, String> rs = new HashMap<String, String>();
        rs.put("redisinfo", redisinfo);
        jedis.close();
        return rs;
    }
}