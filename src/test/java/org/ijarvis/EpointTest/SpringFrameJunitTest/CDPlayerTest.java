package org.ijarvis.EpointTest.SpringFrameJunitTest;

import static org.junit.Assert.*;

import org.ijarvis.EpointTest.SpringFrame.CDPlayerConfig;
import org.ijarvis.EpointTest.SpringFrame.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
	
	@Autowired
	private CompactDisc cd;
	
	@Test
	public void cdShouldNotBeNull(){
		assertNotNull(cd);
	}

}
