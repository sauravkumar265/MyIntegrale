package com.automationframework.runners;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.automationframework.configreader.DataProvider;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/com/bdd/features" }, glue = {"com.automationframework.stepdefinations" },
                  tags={"@MonthlyRoster,@Login"}, 
				  monochrome = true, 
				  plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })
public class Testrunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(DataProvider.getproperty().getextentpath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 7" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.6.0");
	    Reporter.setSystemInfo("Maven", "3.6.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    Reporter.assignAuthor("Saurav kumar");
	    
	    }
	
	}
