package org.testing.utilities;

import io.restassured.response.Response;
//input parameter---response object amd jsonpath
//purpose of the utility---to extarct the value from the response based on th json path we are giving to it
//output parameter---AFter extracting it is giving the extracted value  
public class JsonParsingUsingJsanPath {

	public static String jsonParsing(Response res,String JsonPath )
	{
		String responseExtarctedValue=res.jsonPath().get(JsonPath);
		return responseExtarctedValue;
	}
}
