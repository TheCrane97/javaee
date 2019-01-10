package com.example.pzurawska.zad07.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.example.pzurawska.zad07.domain.Owner;
import com.example.pzurawska.zad07.service.OwnerManager;


@Path("owner")
public class OwnerRESTService {

	@EJB
	OwnerManager om;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOwner(Owner owner){
		om.addOwner(owner);
		return Response.status(201).entity("Owner").build(); 
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getOwner(@PathParam("id") Long id){
		Owner retrieved = om.getOwner(id);
		return retrieved;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners(){
		return om.getAll();
	}

	
	@DELETE
	public Response clearOwners(){
		om.deletAll();
		return Response.status(200).build();
	}
}
