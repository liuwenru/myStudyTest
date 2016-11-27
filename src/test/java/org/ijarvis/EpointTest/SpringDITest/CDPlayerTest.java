package org.ijarvis.EpointTest.SpringDITest;

import org.ijarvis.EpointTest.SpringFrame.CDPlayerConfig;
import org.ijarvis.EpointTest.SpringFrame.CompactDisc;
import org.ijarvis.EpointTest.SpringFrame.SgtPeppers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ijarvis on 11/27/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    public SgtPeppers cd;

    @Test
    public  void  cdShouldNotBeNull(){
        Assert.assertNotNull(cd);
        this.cd.play();
    }
}
