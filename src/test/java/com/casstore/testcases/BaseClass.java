package com.casstore.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.casstore.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readCon = new ReadConfig();
	String url = readCon.getBaseUrl();
	String browser = readCon.getBrowser();

	static WebDriver driver;
	static Logger logger;

	@BeforeClass
	public void setUp() {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		logging instantiate
		logger = LogManager.getLogger("CasStore");
		
//		Open Url 
		driver.get(url);
		logger.info("Url opened");
		
//		maximize window
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
//		driver.close();
		driver.quit();
	}
	
	//user method to capture screen shot
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//screenshots//" + testName + ".png");
	
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
