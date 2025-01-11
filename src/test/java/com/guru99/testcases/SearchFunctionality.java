//package com.guru99.testcases;
//
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.guru99.pagesobjetcs.Guru99LoginPageObjects;
//import com.guru99.utilities.DataFromExcelAfterRead;
//
//public class SearchFunctionality extends BaseClass{
//	Guru99LoginPageObjects loginpage;
//
//	@Test(priority = 1, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC001_TestData", enabled = true)
//	public void TC001_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException, IOException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		//ExtentTest test= reports.createTest("TC001 Login With ValidCredentials");
//		
//		loginpage.loginWithValidCredentials(username, password);
//		//test.info("Entered the valid username and password and clicked on login button");
//	}
//	
//	@Test(priority = 2, enabled = false, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC002_TestData")
//	public void TC002_LoginPage_LoginWithInValidCredentials(String wrongusername, String wrongpassword) throws InterruptedException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		loginpage.loginWithInValidCredentials(wrongusername, wrongpassword);
//		
//	}
//	
//	@Test(priority = 3,enabled = false, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC003_TestData")
//	public void TC003_LoginPage_LoginWithInValidCredentials(String WrongUsername, String CorrectPassword) throws InterruptedException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		loginpage.loginWithInValidUsernameValidPassword(WrongUsername, CorrectPassword);
//		
//	}
//	
//	@Test(priority = 4,enabled = false, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC004_TestData")
//	public void TC004_LoginPage_LoginWithInValidCredentials(String CorrectUsername, String WrongPwd) throws InterruptedException, IOException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		loginpage.loginWithValidUsernameInValidPassword(CorrectUsername, WrongPwd);
//		
//	}
//	
//	@Test(priority = 5,enabled = false)
//	public void TC005_LoginPage_LoginWithoutCredentials() throws InterruptedException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		loginpage.loginWithoutCredentials();
//		
//	}
//	
//	@Test(priority = 6,enabled = false, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC006_TestData")
//	public void TC006_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException {
//		loginpage=new Guru99LoginPageObjects(driver);
//		loginpage.loginWithValidUsernameValidPasswordWithEnterKey(username, password);
//		
//	}
//	
////	@DataProvider
////	public String[][] TC1Data() {
////		String[][] data=new String[2][2];
////		data[0][0]="mngr26593";
////		data[0][1]="123Abc@";
////		
////		data[1][0]="sateesh@gmail.com";
////		data[1][1]="Sateesh@123";
////		
////		//mngr26593 			123Abc@
////		//sateesh@gmail.com		Sateesh@123
////				
////		
////		return data;
////	}
//}
