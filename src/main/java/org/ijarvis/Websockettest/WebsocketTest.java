package org.ijarvis.Websockettest;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;

@ServerEndpoint(value = "/wschat")
public class WebsocketTest {
    private static ArrayList<Session> sessionList = new ArrayList<Session>();

    @OnOpen
    public void onOpen(Session session){
        try{
            sessionList.add(session);
            //asynchronous communication
            session.getBasicRemote().sendText("Hello!");
        }catch(IOException e){}
    }

    @OnClose
    public void onClose(Session session){
        sessionList.remove(session);
    }

    @OnMessage
    public void onMessage(String msg){
        try{
            for(Session session : sessionList){
                //asynchronous communication
                session.getBasicRemote().sendText(msg);
            }
        }catch(IOException e){}
    }
}
