@medunnaAllProject
Feature: US28 Admin creates new country
  Scenario: US28 Admin creates new
    Given yepadmin goes to "MedunnaURL" website
    And yepadmin click to popup
    Then yepadmin click to logIn
    And yepadmin give username and pasword to sign in to login admin
    And yep clicks to itemtitle
    Then yep clicks to Country
    And yep clicks to create a new country
    Then yep gives country name "lastIsland" to create

