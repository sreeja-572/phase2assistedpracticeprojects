package restassuredscripts;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Script007HamcrestValidateMethods {
	
	// Hamcrest dependency has been added to your POM file
	// This dependency provides us many validation methods that help us to validate the response code
	
	// equalTo() Hamcrest method
	
	@Test(priority='1')
	public void ValidateResponseBody() {
		
		String PMapikey="PMAK-6577e3e8b108ce372d2cd605-d88050113e346d992ef3016880126b28f3";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		//fetch the resonse body and validate if response includes correct values or not
		
		.body("workspaces[3].id", equalTo("4b7363cc-f0be-4079-9997-259b5587f69a"),
				"workspaces[3].name", equalTo("Phase-3-Postman"),
				"workspaces[3].type", equalTo("personal"));
			  	
	}
	
	@Test(priority='2')
	public void ValidateResponseBody_equalTo() {
		
		
		given().baseUri("https://petstore.swagger.io")
		.basePath("/v2/user/Saikiran")
		.when().get()
		.then().statusCode(200)
		//fetch the response body and validate if response includes correct values or not
		
		.body("username", equalTo("Saikiran"),
			 ("firstName"),equalTo("sabbani"),
			 ("lastName"),equalTo("saikiran"),
			 ("email"),equalTo("saikirandemo@gmail.com"),
			 ("userStatus"),equalTo(1));
			 
			 		
	}
	@Test(priority='3')
	public void ValidateResponseBody_hasItems() {
		
	String PMapikey="PMAK-6577e3e8b108ce372d2cd605-d88050113e346d992ef3016880126b28f3";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		// fetch the response body and validate if response includes correct values or not
		
		.body("workspaces.name", hasItems("Team Workspace", "My Workspace", "Workspace-2"),
			 "workspaces.type", hasItems("team", "personal"));
		
		
	}
	
	

}
