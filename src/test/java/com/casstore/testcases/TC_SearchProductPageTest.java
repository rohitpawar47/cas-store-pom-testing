package com.casstore.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.casstore.pageobject.IndexPageSignIn;
import com.casstore.pageobject.IndexPageSignOut;
import com.casstore.pageobject.MyAccountPage;
import com.casstore.pageobject.ProductList;
import com.casstore.pageobject.SearchInput;



public class TC_SearchProductPageTest extends BaseClass{

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
		acc.enterRegisteredEmail("fazzy@email.com");

		logger.info("Entered registered password");
		acc.enterRegisteredPassword("fazzy@123");

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
		if(ls.findItem().contains(productTxt)) {
			logger.info("Searched Item: Found");
			Assert.assertTrue(true);
		}else {
			logger.info("Searched Item: Not Found");
			Assert.assertTrue(false);
		}
		logger.info("*************** TestCase Verify Search Product Ends *****************");
	}
	
	@Test(priority = 4)
	public void verifyUserLogout() {
		logger.info("*************** TestCase Verify SignOut Starts *****************");
		IndexPageSignOut out = new IndexPageSignOut(driver);
		out.clickOnSignOutButton();
		logger.info("*************** TestCase Verify SignOut Ends *****************");
	}
}
