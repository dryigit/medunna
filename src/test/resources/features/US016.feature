Feature: US16 Admin Room Creation View Update Delete
@US16
  Scenario: yep Admin can create new rooms
    Given yep goes to "MedunnaURL" website
    And yep click to popup
    Then yep click to logIn
    And yep give username and pasword to sign in to login admin
Given yep clicks to itemtitle
    Then yep clicks to rooms
    And yep creates a new room having "4569" number
And yep verifies room price requirement and gives "2000" room price
    Then yep controls description cen be provided optionaly
    And yep verifies created date  and cannot be typed earlier
    And yep sees number 1 and number 2 rooms at same  type

