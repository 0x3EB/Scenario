Feature: Create a Brick
  Roles can or not create bricks

  Scenario: As an editor, i can create a brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And can create a new brick
    And enter the title "Brick TESTAUTO" and choose the type "Window"

  Scenario:As an editor, i can create a brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And can create a new brick
    And enter the title "Brick TESTAUTO DELETE" and choose the type "Window"
