@tag
Feature: Test upload img in the articles

  @tag1
  Scenario: as a contributor, i can not add/replace/delete img in the articles
    Given I am on the login page
    When I log with the username "cont1" and  the password "cont1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    When Go to Articles of the brick "Brick TESTAUTO"
    And can not go to Images
