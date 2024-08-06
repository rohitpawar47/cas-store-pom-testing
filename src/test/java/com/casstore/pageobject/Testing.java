package com.casstore.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("mazzy@email.com");
		driver.findElement(By.id("passwd")).sendKeys("mazzy@123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.linkText("My addresses")).click();
//		String noAdd = "No addresses are available. Add a new address";
//		String yessAdd = "//strong[text()='Your addresses are listed below.']";
		
		try {
			List<WebElement> addElm = driver.findElements(By.xpath("//div[@id='center_column']/p[starts-with(@class,'alert')]"));
			System.out.println(addElm.size());
			System.out.println(addElm.isEmpty());
			if(addElm.size()>0) {
				driver.findElement(By.xpath("//a[@title='Add an address']")).click();
			}else {
				System.out.println("enter full user detail**************");
				}
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

//		driver.quit();
	}
}
