package org.testing.testSteps;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HTTPMethods {
	Properties pr=new Properties();
	//Constructor
	public HTTPMethods(Properties pr) {
		this.pr=pr;
	}
	public Response PostMethod(String jsonRequestBody,String urikeyname)
	{
		String uriValue=pr.getProperty(urikeyname);
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(jsonRequestBody)
		.when()
		.post(uriValue.toString());
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	
	
	public Response GetAll(String urikeyname)
	{
		String uriValue=pr.getProperty(urikeyname);
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(uriValue);
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	
	
	public Response GetParticular(String urikeyname,String endPointValue)
	{
		String uriValue=pr.getProperty(urikeyname)+"/"+endPointValue;
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(uriValue);
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	public Response GetParticular1(String urikeyname,int endPointValue)
	{
		String uriValue=pr.getProperty(urikeyname)+"/"+endPointValue;
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(uriValue);
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	
	public Response PutMethod(String jsonRequestBody,String urikeyname,String endPointValue)
	{
		String uriValue=pr.getProperty(urikeyname)+"/"+endPointValue;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(jsonRequestBody)
		.when()
		.put(uriValue.toString());
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	public Response Delete(String urikeyname,String endPointValue)
	{
		String uriValue=pr.getProperty(urikeyname)+"/"+endPointValue;
		Response res=
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.delete(uriValue);
		 System.out.println("Statuscode is");
	        System.out.println(res.statusCode());
	        System.out.println("Response Data is");
	        System.out.println(res.asString());
	        return res;
	}
	
	

}
