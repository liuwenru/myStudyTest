package org.ijarvis.EpointTest;

import java.io.IOException;

import org.ijarvis.EpointTest.trilead.trileadUnit;
import org.junit.Test;


public class MyTest {
	public static void main(String[] args) throws IOException {
		trileadUnit test=new trileadUnit();
		test.execCommand("tail -f anaconda-ks.cfg");
	}
	@Test
	public void trileadUnitTest() throws IOException{
		trileadUnit test=new trileadUnit();
		test.execCommand("tail -f anaconda-ks.cfg");
		
	}

}
