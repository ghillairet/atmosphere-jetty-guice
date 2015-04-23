package org.sample;

import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main {

    public static void main(String... args) throws Exception {
        final Server server = new Server(8080);
        final ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

        handler.addEventListener(new AppConfig());
        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));

        handler.addServlet(DefaultServlet.class, "/");

        server.start();
        server.join();
    }

}
