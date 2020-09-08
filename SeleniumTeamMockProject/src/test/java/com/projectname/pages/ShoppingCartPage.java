package com.projectname.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingCartPage {


	@FindBy(xpath="//input[@id='ZipPostalCode']") WebElement zipCode;
    @FindBy(id="termsofservice") WebElement termsCheckBox;
	//@FindBy(xpath="//button[@id='checkout']") WebElement checkoutBox;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkoutButton;
	@FindBy(xpath ="//input[@name='updatecart']")WebElement updateShoppingCartButton;
	@FindBy(xpath = "//div[@class='header-logo']") WebElement homeLogoLink;
	@FindBy(xpath ="//span[@class='product-unit-price']") WebElement productUnitPrice;
	@FindBy(xpath ="//td[@class='qty nobr']/input") WebElement productQuantity;
	@FindBy(xpath = "//span[@class='product-subtotal']") WebElement productSubTotalPrice;
	@FindBy(xpath = "//table[@class='cart-total']/tbody[1]/tr[1]/td[2]/span[1]/span[1]") WebElement shoppingCartTotalPrice;


	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public ShoppingCartPage(WebDriver driver, ExtentTest testLog) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.testLog = testLog;
	
	}

	public void inputPostalCode() throws InterruptedException {
		zipCode.click();
		zipCode.clear();
		zipCode.sendKeys("2141");
	}
	
	public void agreeWithTerms() {
		termsCheckBox.click();
	}
	
	public boolean verifyShoppingCartSubTotal() {
		float i = Float.parseFloat(productUnitPrice.getText());
		int j = Integer.parseInt(productQuantity.getAttribute("value"));
		float k = Float.parseFloat(productSubTotalPrice.getText());

		if(i*j==k) {
			System.out.println("Shopping Cart Page SubTotal expected " + productSubTotalPrice.getText());
			return true;
		}
		return false;	
	}
	
	public boolean verifyShoppingCartPageTotals() {
		float i = Float.parseFloat(productSubTotalPrice.getText());
		float j = Float.parseFloat(shoppingCartTotalPrice.getText());
		
		if(i==j) {
			System.out.println("Shopping Cart Page Total expected " + shoppingCartTotalPrice.getText());
			return true;
		}
		return false;
	}
	
	
	public CheckoutPage clickCheckoutButton() {
		
        try {    
            //Thread.sleep(3000);
            checkoutButton.click();
            testLog.log(LogStatus.INFO, "Clicked checkout button");
        }

        catch (Exception e) {
            Assert.fail("Unable to click checkout button");
        }
        CheckoutPage checkoutpage= new CheckoutPage(driver, testLog);
        PageFactory.initElements(driver, checkoutpage);
        return checkoutpage;
    }
	
}
