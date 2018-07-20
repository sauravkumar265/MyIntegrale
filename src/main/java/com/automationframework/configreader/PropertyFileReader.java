package com.automationframework.configreader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.automationframework.utilities.ResourceHelper;

public class PropertyFileReader implements ConfigReader {
	public Properties pro = null;

	public PropertyFileReader() {
		pro = new Properties();
		try {
			pro.load(ResourceHelper.getResourceInputStream("\\src\\main\\resources\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  String geturl() {

		return pro.getProperty("url");
	}

	public int getPageLoadTimeOut() {

		return Integer.parseInt(pro.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {

		return Integer.parseInt(pro.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {

		return Integer.parseInt(pro.getProperty("ExplicitWait"));
	}
	

	public String getBrowser() {

		return pro.getProperty("Browser");
	}
	public String getextentpath(){
		
		return pro.getProperty("extentpath");
		
	}

	
	public String getUsename() {
		return pro.getProperty("UserName");
	}


	public String getPassword() {
		
		return pro.getProperty("Password");
	}

}
