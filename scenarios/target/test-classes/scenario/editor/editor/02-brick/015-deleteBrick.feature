Feature: delete the brick
  delete and verify if the content is been put into the trash comp

  Scenario: As an editor, deleting the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And delete the brick "Brick TESTAUTO"
