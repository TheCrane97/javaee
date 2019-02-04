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

import com.example.pzurawska.zad07.domain.Identity;
import com.example.pzurawska.zad07.service.IdentityManager;

@Path("identity")
@Stateless
public class IdentityRESTService {
	
	@Inject
	private IdentityManager nvm;

	@GET
	@Path("/{identity}")
	@Produces(MediaType.APPLICATION_JSON)
	public Identity getIdentity(@PathParam("identity") int id) {
		return nvm.getIdentity(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Identity> getIdentity() {
		return nvm.getAllIdentity();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addIdentity(Identity identity) {
		nvm.addIdentity(identity);
		return Response.status(Response.Status.CREATED).entity("identity").build();
	}

	@PUT
	@Path("/{identityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Identity updateIdentity(@PathParam("identityId") int id, Identity identity) {
		return nvm.updateIdentity(identity, id);
	}


	@DELETE
	public Response clearIdentity() {
		nvm.deleteAllIdentity();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{identityId}")
	public Response deleteIdentity(@PathParam("identityId") int id) {
		nvm.deleteIdentity(id);;
		return Response.status(200).build();
	}

}
