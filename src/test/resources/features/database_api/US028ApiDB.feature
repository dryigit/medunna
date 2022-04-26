Feature: US28 admin create state and country with api

  Scenario: US28 verifiying state and country with DB
    Given yep admin connects DB
    And yep admin send query


  @ApiTestItem
  Scenario: US28 create country and state
    Given yep admin create new country "A New World4" and State "Fair4"
