package com.qa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
  //Locators
	@FindBy(css="#twotabsearchtextbox:first-of-type")
	private WebElement searchbox;
	
	@FindBy(css="#nav-search-submit-button")
	private WebElement searchbutton;
	
	
  //constructor 	
	public AmazonHomePage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	
	//Implementation Methods
	public void searchitem(String item) {
		searchbox.sendKeys(item);
		searchbutton.click();
	}

}
