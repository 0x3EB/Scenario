Feature: Check the contributors menu

  Scenario: As a developper, i can not go to the menu Articles types/Images/Links
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
    And Go to articles of the brick "Brick TESTAUTO"
    Then can not add articles
    And can not go to Images
    And can not go to Links
