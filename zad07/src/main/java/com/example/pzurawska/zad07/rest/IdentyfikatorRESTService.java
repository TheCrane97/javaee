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

import com.example.pzurawska.zad07.domain.Identyfikator;
import com.example.pzurawska.zad07.service.IdentyfikatorManager;

@Path("identyfikator")
@Stateless
public class IdentyfikatorRESTService {
	
	@Inject
	private IdentyfikatorManager nvm;

	@GET
	@Path("/{identyfikator}")
	@Produces(MediaType.APPLICATION_JSON)
	public Identyfikator getVin(@PathParam("identyfikator") int id) {
		return nvm.getIdentyfikator(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Identyfikator> getIdentyfikator() {
		return nvm.getAllIdentyfikator();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addIdentyfikator(Identyfikator identyfikator) {
		nvm.addIdentyfikator(identyfikator);
		return Response.status(Response.Status.CREATED).entity("identyfikator").build();
	}

	@PUT
	@Path("/{identyfikatorId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Identyfikator updateIdentyfikator(@PathParam("identyfikatorId") int id, Identyfikator identyfikator) {
		return nvm.updateIdentyfikator(identyfikator, id);
	}


	@DELETE
	public Response clearIdentyfikator() {
		nvm.deleteAllIdentyfikator();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{identyfikatorId}")
	public Response deleteIdentyfikator(@PathParam("identyfikatorId") int id) {
		nvm.deleteIdentyfikator(id);;
		return Response.status(200).build();
	}

}
