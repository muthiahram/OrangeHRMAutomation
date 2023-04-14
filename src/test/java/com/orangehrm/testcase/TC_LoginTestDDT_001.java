package com.orangehrm.testcase;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.BaseClass;
import com.orangehrm.pageobject.LoginPage;
import com.orangehrm.utilities.XLUtils;

public class TC_LoginTestDDT_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginDTT(String Uname, String password) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUname(Uname);

		lp.inputPwd(password);
		lp.clickLgnButton();
		Thread.sleep(3000);

		if (driver.getTitle().equals("OrangeHRM")) {
			lp.clickLogOutArrow();
			Thread.sleep(3000);
			lp.clickLogOutBtn();
			Thread.sleep(3000);
			Assert.assertTrue(true);

		}

		else {

			Assert.assertTrue(false);
			logger.info("Invalid credentials");
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\orangehrm\\testdata\\Testdata.xlsx";
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
