package soa.jaxrslabs.helloensmarestwebserviceexercice1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

		@Path("helloensma")
		public class HelloENSMA {
		    public HelloENSMA() { }
	    
	    @GET
	    @Produces("application/xml")
	    public String getXml() {
	        return "<bonjour>Bonjour ENSMA</bonjour>";
    }
}
