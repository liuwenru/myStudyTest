package org.ijarvis.EpointTest.SpringMVC.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.ijarvis.EpointTest.SpringMVC.Model.frame_user;
import org.ijarvis.EpointTest.SpringMVC.SpringMVC.Mapper.Frame_userMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 
 * @author ijarvis
 *
 */

@Controller
@RequestMapping(value="/mybatis")
public class DbController {
	private static final Logger logger=Logger.getLogger(DbController.class);
	
	@RequestMapping(value="dbget",method=RequestMethod.GET)
	public String dodb(){
		AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext();
		configApplicationContext.scan("org.ijarvis.EpointTest.SpringMVC");
		configApplicationContext.refresh();
		SqlSessionFactory sqlSessionFactory=(SqlSessionFactory) configApplicationContext.getBean("sqlSessionFactory");
		sqlSessionFactory.getConfiguration().addMapper(Frame_userMapper.class);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Frame_userMapper frame_userMapper=sqlSession.getMapper(Frame_userMapper.class);
		frame_user frameuser=(frame_user) frame_userMapper.selectFrameuser("46cc3826-cf59-463e-80b1-cf9203ec2f55");
		logger.debug(frameuser.getPassword());
		return "home";
	}
	
	
}
