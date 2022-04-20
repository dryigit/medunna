Feature: US_019_Admin create a new staff

  Scenario: US019_TC_01_Admin validates newly created Staff info with API

    Given AdminOkan sets up the path and params
    Then AdminOkan sends a request and get a response
    And AdminOkan saves the response to file
    And AdminOkan verifies the expected and actual data


