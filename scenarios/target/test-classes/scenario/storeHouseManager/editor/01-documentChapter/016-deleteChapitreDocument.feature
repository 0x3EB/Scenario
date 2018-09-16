Feature: delete the document 
  delete and verify if the content is been put into the trash comp

  @tag1
  Scenario: As a storeHouseManager, i can delete the document 
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
		And delete the Chapter "Chapitre TESTAUTO DELETE"