package org.ijarvis.EpointTest.trilead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;



/**
 * 
 * @author ijarvis
 *	使用trilead实现远程连接值主机，执行命令
 */
public class trileadUnit {
	private static Logger logger=Logger.getLogger(trileadUnit.class);
	private String hostname="192.168.149.152";
	private String username="root";
	private String userpass="liuwenru";
	private int port=22;
	private Connection connection=null;
	private Session session=null;

	public trileadUnit() throws IOException {
		this.connection=new Connection(hostname);
		this.connection.connect();
		boolean isAuthenticated= this.connection.authenticateWithPassword( username, userpass);
		if (isAuthenticated == false)  
               throw new IOException("Authentication failed.");  
		this.session=this.connection.openSession();
	}
	public void execCommand(String command) throws IOException{
		this.session.execCommand(command);
//		InputStream stdin = this.session.getStdout();
		InputStream stdout = new StreamGobbler(this.session.getStdout());
		BufferedReader br = new BufferedReader(new InputStreamReader(stdout)); 
        while (true)
        {  
            String line = br.readLine();  
            if (line == null)  
                break;  
            System.out.println(line);  
        }  
	}
	public static void main(String args[]) throws IOException{
		new trileadUnit().execCommand("vim anaconda-ks.cfg");
	}
	
	
	
}
