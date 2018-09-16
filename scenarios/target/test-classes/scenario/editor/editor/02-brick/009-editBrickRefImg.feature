Feature: Test upload img ref in the brick

  Scenario: as an editor, i can add/replace/delete ref img in the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    And Go to parameters of the brick "Brick TESTAUTO"
    And can add a photo with the path "C:\Users\lejeune\Pictures\Selenium.jpg"
    Then can replace by a photo with the path "C:\Users\lejeune\Pictures\Logo-Oracle-Java-Sun.jpg"
    And can delete it
    Then click on save
