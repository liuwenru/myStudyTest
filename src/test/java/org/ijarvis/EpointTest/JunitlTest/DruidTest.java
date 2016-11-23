package org.ijarvis.EpointTest.JunitlTest;

import java.io.IOException;
import java.sql.SQLException;

import org.ijarvis.EpointTest.Druid.DruidTestM;
import org.ijarvis.EpointTest.DruidMonitor.DruidMonitorTest;
import org.junit.Test;
import org.springframework.beans.BeansException;

public class DruidTest {
	@Test
	public void DruidTest() throws IOException, BeansException, SQLException{
		DruidMonitorTest.GetDruidMonitorInfo();
		while(true){
			DruidTestM.druidInsert();
		}
	}

}
