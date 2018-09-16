Feature: Check the context menu of the documentation Types
  check context click

  Scenario: As a developper, verify the context menu
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
		And verify the context of the "developper" for the brick
		Then Go to How tos
		And verify the context of the "developper" for the document