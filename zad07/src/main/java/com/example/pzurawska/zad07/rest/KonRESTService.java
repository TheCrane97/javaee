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

import com.example.pzurawska.zad07.domain.Kon;
import com.example.pzurawska.zad07.service.KonManager;


@Path("kon")
@Stateless
public class KonRESTService {
	
	@Inject
	private KonManager mm;
	
	@GET
	@Path("/{konId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Kon getKon(@PathParam("konId") int id) {
		return mm.getKon(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Kon> getKon() {
		return mm.getAllKon();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKon(Kon kon) {
		mm.addKon(kon);
		return Response.status(Response.Status.CREATED).entity("Kon").build();
	}
	
	@PUT
	@Path("/{konId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Kon updateKon(@PathParam("konId") int id, Kon kon) {
		return mm.updateKon(kon, id);
	}
	
	
	@DELETE
	public Response clearKon() {
		mm.deleteAllKon();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{konId}")
	public Response deleteMotocykl(@PathParam("konId") int id) {
		mm.deleteKon(id);
		return Response.status(200).build();
	}

}
