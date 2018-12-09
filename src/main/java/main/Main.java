package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestServlet;

public class Main {
    public static void main(String args[]) throws Exception{
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        server.setHandler(context);
        context.addServlet(new ServletHolder(mirrorRequestServlet), "/mirror");
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");


        server.start();
        server.join();
    }
}
