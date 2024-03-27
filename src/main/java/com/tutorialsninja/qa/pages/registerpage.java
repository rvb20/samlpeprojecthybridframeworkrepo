package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpage {
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	 private WebElement firstnamefield;
	 
	 
	 
	 @FindBy(xpath="//input[@id='input-lastname']")
	 private WebElement lastnamefield;
	 
	 @FindBy(xpath="//input[@id='input-email']")
	 private WebElement emailfield;
	 
	 
	 @FindBy(xpath="//input[@id='input-telephone']")
	 private WebElement telephonefield;
	 
	 @FindBy(xpath="//input[@id='input-password']")
	 private WebElement passwordfield;
	 
	 @FindBy(xpath="//input[@id='input-confirm']")
	 private WebElement confirmpasswordfield;
	 
	 @FindBy(xpath="//input[@name='agree']")
	 private WebElement aggreefield;
      
	 @FindBy(xpath="//input[@value='Continue']")
	 private WebElement continuefield;
	 
	 
	 @FindBy(xpath="//label[normalize-space()='Yes']")
	 private WebElement yesfield;
	 
	 @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	 private WebElement actualmessage;
	 
	 @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	 private WebElement privacypolicy;
	 
	 
	 
	 
	 
	private WebDriver driver;
	 
	 
	 public registerpage(WebDriver driver) {
			this.driver= driver;
			
			PageFactory.initElements(driver, this);
		}
	 
	 public void enterfieldname(String firstname) {
		 firstnamefield.sendKeys(firstname);
	 
	 }
public void enterlastname(String lastname)	{
	lastnamefield.sendKeys(lastname);;;
}

public void enteremail(String validemail) {
	 emailfield.sendKeys(validemail);;
	
}
public void   entertelephone(String telephonenumber) {
	telephonefield.sendKeys(telephonenumber);;
	}
public void enterpassword(String validpassword) {
	passwordfield.sendKeys(validpassword);;
}
public void enterconfpassword(String validpassword) {
	confirmpasswordfield.sendKeys(validpassword);;
}
public void enteragrrefield() {
	aggreefield.click();;
}

public void entercontinue() {
	continuefield.click();
}
public void enteryesfield() {
	yesfield.click();
}
public String enteractualtext() {
	  return actualmessage.getText();
	
}
public String entetprivacypolicy() {
	 return privacypolicy.getText();
}
}
	 
	
