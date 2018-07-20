package com.automationframework.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerHelper {
	private static boolean root = false;

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clas){
		
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
