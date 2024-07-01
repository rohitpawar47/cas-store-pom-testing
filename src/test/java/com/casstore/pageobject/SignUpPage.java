package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	static WebDriver localDriver;

//	Constructor
	public SignUpPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
//	Click on home page profile button
	@FindBy(xpath = "//p[text()='Profile']")
	WebElement profileButton;

	public void clickOnProfileButton() {
		profileButton.click();
	}

//	Click on home page sign up button
	@FindBy(linkText = "Not a mumber yet? Join here!")
	WebElement signUpButton;

	public void clickOnJoinHere() {
		signUpButton.click();
	}
	
//	Enter user name
	@FindBy(name="displayName")
	WebElement userName;
	
	public void enterUsername(String user) {
		userName.sendKeys(user);
	}
	
//	Enter email address
	@FindBy(name = "email")
	WebElement emailAddress;

	public void enterEmailAddress(String eAdd) {
		emailAddress.sendKeys(eAdd);
	}

//	Enter password
	@FindBy(name = "password")
	WebElement pass;

	public void enterPassword(String pwd) {
		pass.sendKeys(pwd);
	}
	
//	Enter confirm password
	@FindBy(name = "confirmPassword")
	WebElement conPass;

	public void enterConfirmPassword(String cPass) {
		conPass.sendKeys(cPass);
	}
	
//	Click on join cas button
	@FindBy(xpath = "//button[text()='JOIN CAS']")
	WebElement joinCass;
	
	public void clickOnJoinCasButton() {
		joinCass.click();
	}
}










