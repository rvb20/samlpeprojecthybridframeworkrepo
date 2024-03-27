package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Edit your account information')")
	 private WebElement editaccountinfo;
	
	
		public accountpage(WebDriver driver) {
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
		}
	
public Boolean getdisplaystatusofaccount() {
	 boolean displaystatus=editaccountinfo.isDisplayed();
	return displaystatus;
	 
}
}
