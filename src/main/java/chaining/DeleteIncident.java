package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends base {
//CHANNING IN NEXT CLASS
	
	//for delete we need to pass ondata - sys_id  - 
	//did some logic - connecting tigethe - //we did chaininh - creted and delete 
	//chaininh in parallel we are going to do 
	
	@Test(dependsOnMethods = "chaining.CreateIncidentwithoutbody.createincident")	
	public void deleteIncident() {
		
		Response response = RestAssured.given()	
				.contentType(ContentType.JSON)
				//parameter for pathparam for deleting	
				.pathParam("sysID", "sys_id")       //if you want to pass the value in the parameter level
				.delete("{sysID}");
		
			
		System.out.println(response.getStatusCode());
		
		
		System.out.println(response.contentType());

		response.prettyPrint();
		
	}
	

}
