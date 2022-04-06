Feature: US11

  Scenario: US11 TC 01
    Given yep goes to "MedunnaURL" website
    Then yep click Appointment link
    And yep write information to make an appoinment
    Then yep send an appointment request
    Then yep verify tostify text "Appointment registration saved!"


    Scenario: US11 TC02
      Given yep goes to "MedunnaURL" website
      And yep click to popup
      Then yep click to logIn
And yep give username and pasword to sign in

