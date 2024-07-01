package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	static WebDriver localDriver;

//	Constructor
	public MyAccountPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
//	Create an account 
	@FindBy(id = "email_create")
	WebElement emailInput;
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreate;
	
	public void enterEmailAddress(String eAdd) {
		emailInput.sendKeys(eAdd);
	}
	
	public void clickToCreateAnAccount() {
		submitCreate.click();
	}
	
	
//	Already registered
	@FindBy(id="email")
	WebElement emailAdd;
	
	@FindBy(id="passwd")
	WebElement pass;
	
	@FindBy(id="SubmitLogin")
	WebElement loginBtn;
	
	public void enterRegisteredEmail(String eReg) {
		emailAdd.sendKeys(eReg);
	}
	
	public void enterRegisteredPassword(String pwd) {
		pass.sendKeys(pwd);
	}
	
	public void clickOnSignInButton() {
		loginBtn.click();
	}
}
