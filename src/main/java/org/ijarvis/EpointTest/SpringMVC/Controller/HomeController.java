package org.ijarvis.EpointTest.SpringMVC.Controller;

import org.ijarvis.EpointTest.Weblogic.WebLogicLogTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.xml.ws.RequestWrapper;

import java.io.IOException;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by ijarvis on 11/27/16.
 *
 *
 *
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return  "home";
    }
    @RequestMapping(value = "/weblogic",method = RequestMethod.GET)
    public  String weblogic() {
        return "home";
    }
}
