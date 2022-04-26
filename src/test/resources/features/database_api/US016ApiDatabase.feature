Feature: US16 Patient Verifiying
  @Yep
  Scenario: verifiying
    Given yep admin connects database
    And yep admin send query "select " "*" from "jhi_user" where "id" "51911"
    Then yep admin verfies patient id "51911"
  @ApiTestItem
  @Yep
  Scenario: verifiying room with api
  And yep creates new room with api


#Validate all rooms with API creating, reading, updating and deleting
#			Rooms can be Deleted by admin