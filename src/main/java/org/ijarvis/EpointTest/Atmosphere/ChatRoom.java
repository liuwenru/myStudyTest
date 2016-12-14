package org.ijarvis.EpointTest.Atmosphere;
import org.apache.log4j.Logger;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.atmosphere.cpr.ApplicationConfig.MAX_INACTIVE;
@ManagedService(path = "/websocket/chat",atmosphereConfig = MAX_INACTIVE + "=120000")
public class ChatRoom{
	private static final Logger logger=Logger.getLogger(ChatRoom.class);
	@Inject
	private BroadcasterFactory factory;
	@Inject
	private AtmosphereResource r;
	@Inject
	@Named("/websocket/chat")
	private static Broadcaster broadcaster;
	@Ready
	public void onReady(final AtmosphereResource r) {
		logger.debug("Browser {} connected.");
		logger.info("BroadcasterFactory used {}"+factory.getClass().getName());
		logger.info("Broadcaster injected {}"+broadcaster.getID());
	}
	@Message
	public void OnMessage(AtmosphereResource r,String message) throws ExecutionException, InterruptedException {
		logger.debug("OnMessage is ready............."+message);
//		r.getBroadcaster().broadcast("this is a brocaset message"+message+" comeing................");
//		r.getBroadcaster().broadcast("this is a brocaset message comeing................");
		broadcaster.broadcast(message);
	}
	@Disconnect
	public void disconnected(AtmosphereResource r) {
		logger.debug("connection close................"+r.uuid());
	}
}
