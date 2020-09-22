import org.ijarvis.SpringMVCTest.SpringMVCTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/beans.xml","classpath*:/spring-mvc.xml"})
public class TestController {
    // 模拟request,response
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    // 注入loginController
    @Autowired
    private SpringMVCTest loginController ;

    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }
    /**
     *
     * @Title：testLogin
     * @Description: 测试用户登录
     */
    @Test
    public void testLogin() {
        try {
            request.setParameter("userName", "admin");
            request.setParameter("password", "2");
            assertEquals("login",loginController.loginTest(request,response)) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
