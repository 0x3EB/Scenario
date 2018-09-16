@BrickDeleteStmgr
Feature: delete the brick 
  delete and verify if the content is been put into the trash comp

  @tag1
  Scenario: As a contributor, i can not delete the brick
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
		And can not delete the brick "Brick TESTAUTO"