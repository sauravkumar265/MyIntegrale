package com.automationframework.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationframework.utilities.WaitHelper;
import static com.automationframework.utilities.RailViewPortalConstant.BURGER_MENU;
import static com.automationframework.utilities.RailViewPortalConstant.MENU_LIST;
import static com.automationframework.utilities.RailViewPortalConstant.crew_select;
import static com.automationframework.utilities.RailViewPortalConstant.select_month;
import static com.automationframework.utilities.RailViewPortalConstant.select_year;
import static com.automationframework.utilities.RailViewPortalConstant.refresh_MonthlyRoster;
import static com.automationframework.utilities.RailViewPortalConstant.selectAndRequestLeave;
import static com.automationframework.utilities.RailViewPortalConstant.requestLeaveClick;
import static com.automationframework.utilities.RailViewPortalConstant.submitLeave;
import static com.automationframework.utilities.RailViewPortalConstant.LeaveSuccess;
import static com.automationframework.utilities.RailViewPortalConstant.CancelLeave;
import java.util.List;

public class MonthlyRosterPageObject {
	private WebDriver driver;
	private WaitHelper wb;
	@FindBy(xpath = BURGER_MENU)
	public WebElement menuoption;
	@FindBy(xpath = MENU_LIST)
	public WebElement listBurgerMenu;
	@FindBy(xpath = crew_select)
	public WebElement getCrewDropdown;
	@FindBy(xpath = select_month)
	public WebElement monthList;
	@FindBy(xpath = select_year)
	public WebElement yearList;
	@FindBy(xpath = refresh_MonthlyRoster)
	public WebElement refreshAfterSelection;
	@FindBy(xpath = selectAndRequestLeave)
	public WebElement leaveRequest;
	@FindBy(xpath = requestLeaveClick)
	public WebElement clickLeaveButton;
    @FindBy(xpath=submitLeave)
    public WebElement LeaveSubmission;
    @FindBy(xpath=LeaveSuccess)
    public WebElement successOnLeaveRequest;
    @FindBy(xpath=CancelLeave)
    public WebElement cancelLeaveButton;
    
	public MonthlyRosterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getMenuOption() {
		init();
		wb.waitForElementClickable(menuoption, 120, 1);
		menuoption.click();
	}

	public void getBurgerMenuList(String select) {
		wb.waitForElementVisible(listBurgerMenu, 50, 1);
		List<WebElement> getmenu = this.driver.findElements(By.xpath(MENU_LIST));
		for (WebElement ele : getmenu) {
			String menu = ele.getText();
			System.out.println("List of menu in the burger menu is --" + menu);
			if (select.equalsIgnoreCase(menu)) {
				ele.click();
				break;

			}
		}
	}

	public void selectCrewFromDropDown(String crew) {
		wb.waitForElementVisible(getCrewDropdown, 100, 1);
		try {
			List<WebElement> getdd = this.driver.findElements(By.xpath(crew_select));
			for (WebElement ele : getdd) {
				String dropDownlist = ele.getText();
				System.out.println("List of menu available in the dropdown list  " + dropDownlist);
				if (crew.equalsIgnoreCase(dropDownlist)) {
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out
					.println("You don't have access to select crew from dropdown please try with different user !!!!");
		}
	}

	public void selectMonth(String month) {
		List<WebElement> monthElements = driver.findElements(By.xpath(select_month));
		for (WebElement monthDropDownList : monthElements) {
			String dropdownlist = monthDropDownList.getText();
			System.out.println("List of month available in the dropdown are ---" + dropdownlist);
			if (month.equalsIgnoreCase(dropdownlist)) {
				monthDropDownList.click();
				break;
			}
		}
	}

	public void selectYear(String year) {
		List<WebElement> yearElements = driver.findElements(By.xpath(select_year));
		for (WebElement yearDropDownList : yearElements) {
			String dropdownlist = yearDropDownList.getText();
			System.out.println("List of years available in the dropdown are ---" + dropdownlist);
			if (year.equalsIgnoreCase(dropdownlist)) {
				yearDropDownList.click();
				break;
			}
		}
	}

	public void refreshMonthlyRoster() {
		refreshAfterSelection.click();
	}

	public void requestLeave() {
		wb.waitForElementClickable(leaveRequest, 120, 1);
         System.out.println("Checking request leave section ");
		List<WebElement> ele = driver.findElements(By.xpath(selectAndRequestLeave));
		for (WebElement days : ele) {
			String daysAvailable = days.getText();
			System.out.println("Dates that we are checking  --" + daysAvailable);
			days.click();
			if (clickLeaveButton.isDisplayed()) {
				clickLeaveButton.click();
				System.out.println("Selected date have Request leave available");
				break;
			} else{
				System.out.println("Selected date don't have request leave option");
			}
			
            }
           }
	public void submitLeaveForSelectedDate(){
		wb.waitForElementClickable(LeaveSubmission, 120, 1);
		LeaveSubmission.click();
	}

	public void validateLeaveRequest(){
		wb.waitForElementClickable(successOnLeaveRequest, 120, 1);
		String actualTitle=successOnLeaveRequest.getText();
		System.out.println("Actual Title that we are getting after applying leave is --"+actualTitle);
		String ExpectedTitle="Request has been processed successfully and authorised";
       if(actualTitle.contentEquals(ExpectedTitle)){
    	    }
       else{
    	Assert.fail("Assertion fail as actualTitle and expectedTitle are not equals");
       }
	}
	
	public void cancelLeaveRequest(){
		wb.waitForElementClickable(leaveRequest, 180, 1);
        System.out.println("Checking request leave section ");
		List<WebElement> ele = driver.findElements(By.xpath(selectAndRequestLeave));
		for (WebElement days : ele) {
			String daysAvailable = days.getText();
			System.out.println("Dates that we are checking for cancelling leave are  --" + daysAvailable);
			days.click();
			if (cancelLeaveButton.isDisplayed()) {
				if(cancelLeaveButton.isEnabled()){
				cancelLeaveButton.click();
				System.out.println("Selected date have Cancel leave available");
				break;
			} 
				}
			else{
				System.out.println("Selected date don't have request leave option");
			}
			
           }
          }
	
	public void init() {
		wb = new WaitHelper(this.driver);
	}
}
