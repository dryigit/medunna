Feature: US18 database

  @db_login_name
  Scenario: lvnt read user information
    Given lvnt user connects to the database
    And lvnt user gets the "*" from "jhi_user" table
    And lvnt verify "jhi_user" table "ssn" column contains "039-83-9121"
    Then close the database connection