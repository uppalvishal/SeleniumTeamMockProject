package com.projectname.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class ConfirmationPage {


	@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']") WebElement confirmationPage;
		
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public ConfirmationPage(WebDriver driver, ConfirmationPage shoppingCart) {
		// TODO Auto-generated constructor stub
	
	
	}

}
