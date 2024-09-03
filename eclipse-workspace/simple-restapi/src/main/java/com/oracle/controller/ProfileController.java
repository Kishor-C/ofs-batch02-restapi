package com.oracle.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

// http://ip:port/simple-restapi/webapi/profile/api

@Path("/profile/api")
public class ProfileController {

	
	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)
	public Response greetMessage3() {
		// assume you are sending an employee object data: id, name, salary
		String employee = "<employee><id>100</id><name>Raj</name><salary>40000</salary></employee>";
		return Response.status(200).entity(employee).build();
	}
	
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public Response greetMessage4() {
		// assume you are sending an employee object data: id, name, salary
		String text = "<body><h2>Hello Everyone</h2></body>";
		return Response.status(200).entity(text).build();
	}
	
	
	
	@GET
	@Path("/greet")
	@Produces(MediaType.TEXT_PLAIN)
	public Response greetMessage() {
		if(Math.random() > 0.5) {
			return Response.status(200).entity("Success response").build();
		} else {
			return Response.status(404).entity("Error response").build();
		}
	}
	
	@POST
	@Path("/greet")
	@Produces(MediaType.TEXT_PLAIN)
	public String greetMessage2() {
		return "Got it from Post method!";
	}
	
}
