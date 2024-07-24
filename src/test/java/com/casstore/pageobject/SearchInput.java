package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchInput {

	static WebDriver localDriver;

//	Constructor
	public SearchInput(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(id = "search_query_top")
	WebElement searchText;

	public void enterSearchText(String sText) {
		searchText.sendKeys(sText);
	}

	@FindBy(name = "submit_search")
	WebElement srchBtn;

	public void clickOnSearchButton() {
		srchBtn.click();
	}
	

}
