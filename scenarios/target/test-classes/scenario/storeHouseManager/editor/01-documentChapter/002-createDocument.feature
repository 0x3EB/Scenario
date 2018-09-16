@tag
Feature: Creating a Document
  Creating a Document

  @tag1
  Scenario: As a storehousemanager i can create a Document
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then Can create a Howto
    Then Enter the title "HowTo TESTAUTO"
    Then Click on create