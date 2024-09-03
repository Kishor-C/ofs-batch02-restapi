package com.oracle.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// http://ip:port/simple-restapi/webapi/profile/api

@Path("/profile/api")
public class ProfileController {

	@GET
	@Path("/greet")
	@Produces(MediaType.TEXT_PLAIN)
	public String greetMessage() {
		return "Got it!";
	}
}
