package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateIncidentwithoutbody extends base {
	
	@Test
	
	public void createincident() {
		
		Response response = RestAssured.given()	
				.post();
			
		System.out.println(response.getStatusCode());
		
		
		System.out.println(response.contentType());

		response.prettyPrint();
		
		sys_id= response.jsonPath().get("result.sys_id");
		//this sys-id to be transferred to java class
		
		
	}
	

}
