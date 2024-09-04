package com.oracle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracle.beans.Profile;
import com.oracle.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

// http://ip:port/simple-restapi/webapi/profile/api

@Path("/profile/api")
public class ProfileController {
	// we must call the methods from the service hence we must create object of ProfileService
	private static ProfileService service = new ProfileService();
	
	// a web-service that can consume JSON to pass it to the service to add new resource
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // maps the JSON properties to the Profile parameter in the method
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Profile profile) {
		Profile createdProfile = service.addProfile(profile);
		return Response.status(201).entity(createdProfile).build();
	}
	// a web-service that can product JSON array by calling fetchProfiles of ProfileService
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response read() {
		List<Profile> list = service.findProfiles();
		return Response.status(200).entity(list).build();
	}
	
	// a web-service that can get the profile based on id
	@Path("/byid/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") int id) {
		Profile p = service.findProfile(id);
		if(p != null) {
			return Response.status(200).entity(p).build();
		} else {
			// map stores data in key & value
			Map<String, String> map = new HashMap<>();
			map.put("message", "Sorry id: "+id+" not found");
			return Response.status(404).entity(map).build();
		}
	}
	// a web-service that can delete the profile based on id
	@Path("/byid/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		int status = service.deleteProfile(id);
		if(status == 1) {
			Map<String, String> map = new HashMap<>();
			map.put("message", "Profile with an id: "+id+" deleted");
			return Response.status(404).entity(map).build();
		} else {
			Map<String, String> map = new HashMap<>();
			map.put("message", "Sorry id: "+id+" not found");
			return Response.status(404).entity(map).build();
		}
	}
	
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
