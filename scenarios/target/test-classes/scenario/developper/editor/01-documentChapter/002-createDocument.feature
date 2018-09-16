Feature: Creating a Document
  Creating a Document

  Scenario: As a developper, I can not create a Document
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And Can not create a Howto
