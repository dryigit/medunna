Feature: US03


  Scenario Outline: TC 01 to registrste password verification
    Given yep goes to "MedunnaURL" website
    And yep click to popup
    Then yep click to register
    And yep give "<ssn>" and "<firstname>" and "<lastname>"and "<username>" and "<email>"
    And yep verfy password strength conditions

    Examples: Datas
      | ssn  |firstname| lastname|username| email|
      |756-15-6344|raskolnikov|dosto|crazyBoy|crime@punishment.com|