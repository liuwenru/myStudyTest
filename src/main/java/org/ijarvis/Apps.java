package org.ijarvis;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String hello(@RequestParam(value = "sec") String sec) throws IOException, InterruptedException {
        Thread.sleep(Long.parseLong(sec));
        logger.info("vvvvv");
        return "hello";
    }
}
