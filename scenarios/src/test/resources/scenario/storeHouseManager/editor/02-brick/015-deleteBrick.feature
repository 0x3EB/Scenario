Feature: delete the brick 
  delete and verify if the content is been put into the trash comp

  Scenario: As a storeHouseManager, deleting the brick
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
		And delete the brick "Brick TESTAUTO DELETE"