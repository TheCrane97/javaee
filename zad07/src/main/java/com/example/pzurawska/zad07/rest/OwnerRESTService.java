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

import com.example.pzurawska.zad07.domain.Owner;
import com.example.pzurawska.zad07.service.OwnerManager;


@Path("owner")
@Stateless
public class OwnerRESTService {
	

	@Inject
	private OwnerManager pm;
	
	@GET
	@Path("/{ownerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getOwner(@PathParam("ownerId") int id) {
		return pm.getOwner(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner> getOwner() {
		return pm.getAllOwners();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOwner(Owner owner) {
		pm.addOwner(owner);
		return Response.status(Response.Status.CREATED).entity("owner").build();
	}
	
	@PUT
	@Path("/{ownerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Owner updateOwner(@PathParam("ownerId") int id, Owner owner) {
		return pm.updateOwner(owner, id);
	}
	
	
	
	@DELETE
	@Path("/{ownerId}")
	public Response deleteOwner(@PathParam("ownerId") int id) {
		pm.deleteOwner(id);
		return Response.status(200).build();
	}
	
	@DELETE
	public Response clearOwner() {
		pm.deleteAllOwners();
		return Response.status(Response.Status.OK).build();
	}

}
