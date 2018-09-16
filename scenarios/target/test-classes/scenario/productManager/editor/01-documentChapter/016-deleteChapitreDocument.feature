Feature: delete the brick
  delete and verify if the content is been put into the trash comp

  @tag1
  Scenario: As a product manager, i can delete the document 
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And delete the Chapter "Chapitre TESTAUTO DELETE"
