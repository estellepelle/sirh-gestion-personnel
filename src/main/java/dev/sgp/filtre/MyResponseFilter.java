package dev.sgp.filtre;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class MyResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext req, ContainerResponseContext resp) throws IOException {
		// TODO Auto-generated method stub
		
		resp.getHeaders().add("Access-Control-Allow-Origin",  "*");
		resp.getHeaders().add("Access-Control-Allow-Headers",  "origin, content-type, accept, authorization"); 
		resp.getHeaders().add("Access-Control-Allow-Credentials",  "true"); 
		resp.getHeaders().add("Access-Control-Allow-Methods",  "GET, POST, PUT, DELETE, OPTIONS, HEAD"); 
		resp.getHeaders().add("Access-Control-Max-Age",  "1209600");  
	}

}
