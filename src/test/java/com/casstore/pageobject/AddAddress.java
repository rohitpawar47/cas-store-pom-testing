package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddress {
	static WebDriver localDriver;

//	Constructor
	public AddAddress(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(id = "company")
	WebElement comField;

	public void enterCompany(String comp) {
		comField.sendKeys(comp);
	}

	@FindBy(id = "address1")
	WebElement addField1;

	public void enterAddress1(String add1) {
		addField1.sendKeys(add1);
	}

	@FindBy(id = "address2")
	WebElement addField2;

	public void enterAddress2(String add2) {
		addField2.sendKeys(add2);
	}

	@FindBy(id = "city")
	WebElement city;

	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}

	@FindBy(id = "id_state")
	WebElement stateList;

	public void selectState(String stateText) {
		Select state = new Select(stateList);
		state.selectByVisibleText(stateText);
	}

	@FindBy(id = "postcode")
	WebElement postal;

	public void enterPostCode(String post) {
		postal.sendKeys(post);
	}

	@FindBy(id = "id_country")
	WebElement country;

	public void selectCountry() {
		Select state = new Select(country);
		state.selectByVisibleText("United States");
	}

	@FindBy(id = "phone")
	WebElement phone;

	public void enterPhone(String ph) {
		phone.sendKeys(ph);
	}

	@FindBy(id = "phone_mobile")
	WebElement phoneMoble;

	public void enterMobile(String mob) {
		phoneMoble.sendKeys(mob);
	}

	@FindBy(id = "other")
	WebElement textArea;

	public void enterAdditionalInfo(String oth) {
		textArea.sendKeys(oth);
	}

	@FindBy(id = "submitAddress")
	WebElement save;

	public void clickOnSaveBtn() {
		save.click();
	}

}
