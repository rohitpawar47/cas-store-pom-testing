package com.casstore.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.casstore.pageobject.AccountCreationPage;
import com.casstore.pageobject.IndexPageSignIn;
import com.casstore.pageobject.IndexPageSignOut;
import com.casstore.pageobject.MyAccountPage;
import com.casstore.utilities.ReadExcelFile;

public class TC_AccountPageTest extends BaseClass {

	@Test(priority = 1)
	public void verifyIndexPageSignInButton() {
		logger.info("*************** TestCase Verify Index page SignIn Button Starts *****************");

		IndexPageSignIn signIn = new IndexPageSignIn(driver);

		logger.info("Clicked on signin button");
		signIn.clickOnSignInButton();

		logger.info("*************** TestCase Verify Index page SignIn Button Ends *****************");
	}
	
	@Test( priority = 2, enabled = false)
	public void verifyEmailToCreateAccount() {
		logger.info("*************** TestCase Verify Email Address to Create an Account Starts *****************");

		MyAccountPage acc = new MyAccountPage(driver);

		logger.info("Entered email address to create an account");
		acc.enterEmailAddress("fazzy@email.com");

		logger.info("Clicked on create an account button");
		acc.clickToCreateAnAccount();

		logger.info("*************** TestCase Verify Email Address to Create an Account Ends *****************");
	}

	@Test(priority = 3, enabled = false)
	public void verifyAccountCreation() {
		logger.info("*************** TestCase Verify Account Creation Page Starts *****************");

		AccountCreationPage newUser = new AccountCreationPage(driver);

		logger.info("Select gender");
		newUser.selectGenderOne();

		logger.info("Entered first name");
		newUser.enterFirstName("Fazzy");

		logger.info("Entered last name");
		newUser.enterLastName("Star");

		logger.info("Entered password");
		newUser.enterUserPassword("fazzy@123");

		logger.info("Select day");
		newUser.selectADay("17");

		logger.info("Select month");
		newUser.selectAMonth("4");

		logger.info("Select year");
		newUser.selectAYear("1989");

		logger.info("Clicked on checkbox of new newsletter");
		newUser.clickOnNewLetter();

		logger.info("Clicked on register button");
		newUser.clickOnRegisterButton();

		logger.info("*************** TestCase Verify Account Creation Page Ends *****************");
	}

	@Test(priority = 2, dataProvider = "SignInDataProvider", enabled = true)
	public void verifyAlreadyRegistered(String userEmail, String userPassword, String expectedUsername)
			throws Exception {
		logger.info("*************** TestCase Verify SignIn Starts *****************");

		MyAccountPage acc = new MyAccountPage(driver);
		IndexPageSignOut out = new IndexPageSignOut(driver);

		logger.info("Entered registered email address");
		acc.enterRegisteredEmail(userEmail);

		logger.info("Entered registered password");
		acc.enterRegisteredPassword(userPassword);

		logger.info("Clicked on signin button");
		acc.clickOnSignInButton();

		if (out.getUserName().equals(expectedUsername)) {
			logger.info("verifyAlreadyRegistered - Passed");
			Assert.assertTrue(true);

			logger.info("Clicked on signout button");
			out.clickOnSignOutButton();
		} else {
			logger.info("verifyAlreadyRegistered - Failed");
			Assert.assertTrue(false);
			captureScreenShot(driver, "verifyAlreadyRegistered");
		}

		logger.info("*************** TestCase Verify SignIn Ends *****************");
	}

	@DataProvider(name = "SignInDataProvider")
	public String[][] getSignInData() {
//		System.out.println(System.getProperty("user.dir"));
//		String fileName = System.getProperty("user.dir") + "//test-data//cas-store-test-data.xlsx";
		String fileName = "/Users/rohitpawar/Documents/automation-workspace/CASStore/test-data/ecom-user-data.xlsx";

		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

		logger.info("Fetching email, password and username data from excel");
		String data[][] = new String[ttlRows - 1][ttlColumns];

		for (int i = 1; i < ttlRows; i++)// rows =1,2
		{
			for (int j = 0; j < ttlColumns; j++)// col=0, 1,2
			{
				data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}

		}
		return data;
	}
}
