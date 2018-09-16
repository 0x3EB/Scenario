Feature: Create a glossary

  Scenario: As a storehouse Manager, i can create a glossary
    Given I am on the login page
    When I log with the username "jacob" and  the password "edcdemo"
    And I wait the url page change
    Then Homepage should be displayed
    When I click on Documentation
    #And select the product "EDC" and the version "Version 2"
    Then i click on Glossary
    And i create a new term with the name  "TEST GLOSSARY"
    Then Go to How tos
    And Can create a document
    Then Enter the title "HowTo TESTAUTO GLOSSARY"
    Then Click on create
    And add the first article type 
    And add the first article type 
    Then write in the textarea " TEST EDC GLOSSARY"
    And Select it and insert glossary term "TEST GLOSSARY"
    Then check if "TEST EDC GLOSSARY" is a glossary