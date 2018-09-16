@tag
Feature: add articles 
  add articles to the editor area and verify doubles and the order

  @tag1
  Scenario: As a contributor, i can not add all articles
 		Given I am on the login page
    When I log with the username "cont1" and  the password "cont1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to articles of the brick "Brick TESTAUTO"
		Then can not add articles
		And can not edit articles
    