package week2AssignmChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//5. Create a new issue in Jira using RestAssured and
//Update the existing issue description using chaning  and verify the response contains the updated value
public class CreateIssueChaining extends baseClass {
//create baseclass - declare comon variable  issueid
	//create isseu extends base class
	
	//update issue concatenate base uri +issueid . bidy update
	@Test
	public void createIssue() {
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication= RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");

		Response response = RestAssured.given().contentType(ContentType.JSON).log().all()
		.body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RA\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"Created issue In RA Project From File1\",\r\n" + 
				"        \"description\": \"Issue  Created  Using REST API via Postman-ISSUE-1\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Story\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}")
		.post();
	
		JsonPath jsonPath = response.jsonPath();
		
		issueid=jsonPath.get("key");

		System.out.println(issueid);
	}
	
}
