Feature: Commenting in the brick
  Commenting in the brick

  Scenario: As a developper, i can comment one the brick
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
    And add a comment "QSDF" in "Brick TESTAUTO" and post it
