package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPageSignOut {
	static WebDriver localDriver;

//	Constructor
	public IndexPageSignOut(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(className = "logout")
	WebElement signOutBtn;
	
	@FindBy(xpath = "//a[@title='View my customer account']") 
	WebElement userName;
	
	
	public void clickOnSignOutButton() {
		signOutBtn.click();
	}
	
	public String getUserName() {
		String txt = userName.getText();
		return txt;
	}
}
