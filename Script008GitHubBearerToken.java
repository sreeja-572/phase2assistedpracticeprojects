package restassuredscripts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Script008GitHubBearerToken {
	
	
	
	@Test(priority='1')
	public void Authorization_bearertoken() {
		
		Response res=given().baseUri("https://api.github.com")
		.basePath("/user/repos")
		.header("Authorization", "Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
		res.prettyPrint();
		
				
	}
	@Test(priority='2')
	public void Authorization_bearertoken_specificRepo() {
		
		Response res=given().baseUri("https://api.github.com")
		.basePath("/repos/Sabbani-Saikiran/Git-fsd")
		.header("Authorization", "Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
		res.prettyPrint();
		
				
	}
	
			

}
