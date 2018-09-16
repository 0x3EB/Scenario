Feature: Test CreationContact
  The adminsitraor can create a user. So to .

  Scenario: Create a user
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
		Then verify the brick "AZERTY" is on the activity stream
