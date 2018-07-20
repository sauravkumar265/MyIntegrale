package com.automationframework.utilities;

import org.openqa.selenium.WebDriver;
import com.automationframework.browser.ChromeBrowser;
import com.automationframework.browser.FirefoxBrowser;
import com.automationframework.configreader.DataProvider;
import com.automationframework.configreader.PropertyFileReader;

public class TestBase {
	public static  WebDriver driver;
	public static PropertyFileReader prop;

	public static WebDriver getbrowserobject(String btype) {
		if (btype.equalsIgnoreCase("Chrome")) {
			ChromeBrowser chrome = null;
			try {
				chrome = ChromeBrowser.class.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return chrome.getchromebrowser(chrome.getChromeCapabilities());
		} else if (btype.equalsIgnoreCase("Firefox")) {
			FirefoxBrowser ff = null;
			try {
				ff = FirefoxBrowser.class.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ff.getfirefoxbrowser(ff.getFirefoxcapabilities());
		}

		else {
			System.out.println("Driver doesnot exist!!!");
			return null;

		}
	}

public static WebDriver setupbrowser() {
		driver = getbrowserobject(DataProvider.getproperty().getBrowser());
		driver.manage().window().maximize();
		//driver.get(DataProvider.getproperty().geturl());
		return driver;
	}
 

}
