package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
public static JsonPath stringRawtoJson(String response)
{
	JsonPath jp = new JsonPath(response);
	return jp;
}
}
