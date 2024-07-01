package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageSignIn {
	static WebDriver localDriver;

//	Constructor
	public IndexPageSignIn(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

//	Click on home page sign in button
	@FindBy(className = "login")
	WebElement signInButton;

	public void clickOnSignInButton() {
		signInButton.click();
	}

}
