Feature: Commenting in the chapter
  Commenting in the chapter

  @tag1
  Scenario: As a product manager, i can comment one the chapter
    Given I log with username "pmgr1" and password "pmgr1", I select the product "EDC" and the version "Version 2" in documentation
    Then Go to How tos
    And add a comment "QSDF" in "Chapitre TESTAUTO" and post it