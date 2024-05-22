package Serialization;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


public class SpecBuilderTest {
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
	p.setLocation(l);
	
	 RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	 ResponseSpecification respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 RequestSpecification res = given().spec(req).body(p);
	Response response = res.when().post("/maps/api/place/add/json").then().spec(respec).extract().response();
	String responseString = response.asString();
	System.out.println(responseString);

}
	}
