import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StaticJason {
	
	
	@Test
	public void addBook() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
				header("Content-Type","application/json").
				//body(payLoad.addBook("hebele","65565")).
				body(GenerateStringFromResource("C:\\Users\\Onur\\Desktop\\Addbookdetails.json")).
				when().
				post("/Library/Addbook.php").
				then().assertThat().statusCode(200).
				extract().response();
		
		String response = res.asString();
		System.out.println(response);
		
		
		
		JsonPath exctractor = res.jsonPath();
		
		String ID= exctractor.get("ID");
		
		System.out.println("burasi jsonPath "+ ID);
		

				
	}
	
	
	
	
	public static String GenerateStringFromResource(String path) throws IOException{
		return  new String (Files.readAllBytes(Paths.get(path)));
		
	}
	

}
