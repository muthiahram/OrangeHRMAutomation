package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.ReadConfig;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver,this);

	}

	@FindBy(name = "username")
	WebElement username;

	
	@FindBy(name = "password")
	WebElement pwd1;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement lgnbtn;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement logoutArrow;

	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement LogoutButton;

	public void inputUname(String uname) {
		username.sendKeys(uname);

	}

	public void inputPwd(String password) {

		pwd1.sendKeys(password);
	}

	public void clickLgnButton() {

		lgnbtn.click();
	}
	
	public void clickLogOutArrow() {
		logoutArrow.click();
	}
	
	public void clickLogOutBtn() {
		LogoutButton.click();
	}
}