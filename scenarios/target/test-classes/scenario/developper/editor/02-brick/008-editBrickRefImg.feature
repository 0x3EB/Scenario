Feature: Test upload img ref

  Scenario: As a developper, i can add/replace/delete Reference img
    Given I log with username "dev1" and password "dev1", I select the product "EDC" and the version "Version 2" in documentation
    And Go to parameters of the brick "Brick TESTAUTO"
    And can add a photo with the path "C:\Users\lejeune\Pictures\Selenium.jpg"
    Then can replace by a photo with the path "C:\Users\lejeune\Pictures\Logo-Oracle-Java-Sun.jpg"
    And can delete it
    Then click on save
