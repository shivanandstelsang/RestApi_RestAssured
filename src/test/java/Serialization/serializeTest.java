package Serialization;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class serializeTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Rahul Shetty Academy");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://rahulshettyacademy.com");

		ArrayList mylist = new ArrayList();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);

		location l = new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		Response res = given().log().all().queryParam("key", "qaclick123").body(p).post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		

		String responseString = res.asString();
		System.out.println(responseString);
	}

}
