package org.ijarvis.EpointTest.SpringMVC.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.ijarvis.EpointTest.SpringMVC.Mappers.FrameuserMapper;
import org.ijarvis.EpointTest.SpringMVC.Mappers.MyUserMapper;
import org.ijarvis.EpointTest.SpringMVC.Model.FrameUser;
import org.ijarvis.EpointTest.SpringMVC.Model.MyUser;
import org.ijarvis.EpointTest.SpringMVC.SpringMVCUtils.SpringContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DbController {
	private static final Logger logger=Logger.getLogger(DbController.class);
	@RequestMapping(value="/mybatis",method=RequestMethod.GET)
	public  String index(){
		return "index";
	}
	@RequestMapping(value="/mybatis/insert",method=RequestMethod.POST)
	public String Insert(MyUser myUser, Model model){
		SqlSessionFactory sqlSessionFactory=(SqlSessionFactory) SpringContextUtils.getApplicationContext().getBean("sqlSessionFactory");
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MyUserMapper myUserMapper = sqlSession.getMapper(MyUserMapper.class);
		logger.debug(myUserMapper.InsertUser(myUser));
		sqlSession.close();
		return "home";
	}
    @RequestMapping(value="/mybatis/update",method=RequestMethod.POST)
    public String Update(MyUser myUser, Model model){
        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory) SpringContextUtils.getApplicationContext().getBean("sqlSessionFactory");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        MyUserMapper myUserMapper = sqlSession.getMapper(MyUserMapper.class);
        logger.debug(myUserMapper.UpdateUser(myUser));
        sqlSession.close();
        return "home";
    }
	
	
}
