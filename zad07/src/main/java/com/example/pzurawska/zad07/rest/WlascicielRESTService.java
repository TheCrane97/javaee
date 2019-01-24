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

import com.example.pzurawska.zad07.domain.Wlasciciel;
import com.example.pzurawska.zad07.service.WlascicielManager;


@Path("wlasciciel")
@Stateless
public class WlascicielRESTService {
	

	@Inject
	private WlascicielManager pm;
	
	@GET
	@Path("/{wlascicielId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Wlasciciel getWlascicieln(@PathParam("wlascicielId") int id) {
		return pm.getWlasciciel(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wlasciciel> getWlasciciel() {
		return pm.getAllWlasciciel();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addWlasciciel(Wlasciciel wlasciciel) {
		pm.addWlasciciel(wlasciciel);
		return Response.status(Response.Status.CREATED).entity("Wlasciciel").build();
	}
	
	@PUT
	@Path("/{wlascicielId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Wlasciciel updateWlasciciel(@PathParam("wlascicielId") int id, Wlasciciel wlasciciel) {
		return pm.updateWlasciciel(wlasciciel, id);
	}
	
	
	
	@DELETE
	@Path("/{wlascicielId}")
	public Response deleteWlasciciel(@PathParam("wlascicielId") int id) {
		pm.deleteWlasciciel(id);
		return Response.status(200).build();
	}
	
	@DELETE
	public Response clearWlasciciel() {
		pm.deleteAllWlasciciel();
		return Response.status(Response.Status.OK).build();
	}

}
