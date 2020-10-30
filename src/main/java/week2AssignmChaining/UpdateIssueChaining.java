package week2AssignmChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIssueChaining extends baseClass {
	@Test(dependsOnMethods="week2AssignmChaining.CreateIssueChaining.createIssue")
	public void updateissue() {
		

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/"+issueid;
		RestAssured.authentication= RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		
		Response response = RestAssured.given().contentType(ContentType.JSON).log().all().
				body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"        \"description\": \"Story Issue Updated testing\"\r\n" + 
						"    }\r\n" + 
						"}").			
				put();
		
		int statusCode = response.getStatusCode();
		
		System.out.println(statusCode);
	}

}
