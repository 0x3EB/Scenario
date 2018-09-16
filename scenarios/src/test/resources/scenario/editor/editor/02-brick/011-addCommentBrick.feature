Feature: Commenting in the brick
  Commenting in the brick

  Scenario: As an editor, i can comment one the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And add a comment "QSDF" in "Brick TESTAUTO" and post it
