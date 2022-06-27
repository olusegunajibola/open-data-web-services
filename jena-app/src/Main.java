import org.apache.jena.rdf.model.Model;
import org.apache.jena.query.*;
import org.apache.jena.util.FileManager;

public class Main {
	
	public static void main(String args[]) {
		
		sparqlTest();
		
	}
	
	static void sparqlTest()
	{
//		load rdf data into the jena model
		FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
		Model model = FileManager.get().loadModel("NationalUniversitiesRankings.rdf");
		
//		our query
		String queryString = 
				
//				A. use "foaf.rdf"
				
//				"PREFIX foaf:  <http://xmlns.com/foaf/0.1/>" +
//				"SELECT * " +
//				"WHERE {" +
//				"?person foaf:name ?name ."+
//				"?person foaf:mbox ?email"+
//				"}";
				
//				B. use NationalUniversitiesRankings.rdf
				
//				1. this outputs name of all universities
				
				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
				"SELECT ?uniName " +
				"WHERE { " +
				"?unirankings dbp:uniName ?uniName. " +
				" }";
				
//				2. this counts all universities
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"SELECT COUNT(*) " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				" }";
				
//				3. this displays all universities & their locations
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"SELECT * " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings dbp:location ?location " +
//				" }";
				
//				4. this displays all location "NY" new york
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"SELECT ?location " +
//				"WHERE { " +
//				"?unirankings dbp:location ?location. " +
//				"FILTER regex(?location, 'NY', 'i') " +
////				The flag “i” means a case-insensitive pattern match is done.
//				" }";
		
////			5. this display universities from a certain location "NY" new york
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
//				"SELECT ?location ?uniName ?rankNumber " +
////				+ "?uniName, ?location, ?rankNumber  " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings dbp:location ?location. " +
//				"?unirankings xsd:intrankNumber ?rankNumber." +
//				"FILTER regex(?location, 'NY', 'i') " +
////				The flag “i” means a case-insensitive pattern match is done.
//				" } " +
//				"ORDER BY ?rankNumber ";
				
////			6. this display wiki_url from schools with "Miami" in their namee
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"PREFIX sch: <https://schema.org/> " +
//				"SELECT ?sameAs ?uniName " +
//				"WHERE { " +
//				"?unirankings sch:sameAs ?sameAs . " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"FILTER regex(?uniName, 'Miami', 'i') " +
//				" } " ;
				
////			7. this display description of "University of Miami"
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"SELECT ?description " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings dbp:description ?description. " +
//				"FILTER regex(?uniName, 'University of Miami', 'i') " +
//				" } " ;
				
////			8. this display top ten ranked universities
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
//				"SELECT ?uniName ?location  ?rankNumber " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings dbp:location ?location. " +
//				"?unirankings xsd:intrankNumber ?rankNumber." +
//				" } "  +
//				"ORDER BY ?rankNumber "  +
//				" LIMIT 10" ;
				
////			9. this display in descending order
////				universities with school fees > 50000
				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
//				"SELECT ?uniName ?SchoolFees  ?rankNumber " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings xsd:intschFees ?SchoolFees. " +
//				"?unirankings xsd:intrankNumber ?rankNumber." +
//				"FILTER (?SchoolFees > 50000) ." + 
//				" } "  +
//				"ORDER BY DESC(?SchoolFees) " ;
				
////			10. this displays the total number of
//				universities with school fees > 50000
//				
//				"PREFIX dbp: <http://dbpedia.org/ontology/> " +
//				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
//				"SELECT COUNT(*) " +
//				"WHERE { " +
//				"?unirankings dbp:uniName ?uniName. " +
//				"?unirankings xsd:intschFees ?SchoolFees. " +
//				"?unirankings xsd:intrankNumber ?rankNumber." +
//				"FILTER (?SchoolFees > 50000) ." + 
//				" } "   ;				
//		
				
		
		Query query = QueryFactory.create(queryString);
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		// Output query results    
		ResultSetFormatter.out(System.out, results, query);

		// Important free up resources used running the query
		qe.close();
	}
}