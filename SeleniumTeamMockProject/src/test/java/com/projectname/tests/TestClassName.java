package com.projectname.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.projectname.baseclass.BaseTestSuite;
import com.projectname.pages.PageName;
import com.projectname.pages.SecondPageName;

public class TestClassName extends BaseTestSuite {

	@Test()
	public void selectComprehensiveCleaningServicePlan() {
		testLog = extent.startTest(this.getClass().getSimpleName());
		String[][] data = excelData.readData("LoginPage");
		PageName pageClassName = new PageName(driver, testLog);
		pageClassName.enterUserName(data[0][0]);
		SecondPageName secondPageName = pageClassName.clickOnLoginButton();

		//assertEquals("Forgotten Phil is the best password?", secondPageName.verifyForgottenPassword());

		assertEquals("Forgotten best password is actually Phil?", secondPageName.verifyForgottenPassword());
		
		assertEquals("Phil changed this line?", secondPageName.verifyForgottenPassword());

	}
}
