package com.projectname.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
    @FindBy(xpath="//div[@class='block block-category-navigation']/div[2]/ul/li[1]/a") WebElement booksLink;
	@FindBy(xpath="//li[@class='inactive']//a[contains(text(),'Computers')]") WebElement computersLink;
	@FindBy(xpath="//li[@class='inactive']//a[contains(text(),'Apparel & Shoes')]") WebElement apparelAndShoesLink;
	@FindBy(xpath="//a[contains(text(),'vuppal@gmail.com')]") WebElement goToCartLink;
	@FindBy(xpath="//span[@class='cart-qty']") WebElement shoppingCartQuantity;
	@FindBy(xpath="//a[@class='ico-logout']") WebElement logOut;
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	
	
	public HomePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
		
	}
	

	public ShoppingCartPage clickGoToCart() {
			//Thread.sleep(2000);
			shoppingCartQuantity.click();
			//testLog.log(LogStatus.INFO, "Click login link");
			ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, testLog);
			return shoppingCart;
		
	}

	public String shoppingCartQuantity() {
		int i=0;
		
		
		if (i==0){	
		System.out.println("The Shopping Cart quantity is: " + shoppingCartQuantity.getText());
		i++;
		
		}
		else {
		System.out.println("The Shopping Cart quantity now has changed to: " + shoppingCartQuantity.getText());
		}
		return StringUtils.substringBetween(shoppingCartQuantity.getText(),  "(", ")");
		
	}
	
	public BooksPage clickBooksUnderCategories() {
		try {
		//	Thread.sleep(5000);
			booksLink.click();
			testLog.log(LogStatus.INFO, "Able to Click Books Link");
				
		}
		catch (Exception e) {
			Assert.fail("Unable to Click Books");
		}
		BooksPage bookspage = new BooksPage(driver, testLog);
		PageFactory.initElements(driver, bookspage);
		return bookspage;
	}

}
