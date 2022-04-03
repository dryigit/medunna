Feature: US001_sign_Up

  Scenario: TC01_Sign  up with ssn first name last name
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then mf kullanıcı ssn girer
