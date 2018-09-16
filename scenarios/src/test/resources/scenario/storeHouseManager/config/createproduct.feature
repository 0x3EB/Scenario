Feature: Test CreationProduct
  The adminsitraor can create a product. 

Scenario: Create a product
    Given I am on the login page
    When I log with the username "stmgr1" and  the password "stmgr1"
    And I wait the url page change
    Then Homepage should be displayed
    Then I click on configuration
    When I click on Product management
    And I enter the name "EDC14" and version name "V2018" and the title "EDC14" and the vendor "EasyDocContent" and the ProductType "WEB"
    And I Click on create Product
    And I add the user "Sebastien LEJEUNE" to the product "EDC" and verify 
    #And Finish
