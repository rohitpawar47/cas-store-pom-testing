package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductDetails {
	static WebDriver localDriver;
	
	public ProductDetails(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	
	@FindBy(id = "group_1")
	WebElement sizeSelect;	
	public void selectLargeSize() {
		Select objSelect = new Select(sizeSelect);
		objSelect.selectByVisibleText("L");
	}

	@FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]")
	WebElement incQty;	
	public void increaseQuantity() {
		incQty.click();
	}
	
	@FindBy(id="quantity_wanted")
	WebElement inpQty;
	public void inputQuantity(String qty) {
		incQty.sendKeys(qty);
	}
	
	@FindBy(xpath="//p[@id='add_to_cart']/button")
	WebElement addBtn;	
	public void clickOnAddToCart() {
		addBtn.click();
	}
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedBtn;	
	public WebElement sendElementProceed() {
		return proceedBtn;
	}
	public void clickOnProceedToCheckout() {
		proceedBtn.click();
	}
	
	
}
