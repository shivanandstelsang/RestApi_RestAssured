package Basics;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexjsonParse {
	public static void main(String[] args) {
		JsonPath jpath = new JsonPath(Payload.CoursePrice());
		int count = jpath.getInt("courses.size()");
		System.out.println(count);
		
		int totalamount = jpath.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);

		//print title of the first course
		String titlefirstcourse = jpath.get("courses[3].title");
		System.out.println(titlefirstcourse);
		
		//print all course titles and their respective prices
		
		for(int i=0;i<count;i++)
		{
			String couresTitles = jpath.get("courses["+i+"].title");
			 System.out.println(jpath.get("courses["+i+"].price").toString());
			System.out.println(couresTitles);
		}
		
		//how to retrive dynamically values
		System.out.println("Print no of copies sold by cypress course");
		for(int i=0;i<count;i++)
		{
			String couresTitles =jpath.get("courses["+i+"].title");
			if(couresTitles.equalsIgnoreCase("cypress"))
			{
				int copies = jpath.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
	}
}
