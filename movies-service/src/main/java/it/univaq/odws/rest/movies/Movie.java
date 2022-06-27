package it.univaq.odws.rest.movies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movie")
public interface Movie {
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesById (@PathParam("id")int id);
	
	@GET
	@Path("/title/{title}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByTitle (@PathParam("title")String title);
	
	@GET
	@Path("/director/{director}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByDirector (@PathParam("director")String director);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByYear (@PathParam("year")int year);
	
	@GET
	@Path("/genre/{genre}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByGenre (@PathParam("genre")String genre);
	
	@GET
	@Path("/crimebyyear/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getCrimeMoviesByYear(@PathParam("year")int year);	
			
}