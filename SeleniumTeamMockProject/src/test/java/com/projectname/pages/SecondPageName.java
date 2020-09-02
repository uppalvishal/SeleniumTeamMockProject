package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class SecondPageName {

	private String forgottenPassword = "//div[@id='login_link']//a";
	private WebDriver driver;
	private ExtentTest testLog;

	public SecondPageName(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public String verifyForgottenPassword() {
		return driver.findElement(By.xpath(forgottenPassword)).getText();
	}

}
