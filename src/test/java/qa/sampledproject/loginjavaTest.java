package qa.sampledproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialinjava.qa.utils.Utilities;
import com.tutorialsninja.qa.pages.accountpage;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.loginpage;

import qatutorial.baseclass.Base;

public class loginjavaTest extends Base {
	
	public loginjavaTest() {
	 	super();
	}
	
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		
		driver= initializebrowserandoptionurl(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homepage homepage= new homepage(driver);
		homepage.clickonmyaccount();
		homepage.selectlohinoption();
	    

		 
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
	
	@Test(priority=1)
	public void verifyloginwithvalidcredential() {
	

		loginpage  loginpage = new loginpage(driver);
		 loginpage.enteremailaddress(prop.getProperty("validemail"));

		// loginpage.enteremailaddress(com.tutorialinjava.qa.utils.Utilities.generateemailwithtimestamp());
		 loginpage.passswordaddress(prop.getProperty("validpassword"));
		 loginpage.loginaddress();
		 accountpage accountpage = new accountpage(driver);
	 Assert.assertTrue(accountpage.getdisplaystatusofaccount());
         
         
       
		
		
		
	}
	
	
	

	@Test(priority=2)
	
	public void verifyloginwithinvalidcredential() {
		loginpage  loginpage = new loginpage(driver);
		 loginpage.enteremailaddress(Utilities.generateemailwithtimestamp());
		 loginpage.passswordaddress(dataprop.getProperty("invalidpassword"));
		 loginpage.loginaddress();

	  
    String actualwarningmessage=   loginpage.retriveemailpasswordnotmatching();
      String expectedwarningmessage="Warning: No match for E-Mail Address and/or Password." ;  
 Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
	     
	     
		
		
	}
	@Test(priority=3)
	public void verifyloginwithinvalidemailidandpassword () {
		
		loginpage  loginpage = new loginpage(driver);
		 loginpage.enteremailaddress(Utilities.generateemailwithtimestamp());
		 loginpage.passswordaddress(dataprop.getProperty("invalidpassword"));
		 loginpage.loginaddress();

		 String actualwarningmessage=   loginpage.retriveemailpasswordnotmatching();
	   
   String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchingmessage") ;  
Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
	     
	    
	
		
	}
	@Test(priority=4)
	
	public void verifyloginwithvalidemailandinvalidpassword () {
		
		loginpage  loginpage = new loginpage(driver);
		 loginpage.enteremailaddress(prop.getProperty("validemail"));
		 loginpage.passswordaddress(dataprop.getProperty("invalidpassword"));
		 loginpage.loginaddress();
			
		 String actualwarningmessage=   loginpage.retriveemailpasswordnotmatching();

	   String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchingmessage") ;  
 
	Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
		     
		     
		
		
		
	}
	@Test(priority=5)
	public void verifyloginwithoutprovidingcredential() {
		
		loginpage  loginpage = new loginpage(driver);
		 loginpage.enteremailaddress("");
		 loginpage.passswordaddress("");
		 loginpage.loginaddress();
		
		 String actualwarningmessage=   loginpage.retriveemailpasswordnotmatching();

 String expectedwarningmessage=dataprop.getProperty("emailpasswordnomatchingmessage") ;  

Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage),"Expected warning message is not displayed");
	     
	     
		
		

		
		
	}
	
	 
	
                                                                                                                	
	
	
	
	
	
}
