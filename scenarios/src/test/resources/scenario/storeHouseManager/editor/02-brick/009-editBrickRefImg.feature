Feature: Test upload img ref in the parameters of the brick

  Scenario: as a StoreHouse manager, i can add/replace/delete ref img in the parameters of the brick
    Given I am on the login page
		When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    And select the product "EDC" and the version "Version 2"
    And Go to parameters of the brick "Brick TESTAUTO"
    And can add a photo with the path "C:\Users\lejeune\Pictures\Selenium.jpg"
    Then can replace by a photo with the path "C:\Users\lejeune\Pictures\Logo-Oracle-Java-Sun.jpg"
    And can delete it
    Then click on save

