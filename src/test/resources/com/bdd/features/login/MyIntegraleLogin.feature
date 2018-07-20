@Login
Feature: To Test the login scenario of rail view application
Scenario: To test the login scenario with valid user
    Given Use will open the browser and pass the url of MyIntegrale application 
    Then User will enters the username and password 
    And click on Login button
    Then The user should be redirected to the rail view home page
 
