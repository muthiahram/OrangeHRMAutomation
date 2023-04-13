package com.orangehrm.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.BaseClass;
import com.orangehrm.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test

	public void loginTest() {

		LoginPage lp = new LoginPage(driver);

		lp.inputUname(username);
		lp.inputPwd(pwd);
		lp.clickLgnButton();

		if (driver.getTitle().equals("OrangeHRM")) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}

	}
}