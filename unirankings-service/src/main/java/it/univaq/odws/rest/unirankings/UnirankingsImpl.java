package it.univaq.odws.rest.unirankings;

import java.io.ByteArrayOutputStream;

import org.apache.jena.query.*;
import org.apache.jena.riot.RDFDataMgr;

public class UnirankingsImpl implements Unirankings {
	
	private static final String UNIRANKINGS_DATASET = "NationalUniversitiesRankings2.rdf";
	
	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(UNIRANKINGS_DATASET);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}

	@Override
	public String getUnirankingsById(int id) {
		Dataset dataset = loadDataset();
		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+">  dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+"> dbp:location ?location.").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+"> dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+"> dbp:description ?description.").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+"> dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	<http://odws.univaq.it/unirankings/"+id+"> sch:sameAs ?wikidata_url").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByName(String name) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?uniName), \"" + name.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByLocation(String location) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?location), \"" + location.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByRank(int rank) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(?rank = \"" + rank + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByDescription(String description) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?description), \"" + description.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsBySchoolfees(int schoolfees) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	FILTER(?schoolFees = \"" + schoolfees + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

}
