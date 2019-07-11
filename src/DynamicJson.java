import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payLoad;

import static io.restassured.RestAssured.given;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;




public class DynamicJson {
	
	
			
	
	

	
@Test(dataProvider = "yattara")
public void postData(String ispn, String aisle) {
	
	RestAssured.baseURI="http://216.10.245.166";
	Response res=given().
			header("Content-Type","application/json").
			//body(payLoad.addBook("hebele","65565")).
			body(payLoad.addBook(ispn,aisle)).
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

//@Test(dataProvider = "yattara")
//public void deleteBook(String ispn, String aisle) {
//	
//	RestAssured.baseURI="http://216.10.245.166";
//	Response res=given().
//			header("Content-Type","application/json").
//			//body(payLoad.addBook("hebele","65565")).
//			//body(payLoad.addBook(ispn,aisle)).
//			body()
//			
//			when().
//			post("/Library/DeleteBook.php").
//			then().assertThat().statusCode(200).
//			extract().response();
//	
//	String response = res.asString();
//	System.out.println(response);
//	
//	
//	
//	JsonPath exctractor = res.jsonPath();
//	
//	String ID= exctractor.get("ID");
//	
//	System.out.println("burasi jsonPath "+ ID);
//	
//
//
//}








//@Test
public void getBook() {
	
	RestAssured.baseURI="http://216.10.245.166";

Response res = 	given().
	param("AuthorName", "Rahul").
when().get("/Library/GetBook.php").
then().assertThat().statusCode(200).extract().response();


String a = res.asString();
System.out.println(a);

JsonPath exctactor = res.jsonPath();
exctactor.prettyPrint();
	
}



@DataProvider(name="yattara")
public Object[][] getData(){
	
	Object[][] data= {{"kdjfj","325646"},{"kddfj","3333646"},{"kqqqfj","329876"},{"kldfj","522569"}};
	
	
	return data ;
	
}


public static String GenerateStringFromResource(String path) throws IOException{
	return  new String (Files.readAllBytes(Paths.get(path)));
	
}



}
