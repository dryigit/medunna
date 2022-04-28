Feature: US18 database

  @db_login_name
  Scenario: lvnt read user information
    Given lvnt user connects to the database
    And lvnt user gets the "*" from "physician" table
    And lvnt verify "jhi_user" table "login" column contains "10518"
    Then close the database connection