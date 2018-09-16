Feature: Test upload img in the articles in the brick

  Scenario: as an editor, i can add/replace/delete img in the brick
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    When Go to Articles of the brick "Brick TESTAUTO"
    And add articles
    Then click on save
    And I can go to Images
    Then I upload an img with the path "C:\Users\lejeune\Pictures\csharp.png"
    And add it to the content of the articles
    Then I replace by an img with the path "javafx.png"
    And I delete it
    Then click on save
