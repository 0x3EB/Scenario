@tag
Feature: Edit Parameters 

  @tag1
  Scenario: As a contributor, i can not edit the content of a brick
    Given I am on the login page
    When I log with the username "cont1" and  the password "cont1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can not edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"