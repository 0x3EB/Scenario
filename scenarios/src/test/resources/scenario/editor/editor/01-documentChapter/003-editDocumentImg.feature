Feature: Test upload img in the articles into the document

  Scenario: as an editor, i can be add/replace/delete img into the document
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And add articles
    Then click on save
    And I can go to Images
    Then I upload an img with the path "Selenium.jpg"
    And add it to the content of the articles
    Then I replace by an img with the path "pyhton_black.jpg"
    And I delete it
    Then click on save
