@tag
Feature: Add link to the brick 
  user can or not add links to the 

  @tag1
  Scenario: As a contributor, i can not add links to brick
  	Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
  	Then double click on the brick "Brick TESTAUTO"
  	And can not add an internal link of the document "Chapitre TESTAUTO"
  	Then can not add an external link of the product "EDC IDE Eclipse" and the document "Chapter axePB" 