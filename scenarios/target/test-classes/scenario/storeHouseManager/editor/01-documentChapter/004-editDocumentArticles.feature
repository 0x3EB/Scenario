Feature: edit articles in the document
  Edit articles in the document

  @tag1
  Scenario: As a storehouse manager, i can add/Move articles in the document
    Given I log with username "stmgr1" and password "stmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And add articles
    Then click on save
    And can move Articles
    Then click on save

