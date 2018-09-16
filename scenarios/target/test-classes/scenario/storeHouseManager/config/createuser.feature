Feature: Test CreationContact
  The adminsitraor can create a user. So to .

  Scenario: Create a user
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    Then I click on configuration
    When I click on User Management
    And I enter the username "bbbbbb" and email "bbbbb@from.com" and the firstname "yjtyjtt" and the lastname "gdfge"
    And I Click on create
    #And verify if username "sebastienl" and email "sebastien.lejeune6@gmail.com" and the firstname "Sebastien" and the lastname "LEJEUNE" are correct
    #And Finish
