package restassuredscripts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Script010_LoggingMethods {
	
	
	@Test
	public void LoggingRestAssured() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().log().all();
		//.then().log().headers();
		//.then().log().ifError();
		//.then().statusCode(200).log().cookies();
		
		
	}

}