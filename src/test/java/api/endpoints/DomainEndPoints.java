package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


import org.hamcrest.Matchers;

import api.payload.Domain;


public class DomainEndPoints {
	public static Response createDomain(Domain payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	public static Response readDomain(String id)
	{
		Response response = given()
				.pathParam("id", id)
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	public static Response updateDomain(String id,Domain payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", payload)
		.body(payload)
		.when()
		.put(Routes.update_url);
		
		return response;
	}
	public static Response deleteDomain(String id)
	{
		Response response = given()
				.pathParam("id", id)
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}


}
