Feature: Add link to the brick 
  user can or not add links to the 

  Scenario: As an editor, i can add links to brick
  	Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
  	Then Edit the brick "Brick TESTAUTO"
  	And can add an internal link of the document "Chapitre TESTAUTO"
  	Then can add an external link of the product "EDC IDE Eclipse" and the document "Chapitre TESTAUTO EDC Eclipse" 