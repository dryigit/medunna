Feature: US_007_Randevu olusturma


  Scenario Outline: TC01_Hasta geçerli randevu tarihi oluşturabilmeli (positive senaryo)

  Given Hydr hasta medunna anasayfasına gider
  And  "<firstname>" girer
  And  "<lastname>" girer
  And  "<SSN>" girer
  And  "<Email>" girer
  And  "<PhoneNumber>" girer
  And  "<RandevuTarihi>" girer
  Then Randevu tarihi (ay/gün/yıl) seklinde olmalı
  And Send an Appointment Request butonuna tıklar
  Then Randevu tarihi olusturuldugunu kontrol eder


    Examples: Test Data

    |firstname | lastname   | SSN         | Email                 | PhoneNumber | RandevuTarihi |
    | haydar   | aslan      | 854-12-2114 | haydari@medunna.com  | 147-542-7854 | 08/04/2022 |

