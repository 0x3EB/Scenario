Feature: extract the documentation by a publishment
  extract into a zip file

  @tag1
  Scenario: As an editor, i can not publish and download the zip file
  Given I log with the username "editor1p1" and  the password "editor1p1"
  Then I can not go to publishing
  