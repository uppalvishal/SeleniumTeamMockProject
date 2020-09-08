package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class OrderDetailsPage {


	@FindBy(xpath="//a[@class='ico-logout']") WebElement logOut;
		
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public OrderDetailsPage(WebDriver driver, ExtentTest testLog) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.testLog = testLog;
	}

	public void LogOut() throws InterruptedException {
		Thread.sleep(2000);
		logOut.click();
	}
	
}
