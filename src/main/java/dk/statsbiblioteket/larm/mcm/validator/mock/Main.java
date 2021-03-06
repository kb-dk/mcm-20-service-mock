package dk.statsbiblioteket.larm.mcm.validator.mock;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

public class Main {
	
	public static void main(String[] args) throws IOException {
		  final String baseUri = "http://localhost:9998/";
		  final Map<String, String> initParams = 
			  new HashMap<String, String>();
	  
		  initParams.put("com.sun.jersey.config.property.packages", "dk.statsbiblioteket.larm.mcm.validator.mock");
	 
		  System.out.println("Starting grizzly...");
		  SelectorThread threadSelector = 
			  GrizzlyWebContainerFactory.create(baseUri, initParams);
		  System.out.println(String.format(
				  "Jersey app started with WADL available at %sapplication.wadl\n" + 
				  "Try out %sObject/Get?sessionGUID=sample.mp4&query=UUID:9b8d95d1-dccc-458d-bfbd-eed7ecc84422&includeFiles=true&pageSize=1 or %soutput_internal_status\nHit enter to stop it...", baseUri, baseUri, baseUri));
		  System.in.read();
		  threadSelector.stopEndpoint();
		  System.exit(0);
	}    
}