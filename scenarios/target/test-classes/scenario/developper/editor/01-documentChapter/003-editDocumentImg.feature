Feature: Test upload img in the articles

  Scenario:as a developper, i can not add/replace/delete img to the document
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    Then edit the HowTo "HowTo TESTAUTO"
    Then Go to articles
    And add articles
    Then click on save
    And I can not go to Images