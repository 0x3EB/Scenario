Feature: Test upload img in the articles

  Scenario: as a product manager, i can be add/replace/delete img in the brick
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    When Go to Articles of the brick "Brick TESTAUTO"
    And add articles
    Then click on save
    And I can go to Images
    Then I upload an img with the path "C:\Users\lejeune\Pictures\csharp.png"
    And add it to the content of the articles
    Then I replace by an img with the path "javafx.png"
    And I delete it
    Then click on save
