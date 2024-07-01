package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	static WebDriver localDriver;

//	Constructor
	public SignInPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
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

//	Click sign in button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	public void clickOnSubmitButton() {
		submitButton.click();
	}

//	Click sign in with google
//	@FindBy(xpath = "//button[text()='Sign in with Google']")
//	WebElement signInGoogle;
//
//	public void clickOnSignInwithGoogle() {
//		signInGoogle.click();
//	}

//	@FindBy(className = "aZvCDf")
//	WebElement popUpbutton;
//
//	public void clickOnPopUpGoogle() {
//		popUpbutton.click();
//	}

//	Click on registration link
//	@FindBy(linkText = "Sign Up")
//	WebElement registration;
//	
//	public void clickOnRegistrationLink() {
//		registration.click();
//	}
}
