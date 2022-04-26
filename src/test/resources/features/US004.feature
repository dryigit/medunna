@medunnaAllProject
Feature: Giris Sayfasi Testi

  Scenario Outline: TC01 giris sayfasi testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then cikan pencerede dogru "<username>" ve "<password>" girip sign in yaptiginda menude mypages sekmesini gorur


    Examples: test data
      |username|password|
      |doctorYigit|Medunna1!|

  Scenario: TC02 beni hatirla testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then kullanici giris ekraninda beni hatirla bolumunu gorur

  Scenario: TC03 sifremi unuttum testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then kullanici giris ekraninda sifremi unuttum bolumunu gorur

  Scenario: TC04 yeni hesap olusurma testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then kullanici giris ekraninda register a new account bolumunu gorur

  Scenario: TC05 cancel secenegi testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then kullanici giris ekraninda cancel secenegini gorur
