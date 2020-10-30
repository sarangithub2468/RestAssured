package week2Assignm;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMultipleIssues {
//4. Create multiple issues in Jira using data files(json format) and data provider in RestAssured

	@DataProvider(name = "SendFile",parallel=true)
	public String[] fetchfile() {
		String[]  data = new String[2];  //sibgle dimensional array
		data[0]= "D:\\WORKSPACE SELENIUM\\RestAutomation\\data\\Data1.json";
		data[1]="D:\\WORKSPACE SELENIUM\\RestAutomation\\data\\Data2.json";
	
	return data ;
	}	
	
	@Test(dataProvider="SendFile")
	public void multipleIssues(String FilePath) {
		
		File Data = new File(FilePath);
		
		//if server locally - base path if differene taserver in machine -0 baseuri
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		//preamptivr - will by pass check ffor username and password
		//required while using APi key for credentials
		RestAssured.authentication= RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		
		RestAssured.given().
		contentType(ContentType.JSON).log().all().body(Data).post().then().log().all();
		
		
	}
}
