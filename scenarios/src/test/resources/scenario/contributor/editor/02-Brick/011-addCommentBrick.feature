Feature: Commenting in the brick
  Commenting in the brick

  @tag1
  Scenario: As a contributor, i can comment one the brick
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    And add a comment "QSDF" in "Brick TESTAUTO" and post it
