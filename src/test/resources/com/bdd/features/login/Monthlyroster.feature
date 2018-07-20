@MonthlyRoster
Feature: To test Monthly Roster
Scenario Outline: To test leave for monthly roster 
    Given Use will open the browser and pass the url of MyIntegrale application 
    Then User will enters the username and password 
    And click on Login button
    Then The user should be redirected to the rail view home page
    And User will click on burger menu 
    Then Select the option "Monthly Roster" from the menu 
    Then user will select the crew from drop down list "<crew>"
    And select the month from "<month_select>" and year from "<year_select>"
    Then click on refresh button 
    And User will request leave for the selected day 
    Then User will submit the leave for the selected date
    And user will validate leave request is sucessful 
    And user will check cancel leave functionality
    
    
   Examples:
   |crew     |month_select|year_select|
   |WOODS NQ |    Sep     | 2018      |
  
   