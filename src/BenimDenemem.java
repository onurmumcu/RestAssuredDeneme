import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class BenimDenemem {

	@Test
	public void deneme1() {
		
		given().baseUri("https://maps.googleapis.com").
		param("locationlllll","-33.8670522,151.1957362").
		param("radius","500").
	    param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
	    get("/maps/api/place/nearbysearch/json").
then().assertThat().statusCode(200).contentType(ContentType.JSON);
	}

}
