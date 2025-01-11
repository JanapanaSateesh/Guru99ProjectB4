package com.guru99.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.guru99.pagesobjetcs.Guru99LoginPageObjects;
import com.guru99.utilities.DataFromExcelAfterRead;

public class Guru99LoginPageTest extends BaseClass{
	Guru99LoginPageObjects loginpage;

	@Test(priority = 1, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC001_TestData", enabled = true, groups = {"regression","smoke"})
	public void TC001_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException, IOException {
		loginpage=new Guru99LoginPageObjects(driver.get());	
		loginpage.loginWithValidCredentials(username, password);

	}

	@Test(priority = 2, enabled = true, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC002_TestData",groups = {"regression"})
	public void TC002_LoginPage_LoginWithInValidCredentials(String wrongusername, String wrongpassword) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver.get());

		loginpage.loginWithInValidCredentials(wrongusername, wrongpassword);

	}

	@Test(priority = 3,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC003_TestData",groups = {"regression","sanity"})
	public void TC003_LoginPage_LoginWithInValidCredentials(String WrongUsername, String CorrectPassword) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver.get());
		loginpage.loginWithInValidUsernameValidPassword(WrongUsername, CorrectPassword);

	}

	@Test(priority = 4,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC004_TestData",groups = {"regression"})
	public void TC004_LoginPage_LoginWithInValidCredentials(String CorrectUsername, String WrongPwd) throws InterruptedException, IOException {
		loginpage=new Guru99LoginPageObjects(driver.get());
		loginpage.loginWithValidUsernameInValidPassword(CorrectUsername, WrongPwd);

	}

	@Test(priority = 5,enabled = true,groups = {"regression"})
	public void TC005_LoginPage_LoginWithoutCredentials() throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver.get());
		loginpage.loginWithoutCredentials();

	}

	@Test(priority = 6,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC006_TestData",groups = {"regression","smoke"})
	public void TC006_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver.get());
		loginpage.loginWithValidUsernameValidPasswordWithEnterKey(username, password);

	}


}
