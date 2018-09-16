Feature: Check the context menu of the documentation Types
   check context click

  Scenario: As an editor, verify the context menu
   Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
		And verify the context of the "storehousemanager" for the brick
		Then Go to How tos
		And verify the context of the "storehousemanager" for the document