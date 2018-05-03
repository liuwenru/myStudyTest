package org.ijarvis.AtmoshareTest;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;

import java.io.IOException;

public interface AtmosphereHandler {
    void onRequest(AtmosphereResource resource) throws IOException;

    void onStateChange(AtmosphereResourceEvent event) throws IOException;

    void destroy();
}
