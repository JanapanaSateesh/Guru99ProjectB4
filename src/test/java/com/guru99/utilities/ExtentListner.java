package com.guru99.utilities;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener{
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport() {
		String timestamp=new SimpleDateFormat("YYY_MM_dd_hh_mm_ss").format(new Date());
		
		htmlreporter=new ExtentSparkReporter("./Reports/SummaryReport "+timestamp+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		htmlreporter.config().setDocumentTitle("Summary Report");
		htmlreporter.config().setTheme(Theme.DARK);
		reports.setSystemInfo("Machine Name", "Test Env");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("User", "Sateesh");
		reports.setSystemInfo("OS", "Windows 11");
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Executing");
		ExtentTest test= reports.createTest(result.getName());
		
		extentTestThreadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("OnTestSuccess Executing");
		ExtentTest test= extentTestThreadLocal.get();
		test.log(Status.PASS,result.getName()+"Test case is passed" );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailure Executing");
		ExtentTest test= extentTestThreadLocal.get();
		test.log(Status.FAIL,result.getName()+"Test case is failed" );
		 WebDriver driver= (WebDriver) result.getTestContext().getAttribute("driver");
		 byte[] screenshotInBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 String screenshot= Base64.getEncoder().encodeToString(screenshotInBytes);
		 test.addScreenCaptureFromBase64String(screenshot);
		 test.fail(result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		ConfigureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
