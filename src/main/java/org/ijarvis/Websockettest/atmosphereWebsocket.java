package org.ijarvis.Websockettest;


import org.apache.log4j.Logger;
import org.atmosphere.config.service.*;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.Broadcaster;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@ManagedService(path = "/websocket/eXun", atmosphereConfig = {"org.atmosphere.cpr.CometSupport.maxInactiveActivity=120000" })
public class atmosphereWebsocket {

    transient private Logger logger = Logger.getLogger(getClass());

    @Inject
    private AtmosphereResource r;

    @Inject
    @Named("/websocket/eXun")
    public static Broadcaster broadcaster;

    /**
     * 打开连接时触发
     */
    @Ready
    public void onReady() {
        logger.debug("user connected : " + r.getRequest().getHeader("uid"));
    }

    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
        // 获取用户信息
        String userGuid = r.getRequest().getHeader("uid");
        if (event.isCancelled()) {// 非正常关闭时触发，报错了
            logger.debug("user accidental disconnected : " + userGuid);
        }
        else if (event.isClosedByClient()) {// 关闭连接时触发
            logger.debug("user disconnected : " + userGuid);
        }
    }
    /**
     * 接收到消息
     */
    public void onMessage(String data) throws IOException {
        logger.debug("resolve message");
    }

    @Heartbeat
    public void onHeartbeat(AtmosphereResourceEvent event) {
        logger.debug("Heartbeat send by {" + event.getResource().uuid() + "}");
    }
}
