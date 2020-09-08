package com.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class OrderProcessedPage {


	//@FindBy(xpath="//a[contains(text(),'Click here for order details.')]") WebElement orderDetailsLink;
    @FindBy(xpath="//div[@class='section order-completed']/ul/li[2]/a") WebElement orderDetailsLink;

		
	
	private WebDriver driver;
	private ExtentTest testLog;
	private WebDriverWait wait;
	
	public OrderProcessedPage(WebDriver driver, ExtentTest testLog) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.testLog = testLog;
	
	}
	
	public OrderDetailsPage Confirm() throws InterruptedException {
		Thread.sleep(2000);
		orderDetailsLink.click();
		
		//driver.findElement(By.xpath("//div[@class='section order-completed']/ul/li[2]/a")).click();
		
		OrderDetailsPage orderdetailspage = new OrderDetailsPage(driver, testLog);
		PageFactory.initElements(driver, orderdetailspage);
        return orderdetailspage;
		
	}
	
	
	
}
