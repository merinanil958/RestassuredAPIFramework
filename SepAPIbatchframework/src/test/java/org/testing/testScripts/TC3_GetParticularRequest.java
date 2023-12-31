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

public class TC3_GetParticularRequest {
	
	@Test
	public void testcase3() throws IOException
	{
		ExtentReports extent=Report.handleReport();
		ExtentTest test=extent.startTest("TC3_GetParticularRequest");
		
		System.out.println("TC3_GetParticularRequest");
		Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.GetParticular("QA_URI",TC1_postRequest.returnidvalue);
		Boolean result=validateResponse.statuscodeValidate(200, res);
		Boolean dataresult=validateResponse.responseDataValidate("Technical Test Analyst", res, "Designation");
		if((result==false)||(dataresult==false))
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
