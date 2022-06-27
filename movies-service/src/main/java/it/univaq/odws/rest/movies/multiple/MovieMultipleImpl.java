package it.univaq.odws.rest.movies.multiple;

import java.io.ByteArrayOutputStream;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;

public class MovieMultipleImpl implements MovieMultiple{
	
	private static final String MOVIES_DATASET = "movies.rdf";
	private static final String MOVIES_ORIGIN_DATASET = "movies-origin.rdf";

	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(MOVIES_DATASET);
		RDFDataMgr.read(dataset, MOVIES_ORIGIN_DATASET);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}
	
	@Override
	public String getMoviesByTitle(String title) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER((LCASE(?title) = \"" + title.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getMoviesByDirector(String director) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());		
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?director),\"" + director.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getMoviesByYear(int year) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(?year = \"" + year + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getMoviesByGenre(String genre) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?genres),\"" + genre.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getCrimeMoviesByYear(int year) {
		Dataset dataset = loadDataset();
		
		//Solution 1: use a specific query 		
		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(?genres,\"Crime\") && ?year = \"" + year + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
		
		//Solution 2: iterate over the result of the year query to get all the crime movies
//		StringBuilder query = new StringBuilder();
//		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
//		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
//		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
//		query.append("WHERE {").append(System.lineSeparator());
//		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
//		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
//		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
//		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
//		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
//		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
//		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
//		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
//		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
//		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
//		query.append("	FILTER(?year = \"" + year + "\")").append(System.lineSeparator());
//		query.append("}").append(System.lineSeparator());
//
//		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
//		ResultSet resultSet = queryExecution.execSelect();
//		
//		StringBuilder resultJSON = new StringBuilder();
//		resultJSON.append("{").append(System.lineSeparator());
//		resultJSON.append("  \"head\": {").append(System.lineSeparator());
//		resultJSON.append("    \"vars\": [ \"title\" , \"director\" , \"year\" , \"genres\" , \"countryOfOrigin\" , \"originalLanguage\" , \"imdb_url\" , \"wikidata_url\"]").append(System.lineSeparator());
//		resultJSON.append("  } ,").append(System.lineSeparator());
//		resultJSON.append("  \"results\": {").append(System.lineSeparator());
//		resultJSON.append("    \"bindings\": [").append(System.lineSeparator());
//		
//		while (resultSet.hasNext()) {
//			QuerySolution row = resultSet.nextSolution();
//			String genres = row.getLiteral("genres").getString();
//			if (genres.contains("Crime")) {
//				String title = row.getLiteral("title").getString();
//				String director = row.getLiteral("director").getString();
//				String countryOfOrigin = row.getLiteral("countryOfOrigin").getString();
//				String originalLanguage = row.getLiteral("originalLanguage").getString();
//				String imdb_url = row.getLiteral("imdb_url").getString();
//				String wikidata_url = row.getLiteral("wikidata_url").getString();
//				resultJSON.append("      {").append(System.lineSeparator());
//				resultJSON.append("        \"title\": { \"type\": \"literal\" , \"value\": \"" + title + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"director\": { \"type\": \"literal\" , \"value\": \"" + director + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"year\": { \"type\": \"literal\" , \"value\": \"" + year + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"genre\": { \"type\": \"literal\" , \"value\": \"" + genres + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"countryOfOrigin\": { \"countryOfOrigin\": \"literal\" , \"value\": \"" + countryOfOrigin + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"originalLanguage\": { \"originalLanguage\": \"literal\" , \"value\": \"" + originalLanguage + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"imdb_url\": { \"type\": \"literal\" , \"value\": \"" + imdb_url + "\" } ,").append(System.lineSeparator());
//				resultJSON.append("        \"wikidata_url\": { \"type\": \"literal\" , \"value\": \"" + wikidata_url + "\" }").append(System.lineSeparator());
//				resultJSON.append("      },").append(System.lineSeparator());
//			}
//			if(!resultSet.hasNext())
//				resultJSON.deleteCharAt(resultJSON.lastIndexOf(","));
//		}
//		resultJSON.append("    ]").append(System.lineSeparator());
//		resultJSON.append("  }").append(System.lineSeparator());
//		resultJSON.append("}").append(System.lineSeparator());
//		return resultJSON.toString();
	}

	@Override
	public String getMoviesByCountryOfOrigin(String country) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?countryOfOrigin),\"" + country.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getMoviesByOriginalLanguage(String language) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?title ?director ?year ?genres ?countryOfOrigin ?originalLanguage ?imdb_url ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?movie dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie dbp:director ?director.").append(System.lineSeparator());
		query.append("	?movie dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie dbp:genre ?genres.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalTitle ?title.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:releaseDate ?year.").append(System.lineSeparator());
		query.append("	?movie_origin sch:countryOfOrigin ?countryOfOrigin.").append(System.lineSeparator());
		query.append("	?movie_origin dbp:originalLanguage ?originalLanguage.").append(System.lineSeparator());			
		query.append("	?movie dbp:imdbId ?imdb_url.").append(System.lineSeparator());
		query.append("	?movie sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?originalLanguage),\"" + language.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

}
