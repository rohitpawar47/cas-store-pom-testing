package com.casstore.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import com.casstore.pageobject.HomePageSignIn;
import com.casstore.pageobject.SignInPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cas-fashion-store.netlify.app");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
//		Home page sign in 
		HomePageSignIn dex = new HomePageSignIn(driver);
		dex.clickOnProfileButton();
		dex.clickOnSignInButton();
		
//		Sign in page
		SignInPage sig = new SignInPage(driver);
		sig.enterEmailAddress("sun@email.com");
		sig.enterPassword("12341234");
		sig.clickOnSubmitButton();
//		sig.clickOnSignInwithGoogle();
//		sig.clickOnPopUpGoogle();
	}
}
