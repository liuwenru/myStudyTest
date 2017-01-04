package org.ijarvis.EpointTest.AtmosphereWebsocket;

import org.apache.log4j.Logger;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;

@ManagedService(path="/websocket/chat")
public class AtmosphereWebsocketTest {
	private static Logger logger=Logger.getLogger(AtmosphereWebsocketTest.class);
	@Ready
	public void onReady(AtmosphereResource resource){
		logger.debug("Atmosphere.............onReady...........");
	}
	
	@Message
	public void onMessage(String resource){
		logger.debug("Atmosphere.............onMessage..........."+resource);
	}
	@Disconnect
	public void disconnected(AtmosphereResourceEvent r) {
		logger.debug("Atmosphere.............disconnected...........");
	}
	

}
