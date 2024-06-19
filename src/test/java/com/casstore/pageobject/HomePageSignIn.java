package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageSignIn {
	static WebDriver localDriver;
	
//	Constructor
	public HomePageSignIn(WebDriver remoteDriver){
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
//	Click on home page profile button
	@FindBy(xpath = "//p[text()='Profile']") WebElement profileButton;
	public void clickOnProfileButton() {
		profileButton.click();
	}
	
//	Click on home page sign in button
	@FindBy(linkText = "Sign in") WebElement signInButton; 
	public void clickOnSignInButton() {
		signInButton.click();
	}
}
