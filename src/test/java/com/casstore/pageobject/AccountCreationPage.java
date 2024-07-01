package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;




public class AccountCreationPage {
	static WebDriver localDriver;

//	Constructor
	public AccountCreationPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(id = "id_gender1")
	WebElement genderOneRadio;
	
	@FindBy(id = "id_gender2")
	WebElement genderTwoRadio;
	
	@FindBy(id = "customer_firstname")
	WebElement userFirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement userLastName;
	
//	@FindBy(id ="email")
//	WebElement checkEmailInput;
//	@FindBy(xpath = "//input[@value='']", id="email")
//	WebElement emailValueNull;
	
	@FindBy(id="passwd")
	WebElement userPassword;
	
	@FindBy(id="days")
	WebElement selectDays;
	
	@FindBy(id="months")
	WebElement selectMonths;
	
	@FindBy(id="years")
	WebElement selectYears;
	
	@FindBy(xpath="//label[text()='Sign up for our newsletter!']")
	WebElement newsLetter;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	
	
	public void selectGenderOne() {
		genderOneRadio.click();
	}
	
	public void selectGenderTwo() {
		genderTwoRadio.click();
	}
	
	public void enterFirstName(String firstname) {
		userFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		userLastName.sendKeys(lastname);
	}
	
//	public void emailInput() {
//		 Assert.assertTrue(emailValueNull.isDisplayed());
//	}
	
	public void enterUserPassword(String pwd) {
		userPassword.sendKeys(pwd);
	}
	
	
	public void selectADay(String d) {
		Select day = new Select(selectDays);
		day.selectByValue(d);
	}
	
	public void selectAMonth(String m) {
		Select month = new Select(selectMonths);
		month.selectByValue(m);
	}
	
	public void selectAYear(String y) {
		Select year = new Select(selectYears);
		year.selectByValue(y);
	}

	public void clickOnNewLetter() {
		newsLetter.click();
	}
	
	public void clickOnRegisterButton() {
		register.click();
	}
	
}











