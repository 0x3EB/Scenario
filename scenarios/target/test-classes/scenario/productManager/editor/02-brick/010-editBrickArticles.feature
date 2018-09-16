Feature: add articles
  add articles to the editor area and verify doubles and the order

  Scenario: As a product manager, i can add all articles in the brick
    Given I am on the login page
    When I log with the username "pmgr1" and  the password "pmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to articles of the brick "Brick TESTAUTO"
		Then can add articles
    Then add all contributors on the edit page
    And can edit articles
    Then click on save
