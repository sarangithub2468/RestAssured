package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentwithbody {
	
//put tghe post in raw foiormat and inpit as string 	
	
	@Test	
	public void createincidwithoutbody() {
		
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
		
		
		 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)		
	                 .body("{\"short_description\": \"Post from Rest Assured\", \"category\": \"Hardware\"}")       				
					.post();
				//put back slash before double quotes
			System.out.println(response.getStatusCode());
			
			
			System.out.println(response.contentType());

			//response.prettyPrint();
			
		}	
		
	

}
