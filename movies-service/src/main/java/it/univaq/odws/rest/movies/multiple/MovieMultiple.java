package it.univaq.odws.rest.movies.multiple;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movie-extended-info")
public interface MovieMultiple {
		
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
		
	@GET
	@Path("/country-of-origin/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByCountryOfOrigin(@PathParam("country")String country);
	
	@GET
	@Path("/original-language/{language}")
	@Produces({MediaType.APPLICATION_JSON})
	String getMoviesByOriginalLanguage(@PathParam("language")String language);
}
