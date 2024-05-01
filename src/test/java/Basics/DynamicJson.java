package Basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
	@Test(dataProvider="BookData")
public void addBook(String isbn, String aisle)
{
	RestAssured.baseURI = "http://216.10.245.166";
	String res = given().log().all()
	.header("Content-Type", "application/json")
	.body(Payload.addBook("asdfs", "6545"))
	
	.when().post("/Library/Addbook.php")
	
	.then().log().all().assertThat().statusCode(200)
	.extract().response().asString();
	  JsonPath jspath = ReusableMethods.stringRawtoJson(res);
	  String id = jspath.get("ID");
	  System.out.println(id);
}
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		return new Object[][] {{"osdkj", "7878"},{"djsds", "3909"}, {"edhe", "323"}
		};
	}
}
