package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetallIncidents	 {
	
    @Test
	public void GetAllIncident() {
		// TODO Auto-generated method stub
		//base uri is string
//Step1	//get the end point // default prt will be pointed out to 8080
		RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";
//Step2//Authorization(Basic Auth)  //auhenticstion to connected to rests=assured claass 
		 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");  //this is just declatrig gh==the valuee- - value not connected to used the
		//iformation- add one more line
//Step 3//Request type/GET  // wecan also gine lieke RestAssured.get("incident")
		 Response response = RestAssured
				 .given()
				 .param("category", "Hardware")
				 .param("sysparm_fields", "sys_id,number,category")
				 .get(); 
		 // now we got test running but no response
//-------------------------------------------------------
//step4 validate Response - status code	 
		System.out.println(response.getStatusCode());
//Step 5 : validate Response format			
		System.out.println(response.getContentType());			
		//System.out.println(response.getTime());			
//Step 6: print the response 
		response.prettyPrint();
		
		
		
	}

}
