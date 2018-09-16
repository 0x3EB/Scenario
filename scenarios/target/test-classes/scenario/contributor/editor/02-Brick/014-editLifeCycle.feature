@tag
Feature: Modify the Life Cycle
  user can or not modify th elife cycle of a product

  @tag1
  Scenario: As a contributor, i can not modify the life cycle
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then double click on the brick "Brick TESTAUTO"
    And i can not click on finish
    Then i can not click on validate
