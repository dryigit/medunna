@Tc
@medunnaAllProject
Feature: US001_sign_Up

  Scenario Outline: TC01_gecerli bir ssn girilir
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf kullanici register butonuna tiklar
    Then mf kullanici "<ssn>" girer
    Examples: test data
      |ssn|
      |123-12-1212|

  Scenario: TC03_SSN Bos birakilamaz
    Given mf kullanici "MedunnaURL" sayfasina gider
    Then mf kullanici menude bulunan account simgesine tiklar
    Then mf kullanici register butonuna tiklar
    And mf kullanici ssn kutusunu bos birakirsa hata alir

    Scenario Outline: TC03_Kullanici gecerli bir ilk isim girer
      Given mf kullanici "MedunnaURL" sayfasina gider
      Then mfi kullanici menude bulunan account simgesine tiklar
      Then mf kullanici register butonuna tiklar
      And mf kullanici gecerli bir "<ilkIsim>" girer
      Examples: test data
        |ilkIsim|
        |Alican|

  Scenario Outline: TC04_Kullanıcı gecerli bir soyisim girer
    Given mf kullanici "MedunnaURL" sayfasina gider
    Then mf kullanici menude bulunan account simgesine tiklar
    Then mf kullanici register butonuna tiklar
    And mf kullanici gecerli bir "<soyisim>" isim girer
    Examples: test data
      |soyisim|
      |kara|

