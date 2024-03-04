package Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;

public class Build_Rest_Api_Automation_Test {
public static void main(String[] args)
{
	// validate if Add Place API is working as expected
	//1)Given :- all input details
	//2)When :- Submit the API - resource, http method
	//3)Then :- Validate the response
	
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(Payload.AddPlace())
	
	.when().post("maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
             .header("Server", "Apache/2.4.52 (Ubuntu)");
   //  System.out.println("Response Body: " + responseBody);
     }
}
