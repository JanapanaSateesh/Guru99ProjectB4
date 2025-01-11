package com.guru99.pagesobjetcs;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	

	
	
	public static void ExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,400)");
		
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,-400)");
		
	}
	
	
	public static void DoubleClick(WebDriver driver, WebElement elemenet) {
		Actions act=new Actions(driver);
		act.contextClick(elemenet).build().perform();
	}
}
