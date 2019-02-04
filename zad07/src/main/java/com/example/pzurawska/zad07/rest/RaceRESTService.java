package com.example.pzurawska.zad07.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import com.example.pzurawska.zad07.domain.Race;
import com.example.pzurawska.zad07.service.RaceManager;



@Path("race")
@Stateless
public class RaceRESTService {
	

	@Inject
	private RaceManager pm;	
	
	@GET
	@Path("/{raceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Race getRace(@PathParam("raceId") int id) {
		return pm.getRace(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Race> getRace() {
		return pm.getAllRace();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRace(Race race) {
		pm.addRace(race);
		return Response.status(Response.Status.CREATED).entity("Race").build();
	}

	@PUT
	@Path("/{raceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Race updateRace(@PathParam("raceId") int id, Race race) {
		return pm.updateRace(race, id);
	}


	@DELETE
	public Response clearRaces() {
		pm.deleteAllRace();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{raceId}")
	public Response deleteRace(@PathParam("raceId") int id) {
		pm.deleteRace(id);
		return Response.status(200).build();
	}
}
