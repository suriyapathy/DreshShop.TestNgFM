package com.selenium.Extendreport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.baseclass.baseclass;


public class TestListener extends baseclass implements ITestListener {
	ExtentTest test;
	ExtentReports extentReport = ExtentReporterNG.getReportObject();
	ThreadLocal <ExtentTest>threadLocal=new ThreadLocal<ExtentTest>();

	public void onStart(ITestContext context) {
		System.out.println("*** Test suite" + context.getName() + " started ***");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " started ***");
		test = extentReport.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		extentReport.flush();
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
		threadLocal.get().fail("TEST CASE FAILED IS " + result.getThrowable()); 
		String filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}