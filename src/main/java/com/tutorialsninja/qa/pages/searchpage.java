package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchpage {
	
	
	@FindBy(xpath="//a[normalize-space()='HP LP3065']")
	private WebElement validhpproduct;
	
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noproductmessage;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 WebDriver driver;

	public  searchpage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	public boolean entervalidproduct() {
	  
		 boolean displaystatus= validhpproduct.isDisplayed();
		return displaystatus;
		
	}
	public String noproductmessagetext() {
	String nomessage=	 noproductmessage.getText();
	return nomessage;
	}
	
	}


