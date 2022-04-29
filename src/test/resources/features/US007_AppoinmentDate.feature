@Tc
@medunnaAllProject
Feature: US_007_Randevu olusturma


  Scenario Outline: TC01_Hasta gecerli randevu tarihi olusturabilmeli (positive senaryo)

  Given Hydr hasta medunna anasayfasina gider
  And  Hydr isim olarak "<firstname>" girer
  And  Hydr soyisim olarak "<lastname>" girer
  And  Hydr SSN "<SSN>" girer
  And  Hydr email "<Email>" girer
  And  Hydr telNo "<PhoneNumber>" girer
  And  Hydr gecerli randevu tarihi "<RandevuTarihi>" girer
  And Hydr Send an Appointment Request butonuna tiklar
  Then Hydr randevu tarihi olusturuldugunu kontrol eder


    Examples: Test Data

    |firstname | lastname   | SSN         | Email                 | PhoneNumber | RandevuTarihi |
    | haydar   | aslan      | 854-12-2114 | haydari@medunna.com  | 147-542-7854 | 12/04/2022   |


  Scenario Outline: TC02_Hasta gecersiz randevu tarihi olusturamamalı (negative senaryo)

    Given Hydr hasta medunna anasayfasina gider
    And  Hydr isim olarak "<firstname>" girer
    And  Hydr soyisim olarak "<lastname>" girer
    And  Hydr SSN "<SSN>" girer
    And  Hydr email "<Email>" girer
    And  Hydr telNo "<PhoneNumber>" girer
    And  Hydr randevu tarihi "<RandevuTarihi>" girer
    And Hydr Send an Appointment Request butonuna tiklar
    Then Hydr randevu tarihi olusturulmadigini kontrol eder


    Examples: Test Data

      |firstname | lastname   | SSN         | Email                 | PhoneNumber | RandevuTarihi |
      | haydar   | aslan      | 854-12-2114 | haydari@medunna.com  | 147-542-7854 | 01/04/2022 |