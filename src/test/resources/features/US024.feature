
Feature:US 24

  Scenario:TC01 Hasta hesabına girdiginde test sonuclarini görebilmelidir.
    Given Kullanici url'ye gider.
    And Kullanici insan ikonuna tiklar.
    And Kullanici Sign In butonuna tiklar.
    And Kullanici Username kismina valid patient deger girer.
    And Kullanici Password kismina valid patient deger girer ve Sign In butonua tiklar.
    And Kullanici My Pages Patient yazisina tiklar.
    And Kullanici acilan alt menude My Appointment yazisina tiklar.
    And Kullanici tarihleri olusturulan appointmente gore degistirir.
    And Kullanici acilan sayfada Show Tests butonuna tiklar.
    And Kullanici acian Tests sayfasinda View Results yazisina tiklar.
    Then Kullanici Test Results sayfasinda " id, name for test, default max ve min value, test date and description" bölümlerinin goruldugunu dogrular.


  Scenario: TC02 Hasta faturasunuda görebilmelidir. (Show Invoice)
    Given Kullanici url'ye gider.
    And Kullanici insan ikonuna tiklar.
    And Kullanici Sign In butonuna tiklar.
    And Kullanici Username kismina valid patient deger girer.
    And Kullanici Password kismina valid patient deger girer ve Sign In butonua tiklar.
    And Kullanici My Pages Patient yazisina tiklar.
    And Kullanici acilan alt menude My Appointment yazisina tiklar.
    And Kullanici tarihleri olusturulan appointmente gore degistirir.
    And Kullanici Show Invoice yazisina tiklar.
    Then Kullanici faturasinin gozuktugunu dogrular.