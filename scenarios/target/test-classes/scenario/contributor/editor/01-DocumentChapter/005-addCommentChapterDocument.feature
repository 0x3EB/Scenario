Feature: Commenting in the chapter
  Commenting in the chapter

  @tag1
  Scenario: As a contributor, i can comment one the chapter
    Given I log with username "cont1" and password "cont1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And add a comment "QSDF" in "Chapitre TESTAUTO" and post it