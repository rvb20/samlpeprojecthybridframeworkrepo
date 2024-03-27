package qatutorial.baseclass;




import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialinjava.qa.utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	 public  Base(){
		 
		  prop = new Properties();
		 File propfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
	dataprop = new Properties();
	
	
	File datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
	try {
		
	
	
	FileInputStream fis2 = new FileInputStream(datapropfile);

	
	dataprop.load(fis2);
	
	}catch (Exception e) {
		e.printStackTrace();
	}
		 
		 
		 
		 
		 
		try {	 
		 
		 FileInputStream fis = new FileInputStream(propfile);
		 
		 prop.load(fis);
		 }catch(Throwable e) {
			 e.printStackTrace();
		 }}
			
			 
	 
	 
	 
	
	
	
	public WebDriver   initializebrowserandoptionurl(String browsername) {
		
	
		
		if(browsername.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			 
			driver= new FirefoxDriver();
			
		}
		return driver;
		
		
		}

		@BeforeMethod
		public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\sampledproject\\driver\\chromedriver.exe");
	      
	       ChromeOptions co= new ChromeOptions();
	       co.addArguments("--remote-allow-origins=*");
	       
		
		
	       driver=new ChromeDriver(co);
	       driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));

		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));

	       driver.get(prop.getProperty("url"));
	       
			  driver.findElement(By.xpath("//a[@title='My Account']")).click();
			
	       
	       return;
	       }
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		}
	   
	@Test(priority=1)
	public void verifyregisteringanaccountwithmandatoryfields() {
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		  driver.findElement(By.xpath("//a[@title='My Account']")).click();
		
		
	}

}
