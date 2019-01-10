package com.example.pzurawska.zad07.rest;


import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.pzurawska.zad07.domain.Horse;
import com.example.pzurawska.zad07.service.HorseManager;

@Path("horse")
public class HorseRESTService {
	
	@EJB
	HorseManager hm;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHorse(Horse horse){
		hm.addHorse(horse);
		return Response.status(201).entity("Horse").build(); 
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Horse getHorse(@PathParam("id") Long id){
		
		Horse retrieved = hm.getHorse(id);
		return retrieved;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Horse> getAllHorses(){
		return hm.getAll();
	}

	
	@DELETE
	public Response clearHorses(){
		hm.deletAll();
		return Response.status(200).build();
	}
	
	

}
