Feature: Edit Parameters of the brick

  Scenario: As an editor, i can edit the parameters of the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"
    Then click on save
