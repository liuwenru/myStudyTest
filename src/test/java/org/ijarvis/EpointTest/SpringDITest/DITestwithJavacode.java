package org.ijarvis.EpointTest.SpringDITest;

import org.ijarvis.EpointTest.SpringFrame.CDPlayJavaConfig;
import org.ijarvis.EpointTest.SpringFrame.CompactDisc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ijarvis on 11/27/16.
 */
public class DITestwithJavacode {
    @Test
    public  void  TestConfigTest(){
        ApplicationContext context=new AnnotationConfigApplicationContext(CDPlayJavaConfig.class);
        CompactDisc compactDisc=context.getBean(CompactDisc.class);
        compactDisc.play();
    }
}
