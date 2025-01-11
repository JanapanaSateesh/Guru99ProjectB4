package com.guru99.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.guru99.utilities.ReadConfigFile;

public class BaseClass {

	//public WebDriver driver;
	
	//Read the Url data from properties file
	ReadConfigFile readconfigfiledata;
	
	
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();




	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void SetUp(ITestContext context, String Browser) throws IOException {
		readconfigfiledata=new ReadConfigFile();
		String url=readconfigfiledata.getUrl();


		//driver=new ChromeDriver();
		switch(Browser.toUpperCase()) {
		case "CHROME":driver.set(new ChromeDriver());
		break;


		case "EDGE":driver.set(new EdgeDriver());
		break;

		default: throw new IllegalArgumentException("Please provide Correct browser name");
		}


		context.setAttribute("driver", driver.get());
		driver.get().get(url);
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}



	@AfterMethod(alwaysRun = true)
	public void TearDown() {

		driver.get().quit();
		//reports.flush();
	}
}
