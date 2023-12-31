package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonFile;
import org.testing.utilities.Jsonreplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC4_UpdateRequest {
@Test
public void testCase4() throws IOException
{
	ExtentReports extent=Report.handleReport();
	ExtentTest test=extent.startTest("TC4_UpdateRequest");
	
	System.out.println("TC4_UpdateRequest");
	Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
	String requestBody=JsonFile.LoadJsonData("../SepAPIbatchframework/src/test/java/org/testing/resources/updateRequest.json");
	//Scanner s=new Scanner(System.in);
	String VaribaleValue = TC1_postRequest.returnidvalue;
	//System.out.println(VaribaleValue);
	requestBody=Jsonreplacement.JsonVariableAssign(requestBody,"id",VaribaleValue);
	//System.out.println("Request Body is");
	//System.out.println(requestBody);
	HTTPMethods http=new HTTPMethods(pr);
	System.out.println(pr);
	Response res=http.PutMethod(requestBody, "QA_URI",TC1_postRequest.returnidvalue);
	Boolean result=validateResponse.statuscodeValidate(200, res);
	if(result==false)
	{
		test.log(LogStatus.FAIL, "Status code is not matching");
		extent.endTest(test);
		extent.flush();
		Assert.assertTrue(result);//hard assertion. It will not execute further
	}
	else
	{
	test.log(LogStatus.PASS, "Status code is matching");
	extent.endTest(test);
	extent.flush();
	}
	Boolean dataresult=validateResponse.responseDataValidate("Test manager", res, "Designation");
}
}
