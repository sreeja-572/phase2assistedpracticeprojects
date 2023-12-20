package restassuredscripts;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class Script004PayloadJSON {
	
	@Test
	public void PostUsingJSON() {
		
		JSONObject body = new JSONObject();
		
		body.put("name", "kiran");
		body.put("salary", "500000");
		body.put("age", "20");
		
		
	int responseid = 	RestAssured    // Chaining the request
		.given()
		.baseUri("https://dummy.restapiexample.com/api/v1/create")
		.contentType(ContentType.JSON)
		.body(body.toString())
		.when().post()
		.then()
		.statusCode(200)
		.body("data.name", equalTo("kiran"))
		.extract().path("data.id");
	
		System.out.println(responseid);
		
			
	}

}