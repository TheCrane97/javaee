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

import com.example.pzurawska.zad07.domain.Rasa;
import com.example.pzurawska.zad07.service.RasaManager;



@Path("rasa")
@Stateless
public class RasaRESTService {
	

	@Inject
	private RasaManager pm;	
	
	@GET
	@Path("/{rasaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rasa getProducer(@PathParam("rasaId") int id) {
		return pm.getRasa(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rasa> getRasa() {
		return pm.getAllRasa();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRasa(Rasa rasa) {
		pm.addRasa(rasa);
		return Response.status(Response.Status.CREATED).entity("Rasa").build();
	}

	@PUT
	@Path("/{rasaId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Rasa updateRasa(@PathParam("rasaId") int id, Rasa rasa) {
		return pm.updateRasa(rasa, id);
	}


	@DELETE
	public Response clearProducers() {
		pm.deleteAllRasa();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{rasaId}")
	public Response deleteRasa(@PathParam("rasaId") int id) {
		pm.deleteRasa(id);
		return Response.status(200).build();
	}
}
