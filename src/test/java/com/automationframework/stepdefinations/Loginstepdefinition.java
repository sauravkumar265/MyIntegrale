package com.automationframework.stepdefinations;

import org.junit.Assert;
import com.automationframework.configreader.DataProvider;
import com.automationframework.pageobjects.LoginPageObject;
import com.automationframework.utilities.TestBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Loginstepdefinition extends TestBase {
	private LoginPageObject loginpage;
	//private WebDriver driver;

	@Before({"@Login"})
	public void initialize() {
		TestBase.driver = TestBase.setupbrowser();
	}
	@Given("^Use will open the browser and pass the url of MyIntegrale application$")
	public void use_will_open_the_browser_and_pass_the_url_of_MyIntegrale_application() throws Throwable {
	   TestBase.driver.get(DataProvider.getproperty().geturl());
	}
    @Then("^User will enters the username and password$")
	public void user_will_enters_the_username_and_password() throws Throwable {
		this.loginpage = new LoginPageObject(TestBase.driver);
		this.loginpage.enterusername();
		this.loginpage.enterpassword();
	}

	@Then("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		this.loginpage.submit();
	}

	@Then("^The user should be redirected to the rail view home page$")
	public void the_user_should_be_redirected_to_the_rail_view_home_page() throws Throwable {
		String actualTitle = TestBase.driver.getTitle();
		System.out.println("Actual Title of the page is --" + actualTitle);
		if (actualTitle.contains("MyIntegrale")) {
		} else {
			Assert.fail("Assertion fail as actual status is not equals to expected Title ");
		}
	}
	

	
	
}
