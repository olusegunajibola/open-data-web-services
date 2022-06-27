package it.univaq.odws.rest.unirankings.campus;

import java.io.ByteArrayOutputStream;

import org.apache.jena.query.*;
import org.apache.jena.riot.RDFDataMgr;



public class UniCampusImpl implements UniCampus {
	
	private static final String UNIRANKINGS_DATASET = "NationalUniversitiesRankings2.rdf";
	private static final String UNICAMPUS_DATASET = "UniversityandCollegeCampuses.rdf";
	
	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(UNIRANKINGS_DATASET);
		RDFDataMgr.read(dataset, UNICAMPUS_DATASET);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}

	@Override
	public String getUnirankingsByName(String name) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
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
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
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
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
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
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
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
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(?schoolFees = \"" + schoolfees + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByGis(String gis) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?gis), \"" + gis.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	public String getUnirankingsByWebsite(String website) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?website), \"" + website.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByAddress(String address) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(CONTAINS(LCASE(?address), \"" + address.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByShapel(int shapel) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(?shapel = \"" + shapel + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

	@Override
	public String getUnirankingsByShapea(int shapea) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX dbp: <http://dbpedia.org/ontology/>").append(System.lineSeparator());
		query.append("PREFIX sch: <https://schema.org/>").append(System.lineSeparator());
		query.append("SELECT ?uniName ?location ?rank ?description ?schoolFees ?wikidata_url  ?gis ?shapel ?website ?address ?shapea").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?unirankings dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unirankings dbp:location ?location.").append(System.lineSeparator());
		query.append("	?unirankings dbp:rankNumber ?rank.").append(System.lineSeparator());
		query.append("	?unirankings dbp:description ?description.").append(System.lineSeparator());
		query.append("	?unirankings dbp:schFees ?schoolFees.").append(System.lineSeparator());
		query.append("	?unirankings sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus sch:sameAs ?wikidata_url.").append(System.lineSeparator());
		query.append("	?unicampus dbp:gis ?gis.").append(System.lineSeparator());
		query.append("	?unicampus dbp:uniName ?uniName.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapel ?shapel.").append(System.lineSeparator());
		query.append("	?unicampus sch:website ?website.").append(System.lineSeparator());
		query.append("	?unicampus dbp:address ?address.").append(System.lineSeparator());
		query.append("	?unicampus dbp:shapea ?shapea.").append(System.lineSeparator());
		query.append("	FILTER(?shapea = \"" + shapea + "\")").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		return convertResultSetToJSONString(resultSet);
	}

}
