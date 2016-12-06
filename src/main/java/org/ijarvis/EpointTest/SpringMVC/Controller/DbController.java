package org.ijarvis.EpointTest.SpringMVC.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.ijarvis.EpointTest.SpringMVC.Mappers.FrameuserMapper;
import org.ijarvis.EpointTest.SpringMVC.Model.FrameUser;
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
		sqlSessionFactory.getConfiguration().addMapper(FrameuserMapper.class);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		FrameuserMapper frame_userMapper=sqlSession.getMapper(FrameuserMapper.class);
		FrameUser frameuser=(FrameUser) frame_userMapper.selectFrameuser();
		logger.debug(frameuser.getPassword());
		return "home";
	}
	
	
}
