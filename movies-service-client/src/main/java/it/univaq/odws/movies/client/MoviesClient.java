package it.univaq.odws.movies.client;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

public class MoviesClient {
	
	private static final String endpoint = "http://localhost:8089/movies-service/rest/";
	public static void main(String[] args) {
		WebClient client = WebClient.create(endpoint + "movie/title/Taxi Driver");
		//WebClient client = WebClient.create(endpoint + "movie-extended-info/title/Taxi Driver");
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		try {
			String jsonResponse = IOUtils.toString((InputStream) response.getEntity());
			System.out.println(jsonResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
