import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

public class ilkdeneme {
	
	
	String isbn = "hebele isbn---";
   String aisle = "hubele 648952";	
    
   String payloadOlan = "{\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}";
	

   
   
   
   
   
   
   
	//@AfterTest
	public void deleteAdded() {
		
		
		RestAssured.baseURI="http://216.10.245.166";

		Response resp=given().

		header("Content-Type","application/json").

		body(payloadOlan).

		when().

		post("/Library/DeleteBook.php").

		then().assertThat().statusCode(200).

		extract().response();
		
	
		System.out.println("Books silindi");
		

	}
		
		
	
	
	//@Test
	public void addBook(){

	RestAssured.baseURI="http://216.10.245.166";

	Response resp=given().

	header("Content-Type","application/json").

	body(payloadOlan).

	when().

	post("/Library/Addbook.php").

	then().assertThat().statusCode(200).

	extract().response();
	
	System.out.println(resp.asString());
	
	System.out.println("Books eklendi");

}
	
@Test
public void getBook() {
		
	   Map reqBooks = new HashMap<>();
	   reqBooks.put("anahtar1", "deger1");
	   reqBooks.put("anahtar2", "deger2");
	   reqBooks.put("anahtar3", "deger3");
	   reqBooks.put("anahtar4", "deger4");
	  
	   
	   Map reqBooks2 = new HashMap<>();
	   reqBooks2.put("anahtar1", "deger1");
	   reqBooks2.put("anahtar2", "deger2");
	   reqBooks2.put("anahtar3", "deger3");
	   reqBooks2.put("anahtar4", "deger4");
	   
	   for(Object key : reqBooks.keySet()) {
		   System.out.println(reqBooks.get(key)+"< >"+reqBooks2.get(key));
		   assertEquals(reqBooks.get(key), reqBooks2.get(key));
	   }
	   
	   
	   //System.out.println(reqBooks.keySet());
	   
	   //System.out.println(reqBooks);
		
		RestAssured.baseURI="http://216.10.245.166";

		Response resp=given().

		header("Content-Type","application/json").

		body(payloadOlan).

		when().

		get("Library/GetBook.php?AuthorName=Rahul").

		then().assertThat().statusCode(200).

		extract().response();
		
		//Map postBook=resp.body().as(Map.class);
		//System.out.println(postBook);
		
		
		
		
		JsonPath js = resp.jsonPath();
		//System.out.println(js.prettyPrint());
		
		//System.out.println(resp .asString());


}



}