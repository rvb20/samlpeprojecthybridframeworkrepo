package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	@FindBy(xpath="//a[@title='My Account']")
	 private WebElement myaccountdropmenu;
	@FindBy(xpath=" //a[normalize-space()='Login']")
	private WebElement loginoption;
	 WebDriver driver;
	 @FindBy(xpath="//a[normalize-space()='Register']")
			 private WebElement registoroption;
	 @FindBy(xpath="//input[@placeholder='Search']")
	 private WebElement searchboxfield;
	 
	 @FindBy(xpath="//i[@class='fa fa-search']")
	 private WebElement searchbutton;
	 
	 
	 
	public homepage(WebDriver driver) {
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	public void clickonmyaccount() {
		myaccountdropmenu.click();
	}
	
	public void selectlohinoption() {
		loginoption.click();
	}
	public void selectregistoreoption(){
		registoroption.click();
	}
	public String  enterproductnameintosearchfield(String producttext) {
		searchboxfield.sendKeys(producttext);
		return null;

		
	}
	public void clickonsearchbutton() {
		searchbutton.click();
	}
	
	
}
