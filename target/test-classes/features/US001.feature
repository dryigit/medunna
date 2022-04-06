Feature: US001_sign_Up

  Scenario: TC01_gecerli bir ssn girilir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menüde bulunan account simgesine tıklar
    And mf kullanici register butonuna tıklar
    Then mf kullanıcı ssn girer

  Scenario: TC03_SSN Bos birakilamaz
    Given mf kullanici "MedunnaURL" sayfasina gider
    Then mf kullanici menüde bulunan account simgesine tıklar
    Then mf kullanici register butonuna tıklar
    And mf kullanıcı ssn kutusunu bos birakirsa hata alir

    Scenario: TC03_Kullanici gecerli bir ilk isim girer
      Given mf kullanici "MedunnaURL" sayfasina gider
      Then mf kullanici menüde bulunan account simgesine tıklar
      Then mf kullanici register butonuna tıklar
      And mf kullanici gecerli bir ilk isim girer

  Scenario: TC04_Kullanıcı gecerli bir soyisim girer
    Given mf kullanici "MedunnaURL" sayfasina gider
    Then mf kullanici menüde bulunan account simgesine tıklar
    Then mf kullanici register butonuna tıklar
    And mf kullanici gecerli bir soyisim isim girer

