package com.qa.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pom.AmazonHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest {
	
	AmazonHomePage home;
	WebDriver driver;
	
	//public static void main(String [] args) throws InterruptedException {
	@Parameters("Browser")
	@Test(priority=1)
	public void homeTest(String BrowserName) throws InterruptedException {
		
		System.out.println("BrowerName from paramater is ****** :"+"BrowserName");
		
		if(BrowserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if(BrowserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		Thread.sleep(2000);
		System.out.println("######"+driver.getTitle()+"#########");
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
		
	}
	@Test(priority=2)
	public void searchitem() throws InterruptedException{
		System.out.println("*********"+driver.getCurrentUrl()+"**********");
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/");
		
		home =new AmazonHomePage(driver);
		home.searchitem("watch");
		Thread.sleep(2000);
		driver.quit();
	}
	
}
	
