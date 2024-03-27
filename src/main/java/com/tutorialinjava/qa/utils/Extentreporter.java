package com.tutorialinjava.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreporter {
  public  static ExtentReports generateextentreport() {
	  
	  
	  ExtentReports extentreports = new ExtentReports();
	  
	  File extentreportfile= new File(System.getProperty("user.dir")+"\\test-output\\Extentreports\\extentreport.html");
	  
	  ExtentSparkReporter sparkreport= new ExtentSparkReporter(extentreportfile);
	  
	  sparkreport.config().setTheme(Theme.DARK);
	  sparkreport.config().setReportName("tutorialsninja test automation result");
	  sparkreport.config().setDocumentTitle("TN Automation Report");
	  sparkreport.config().setTimeStampFormat("dd//MM//YYYY hh:mm:ss");
	  extentreports.attachReporter(sparkreport);
	  
	  
	  Properties configprop = new Properties();
	 File  ficonfigprop = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
	 try {
	 FileInputStream fisconfigprop =new FileInputStream(ficonfigprop);
	 
	 configprop.load(fisconfigprop);
	 }catch(Throwable e) {
		 e.printStackTrace();
	 }
	 
	 
	  extentreports.setSystemInfo("application url", configprop.getProperty("url"));
	  extentreports.setSystemInfo("browser url", configprop.getProperty("browser"));
	  extentreports.setSystemInfo("email", configprop.getProperty("validemail"));
	  extentreports.setSystemInfo("password", configprop.getProperty("validpassword"));
	  extentreports.setSystemInfo("operating system",System.getProperty("os.name"));
	  extentreports.setSystemInfo("java version",System.getProperty("java.version"));
	  extentreports.setSystemInfo("username",System.getProperty("user.name"));
	return extentreports;
	 
  }
}
