package org.ijarvis.EpointTest.Servlet;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint(value="/chat") 
public class ChatWebSocketServlet  {
	private static Logger logger=Logger.getLogger(ChatWebSocketServlet.class);
    private static final Set<ChatWebSocketServlet> connections =  new CopyOnWriteArraySet<ChatWebSocketServlet>();  
    private String nickname="";  
    private Session session;
    public ChatWebSocketServlet() {
		// TODO Auto-generated constructor stub
    	this.nickname=UUID.randomUUID().toString();
	}
	@OnOpen
	public void onopen(Session session) {  
		logger.debug("websocket is open.........");
		this.session=session;
		connections.add(this);
		logger.debug(this.nickname+" is comming.........");
	}

    @OnClose  
    public void close() {  

    }  
    @OnMessage  
    public void receive(String message) {
    	logger.debug(this.nickname+"----"+message);
 
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
                    // Ignore  
                }  
                String message = String.format("* %s %s",  
                        client.nickname, "has been disconnected.");  
                broadcast(message);  
            }//try   
        }//for  
    }
}