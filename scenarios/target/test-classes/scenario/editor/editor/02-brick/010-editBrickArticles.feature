Feature: add articles in the brick
  add articles to the editor area and verify doubles and the order in the brick

  Scenario: As an editor, i can add all articles in the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And Go to articles of the brick "Brick TESTAUTO"
    Then can add articles
    Then add all contributors on the edit page
    And can edit articles
    Then click on save
