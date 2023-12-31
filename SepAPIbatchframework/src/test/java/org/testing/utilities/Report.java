package org.testing.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class Report {
	public static ExtentReports handleReport()
	{
		ExtentReports extent=new ExtentReports("../SepAPIbatchframework/Reports/Report1.html",false);
		return extent;
	}

}
