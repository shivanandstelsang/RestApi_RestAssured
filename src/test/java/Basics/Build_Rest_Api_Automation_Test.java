package Basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Build_Rest_Api_Automation_Test {

	// validate if Add Place API is working as expected
	// 1)Given :- all input details
	// 2)When :- Submit the API - resource, http method
	// 3)Then :- Validate the response
	@Test
	public static void restapi() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.AddPlace())

				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response()
				.asString();
		System.out.println("responsebody : " + response);
		// System.out.println("api");

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);

//update place
		/*
		 * given().log().all().queryParam("key", "qaclick123").header("Content-Type",
		 * "application/json") .body(Payload.UpdatePlace())
		 * 
		 * .when().put("maps/api/place/update/json")
		 * .then().log().all().assertThat().statusCode(200) .body("msg",
		 * equalTo("Address successfully updated"));
		 */
		
		// After obtaining placeId from the response of Add Place API call
		//String placeId1 = js.getString("place_id");

		String newAddress = "india";
		// Use placeId in the UpdatePlace method call
		String updateResponse = given().log().all()
		        .queryParam("key", "qaclick123")
		        .header("Content-Type", "application/json")
		        .body(Payload.UpdatePlace(placeId, newAddress))
		        .when().put("maps/api/place/update/json")
		        .then().log().all().assertThat().statusCode(200)
		        .body("msg", equalTo("Address successfully updated"))
		        .extract().response().asString();

		
	//get place
		String getresponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		//JsonPath jp = new JsonPath(getresponse);
		JsonPath jp1 = ReusableMethods.stringRawtoJson(getresponse);
		String actualAddress = jp1.getString("address");
		System.out.println("actualAddress");
		Assert.assertEquals(actualAddress, newAddress);
		
	}
}
