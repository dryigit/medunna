Feature: US16 Patient Verifiying
  @US16
  Scenario: verifiying
    Given yep admin connects database
    And yep admin send query "select " "*" from "jhi_user" where "id" "51911"