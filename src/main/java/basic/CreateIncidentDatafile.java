package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentDatafile {

	@Test	
	public void CreateIncidtDatafile() {
		
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
		
		
		 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
			File Datafile = new File("./data/Data1.json");
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)			
	                 .body(Datafile)       				
					.post();
				//put back slash before double quotes
			System.out.println(response.getStatusCode());
			
			
			System.out.println(response.contentType());

			response.prettyPrint();
			
		}	
		
	

}
