package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {
	//for delete we need to pass ondata - sys_id  - 
	//did some logic - connecting tigethe - //we did chaininh - creted and delete 
	//chaininh in parallel we are going to do 
	@Test
	
	public void createincident() {
		
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
		
		
	 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)				
				.delete();
		
			
		System.out.println(response.getStatusCode());
		
		
		System.out.println(response.contentType());

		response.prettyPrint();
		
	}
	

}
