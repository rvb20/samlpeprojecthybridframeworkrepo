package qa.sampledproject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.searchpage;

import qatutorial.baseclass.Base;

public class SearchTest extends Base {
	
	public SearchTest () {
		super();
	}
	 public WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		driver= initializebrowserandoptionurl( prop.getProperty("browser"));
		driver.get("http://tutorialsninja.com/demo/");

		driver.manage().window().maximize();
		
		homepage homepage= new homepage(driver);
		//homepage.clickonmyaccount();
	//	homepage.selectregistoreoption();
		
	      
	       }
	
	@AfterMethod
	public void teardown() {
		driver.close();
		
		}
	
	
	@Test(priority=1)
	
	public void verifywithvalidproduct() {
		homepage homepage= new homepage(driver);
		homepage.enterproductnameintosearchfield(dataprop.getProperty("validproduct"));
		homepage.clickonsearchbutton();
 		
		
		searchpage searchpage = new searchpage(driver);
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataprop.getProperty("validproduct"));
		//  driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
			 driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']"));
			 
			Assert.assertTrue( searchpage.entervalidproduct());

		     
		
		
		
		
	}
	@Test(priority=2)
	public void verifywithinvalidproduct() {
		homepage homepage= new homepage(driver);
		homepage.enterproductnameintosearchfield(dataprop.getProperty("invalidproduct"));
		homepage.clickonsearchbutton();
		searchpage searchpage = new searchpage(driver);

		
		
		
	//	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataprop.getProperty("invalidproduct"));
	//	  driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		  
		  String actualmessage= searchpage.noproductmessagetext();
		  Assert.assertEquals(actualmessage, dataprop.getProperty("noproducttextinsearchresult"));
		     
		  
	
		
	}
	@Test(priority=3)
	public void verifywithotanyproduct() {
		homepage homepage= new homepage(driver);
		homepage.clickonsearchbutton();

		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("honda");
		//  driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		searchpage searchpage = new searchpage(driver);

		
		 //String actualmessage=searchpage.noproductmessagetext();
		 // Assert.assertEquals(actualmessage, dataprop.getProperty("noproducttextinsearchresult"));
		     
		  
		  
		  String actualmessage=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		  Assert.assertEquals(actualmessage, dataprop.getProperty("noproducttextinsearchresult"));
		     
		
	}

}

