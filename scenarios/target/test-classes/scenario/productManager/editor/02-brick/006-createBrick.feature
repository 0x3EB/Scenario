Feature: Create a Brick
  Roles can or not create bricks

  Scenario: As a product manager, i can create a brick
    Given I am on the login page
    When I log with the username "pmgr1" and  the password "pmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And can create a new brick
    And enter the title "Brick TESTAUTO" and choose the type "Window"

  Scenario: As a product manager, i can create a brick
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And can create a new brick
    And enter the title "Brick TESTAUTO DELETE" and choose the type "Window"
