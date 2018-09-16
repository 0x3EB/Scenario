Feature: delete the brick 
  delete and verify if the content is been put into the trash comp

  @tag1
  Scenario: As a contributor, i canot delete the chapter
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
		And can not delete the Chapter "Chapter TESTAUTO DELETE"