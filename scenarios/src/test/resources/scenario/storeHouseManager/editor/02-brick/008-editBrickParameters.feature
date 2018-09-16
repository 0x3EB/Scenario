Feature: Edit Parameters of the brick

  Scenario: As a storeHouse manager, i edit the description and keys of the brick
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"
    Then click on save
