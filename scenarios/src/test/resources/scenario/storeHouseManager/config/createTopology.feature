Feature: Test topology
  The adminsitraor can create/modify Topologies. So to .

  Scenario: test Strategies
    Given I am on the login page
    When I log with the username "jacob" and  the password "edcdemo"
    And I wait the url page change
    Then Homepage should be displayed
    Then I click on configuration
    Then I click on Topologies
    And Select the version "V2018"
    Then create the Topology with name "TEST AUTO STRATEGY" the structure "HTML" the color "" the icon "" and the description "TEST STRATEGY"
    And add the strategy "Contextualised UI Help"
    Then i click on documentation
    And can create a new brick
    And enter the title "Brick TOPOLOGY TESTAUTO" and choose the type "Window"
    Then Check if i got the article types "TEST AUTO STRATEGY"
