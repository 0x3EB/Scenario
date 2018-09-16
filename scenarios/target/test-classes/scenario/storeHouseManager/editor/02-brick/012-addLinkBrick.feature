Feature: Add link to the brick 
  user can or not add links to the brick

  Scenario: As a storeHouseManager i can add links to brick
  	Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
  	Then Edit the brick "Brick TESTAUTO"
  	And can add an internal link of the document "Chapitre TESTAUTO"
  	Then can add an external link of the product "EDC IDE Eclipse" and the document "Chapitre TESTAUTO EDC Eclipse" 