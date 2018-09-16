Feature: Creating a Document
  Creating a Document

  Scenario: As an editor, i can create a Document
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    Then Can create a Howto
    Then Enter the title "HowTo TESTAUTO"
    Then Click on create