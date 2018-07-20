package com.automationframework.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automationframework.utilities.ResourceHelper;

public class ChromeBrowser {
	public Capabilities getChromeCapabilities() {
		// Adding capabilities to chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return chrome;
	}

	@SuppressWarnings("deprecation")
	public WebDriver getchromebrowser(Capabilities cap) {
		if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("\\src\\main\\resources\\drivers\\window\\chromedriver.exe"));
			return new ChromeDriver(cap);
		} else {
			System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\drivers\\Mac\\chromedriver");
			return new ChromeDriver(cap);
		}
	}
}
