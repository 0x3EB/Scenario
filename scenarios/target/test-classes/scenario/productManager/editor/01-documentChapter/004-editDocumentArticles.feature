Feature: edit articles
  Edit articles in the document

  @tag1
  Scenario: As a product manager, i can add/Move articles
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And add articles
    Then click on save
    And can move Articles
    Then click on save
