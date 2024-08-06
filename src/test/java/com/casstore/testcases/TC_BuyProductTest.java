package com.casstore.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.casstore.pageobject.AddAddress;
import com.casstore.pageobject.CheckoutFlow;
import com.casstore.pageobject.IndexPageSignIn;
import com.casstore.pageobject.IndexPageSignOut;
import com.casstore.pageobject.MyAccountPage;
import com.casstore.pageobject.ProductDetails;
import com.casstore.pageobject.ProductList;
import com.casstore.pageobject.SearchInput;

public class TC_BuyProductTest extends BaseClass {

	@Test(priority = 1)
	public void verifyIndexPageSignInButton() {
		logger.info("*************** TestCase Verify Index page SignIn Button Starts *****************");

		IndexPageSignIn signIn = new IndexPageSignIn(driver);

		logger.info("Clicked on signin button");
		signIn.clickOnSignInButton();

		logger.info("*************** TestCase Verify Index page SignIn Button Ends *****************");
	}

	@Test(priority = 2)
	public void verifyUserLogin() {
		logger.info("*************** TestCase Verify SignIn Starts *****************");

		MyAccountPage acc = new MyAccountPage(driver);

		logger.info("Entered registered email address");
		acc.enterRegisteredEmail("mazzy@email.com");

		logger.info("Entered registered password");
		acc.enterRegisteredPassword("mazzy@123");

		logger.info("Clicked on signin button");
		acc.clickOnSignInButton();

		logger.info("*************** TestCase Verify SignIn Ends *****************");
	}

	@Test(priority = 3)
	public void verifySearchProduct() {
		logger.info("*************** TestCase Verify Search Product Starts *****************");

		SearchInput srch = new SearchInput(driver);
		String productTxt = "dress";

		logger.info("Entered Search Item");
		srch.enterSearchText(productTxt);

		logger.info("Clicked Search Product Button");
		srch.clickOnSearchButton();

		ProductList ls = new ProductList(driver);
		if (ls.findItem().contains(productTxt)) {
			logger.info("Searched Item: Found");
			Assert.assertTrue(true);
		} else {
			logger.info("Searched Item: Not Found");
			Assert.assertTrue(false);
		}
		logger.info("*************** TestCase Verify Search Product Ends *****************");
	}

	@Test(priority = 4)
	public void verifyBuyProduct() {
		logger.info("*************** TestCase Verify Buy Product Starts *****************");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		ProductList ls = new ProductList(driver);
		logger.info("Clicked on item");
		ls.clickOnItem();

		ProductDetails det = new ProductDetails(driver);

		logger.info("Selected large size");
		det.selectLargeSize();

		logger.info("Quantity increased");
		det.inputQuantity("2");

		logger.info("Clicked on Add to cart");
		det.clickOnAddToCart();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
		logger.info("Clicked on Proceed to checkout");
		det.clickOnProceedToCheckout();

		CheckoutFlow flow = new CheckoutFlow(driver);
		flow.clickOnMyAddress();
		logger.info("Clicked on My addresses");

		String text = "";
		for (WebElement i : flow.checkForAddress()) {
			text = i.getText();
		}

		String noAdd = "No addresses are available. Add a new address";
		try {
			if (text.equals(noAdd)) {
				flow.clickNewAddress();
				logger.info("Clicked on add new address");

				AddAddress add = new AddAddress(driver);
				logger.info("Default: Fisrt name & Last name");

				logger.info("Entered company");
				add.enterCompany("IT");

				logger.info("Entered address1");
				add.enterAddress1("1234, St. Street");

				logger.info("Entered address2");
				add.enterAddress2("Near Atm");

				logger.info("Entered city");
				add.enterCity("San Jose");

				logger.info("Selected state");
				add.selectState("California");

				logger.info("Entered postal code");
				add.enterPostCode("90210");

				logger.info("Selected country");
				add.selectCountry();

				logger.info("Entered phone number");
				add.enterPhone("90097987986");

				logger.info("Entered mobile number");
				add.enterMobile("09807870700");

				logger.info("Entered additional information");
				add.enterAdditionalInfo("Leave package at doorstep");

				logger.info("Clicked on save button");
				add.clickOnSaveBtn();

				logger.info("Clicked on cart button");
				add.clickOnCartBtn();
			} else {
				AddAddress add = new AddAddress(driver);
				logger.info("Clicked on cart button: address is already available");
				add.clickOnCartBtn();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		{

		}

		logger.info("Clicked on Proceed to checkout summary");
		flow.clickOnProceedFlowBtn();

		logger.info("Clicked on Proceed to checkout address");
		flow.clickOnProcessAddress();

		logger.info("Clicked on Agree terms checkbox");
		flow.clickOnAgreeCheckbox();

		logger.info("Clicked on Proceed to checkout shipping");
		flow.clickOnProceedShipping();

		logger.info("Clicked on Pay by Check");
		flow.clickOnPayByCheck();

		logger.info("Clicked on Confirm my order");
		flow.clickOnConfirmOrderBtn();

		logger.info("Checked order success message");
		String expectedMsg = "Your order on My Shop is complete.";
		if (flow.checkOrderSuccessMessage().equals(expectedMsg)) {
			logger.info("Order is complete");
			Assert.assertTrue(true);
		} else {
			logger.info("Order is not complete");
			Assert.assertTrue(false);
		}
		logger.info("*************** TestCase Verify Buy Product Ends *****************");
	}

	@Test(priority = 4, enabled = false)
	public void verifyUserLogout() {
		logger.info("*************** TestCase Verify SignOut Starts *****************");
		IndexPageSignOut out = new IndexPageSignOut(driver);
		out.clickOnSignOutButton();
		logger.info("*************** TestCase Verify SignOut Ends *****************");
	}
}
