package Pojo_Courses_API;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.path.json.JsonPath;

public class OauthTest {
	public static void main(String[] args) {
		String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
		String response = given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type", "client_credentials").formParams("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		System.out.println(response);
		
		 JsonPath jpath = new JsonPath(response);
		 String token = jpath.getString("access_token");
		
		GetCourse gc=given().queryParams("access_token", token)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		
		//Get the course name of API
		List<API> apicourses = gc.getCourses().getApi();
		for(int i=0;i<apicourses.size();i++)
		{
			if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.print(apicourses.get(i).getPrice());
			}
		}
		
		// Get the course name of WebAutomation
		ArrayList a = new ArrayList();
		List<WebAutomation> w = gc.getCourses().getWebAutomation();
		for(int j=0;j<w.size();j++)
		{
			//if(w.get(j).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			//{
				//System.out.println(w.get(j).getPrice());
			//}
	    a.add(w.get(j).getCourseTitle());
		}
		
		List<String> expectedList = Arrays.asList(courseTitles);
		Assert.assertTrue(a.equals(expectedList));
	
		
		
		
	}

}
