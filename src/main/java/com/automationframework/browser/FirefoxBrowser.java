package com.automationframework.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automationframework.utilities.ResourceHelper;

public class FirefoxBrowser {
public Capabilities getFirefoxcapabilities(){
	DesiredCapabilities firefox= DesiredCapabilities.firefox();
	FirefoxProfile profile= new FirefoxProfile();
	profile.setAcceptUntrustedCertificates(true);
	firefox.setCapability(FirefoxDriver.PROFILE, profile);
	firefox.setCapability("marionette", true);
	return firefox;
	}
public WebDriver getfirefoxbrowser(Capabilities cap){
	if(System.getProperty("os.name").contains("Window")){
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/window/geckodriver.exe"));
		return new FirefoxDriver();
	}
	else if(System.getProperty("os.name").contains("Mac")){
		System.getProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/window/geckodriver"));
	}
	return null;
	
}
}
