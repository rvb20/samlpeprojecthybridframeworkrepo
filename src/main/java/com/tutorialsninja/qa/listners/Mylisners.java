package com.tutorialsninja.qa.listners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialinjava.qa.utils.Extentreporter;

public class Mylisners implements ITestListener {

	ExtentReports	extentreports;
	ExtentTest extentest;
	@Override
	public void onStart(ITestContext context) {
		
		
		extentreports	 = Extentreporter.generateextentreport();
		
		}

	
	  
	
	@Override
	public void onTestStart(ITestResult result) {
		 String testname=result.getName();

		   ExtentTest extentest=   extentreports.createTest(testname);
		   extentest.log(Status.INFO,testname+"stratedsuccesfully" );
			

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 String testname=result.getName();
		   ExtentTest extentest=   extentreports.createTest(testname);

		   extentest.log(Status.PASS,testname+" got stratedsuccesfully executed" );


	}

	@Override
	public void onTestFailure(ITestResult result) {
		 String testname=result.getName();
		   ExtentTest extentest=   extentreports.createTest(testname);

	WebDriver driver=null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destscreenpath= System.getProperty("user.dir")+"\\src\\screenshots\\"+testname+".png";
		 try {
			FileHandler.copy(srcfile, new File(destscreenpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}   
		 
		 
		 extentest.addScreenCaptureFromPath(destscreenpath);
		   extentest.log(Status.INFO,result.getThrowable() );
		   extentest.log(Status.FAIL, testname+" got failed");

		 
		//	System.out.println(testname+" got failed");
		//	System.out.println(result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 String testname=result.getName();
		   ExtentTest extentest=   extentreports.createTest(testname);

		   extentest.log(Status.INFO,result.getThrowable() );
		   extentest.log(Status.SKIP,testname+" got skipped" );


		
	}

	
	@Override
	public void onFinish(ITestContext context) {
extentreports.flush();
	}
	
	
	

}
