package basic;

	
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class INCIDENTPrintonlythecountJSONFORMAT	 {
	
    @Test
	public void printcount() {
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
				 .accept(ContentType.JSON)
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
		//convert the respinse to json format - json paht
		//result.number
		JsonPath jsonResponse = response.jsonPath();		
		List<String> list = jsonResponse.getList("result.number");  //if very sure abt data type change list type as string
		
		//print hte first number as response // get the first item from the list
		String firstitem = list.get(0);
		System.out.println(firstitem);	
//get the count'
		//store the data in the collection
		//lot of datas in siblgle object then f=go for collection
	    System.out.println(list.size());		
		//List - response and store in the list
		
          

		
	}

}
