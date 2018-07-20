package com.automationframework.utilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void setimplicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
public void waitForElementClickable(WebElement element,int timeOutinsecond, int poolingtime){
	WebDriverWait wait= getWait(timeOutinsecond, poolingtime );
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementVisible(WebElement element,int timeOutinsecond, int poolingtime){
	WebDriverWait wait= getWait(timeOutinsecond, poolingtime);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
public WebElement waitForElement(int timeout, WebElement element){
	WebDriverWait wait= new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.visibilityOf(element));
	}	
}
