
Feature: Test Strategies
  The adminsitraor can create/modify strategies. So to .

Scenario: test Strategies
Given I am on the login page
    When I log with the username "jacob" and  the password "edcdemo"
    And I wait the url page change
    Then Homepage should be displayed
    Then I click on configuration
    Then I click on strategies
    And Select the version "V2018"
    Then create the strategy with name "TEST AUTO STRATEGY" the structure "Chapters & Documents" the color "" the icon "" and the description "TEST STRATEGY"
    And add the topology "About"
    Then check if the strategy has been add to the documentation menu of "" version ""
    When i click on strategy just created
    Then Can create a document
    Then Enter the title "DOCUMENT TEST"
    Then Click on create
    Then Check if i got the article types "About"
