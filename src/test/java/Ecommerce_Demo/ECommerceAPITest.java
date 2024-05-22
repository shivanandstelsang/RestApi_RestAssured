package Ecommerce_Demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ECommerce_POJO.LoginRequest;
import ECommerce_POJO.LoginResponse;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

	public static void main(String[] args) {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("rahulshetty@gmail.com");
		loginRequest.setUserPassword("Iamking@000");
		
		RequestSpecification reqLogin = given().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();
		
		System.out.println(loginResponse.getUserId());
		
		//Add Product
		 RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", token).build();
		 
		 given().log().all().spec(addProductBaseReq);
		 
	}

}
