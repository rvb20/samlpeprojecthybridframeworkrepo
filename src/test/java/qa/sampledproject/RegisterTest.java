package qa.sampledproject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.registerpage;

import qatutorial.baseclass.Base;

public class RegisterTest extends Base {
	public  RegisterTest() {
		super();
	}
	
	 public WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		 driver  = initializebrowserandoptionurl(prop.getProperty("browser"));
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
		homepage homepage= new homepage(driver);
		homepage.clickonmyaccount();
		homepage.selectregistoreoption();
		
		
		
	      
	       }
	@AfterMethod
	public void teardown() {
		driver.close();
		}
	   
	@Test(priority=1)
	public void verifyregisteringanaccountwithmandatoryfields() {
		
		registerpage registerpage= new registerpage(driver);
		
		 registerpage.enterfieldname(dataprop.getProperty("firstname"));
		 registerpage.enterlastname(dataprop.getProperty("lastname"));
		 registerpage.enteremail(com.tutorialinjava.qa.utils.Utilities.generateemailwithtimestamp());

		 registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
		 registerpage.enterpassword(prop.getProperty("validpassword"));
		 registerpage.enterconfpassword(prop.getProperty("validpassword"));
		 registerpage.enteragrrefield();
		 registerpage.entercontinue();
		 
		 
		 
	
		}
	@Test(priority=2)
	public void verifyregisterwithprovidingallfiles() {
		
		registerpage registerpage= new registerpage(driver);
		
		 registerpage.enterfieldname(dataprop.getProperty("firstname"));
		 registerpage.enterlastname(dataprop.getProperty("lastname"));
		 registerpage.enteremail(com.tutorialinjava.qa.utils.Utilities.generateemailwithtimestamp());

		 registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
		 registerpage.enterpassword(prop.getProperty("validpassword"));
		 registerpage.enterconfpassword(prop.getProperty("validpassword"));
		 registerpage.enteryesfield();
		 registerpage.enteragrrefield();
		 registerpage.entercontinue();
		 
		 
		 
	
	
		
		
		
		 
	
		
		  
		
		
		
		
		
	}
	@Test(priority=3)
	public void verifyaccountalereadyregister() {
		registerpage registerpage= new registerpage(driver);

		 registerpage.enterfieldname(dataprop.getProperty("firstname"));
		 registerpage.enterlastname(dataprop.getProperty("lastname"));
		 registerpage.enteremail(prop.getProperty("validemail"));

		 registerpage.entertelephone(dataprop.getProperty("telephonenumber"));
		 registerpage.enterpassword(prop.getProperty("validpassword"));
		 registerpage.enterconfpassword(prop.getProperty("validpassword"));
		 registerpage.enteryesfield();
		 registerpage.enteragrrefield();
		 registerpage.entercontinue();
		
		String actualwarning = registerpage.enteractualtext();          
		Assert.assertTrue( actualwarning.contains(dataprop.getProperty("duplicateemailwarning")),"Expected warning message is not displayed");
	    

		}
	@Test(priority=4)
	public void verifyaccountwithoutcredential() {
		
		registerpage registerpage= new registerpage(driver);

		 registerpage.enterfieldname(dataprop.getProperty("firstname"));
		 registerpage.enterlastname(dataprop.getProperty("lastname"));
		 registerpage.enteremail(prop.getProperty("validemail"));

		 registerpage.entertelephone("");
		 registerpage.enterpassword("");
		 registerpage.enterconfpassword("");
		 registerpage.enteryesfield();
		 registerpage.enteragrrefield();
		 registerpage.entercontinue();
		
				
		//String actualprivacypolicywarning = registerpage.entetprivacypolicy();
		//Assert.assertTrue( actualprivacypolicywarning.contains(dataprop.getProperty("privacypolicywarning")),"Expected warning message is not displayed");
	     


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	 

}
