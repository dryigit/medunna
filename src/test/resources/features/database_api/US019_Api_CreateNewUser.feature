Feature: US_019_Admin create a new staff, edit and delete


  Scenario: US019_TC06_Admin creates a new user using API
    Given AdminOki sets up the path and params
    And AdminOki creates expected data_payload "login" "firstName" "lastName" "ssn" "email" with faker class
    And AdminOki saves the records to file
    And AdminOki sends the post request with token and gets the response and then validates
  #  Then AdminOki validates the expected and actual data



