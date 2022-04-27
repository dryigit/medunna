@medunnaAllProject
Feature: US_019_Admin create a new staff

  Scenario Outline: US019_TC_01_Admin validates newly created Staff info with API

    Given AdminOkan sets up the path and params
    And AdminOkan create expected data "<lastName>" "<firstName>" "<id>"
    Then AdminOkan sends a request and get a response
    And AdminOkan saves the response to file
    And AdminOkan verifies the expected and actual data

    Examples:

    | lastName | firstName | id |
    |Kaya| Zeynep | 67348       |


