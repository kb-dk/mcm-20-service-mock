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
				  "Try out %sObject/Get?sessionGUID=fa49caf1-0586-4ee3-b4c3-1ab823ba108f&objectGuids=84802737-4910-d941-a7f0-14e4bdf1bc4d&includeMetadata=true&includeFiles=true\nHit enter to stop it...", baseUri, baseUri));
		  System.in.read();
		  threadSelector.stopEndpoint();
		  System.exit(0);
	}    
}