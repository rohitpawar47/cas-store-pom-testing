package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList {

	static WebDriver localDriver;

//	Constructor
	public ProductList(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	@FindBy(xpath = "//h5[@itemprop='name']/descendant::a")
	WebElement proItem;
	
	public String findItem() {
		return proItem.getText().toLowerCase();
	}

}
