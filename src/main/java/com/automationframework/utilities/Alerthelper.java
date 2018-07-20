package com.automationframework.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Alerthelper {
private WebDriver driver;
public Alerthelper(WebDriver driver){
	this.driver=driver;
}
public Alert getalert(){
	return driver.switchTo().alert();
	}
public void acceptalert(){
	getalert().accept();
}
public void dismissalert(){
	getalert().dismiss();
}
public String gettext(){
	return getalert().getText();
	}
public boolean isAlertpresent(){
	boolean flag= false;
	try{
		getalert();
		return true;
	}catch(NoAlertPresentException e){
		return flag;
	}
	}
public void acceptAlertifPresent(){
	if(isAlertpresent()){
		acceptalert();
	}
	else{
		return;
	}
}
public void dismissAlert(){
	if(isAlertpresent()){
		dismissalert();
	}
	else{
		return;
	}
}

}
