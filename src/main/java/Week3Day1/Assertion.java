package Week3Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Assertion {
	@Test	
	public void createincidwithoutbody() {
		
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
		
		
		 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
			
		        Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.when()
	                 .body("{\"short_description\": \"Post from Rest Assured\", \"category\": \"Hardware\"}")       				
					.post()  //after post we can  use then do sometiig with the response wwe can use assert that 
					//for validating resposne
	//tgen used for vefiyig after [pstmethod		     
					.then().assertThat().statusCode(201).extract().response();
					
				//If if conditio is used - nif ailure will,l be shown, this we be displayed as pass -- etst case is nit c=getting failed 
		        //so use testng assertion oir restassured assertion
		 
		 
		 //put back slash before double quotes
			//
		 
		// System.out.println(response.getStatusCode());
			
			
			//System.out.println(response.contentType());
			//testNg assertion
			//Assert.assertEquals(response.getStatusCode(), 200);

			//response.prettyPrint();
			
		}	
		
	

}


