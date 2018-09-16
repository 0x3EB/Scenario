Feature: Test upload img in the articles

  @tag1
  Scenario:as a contributor, i can not add/replace/delete img
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And I can not go to Images