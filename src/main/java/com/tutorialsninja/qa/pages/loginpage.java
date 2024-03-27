package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	@FindBy(id="input-email")
	 private WebElement emailaddres;
		
	@FindBy(id="input-password")
	 private WebElement passwordfield ;
		
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginfield ;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	 private WebElement emailpassworgnotmatching;
	
	
		
 public loginpage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
 }
 public void enteremailaddress(String producttext) {
	 emailaddres.sendKeys(producttext);
 }
 public void passswordaddress(String producttext){
	 passwordfield .sendKeys(producttext);;
 }
 public void loginaddress() {
	 loginfield.click();
 }
 
 public String retriveemailpasswordnotmatching() {
	String warningtext= emailpassworgnotmatching.getText();
	return warningtext;
 }
}
