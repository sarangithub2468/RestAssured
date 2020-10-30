package Week3Day1;

import java.io.ObjectInputStream.GetField;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnCookies {
	
@Test
	public void learnCookies() {
		// TODO Auto-generated constructor stub
	

	RestAssured.baseURI = "https://dev104158.service-now.com/api/now/table/incident";		
	
	
	 RestAssured.authentication = RestAssured.basic("admin", "Testapi@123");
		
	        Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
                .body("{\"short_description\": \"Post from Rest Assured\", \"category\": \"Hardware\"}")       				
				.post(); 
	        
	        //2 methids get cookie and get cookies
	        
/*	        String cookie = response.getCookie("glide_user_route");
	        
	        System.out.println(cookie);*/
	        
	        Map<String, String> cookies = response.getCookies();
	        cookies.get("glide_user_route");
	        
	        //map will have key value paor
	        //ma,e is the key-- 
	        //key -coolie name  //value -- repoective alue
	        //to get all the values
	        
	       //cookies.forEach(gettig all the v alues-- entry d]set can be used);
	       // .cookies.ebtry set will get kehy and valei
	        
	        Set<Entry<String, String>> entrySet = cookies.entrySet();
	        
	        
	        for (Entry<String, String> eachentry : entrySet) {
	        	
				System.out.println(eachentry.getKey());
				System.out.println(eachentry.getValue());

			}
	        
	        
	        
	        
	        
	        
	        
	        
}

}
