Feature: delete the document
  delete and verify if the content is been put into the trash comp

  Scenario: As a storeHouseManager, i can delete the document 
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    And delete the Chapter "Chapitre TESTAUTO DELETE"
