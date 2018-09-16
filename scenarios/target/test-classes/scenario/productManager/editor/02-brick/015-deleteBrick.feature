Feature: delete the brick 
  delete and verify if the content is been put into the trash comp

  Scenario: As a product manager, deleting the brick
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
		And delete the brick "Brick TESTAUTO DELETE"