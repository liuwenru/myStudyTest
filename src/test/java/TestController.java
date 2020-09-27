import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.ijarvis.SpringMVCApp.Apps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring-mvc.xml"})
public class TestController {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    // 注入loginController
    @Autowired
    private Apps loginController ;
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @PerfTest(threads=10, invocations=1)
    @Test
    public void testLogin() {
        try {
            request.setParameter("userName", "admin");
            request.setParameter("password", "1");
            assertEquals("index",loginController.loginTest(request,response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
