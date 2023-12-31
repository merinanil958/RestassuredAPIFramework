package org.testing.responseValidation;

import org.json.JSONObject;
import org.testing.assertion.Assertionn1;
import org.testing.utilities.JsonParsingUsingJsanPath;
import org.testing.utilities.JsonParsingUsingOrgJson;

import io.restassured.response.Response;

public class validateResponse {
	public static Boolean statuscodeValidate(int expected,Response res)
	{
		int actual=res.getStatusCode();
		Boolean result=Assertionn1.assertion(actual, expected);
		return result;
	}
	public static Boolean responseDataValidate(String expected,Response res,String Jsonpath)
	{
		String actual=JsonParsingUsingJsanPath.jsonParsing(res,Jsonpath);
		
		Boolean result=Assertionn1.assertion(actual, expected);
		return result;
	}
	public static Boolean responseDataValidate1(String expected,Response res,String Jsonpath)
	{
		//String actual=JsonParsingUsingJsanPath.jsonParsing(res,Jsonpath);
		JSONObject j1=new JSONObject(res.toString());
		System.out.println(j1);
		JSONObject j2=j1.getJSONObject("data");
		String actual=j2.get(Jsonpath).toString();
		System.out.println(actual);
		Boolean result=Assertionn1.assertion(actual, expected);
		return result;
	}
}
