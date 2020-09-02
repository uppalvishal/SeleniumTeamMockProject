package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageName {

	private String loginBtn = "//input[@type='submit']";
	private String userName = "email";
	private WebDriver driver;
	private ExtentTest testLog;

	public PageName(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public void enterUserName(String userName) {
		try {
			driver.findElement(By.id(this.userName)).sendKeys(userName);
			testLog.log(LogStatus.INFO, "Entered username as " + userName);
		} catch (Exception e) {
			Assert.fail("Unable to enter username as " + userName);
		}
	}

	public SecondPageName clickOnLoginButton() {
		try {
			driver.findElement(By.xpath(loginBtn)).click();
			testLog.log(LogStatus.INFO, "Clicked on login button");

		} catch (Exception e) {
			Assert.fail("Unable to click on login button");
		}
		return new SecondPageName(driver, testLog);
	}

}
