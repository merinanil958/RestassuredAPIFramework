package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingJsanPath;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC2_getALL {
@Test
public void testcase2() throws IOException
{
	ExtentReports extent=Report.handleReport();
	ExtentTest test=extent.startTest("TC2_getALL");
	System.out.println("TC2_getALL");
	Properties pr=PropertiesFile.Loadproperties("../SepAPIbatchframework/URI.properties");
	HTTPMethods http=new HTTPMethods(pr);
	Response res=http.GetAll("QA_URI");
	//JsonParsingUsingOrgJson.doParsing(res,"id");
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
	//JsonParsingUsingOrgJson.doParsing2(res);
}
}
