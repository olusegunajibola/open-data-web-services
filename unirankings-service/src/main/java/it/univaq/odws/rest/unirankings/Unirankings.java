package it.univaq.odws.rest.unirankings;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/uniranking")
public interface Unirankings {
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsById (@PathParam("id") int id);
	
	@GET
	@Path("/name/{name}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByName (@PathParam("name") String name);
	
	@GET
	@Path("/location/{location}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByLocation (@PathParam("location") String location);
	
	@GET
	@Path("/rank/{rank}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByRank (@PathParam("rank") int rank);
	
	@GET
	@Path("/description/{description}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByDescription (@PathParam("description") String description);
	
	@GET
	@Path("/schoolfees/{schoolfees}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsBySchoolfees (@PathParam("schoolfees") int schoolfees);
}

