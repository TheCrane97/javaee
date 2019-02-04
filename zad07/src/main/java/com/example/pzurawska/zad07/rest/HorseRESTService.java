package com.example.pzurawska.zad07.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.pzurawska.zad07.domain.Horse;
import com.example.pzurawska.zad07.service.HorseManager;


@Path("horse")
@Stateless
public class HorseRESTService {
	
	@Inject
	private HorseManager mm;
	
	@GET
	@Path("/{horseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Horse getHorse(@PathParam("horseId") int id) {
		return mm.getHorse(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Horse> getHorse() {
		return mm.getAllHorses();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHorse(Horse horse) {
		mm.addHorse(horse);
		return Response.status(Response.Status.CREATED).entity("horse").build();
	}
	
	@PUT
	@Path("/{horseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Horse updateHorse(@PathParam("horseId") int id, Horse horse) {
		return mm.updateHorse(horse, id);
	}
	
	
	@DELETE
	public Response clearHorses() {
		mm.deleteAllHorses();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{horseId}")
	public Response deleteHorse(@PathParam("horseId") int id) {
		mm.deleteHorse(id);
		return Response.status(200).build();
	}

}
