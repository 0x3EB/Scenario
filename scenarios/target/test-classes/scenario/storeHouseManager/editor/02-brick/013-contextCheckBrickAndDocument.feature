Feature: Check the context menu of the documentation Types
   check context click

  @tag1
  Scenario: As a storeHouseManager, verify the context menu
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
		And verify the context of the "storehousemanager" for the brick
		Then Go to How tos
		And verify the context of the "storehousemanager" for the document