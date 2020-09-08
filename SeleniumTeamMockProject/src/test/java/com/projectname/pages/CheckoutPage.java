package com.projectname.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CheckoutPage<OrdersProcessedPage> {


	@FindBy(xpath="//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']") WebElement billingAddressTick;
	@FindBy(xpath="//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']") WebElement shippingAddressTick;
	@FindBy(xpath="//input[@id='shippingoption_1']") WebElement nextDayAir;
	@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']") WebElement shippingMethodContinue;
	@FindBy(id="paymentmethod_1") WebElement checkMoneyOrder;
	@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']") WebElement Payment;
	@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']") WebElement paymentInformation;
	@FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']") WebElement confirmOrder;
		
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver, ExtentTest testLog) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.testLog = testLog;
	
	}
	
	public void ClickToCheckout() {
		billingAddressTick.click();
		
	}
	
	public void ClickToShipping() {
		shippingAddressTick.click();
		
	}
	
	public void ClickToShippingMethod() {
		nextDayAir.click();
		shippingMethodContinue.click();
	}
	
	public void ClickToPayment() {
		checkMoneyOrder.click();
		Payment.click();
	}
	
	public void ClickPaymentInformation() {
		
		paymentInformation.click();
	}
	

	public OrderProcessedPage ConfirmOrder() throws InterruptedException {
		Thread.sleep(2000);
		
        
		confirmOrder.click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,200)", "");
		
		OrderProcessedPage ordersprocesspage = new OrderProcessedPage(driver, testLog);
		PageFactory.initElements(driver, ordersprocesspage);
        return ordersprocesspage;
	}
	
}
