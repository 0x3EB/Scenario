Feature: Creating a chapter
  Creating a Chapter

  Scenario: As an editor i can create a Chapter
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    And Can create a procedure
    Then Enter the title "Chapitre TESTAUTO"
    Then Click on create

  Scenario: As an editor i can create a Chapter called DELETE in EDC
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    And Can create a procedure
    Then Enter the title "Chapitre TESTAUTO DELETE"
    Then Click on create

  Scenario: As an editor i can create a Chapter in EDC IDE ECLIPSE
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    And Can create a procedure in EDC ECLIPSE
    Then Enter the title "Chapitre TESTAUTO EDC Eclipse"
    Then Click on create
