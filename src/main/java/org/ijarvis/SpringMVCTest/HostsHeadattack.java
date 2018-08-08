package org.ijarvis.SpringMVCTest;

// 验证 主机头攻击

import org.apache.catalina.LifecycleException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HostsHeadattack {
    @RequestMapping("/HostHeadattack")
    @ResponseBody
    public void HeadTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, LifecycleException {
        resp.sendRedirect("/intelliq-web/index.html");
    }
}
