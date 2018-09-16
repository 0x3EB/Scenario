Feature: add articles in the brick
  add articles to the editor area and verify doubles and the order

  Scenario: As a storehouse manager, i can add all articles in the brick
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to articles of the brick "Brick TESTAUTO"
		Then can add articles
    Then add all contributors on the edit page
    And can edit articles
    Then click on save
