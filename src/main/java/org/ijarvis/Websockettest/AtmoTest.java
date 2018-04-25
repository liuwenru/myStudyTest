package org.ijarvis.Websockettest;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.cpr.AtmosphereResponse;

@ManagedService(path = "/echo")
public class AtmoTest {

    @org.atmosphere.config.service.Message
    public void onMessage(AtmosphereResponse res, String m) {
        res.write("Echo: " + m);
    }
}
