package org.ijarvis.EpointTest.Atmosphere;
import org.apache.log4j.Logger;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import static org.atmosphere.cpr.ApplicationConfig.MAX_INACTIVE;
@ManagedService(path = "/websocket/chat",atmosphereConfig = MAX_INACTIVE + "=120000")
public class ChatRoom{
	private static final Logger logger=Logger.getLogger(ChatRoom.class);
	@Ready
	public String onReadys(final AtmosphereResource r) {

		logger.debug("Browser {} connected.");
		return "bbbbb";
	}
	@Ready
	public String onReady(final AtmosphereResource r) {

		logger.debug("Browser {} connected.");
		return "aaaaa";
	}

	@Message
	public void OnMessage(AtmosphereResource r,String message){

		logger.debug("OnMessage is ready............."+message);


	}
}
