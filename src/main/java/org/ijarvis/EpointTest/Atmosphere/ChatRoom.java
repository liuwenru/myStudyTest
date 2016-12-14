package org.ijarvis.EpointTest.Atmosphere;
import org.apache.log4j.Logger;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.cpr.AtmosphereResource;


@ManagedService(path="/chat")
public class ChatRoom{
	private static final Logger logger=Logger.getLogger(ChatRoom.class);
	@Message
	public void OnMessage(AtmosphereResource r,String message){
		logger.debug("OnMessage is ready............."+message);
	}
}
