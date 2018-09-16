Feature: Commenting in the brick
  Commenting in the brick

  Scenario: As a storeHouseManager, i can comment one the brick
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    And add a comment "QSDF" in "Brick TESTAUTO" and post it
