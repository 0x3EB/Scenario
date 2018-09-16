Feature: Edit parameters of the brick
  Roles can or not edit parameters of the brick

  Scenario: As a developper, I can edit parameters of the brick
    Given I am on the login page
    When I log with the username "dev1" and  the password "dev1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"
    Then click on save
