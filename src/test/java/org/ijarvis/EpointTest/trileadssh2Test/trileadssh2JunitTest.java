package org.ijarvis.EpointTest.trileadssh2Test;

import org.apache.log4j.Logger;
import org.junit.Test;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class trileadssh2JunitTest {
	private static Logger logger=Logger.getLogger(trileadssh2JunitTest.class);
	@Test
	public void trileadssh2Test() throws IOException{
		Connection connection = new Connection("192.168.149.150", 22);
		connection.connect(); 
        boolean isAuthenticated = connection.authenticateWithPassword("ijarvis", "liuwenru"); 
        final Session session = connection.openSession();
        session.execCommand("vim");
        InputStream stdout = new StreamGobbler(session.getStdout());  
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));  
        String message = "";  
        String line = null; 
        while((line = br.readLine()) != null) {
        	
        	logger.debug(line);
            message += line;
        }
        logger.debug(message);
	}
}
