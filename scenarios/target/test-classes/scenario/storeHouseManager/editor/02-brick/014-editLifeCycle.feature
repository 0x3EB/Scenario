@tag
Feature: Modify the Life Cycle of the brick
  user can or not modify th elife cycle of a product

  @tag1
  Scenario: As a storeHouseManager i can modify the life cycle of the brick
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Edit the brick "Brick TESTAUTO"
    And i can click on life cycle
    And i can click on finish
    Then i can not edit everything
    Then i can click on validate
