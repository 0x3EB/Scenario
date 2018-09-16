@tag
Feature: Test upload ref img

  @tag1
  Scenario: As a contributor, i can not add/replace/delete an img
    Given I am on the login page
    When I log with the username "cont1" and  the password "cont1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    And can not add a photo with the path "C:\Users\lejeune\Pictures\Selenium.jpg"
    Then can not replace by a photo with the path "C:\Users\lejeune\Pictures\Logo-Oracle-Java-Sun.jpg"
    And can not delete it
