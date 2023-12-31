package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonFile;
import org.testing.utilities.JsonParsingUsingJsanPath;
import org.testing.utilities.Jsonreplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC8_AddnewEmployee {
	public static String returnidvalue=null;
	
	
	@Test
	public void testcase8() throws IOException {
		ExtentReports extent=Report.handleReport();
		ExtentTest test=extent.startTest("TC8_AddnewEmployee");
		
		
		System.out.println("TC8_AddnewEmployee");
		
		Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
		String requestBody=JsonFile.LoadJsonData("../SepAPIbatchframework/src/test/java/org/testing/resources/inputRequest1.json");
		System.out.println(requestBody);
		/* Get id from user
		Scanner s=new Scanner(System.in);
		String VaribaleValue = s.next();*/
		//Get id value using random class
		Random r=new Random();
		String VaribaleValue = r.toString();
		//Integer VaribaleValue=r.nextInt();
		requestBody=Jsonreplacement.JsonVariableAssign(requestBody,"id","345");
		
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.PostMethod(requestBody, "real_URI");
		Boolean result=validateResponse.statuscodeValidate(201, res);
		
		//Boolean dataresult=validateResponse.responseDataValidate1("George",res,"first_name");
		if((result==false))
		{
			test.log(LogStatus.FAIL, "Status code/data is not matching");
			extent.endTest(test);
			extent.flush();
			Assert.assertTrue(result);//hard assertion. It will not execute further
		}
		else
		{
		test.log(LogStatus.PASS, "Status code and data is matching");
		extent.endTest(test);
		extent.flush();
		}
		
		returnidvalue =JsonParsingUsingJsanPath.jsonParsing(res,"id");
		
	}

}
