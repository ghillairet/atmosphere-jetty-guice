package org.sample;

import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import org.atmosphere.container.Jetty9AsyncSupportWithWebSocket;
import org.atmosphere.guice.AtmosphereGuiceServlet;
import org.sample.resources.SocketResource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AppServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        Map<String, String> params = new HashMap<>();
        params.put("com.sun.jersey.config.property.packages", "org.sample.resources");
        params.put("org.atmosphere.websocket.messageContentType", "application/json");
        params.put("org.atmosphere.cpr.asyncSupport", Jetty9AsyncSupportWithWebSocket.class.getName());

        serve("/socket/*").with(AtmosphereGuiceServlet.class, params);

        bind(SocketResource.class);
        bind(new TypeLiteral<Map<String, String>>() {
        }).annotatedWith(Names.named(AtmosphereGuiceServlet.PROPERTIES)).toInstance(
                Collections.<String, String> emptyMap());
    }

}
