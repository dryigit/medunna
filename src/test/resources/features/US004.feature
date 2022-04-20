Feature: Giris Sayfasi Testi

  Scenario Outline: TC01 giris sayfasi testi
    Given mf kullanici "MedunnaURL" sayfasina gider
    And mf kullanici menude bulunan account simgesine tiklar
    And mf acilan alt menuden sign in butonuna tiklar
    Then cikan pencerede dogru "<username>" ve "<password>" girip sign in yaptiginda menude mypages sekmesini gorur


    Examples: test data
      |username|password|
      |doctorYigit|Medunna1!|