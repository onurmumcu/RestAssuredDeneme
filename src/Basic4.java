import org.testng.annotations.Test;
	import static io.restassured.RestAssured.given;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

	
public class Basic4 {
	 

		
		@Test
		public void createPlaceAPI() throws IOException
		{
			String postData = GenerateStringFromResource("C:\\Users\\Onur\\Desktop\\postData.xml");
			RestAssured.baseURI="https://maps.googleapis.com";
			given().
			
			queryParam("key","AIzaSyCbMXSQKA7KC9mD1uD0nx8gikLLQSSp_jY").
			body(postData).
			when().
			post("/maps/api/place/add/xml").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
			
		// Create a place =response (place id)
			
			// delete Place = (Request - Place id)	
			

		}
		
		public static String GenerateStringFromResource(String path) throws IOException{
			return  new String (Files.readAllBytes(Paths.get(path)));
			
		}
		
	}



