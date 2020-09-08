package com.projectname.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BooksPage {

	@FindBy(xpath="//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]") WebElement bookAddToCart;
	@FindBy(xpath="//span[contains(text(),'Shopping cart')]") WebElement shoppingCart;
	@FindBy(xpath="//input[@value='Go to cart']") WebElement shoppingAddToCart;
	
	
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	
	
	public BooksPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
		
	}
	

	public void addToCart() throws InterruptedException {
		Thread.sleep(3000);
		bookAddToCart.click();
	}
	
	
	public void HoverOverShoppingCart() throws InterruptedException {
		Thread.sleep(3000);
	
		Actions actions= new Actions(driver);
        actions.moveToElement(shoppingCart).perform();
	}
	
	
	public ShoppingCartPage clickGoToCart() throws InterruptedException {
			Thread.sleep(3000);
			shoppingAddToCart.click();
			testLog.log(LogStatus.INFO, "Click login link");
			ShoppingCartPage shoppingcart = new ShoppingCartPage(driver, testLog);
			PageFactory.initElements(driver, shoppingcart);
			return shoppingcart;
		
	}


}
