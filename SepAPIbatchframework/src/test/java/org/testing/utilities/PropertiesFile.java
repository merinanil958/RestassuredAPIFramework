package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//input parameter----filepath
//purpose of the method -----to load the properties file
//output parameter---it will return the properties class object
public class PropertiesFile {
	public static Properties Loadproperties(String filePath) throws IOException
	{
		File f=new File(filePath);//create a connection
		FileInputStream fi=new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(fi);
		return pr;
	}

}
