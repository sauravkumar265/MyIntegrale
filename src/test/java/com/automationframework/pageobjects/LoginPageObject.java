package com.automationframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationframework.configreader.DataProvider;
import com.automationframework.utilities.WaitHelper;
import static com.automationframework.utilities.RailViewPortalConstant.RAILVIEW_USER;
import static com.automationframework.utilities.RailViewPortalConstant.RAILVIEW_PASSWORD;
import static com.automationframework.utilities.RailViewPortalConstant.RAILVIEW_LOGIN_BUTTON;
import static com.automationframework.utilities.RailViewPortalConstant.RAILVIEW_LOGOUT;
import static com.automationframework.utilities.RailViewPortalConstant.RAILVIEW_SELECT_LOGOUT_POPUP;
public class LoginPageObject {
	private WebDriver driver;
	private WaitHelper wb;
	@FindBy(xpath = RAILVIEW_USER)
	public WebElement username;
	@FindBy(xpath = RAILVIEW_PASSWORD)
	public WebElement password;
	@FindBy(xpath = RAILVIEW_LOGIN_BUTTON)
	public WebElement Loginsubmit;
	@FindBy(xpath=RAILVIEW_LOGOUT)
	public WebElement logout;
	
	@FindBy(xpath=RAILVIEW_SELECT_LOGOUT_POPUP)
	public WebElement confirmation_popup;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	  * This method will set the username that we are passing from cucumber parametre 
	  */
	public void enterusername() {
		if (username.isDisplayed()) {
			if (username.isEnabled()) {
				username.sendKeys(DataProvider.getproperty().getUsename());
			}
		}
	}
	/**
	  * Below method is used to set the password ie set from cucumber parametre 
	  */
	public void enterpassword() {
		if (password.isDisplayed()) {
			if (password.isEnabled()) {
				password.sendKeys(DataProvider.getproperty().getPassword());
			}
		}
	}
	/**
	  * Below method will perform click operation on login button after entering username and password 
	  */
	public void submit() {
		init();
		wb.waitForElementClickable(Loginsubmit, 50, 1);
		Loginsubmit.click();

	}
	/**
	  * This method will perform click operation on burger menu 
	  */

	 
	public void clickLogout(){
		wb.waitForElementClickable(logout, 150, 1);
		logout.click();
	}
	
	public void logoutpopup(){
		if(confirmation_popup.isDisplayed()){
			if(confirmation_popup.isEnabled()){
				confirmation_popup.click();
			}
		}
		
	}
	
	/**
	  * This method is used to initilize the driver of wait helper class 
	  */
	public void init() {
		wb = new WaitHelper(this.driver);
	}
}
