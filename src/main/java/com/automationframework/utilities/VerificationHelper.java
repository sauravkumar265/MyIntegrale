package com.automationframework.utilities;

import org.openqa.selenium.WebElement;

public class VerificationHelper {
public static synchronized boolean  iselementpresent(WebElement element){
	boolean isdisplayed=true;
	try{
		isdisplayed=element.isDisplayed();
		System.out.println(element.getText()+ "is displayed");
	}catch(Exception e){
		System.out.println("No element is displayed currently");
	}
	return isdisplayed;
	}
public static synchronized boolean elementnotpresent(WebElement element){
	boolean isdisplayed=false;
	try{
		element.isDisplayed();
		System.out.println(element.getText()+"element displayed ");
	}catch(Exception ex){
		System.out.println();
	}
	return isdisplayed;
	}

}
