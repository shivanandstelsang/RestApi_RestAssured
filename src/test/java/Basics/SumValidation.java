package Basics;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import Files.Payload;

public class SumValidation {
	@Test
	public void sumofCourses()
	{			int sum=0;

		JsonPath jsp = new JsonPath(Payload.CoursePrice());
		int count = jsp.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			 int price = jsp.getInt("courses["+i+"].price");
			 int copies = jsp.getInt("courses["+i+"].copies");
			 int amount = price * copies;
			 System.out.println(amount);
			 sum = sum + amount;
		}
		 System.out.println(sum);

		
	}

}
