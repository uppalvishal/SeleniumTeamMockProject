package com.projectname.tests;
import static org.testng.Assert.assertEquals;

 

import java.util.List;

 

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectname.pages.BooksPage;
import com.projectname.pages.CheckoutPage;
import com.projectname.pages.HomePage;
import com.projectname.pages.LoginPage;
import com.projectname.pages.OrderDetailsPage;
import com.projectname.baseclass.BaseTestSuite;
import com.projectname.pages.ShoppingCartPage;
import com.projectname.pages.OrderProcessedPage;
import com.relevantcodes.extentreports.LogStatus;

 

public class Test_001<OrdersProcessedPage> extends BaseTestSuite {

 

    @Test
    public void tcase1() throws Exception {
        testLog = extent.startTest(this.getClass().getSimpleName());
 //       String[][] logindata = excelData.readData("LoginPage");
        LoginPage login = new LoginPage(driver, testLog);
        PageFactory.initElements(driver, login);
        login.clickLoginLink();
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        login.enterEmail("vuppal@gmail.com");
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        login.enterPassword("test123");
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        HomePage home=login.clickLoginButton();
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        
        
        // Assertion 1: Checking that Cart is 0
        Assert.assertEquals(home.shoppingCartQuantity(), "0", "Shopping cart before adding product is not empty!");
        // Print out statement for shpping cart
        
        BooksPage bookspage = home.clickBooksUnderCategories();
        bookspage.addToCart();
        bookspage.HoverOverShoppingCart();
        
        
        // Assertion 2: Checking that Cart has 1
      	Assert.assertEquals(home.shoppingCartQuantity(), "1", "Cart product count is not expected");
        
        
        ShoppingCartPage shoppingcart = bookspage.clickGoToCart();
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        shoppingcart.inputPostalCode();
        shoppingcart.agreeWithTerms();
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        
        //Assertion #3
        Assert.assertEquals(shoppingcart.verifyShoppingCartSubTotal(), true, "Sub totals of products do not match");
      		
      	//Assertion #4
      	Assert.assertEquals(shoppingcart.verifyShoppingCartPageTotals(), true, "Sub total does not match total");
        
        CheckoutPage checkoutpage = shoppingcart.clickCheckoutButton();
        checkoutpage.ClickToCheckout();
        checkoutpage.ClickToShipping();
        checkoutpage.ClickToShippingMethod();
        checkoutpage.ClickToPayment();
        checkoutpage.ClickPaymentInformation();

        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        
        OrderProcessedPage ordersprocesspage = checkoutpage.ConfirmOrder();
       
                
        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
        Thread.sleep(2000);
        OrderDetailsPage orderdetailspage = ordersprocesspage.Confirm();
        orderdetailspage.LogOut();
        
        
        //driver.findElement(By.xpath("//div[@class='section order-completed']/ul/li[2]/a")).click();
        
        
// Checkout Page -> OrderProcessedPage -> OrderDetailsPage
//        OrderProcessedPage orderprocessedpage=checkoutpage.clickConfirmButton();
        
        
// 		  OrderDetailsPage orderdetailspage=orderprocessedpage.clickOrderDetailsLink();
        
        
    }
    
//    public void resetShoppingCart(HomePage home, LoginPage login, String[][] logindata ) {
//        ShoppingCartPage shoppingpage = home.clickShoppingCartLink();
//        WebElement table = shoppingpage.getProductsTbl();
//
//
//
//        // get all rows
//        List < WebElement > rows_table = table.findElements(By.tagName("tr"));
//        int rows_count = rows_table.size();
//        //Loop will execute till the last row of table.
//        for (int row = 0; row < rows_count; row++) { 
//            // iterate through the rows
//            // get the rowCells in each row
//            driver.findElement(By.xpath("(//*[@class='remove-from-cart'])["+(row+1)+"]/span/following-sibling::input")).click();
//        }
//
//
//
//        // shoppingcartpage.clickRemoveCheckbox();
//        shoppingcartpage.clickupdateShoppingCartButton();
//        shoppingcartpage.clicklogoutLink();
//        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
//        login.clickLoginLink();
//        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
//        login.enterEmail(logindata[0][0]);
//        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
//        login.enterPassword(logindata[0][1]);
//        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
//        home = login.clickOnLoginButton();
//        testLog.log(LogStatus.INFO, testLog.addScreenCapture(createScreenshot()));
//    
//}
    
}