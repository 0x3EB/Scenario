Feature: Modify the Life Cycle of the brick
  user can or not modify th elife cycle of a product

  Scenario: As an editor, i can modify the life cycle of the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Edit the brick "Brick TESTAUTO"
    And i can click on life cycle
    And i can click on finish
    Then i can not edit everything
    Then i can not click on validate
