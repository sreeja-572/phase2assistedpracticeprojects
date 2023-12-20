package restassuredscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Script012_SSLAuthentication {
	
	
	@Test
	public void SSL_Authentication() {
		
		//Use relaxed HTTP validation with SSLContext protocol SSL. 
		//This means that you'll trust all hosts regardless if the SSL certificate is invalid.
		
		RestAssured.given().relaxedHTTPSValidation()
		.when().get("https://testautomasi.com/Home/").then().log().all();
		
		
	}

}