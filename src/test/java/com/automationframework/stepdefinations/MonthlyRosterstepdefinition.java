package com.automationframework.stepdefinations;

import com.automationframework.pageobjects.MonthlyRosterPageObject;
import com.automationframework.utilities.TestBase;

import cucumber.api.java.Before;

import cucumber.api.java.en.Then;

public class MonthlyRosterstepdefinition {

	private MonthlyRosterPageObject monthlyroster;

	@Before({ "@MonthlyRoster" })
	public void init() {
		TestBase.driver = TestBase.setupbrowser();
		instantiatePageObjects();
	}

	@Then("^User will click on burger menu$")
	public void user_will_click_on_burger_menu() throws Throwable {
		monthlyroster.getMenuOption();
	}

	@Then("^Select the option \"([^\"]*)\" from the menu$")
	public void select_the_option_from_the_menu(String menuOption) throws Throwable {
		monthlyroster.getBurgerMenuList(menuOption);
	}

	@Then("^user will select the crew from drop down list \"([^\"]*)\"$")
	public void user_will_select_the_crew_from_drop_down_list(String crewToSelect) throws Throwable {
		monthlyroster.selectCrewFromDropDown(crewToSelect);
	}

	@Then("^select the month from \"([^\"]*)\" and year from \"([^\"]*)\"$")
	public void select_the_month_from_and_year_from(String month, String year) throws Throwable {
		monthlyroster.selectMonth(month);
		monthlyroster.selectYear(year);

	}

	@Then("^click on refresh button$")
	public void click_on_refresh_button() throws Throwable {
		monthlyroster.refreshMonthlyRoster();
	}

	@Then("^User will request leave for the selected day$")
	public void user_will_request_leave_for_the_selected_day() throws Throwable {
		monthlyroster.requestLeave();
	}

	@Then("^User will submit the leave for the selected date$")
	public void user_will_submit_the_leave_for_the_selected_date() throws Throwable {
		monthlyroster.submitLeaveForSelectedDate();
		}
	
    @Then("^user will validate leave request is sucessful$")
	public void user_will_validate_leave_request_is_sucessful() throws Throwable {
		monthlyroster.validateLeaveRequest();
	}
    
   @Then("^user will check cancel leave functionality$")
	public void user_will_check_cancel_leave_functionality() throws Throwable {
	   monthlyroster.cancelLeaveRequest();
	}
   
   private void instantiatePageObjects() {
		// loginpage = new LoginPageObject(TestBase.driver);
		monthlyroster = new MonthlyRosterPageObject(TestBase.driver);
	}
}