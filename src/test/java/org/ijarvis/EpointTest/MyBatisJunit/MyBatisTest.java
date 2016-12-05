package org.ijarvis.EpointTest.MyBatisJunit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ijarvis.EpointTest.SpringMVC.Model.FrameUser;
import org.ijarvis.EpointTest.SpringMVC.Mappers.FrameuserMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ijarvis on 12/4/16.
 */
public class MyBatisTest {
    @Test
    public  void  TestMyBatis() throws IOException{
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(FrameuserMapper.class);
        SqlSession session = sqlSessionFactory.openSession();
        FrameuserMapper mapper = session.getMapper(FrameuserMapper.class);
        FrameUser frameuser = mapper.selectFrameuser("46cc3826-cf59-463e-80b1-cf9203ec2f55");
        System.out.println(frameuser.getLoginid());
    }
}
