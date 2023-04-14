package com.orangehrm.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.pageobject.BaseClass;
import com.orangehrm.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test

	public void loginTest() {

		LoginPage lp = new LoginPage(driver);

		lp.inputUname(username);
		lp.inputPwd(pwd);
		lp.clickLgnButton();
		logger.info("Entered the credentials successfully");
		if (driver.getTitle().equals("OrangeHRM")) {

			Assert.assertTrue(true);
			logger.info("The login page title is verified");
		}

		else {

			Assert.assertTrue(false);
		}

	}
}