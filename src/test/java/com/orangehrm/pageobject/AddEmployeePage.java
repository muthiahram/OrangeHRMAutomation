package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {
	
	 WebDriver driver;
	
	public AddEmployeePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement pimbtn;
	
	@FindBy(xpath="//a[normalize-space()='Add Employee']")
	WebElement addemployeebtn;
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(name="middleName")
	WebElement middlename;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	WebElement empid;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebtn;
	
	
	
	
	public void clickpimbtn() {
		pimbtn.click();
		
	}
	
	public void addEmployee() {
		addemployeebtn.click();
	}
	
	public void setFirstName() {
		firstname.sendKeys("Gomathi");
	}
	
	public void setLastName() {
		lastname.sendKeys("M");
	}
	
	public void setMiddleName() {
		lastname.sendKeys("Ramu");
	}
	
	
	public void setEmployeeId() {
		empid.clear();
		empid.sendKeys("1234");
	}
	
	public void clkSave() {
		savebtn.click();
		
	}
	
	
	
	
	
}



