package week2Assignm;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AttachFileToJira {

		
		@Test
		public void AttachFile() {
			//attach the file here in package - store the file in the data object through file class
			File Data = new File("./Image.png");
			//if server locally - base path if differene taserver in machine -0 baseuri
			RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/issue/RA-708/attachments";
			//preamptivr - will by pass check ffor username and password
			//required while using APi key for credentials
			RestAssured.authentication= RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		  //for header method called given().header - precondition   piut logall in teh given will vibve the reqiest logs
			Response response = RestAssured.given()
			.headers("Content-Type","multipart/form-data")
			.header("X-Atlassian-Token","no-check").log().all().multiPart(Data).post();
					//.multipardata method(data).post() method for pasting the request
			System.out.println(response.getStatusCode());
					
		}

	}


