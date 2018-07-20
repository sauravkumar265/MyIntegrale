package com.automationframework.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log= LoggerHelper.getLogger(JavaScriptHelper.class);
	public JavaScriptHelper(WebDriver driver){
		this.driver=driver;
	}
	public Object executeScript(String script, Object args){
		JavascriptExecutor je= (JavascriptExecutor) driver;
		log.info(script);
		return je.executeScript(script, args);
	}
	
	public void scrollIntoView(WebElement element){
		executeScript("arguments[0].scrollIntoView(true)", element);
		log.info("Scrolling to element---"+element);
	}

}
