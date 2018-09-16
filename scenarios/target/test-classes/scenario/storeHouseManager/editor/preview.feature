Feature: verify the preview

  Scenario: As a storehouse Manager, i can create a brick
    Given I am on the login page
    When I log with the username "jacob" and  the password "edcdemo"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    #And select the product "EDC" and the version "Version 2"
    And can create a new brick
    And enter the title "Brick TESTAUTO" and choose the type "Window"
    And Go to parameters of the brick "Brick TESTAUTO"
    Then can edit the parameters page with the desciption "TEST" and main key "AAA" and subKey "BBB"
    Then click on save
    Then Go to How tos
    Then Can create a Howto
    Then Enter the title "HowTo TESTAUTO"
    Then Click on create
    And click on contextualised UI help
    Then Edit the brick "Brick TESTAUTO"
    And can add an internal link of the document "HowTo TESTAUTO"
    
    Then click on the preview
    And verify th econtent of the preiew
