package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatemultInciDataProvider {

	//Step[1:create data provider  // this method return multiple datas
	//Label as data provider
	//for running in parellel  parallel = true n data provider
@DataProvider(name ="fetchData",parallel=true)
public String[] getData() {
	//Declare an string array
	//1st array - no of rows 
	//2nd array - no of columns
//for 1 iteration we need	only 1 data . if 2 jason ffile  - 2   if only one columns - remocve the aother stirng ARRAY
	String[] data = new String[2];
	//2 data filr - json 1 and json 2 	
	//Assig the data
	data[0] = "./data/JsonFile1.json";
	data[1] = "./data/JsonFile2.json";
 return data;	
	
}
//In java in run time of recoeive sdata in run time in method level should always - vcrete argumenrt - 	
	
@Test(dataProvider="fetchData")  //@ test is calling dataprovider why is it so - to get the data
//method of data[rovider is get data- it is not providing anyt bdata to @test
//in java if return type is void it will not get any ourput


public void CreatemultIncidDataProvider(String FilePath) {
	
	RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
	
	
	 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
		File Datafile = new File(FilePath);
		//Change the path alone  - it wil run - for tbhios help of data provider
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
