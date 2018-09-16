Feature: Creating a Document
  Creating a Document

  Scenario: As a product manager i can create a Document
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then Can create a Howto
    Then Enter the title "HowTo TESTAUTO"
    Then Click on create