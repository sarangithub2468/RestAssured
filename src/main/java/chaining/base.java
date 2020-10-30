package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class base {
   public RequestSpecification requestSpecification;
	public static String sys_id;
		
	@BeforeMethod            //for evry test this will run before test itself
		public void commonsteps() {
			
			
			RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
			
			
			 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
				
			 RequestSpecification  contentType	 = RestAssured
						.given()
						.contentType(ContentType.JSON);				
//class level declaraton	
	}

}
