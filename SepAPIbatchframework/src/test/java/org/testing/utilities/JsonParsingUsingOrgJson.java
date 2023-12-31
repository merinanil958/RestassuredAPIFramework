package org.testing.utilities;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;


public class JsonParsingUsingOrgJson {
	
	//1. How to parse single value  from the response 
	
	public static void doParsing(Response res,String Keyname)
	{
	JSONObject  js=new JSONObject(res.asString());
	JSONArray j=js.getJSONArray("data");
	
	//parse single value from a respone
	/*
	 JSONObject jobj=j.getJSONObject(0);
	System.out.println(jobj.get(Keyname));*/
	 
	}

	// 2.How to extract multiple occurence of that thing from response
	
	public static void doParsing1(Response res,String Keyname)
	{
	JSONObject  js=new JSONObject(res.asString());
	JSONArray j=js.getJSONArray("data");
	//get all the id values of id 
	/*int length=j.length();
	for(int i=0;i<length;i=i+1) 
	{
	JSONObject jobj=j.getJSONObject(i);
	System.out.println(jobj.get(Keyname));
	}*/
	// parse single value from a respone
	int length=j.length();
	
	 JSONObject jobj=j.getJSONObject(0);
	System.out.println(jobj.get(Keyname));
		
	
	}
	//3.Extract all the values from object1
	
	public static void doParsing2(Response res)
	{
	JSONObject  js=new JSONObject(res.asString());
	JSONArray j=js.getJSONArray("data");
	
	JSONObject jobj=j.getJSONObject(0);
	Set<String> allKeys=jobj.keySet();
	for(String s: allKeys)
	{
		System.out.println("Key name is" +s);
		System.out.println("value is"+jobj.get(s));
	}
	
	
	
	}
	
	//4. Extract all the objects of a array
	public static void doParsing3(Response res)
	{
	JSONObject  js=new JSONObject(res.asString());
	JSONArray j=js.getJSONArray("data");
	int length=j.length();
	for(int i=0;i<length;i=i+1) 
	{
	JSONObject jobj=j.getJSONObject(0);
	Set<String> allKeys=jobj.keySet();
	for(String s: allKeys)
	{
		System.out.println("Key name is" +s);
		System.out.println("value is"+jobj.get(s));
	}
	
	}
	
	}
}
