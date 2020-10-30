package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentwithoutbody {
	
	@Test
	
	public void createincident() {
		
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
		
		
	 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)				
				.post();
			
		System.out.println(response.getStatusCode());
		
		
		System.out.println(response.contentType());

		response.prettyPrint();
		
	}
	

}
