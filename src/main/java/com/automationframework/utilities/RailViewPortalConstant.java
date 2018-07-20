package com.automationframework.utilities;

public class RailViewPortalConstant {
	
	private RailViewPortalConstant(){
		
	}
	/**
     * Element to identify username rail view screen  
     */
	public static final String RAILVIEW_USER= "//input[@id='username_field']";
	
	/**
     * Element to identify the password on rail view screen 
     */
 public static final String RAILVIEW_PASSWORD="//input[@name='password_field']";
 /**
  * Element to identify tHE LOGIN BUTTON on rail view screen 
  */
 public static final String RAILVIEW_LOGIN_BUTTON="//input[@value='Log In']";
 
 /**
  * Element to identify tHE Burger Menu on rail view screen 
  */
 //public static final String RAILVIEW_BURGER_MENU="//*[@id='mySidenav']/p/button";
 

 /**
  * Element to identify logout button on burger menu
  */
 public static final String RAILVIEW_LOGOUT="//a[@id='logout_button_dialog']";

 /**
  * Element to identify logout button on confirmation popup 
  */
 
 public static final String RAILVIEW_SELECT_LOGOUT_POPUP="(//a[contains(text(),'Logout')])[2]";
 
 /**
  * Element to identify tHE Burger Menu on MyIntegrale page  
  */
 public static final String BURGER_MENU="//nav[@id='mySidenav']/p[@class='control']/button[@class='icon-menu']";
 
 public static final String MENU_LIST="//ul[@id='menu_content']/li/a";
 /**
  * Element to select crew from crew crew dropdown 
  */
 public static final String crew_select=" //select[@id='other_crew_select']/option";
 /**
  * Element to select month on monthly roster page 
  */
 public static final String select_month="//select[@id='monthlyDropdown']/option";
 
 public static final String select_year= "//select[@id='yearlyDropdown']/option";
 
 public static final String  refresh_MonthlyRoster="//a[@id='get_data_button']";
 
 public static final String selectAndRequestLeave="//div[@class='fc-content-skeleton']/table/thead/tr/td/span";
 
 public static final String requestLeaveClick= "//a[@id='leave_ua_request_button']";
 
 public static final String submitLeave= "//a[@id='submit_button']";
 
 public static final String LeaveSuccess="//div[@id='rl_success_message']";
 
 public static final String CancelLeave="//a[@id='leave_ua_cancel_button']";
}
