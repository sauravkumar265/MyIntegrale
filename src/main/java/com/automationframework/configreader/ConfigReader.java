package com.automationframework.configreader;

public interface ConfigReader {
	public String geturl();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public String getBrowser();
	public String getextentpath();
	public String getUsename();
	public String getPassword(); 
	}
