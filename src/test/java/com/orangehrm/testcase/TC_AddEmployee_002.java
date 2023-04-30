package com.orangehrm.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.AddEmployeePage;
import com.orangehrm.pageobject.BaseClass;
import com.orangehrm.pageobject.LoginPage;


public class TC_AddEmployee_002 extends BaseClass {

	@Test
	public void addEmployee() throws InterruptedException, IOException {
		AddEmployeePage aep = new AddEmployeePage(driver);
		LoginPage lp = new LoginPage(driver);
        driver.get(appurl);
		lp.inputUname(username);
		lp.inputPwd(pwd);
		lp.clickLgnButton();
		Thread.sleep(3000);
		aep.clickpimbtn();
		aep.addEmployee();
		aep.setFirstName();
		aep.setMiddleName();
		aep.setLastName();

		aep.setEmployeeId();
		logger.info("All the employee details are set");
		Thread.sleep(3000);
		aep.clkSave();
		WebElement e = driver
				.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));

		if (e.getText().equals("PIM")) {

			Assert.assertTrue(true);
			logger.info("Employee details saved successfully and the Employee page breadcrumb is verified");
		}

		else {

			screenshot();
			Assert.assertTrue(false);
			logger.info("Employee details not saved");
		}

	}}

