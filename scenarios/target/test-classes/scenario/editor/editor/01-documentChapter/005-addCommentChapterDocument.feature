Feature: Commenting in the chapter
  Commenting in the chapter

  @tag1
  Scenario: As an editor, i can comment one the chapter
   Given I log with username "editor1p1" and password "editor1p1", I select the version "Version 2" in documentation as an editor
    Then Go to How tos
    And add a comment "QSDF" in "Chapitre TESTAUTO" and post it