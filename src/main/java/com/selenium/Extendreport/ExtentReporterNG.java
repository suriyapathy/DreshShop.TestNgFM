package com.selenium.Extendreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG  {
    
	public static ExtentReports extentReport;
    public static ExtentSparkReporter sparkReport;
	
	
	public static ExtentReports getReportObject() {
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Functional report");
		sparkReport.config().setTheme(Theme.STANDARD);

		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReport);
		extentReport.setSystemInfo("Tester", "Surya");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "QA");
		return extentReport;
	}

}