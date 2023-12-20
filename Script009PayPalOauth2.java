package restassuredscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


//Create credentials for https://developer.paypal.com/

//loginto the paypal webpage.
//go to developer dashboard -> bring cursor to your name --> click on dashboard
//make sure you have sandbox enabled.
//click on Apps & Credentials
//Click on Create an APP --> select Platform app > Click on Create APP

//Click on APIs and SDKs  --> click on Rest API
//Scroll down to postman section

public class Script009PayPalOauth2 {
	
	String accessToken;
	
	
	@Test(priority='1')
	public void GetAccessToken() {
		
		String clientID="AYPvFnA70EpZOIxJWA5ZXbV--5pOIqGK1ud9KmdJ63wRLz01H-QBiLX4pfF2HDJ7AUTLuoNSbda2tqgJ";
		String clientSecret="EO51E4MyJFK_G9lfIET0MCANTmnWGm2WgYWQsTn4Wrtu2HvH8gOT6p1kX3XsXV22P2pLhkZU69CXuKJE";
		
		Response res = RestAssured.given()
						.baseUri("https://api-m.sandbox.paypal.com")
						.basePath("/v1/oauth2/token")
						.auth().preemptive().basic(clientID, clientSecret)
						.param("grant_type", "client_credentials")
						.when().post();
		
						//res.prettyPrint();
		
		Assert.assertEquals(res.statusCode(), 200);
		
		// In the response we got the token, fetch the token from response body and save it in a string
		
		
		
		accessToken = res.getBody().path("access_token");
		
		System.out.println(accessToken);
		
	}
	
	@Test(priority='2')
	public void paypalTestInvoiceAPI() {
		
		
		Response res = RestAssured.given()
						.baseUri("https://api-m.sandbox.paypal.com")
						.basePath("/v1/invoicing/invoices")
						.queryParam("page", "3")
						.queryParam("page_size", "4")
						.queryParam("total_count_required", true)
						.auth().oauth2(accessToken)
						.when().get();
		
						res.prettyPrint();
		
		
		
	}
	
	
	

}