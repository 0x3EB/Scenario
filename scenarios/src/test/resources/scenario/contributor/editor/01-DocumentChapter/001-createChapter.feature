Feature: Creating a chapter
  Creating a Chapter

  @tag1
  Scenario: As a contributor i can not create a Chapter
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And Can not create a procedure