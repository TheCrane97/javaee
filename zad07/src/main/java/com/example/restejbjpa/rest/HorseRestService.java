package com.example.restejbjpa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Horse;
import com.example.restejbjpa.domain.Person;
import com.example.restejbjpa.service.BookManager;
import com.example.restejbjpa.service.HorseManager;
import com.example.restejbjpa.service.PersonManager;

@Path("book")
public class HorseRestService {
	
	@EJB
	HorseManager hm;
	
	@EJB
	PersonManager pm;
	
	
	@GET
	@Path("/manytomany")
	@Produces(MediaType.TEXT_PLAIN)
	public String testRelations(){
		
		Person p = new Person("Niki", "Lauda", 1945);
		
		Horse h1 = new Horse("Jaskier", "izyryjski","2015-10-10",false,652.24);
		Horse h2 = new Horse("Maciek", "fryzyjski","2010-10-10",true,426.24);

		List<Horse> horses = new ArrayList<>();
		horses.add(h1);
		horses.add(h2);
		
		p.addHorse(horses);		
		pm.addPerson(p);
		
	
		System.out.println("Id h: " + h1.getName());
		
		System.out.println("\n\n@@@ Size of owners: " + h1.getOwners().size());
		
		//Car retrieved = pm.getCar(c1.getId());
		//Car retrieved = pm.updateCar(c1);
		
		
		//System.out.println("\n\n@@@ Size of owners: " + retrieved.getOwners().size());

		return "ManyToMany";
	}
	
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHorse(Horse horse){
		
		Person owner1 = new Person("Jan", "Zieliński", 1823);		
		Person owner2 = new Person("Paweł", "Kwiatkowski", 1833);	
		
		List<Person> owners = new ArrayList<>();
		owners.add(owner1);
		owners.add(owner2);
		
		horse.setOwners(owners);
		hm.addHorse(horse);
		
		return Response.	status(Response.Status.CREATED).build();	
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Horse getBook(@PathParam("id") Long id){
		
		Book retrieved = bm.getBook(id);
		
		//retrieved.setAuthors(bm.getAuthorsOfBook(id));
		
		//System.out.println("Authors :" + retrieved.getAuthors().size());
		
		return retrieved;
	}
	
	@GET
	@Path("/query/authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAuthorsOfBook(@PathParam("id") Long id){		
		return bm.getAuthorsOfBook(id) ;
	}
	
	@GET
	@Path("/query/yop/{yop}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBook(@PathParam("yop") int yop){
		return bm.findByYop(yop);
	}
	
	@GET
	@Path("/query/booksauthor/{aFirstName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooksAuthor(@PathParam("aFirstName") String firstName){
		
		List<Object[]> rawAuthors = bm.getBookOfAuthrByAuthorName(firstName);
		JsonArrayBuilder authors = Json.createArrayBuilder();
		
		for(Object[] rawAuthor: rawAuthors){
			
			String fName = (String) rawAuthor[0];
			String lName = (String) rawAuthor[1];
			String title = (String) rawAuthor[2];
			int yop = (Integer) rawAuthor[3];
			
			authors.add(Json.createObjectBuilder()
					.add("firstName", fName)
					.add("lastName", lName)
					.add("title", title)
					.add("yop", yop));
			
		}
		
		JsonObject json =  Json.createObjectBuilder().add("result", authors).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAll(){
		return bm.getAll();
	}
	
	@DELETE
	public Response deletAll(){
		bm.deletAll();
		return Response.status(Response.Status.OK).build();
	}

}
