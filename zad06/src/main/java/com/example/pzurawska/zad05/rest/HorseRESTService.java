package com.example.pzurawska.zad05.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.pzurawska.zad05.domain.Horse;
import com.example.pzurawska.zad05.service.HorseManager;


@Path("horse")
@Stateless


public class HorseRESTService {
	
	@Inject
	private HorseManager hm;

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Horse getHorse(@PathParam("name") String name) {
		return hm.getHorse(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Horse> getHorses() {
		return hm.getAllHorses();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHorse(Horse horse) {
		hm.addHorse(horse);
		return Response.status(201).entity("Horse").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Dziala!!";
	}

	@DELETE
	public Response clearPersons() {
		hm.deleteAllHorses();
		return Response.status(200).build();
	}

}
