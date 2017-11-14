package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import java.net.URI;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class HelloENSMAMain {

    public static final URI BASE_URI = getBaseURI();

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/rest/").port(9991).build();
    }
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Response getXmlWithParams(
            @PathParam("id") String id,
            @DefaultValue("all") @HeaderParam("name") String name) {
        System.out.println(id);
        System.out.println(name);
        return Response
          .status(Status.OK)
          .entity("<bonjour>Bonjour ENSMA de la part de " + name + "</bonjour>")
          .build();
    }

    public static void main(String[] args) {
        ResourceConfig rc = new ResourceConfig();
        rc.packages("soa.jaxrslabs.helloensmarestwebserviceexercice1");
        try {
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
          server.start();
            
            
            System.out.println(String.format("Jersey app started with WADL available at "
                    + "%sapplication.wadl\nHit enter to stop it...",
                    BASE_URI, BASE_URI));
            System.in.read();
            server.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}