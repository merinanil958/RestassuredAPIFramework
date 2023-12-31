package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC5_DeleteRequest {
	
	@Test

	public void testcase5() throws IOException
	{
		ExtentReports extent=Report.handleReport();
		ExtentTest test=extent.startTest("TC5_DeleteRequest");
		System.out.println("TC5_DeleteRequest");
		Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.Delete("QA_URI",TC1_postRequest.returnidvalue);
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
		//Boolean dataresult=validateResponse.responseDataValidate("Test manager", res, "Designation");
	}
}
