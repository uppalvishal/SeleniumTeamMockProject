package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	@FindBy(xpath="//*[@class='ico-login']") WebElement loginLink;
	@FindBy(xpath="//*[@id='Email']") WebElement emailTextBox;
	@FindBy(xpath="//*[@id='Password']") WebElement passwordTextBox;
	@FindBy(xpath="//input[@class='button-1 login-button']") WebElement loginButton;
	@FindBy(xpath="//*[@class='ico-cart']") WebElement shoppingCartLink;
	@FindBy(xpath="//a[@class='ico-logout']") WebElement LogOut;
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	
	
	public LoginPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
		
		//Ask explanation for extentTest
		
	}
	

	public void clickLoginLink() {
		try {
			Thread.sleep(2000);
			loginLink.click();
			testLog.log(LogStatus.INFO, "Click login link");
		}
		catch (Exception e)
		{
			Assert.fail("Unable to click login link");
		}
		
	}

	public void enterEmail(String email) {
		try {
		emailTextBox.sendKeys(email);
		testLog.log(LogStatus.INFO, "Entered email as " + email);
		}
		catch (Exception e) {
			Assert.fail("Unable to input email");
		}
		
	}
	public void enterPassword(String password) {
		try {
		passwordTextBox.click();
		passwordTextBox.sendKeys(password);
		testLog.log(LogStatus.INFO, "Entered password");	
		}
		catch(Exception e){
			Assert.fail("Unable to input password");
		}
		
	}
	public HomePage clickLoginButton() {
		try {
		Thread.sleep(2000);
		loginButton.click();
		testLog.log(LogStatus.INFO, "Entered password");	
		}
		catch(Exception e){
			Assert.fail("Unable to input password");
		}
	    HomePage home= new HomePage(driver, testLog);
	    PageFactory.initElements(driver, home);
	    return home;

	}
	
//	@AfterClass
//	public void clickLogOutLInk() {
//		LogOut.click();
//	}

}
