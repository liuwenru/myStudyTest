package org.ijarvis.AtmoshareTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.atmosphere.config.service.AtmosphereHandlerService;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor;
import org.atmosphere.interceptor.BroadcastOnPostAtmosphereInterceptor;

import java.io.IOException;

@AtmosphereHandlerService(path="/chat/atmospherechat", interceptors = { AtmosphereResourceLifecycleInterceptor.class, BroadcastOnPostAtmosphereInterceptor.class})
public class Chats extends OnMessage<String> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void onMessage(AtmosphereResponse response, String message) throws IOException {
        response.write(mapper.writeValueAsString(mapper.readValue(message, String.class)));
    }
}
