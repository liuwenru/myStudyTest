package org.ijarvis.EpointTest.MyBatisJunits;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by ijarvis on 12/4/16.
 */
public class MyBatisTest {
    @Test
    public  void  TestMyBatis(){
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
