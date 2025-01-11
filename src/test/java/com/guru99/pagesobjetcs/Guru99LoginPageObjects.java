package com.guru99.pagesobjetcs;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.utilities.ExtentListner;

import junit.framework.Assert;

public class Guru99LoginPageObjects {

	WebDriver ldriver;
	public final static Logger logger=LogManager.getLogger("rootLogger");
	
	public Guru99LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="//input[@name='uid']")  WebElement username;
	//WebElement username= driver.findElement(By.xpath("//input[@name='uid']"))
	
	@FindBy(xpath="//input[@name='password']") WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']") WebElement logibutton;
	
	@FindBy(xpath="//input[@name='btnLogin123']") WebElement logibutton1;
	
	public void enterUsername(String uname) throws InterruptedException {
		try {
			
			CommonActions.ExplicitWait(ldriver, username);
			
			
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			username.sendKeys(uname);
			test.log(Status.PASS, "Username Eneted");
			logger.info("Entered Username");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			//logger.error(e.getStackTrace());
			logger.error(e.getMessage());
			throw e;
			
		}
		
		
	}
	
	public void enterPassword(String pwd) throws InterruptedException {
		
		try {
			
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			password.sendKeys(pwd);
			test.log(Status.PASS, "Password Eneted");
			logger.info("Entered password");
		
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
		
	}
	
	public void clickOnLoginButton() throws InterruptedException {
		try {
			
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			logibutton.click();
			test.log(Status.PASS, "Successfully clicked on login button");
			logger.info("Clicked on Login button");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	public void HitEnter() throws InterruptedException {
		try {
			
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			password.sendKeys(Keys.ENTER);
			test.log(Status.PASS, "Hit enter button instaed of cliking on Login");
			logger.info("Hit Enter");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	public void loginWithValidCredentials(String uname, String pwd) throws InterruptedException, IOException {
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	public void loginWithInValidCredentials(String uname, String pwd) throws InterruptedException {
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	public void loginWithValidUsernameInValidPassword(String uname, String pwd) throws InterruptedException, IOException {
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginButton();
		
	}
	
	public void loginWithInValidUsernameValidPassword(String uname, String pwd) throws InterruptedException {
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	public void loginWithoutCredentials() throws InterruptedException {

		clickOnLoginButton();
	}
	
	public void loginWithValidUsernameValidPasswordWithEnterKey(String uname, String pwd) throws InterruptedException {
		enterUsername(uname);
		enterPassword(pwd);
		HitEnter();
	}
	
}
