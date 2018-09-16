Feature: Modify the Life Cycle
  user can or not modify th elife cycle of a product

  Scenario: As a developper, i can not modify the life cycle
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
    Then Edit the brick "Brick TESTAUTO"
    And i can not click on finish
    Then i can not click on validate
