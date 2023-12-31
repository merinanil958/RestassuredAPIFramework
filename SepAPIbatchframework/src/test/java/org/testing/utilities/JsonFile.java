package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;

//input parameter---json filepath
//purpose of the method---toread the json file
//output parameter---String json data
public class JsonFile {
	public static String LoadJsonData(String filePath) throws IOException
	{
		File f=new File(filePath);//create a connection
		FileInputStream fi=new FileInputStream(f);
		JSONTokener js=new JSONTokener(fi);
		JSONObject j=new JSONObject(js);
		return j.toString();
		
	}
}
