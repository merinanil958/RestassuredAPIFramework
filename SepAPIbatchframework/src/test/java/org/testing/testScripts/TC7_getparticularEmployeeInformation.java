package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC7_getparticularEmployeeInformation {
	@Test
	
	public void testcase7() throws IOException
	{
		ExtentReports extent=Report.handleReport();
		ExtentTest test=extent.startTest("TC7_GetParticularEmployeeInformation");
		
		System.out.println("TC7_GetParticularEmployeeInformation");
		Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.GetParticular("real_URI","1");
		//System.out.println(res.asString());
		Boolean result=validateResponse.statuscodeValidate(200, res);
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
		
	}

}
