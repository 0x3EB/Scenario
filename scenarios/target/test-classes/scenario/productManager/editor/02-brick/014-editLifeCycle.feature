Feature: Modify the Life Cycle
  user can or not modify th elife cycle of a product

  Scenario: As a product manager i can modify the life cycle
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Edit the brick "Brick TESTAUTO"
    And i can click on life cycle
    And i can click on finish
    Then i can not edit everything
    Then i can click on validate
