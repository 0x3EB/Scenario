Feature: Commenting in the brick
  Commenting in the brick

  Scenario: As a productManager, i can comment one the brick
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    And add a comment "QSDF" in "Brick TESTAUTO" and post it
