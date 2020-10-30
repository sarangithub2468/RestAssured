package week2Assignm;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAlltheIssuesJira {
	//Get all the issues in jira and find the total number of issues using RestAssured
	
	@Test
	public void GetAllissues() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/search";
		
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		
		Response response = RestAssured.get();
		//For printing the resposne	
		//response.prettyPrint();
/*		//from json formatted data we hav eto get the totolal do use response.json path
        List<String> listIssues = jsonpath.getList("total");  //no list to be used sinc eit involved single ionly
        System.out.println(listIssues);*/
		JsonPath jsonpath = response.jsonPath();
	    int total = jsonpath.get("total");   //tpotoal is in ttype
	    System.out.println(total);
	    
	}

}
