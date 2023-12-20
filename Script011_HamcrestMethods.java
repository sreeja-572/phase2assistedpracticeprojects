package restassuredscripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;


public class Script011_HamcrestMethods {
	
	@Test(priority='1')
	public void containMethod() {
		
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", contains("Phase-3-Postman", "Workspace-v", "Workspace-b","Workspace-f"));
	}
	
	@Test(priority='2')
	public void emptyMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", empty());
		
		
	}
	
	
	@Test(priority='3')
	public void isNotemptyMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", is(not(empty())));
		
		
	}
	
	@Test(priority='4')
	public void hasSizeMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", hasSize(76));
		
		
	}
	
	@Test(priority='5')
	public void everyItemStartsWithMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", everyItem(startsWith("Workspaces")) );
		
		
	}
	
	@Test(priority='6')
	public void hasKeyMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]", hasKey("visibility"));
		
		
	}
	
	@Test(priority='7')
	public void hasValueMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]", hasValue("Team Workspace"));
		
		
	}
	
	@Test(priority='8')
	public void hasKeyValueMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]", hasEntry("name", "Team Workspace"));
		
		
	}
	
	@Test(priority='9')
	public void AnyOfMethod() {
		
		String PMapikey = "PMAK-6581111972602c4ddddad9f0-5b8c9b84cb6c486e5773965eea4126fd46";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMapikey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", anyOf(startsWith("Team"), containsString("Workspace")));
		
		
	}

}