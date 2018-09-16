Feature: Create a Brick
  Roles can or not create bricks

  Scenario: As a contributor, i can not create a brick
    Given I am on the login page
    When I log with the username "cont1" and  the password "cont1"
    And I wait the url page change
    Then Homepage should be displayed
   	When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And can not create a new brick
