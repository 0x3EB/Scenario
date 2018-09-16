Feature: edit articles into the document
  Edit articles in the document

  Scenario: As an editor, i can add/Move articles in the document
    Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And add articles
    Then click on save
    And can move Articles
    Then click on save

