package com.casstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFlow {
	static WebDriver localDriver;

//	Constructor
	public CheckoutFlow(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	WebElement proceedFlowbtn;
	public void clickOnProceedFlowBtn() {
		proceedFlowbtn.click();
	}
	
	@FindBy(name="processAddress")
	WebElement processAdd;
	public void clickOnProcessAddress() {
		processAdd.click();
	}
	
	@FindBy(id="cgv")
	WebElement agree;
	public void clickOnAgreeCheckbox() {
		agree.click();
	}
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proShipBtn;
	public void clickOnProceedShipping() {
		proShipBtn.click();
	}
	
	@FindBy(xpath = "//a[contains(@class, 'cheque')]")
	WebElement paymentMode;
	public void clickOnPayByCheck() {
		paymentMode.click();
	}
	
	@FindBy(xpath="//p[@id='cart_navigation']/button")
	WebElement confirmBtn;
	public void clickOnConfirmOrderBtn() {
		confirmBtn.click();
	}
	
	@FindBy(xpath = "//p[text()='Your order on My Shop is complete.']")
	WebElement orderSuccess;
	public String checkOrderSuccessMessage() {
		return orderSuccess.getText();
	}

}
