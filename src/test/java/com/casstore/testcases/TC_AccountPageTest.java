package com.casstore.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.casstore.pageobject.AccountCreationPage;
import com.casstore.pageobject.IndexPageSignIn;
import com.casstore.pageobject.IndexPageSignOut;
import com.casstore.pageobject.MyAccountPage;
import com.casstore.utilities.ReadExcelFile;

public class TC_AccountPageTest extends BaseClass{
	
	@Test(priority = 1)
	public void verifyIndexPageSignInButton() {
		IndexPageSignIn signIn = new IndexPageSignIn(driver);	
		signIn.clickOnSignInButton();
	}
	
	
	@Test(enabled = false)
	public void verifyEmailToCreateAccount() throws InterruptedException {
		MyAccountPage acc = new MyAccountPage(driver);
		acc.enterEmailAddress("lazzy@email.com");
		acc.clickToCreateAnAccount();
//		Thread.sleep(2000);
	}
	
	@Test(enabled = false)
	public void verifyAccountCreation() throws InterruptedException {
		AccountCreationPage newUser = new AccountCreationPage(driver);
		newUser.selectGenderTwo();
		newUser.enterFirstName("Lazzy");
		newUser.enterLastName("Star");
		newUser.enterUserPassword("lazzy@123");
		newUser.selectADay("17");
		newUser.selectAMonth("4");
		newUser.selectAYear("1989");
		newUser.clickOnNewLetter();
		newUser.clickOnRegisterButton();
//		Thread.sleep(2000);
	}
	
	@Test(priority = 2, dataProvider = "SignInDataProvider")
	public void verifyAlreadyRegistered(String userEmail, String userPassword, String expectedUsername) throws Exception {
		MyAccountPage acc = new MyAccountPage(driver);
		IndexPageSignOut out = new IndexPageSignOut(driver);
		acc.enterRegisteredEmail(userEmail);
		acc.enterRegisteredPassword(userPassword);
		acc.clickOnSignInButton();
		if(out.getUserName().equals(expectedUsername)) {
			logger.info("verifyAlreadyRegistered - Passed");
			Assert.assertTrue(true);
			out.clickOnSignOutButton();
		}else {
			logger.info("verifyAlreadyRegistered - Failed");
			Assert.assertTrue(false);
			captureScreenShot(driver, "verifyAlreadyRegistered");
		}
	}
	
	@DataProvider(name = "SignInDataProvider")
	public String[][] getSignInData(){
//		System.out.println(System.getProperty("user.dir"));
//		String fileName = System.getProperty("user.dir") + "//test-data//cas-store-test-data.xlsx";
		String fileName = "/Users/rohitpawar/Documents/automation-workspace/CASStore/test-data/ecom-user-data.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
	
			}

		}
		return data;
		
	}
}
