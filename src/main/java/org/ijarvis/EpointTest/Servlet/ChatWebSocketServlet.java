package org.ijarvis.EpointTest.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.StreamGobbler;
import org.apache.log4j.Logger;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.StreamGobbler;

@ServerEndpoint(value="/chat") 
public class ChatWebSocketServlet  {
	private static Logger logger=Logger.getLogger(ChatWebSocketServlet.class);
    private static final Set<ChatWebSocketServlet> connections =  new CopyOnWriteArraySet<ChatWebSocketServlet>();  
    private String nickname="";  
    private Session session;
    public ChatWebSocketServlet() {
    	this.nickname=UUID.randomUUID().toString();
	}
	@OnOpen
	public void onopen(Session session) {  
		logger.debug("websocket is open.........");
		this.session=session;
		connections.add(this);
	}

    @OnClose  
    public void close() {  
    	connections.remove(this);	
    }  
    @OnMessage  
    public void receive(String message) throws IOException {
    	logger.debug(this.nickname+"----"+message);
    	execCommand(message);
    	
    }
    private static void broadcast(String msg) {  
        for (ChatWebSocketServlet client : connections) {  
            try {  
                client.session.getBasicRemote().sendText(msg);  
            } catch (IOException e) {  
                connections.remove(client);  
                try {  
                    client.session.close();  
                } catch (IOException e1) {  
                }  
                String message = String.format("* %s %s",  
                        client.nickname, "has been disconnected.");  
                broadcast(message);  
            }
        }//for  
    }
    public static void execCommand(String cmd) throws IOException{
		Connection connection = new Connection("192.168.149.150", 22);
		connection.connect(); 
        boolean isAuthenticated = connection.authenticateWithPassword("ijarvis", "liuwenru"); 
        com.trilead.ssh2.Session session = connection.openSession();
        session.execCommand(cmd);
        InputStream stdout = new StreamGobbler(session.getStdout());  
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));  
        String message = "";  
        String line = null; 
        while((line = br.readLine()) != null) {
        	broadcast(line);
        	logger.debug(line);
            message += line;
        }
        logger.debug(message);
    }
}