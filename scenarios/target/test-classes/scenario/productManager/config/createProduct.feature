Feature: Test CreationProduct
  The storehouse manager can create a product. 

Scenario: As a product manager, i can not go to the config menu
    Given I am on the login page
    When I log with the username "pmgr1" and  the password "pmgr1"
    And I wait the url page change
    Then i can not click on the config menu