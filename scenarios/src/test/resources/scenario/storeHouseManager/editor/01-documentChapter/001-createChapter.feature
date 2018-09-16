Feature: Creating a chapter
  Creating a Chapter

  Scenario: As a storehousemanager i can create a Chapter in EDC
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And Can create a procedure
    Then Enter the title "Chapitre TESTAUTO"
    Then Click on create

  Scenario: As a storehousemanager i can create a Chapter called DELETE in EDC
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And Can create a procedure
    Then Enter the title "Chapitre TESTAUTO DELETE"
    Then Click on create

  Scenario: As a storehousemanager i can create a Chapter in EDC IDE ECLIPSE
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC IDE Eclipse" and the version "Version 2" in documentation
    Then Go to How tos
    And Can create a procedure in EDC ECLIPSE
    Then Enter the title "Chapitre TESTAUTO EDC Eclipse"
    Then Click on create
