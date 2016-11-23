package org.ijarvis.EpointTest.DruidMonitor;

import java.sql.SQLException;

import org.ijarvis.EpointTest.Druid.DruidTestM;
import org.junit.Test;
import org.springframework.beans.BeansException;

public class DruidJunitTest {
	@Test
	public void DruidTest() throws BeansException, SQLException{
		DruidTestM.druidInsert();
	}
}
