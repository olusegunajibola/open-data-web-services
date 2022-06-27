package it.univaq.odws.rest.unirankings.campus;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/unicampus")
public interface UniCampus {
	
	
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
	@Path("/gis/{gis}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByGis (@PathParam("gis") String gis);
	
	@GET
	@Path("/website/{website}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByWebsite (@PathParam("website") String website);
	
	@GET
	@Path("/address/{address}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByAddress (@PathParam("address") String address);

	@GET
	@Path("/description/{description}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByDescription (@PathParam("description") String description);
	
	@GET
	@Path("/shapel/{shapel}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByShapel (@PathParam("shapel") int shapel);
	
	@GET
	@Path("/schoolfees/{schoolfees}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsBySchoolfees (@PathParam("schoolfees") int schoolfees);
	
	@GET
	@Path("/shapea/{shapea}")
	@Produces({MediaType.APPLICATION_JSON})
	String getUnirankingsByShapea (@PathParam("shapea") int shapea);
	
}

