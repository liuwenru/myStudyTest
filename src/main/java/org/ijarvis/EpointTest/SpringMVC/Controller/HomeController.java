package org.ijarvis.EpointTest.SpringMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.RequestWrapper;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by ijarvis on 11/27/16.
 */

@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return  "home";
    }
}
