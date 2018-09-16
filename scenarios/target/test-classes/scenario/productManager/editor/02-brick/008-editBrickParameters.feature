Feature: Edit Parameters

  Scenario: As a product manager, i can add/replace/delete an img
    Given I am on the login page
    When I log with the username "pmgr1" and  the password "pmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"
    Then click on save
