package com.automationframework.stepdefinations;
import com.automationframework.utilities.TestBase;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {
	
    @After
	public void tearDown(){
	driver.quit();
		}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor(" A683454 --" +" Saurav kumar");
	}
	
}
