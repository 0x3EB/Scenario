@tag
Feature: Test Login EDC
  The user can log in on edc software.

  Scenario: Test login
    Given I am on the login page
    When I enter the username "stmgr1" and  the password "stmgr1" 
    And I click on login
    And I wait the url page change
    Then Homepage should be displayed
    And Finish
        
 Scenario: The login failed
    Given I am on the login page
    When I enter the username "stmgr1" and  the password "stmgr2" 
    And I click on login
    Then LoginPage should be displayed
    And Finish
  