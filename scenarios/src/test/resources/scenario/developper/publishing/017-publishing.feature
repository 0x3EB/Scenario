Feature: extract the documentation by a publishment
  extract into a zip file

  @tag1
  Scenario: As a developper, i can not publish and download the zip file
  Given I log with the username "cont1" and  the password "cont1"
  Then I can not go to publishing
  