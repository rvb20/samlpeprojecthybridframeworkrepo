package com.tutorialinjava.qa.utils;







public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	public  static  String generateemailwithtimestamp() {
		
		java.util.Date date= new java.util.Date();
	 
	  String timestamp = date.toString().replace(" ", "-") .replace(" ", "-");
	  return "bhujbalrucha20"+timestamp+"@gmail.com";
	 
  }
		}
	
	
	
	
	
	
	
		 
		
	
	
	


