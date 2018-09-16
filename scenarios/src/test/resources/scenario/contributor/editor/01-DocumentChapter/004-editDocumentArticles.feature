Feature: edit articles
  Edit articles in the document

  @tag1
  Scenario: As a contributor, i can not add/Move articles
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And can not move Articles

