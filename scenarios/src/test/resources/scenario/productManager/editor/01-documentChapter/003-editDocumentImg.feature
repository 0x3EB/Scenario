Feature: Test upload img in the articles

  Scenario: as a product manager, i can be add/replace/delete img
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
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
