Feature: US_007_Randevu olusturma


  Scenario Outline: TC01_Hasta geçerli randevu tarihi oluşturabilmeli (positive senaryo)

  Given Hydr hasta medunna anasayfasına gider
  And  isim olarak "<firstname>" girer
  And  soyisim olarak "<lastname>" girer
  And  SSN "<SSN>" girer
  And  email "<Email>" girer
  And  telNo "<PhoneNumber>" girer
  And  randevu tarihi "<RandevuTarihi>" girer
  And Send an Appointment Request butonuna tıklar
  Then Randevu tarihi olusturuldugunu kontrol eder


    Examples: Test Data

    |firstname | lastname   | SSN         | Email                 | PhoneNumber | RandevuTarihi |
    | haydar   | aslan      | 854-12-2114 | haydari@medunna.com  | 147-542-7854 | 08/04/2022 |


  Scenario Outline: TC02_Hasta geçersiz randevu tarihi oluşturamamalı (negative senaryo)

    Given Hydr hasta medunna anasayfasına gider
    And  isim olarak "<firstname>" girer
    And  soyisim olarak "<lastname>" girer
    And  SSN "<SSN>" girer
    And  email "<Email>" girer
    And  telNo "<PhoneNumber>" girer
    And  randevu tarihi "<RandevuTarihi>" girer
    And Send an Appointment Request butonuna tıklar
    Then Randevu tarihi olusturulmadıgını kontrol eder


    Examples: Test Data

      |firstname | lastname   | SSN         | Email                 | PhoneNumber | RandevuTarihi |
      | haydar   | aslan      | 854-12-2114 | haydari@medunna.com  | 147-542-7854 | 01/04/2022 |