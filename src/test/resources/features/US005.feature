Feature: Kullanıcılar (patients), hastaneden randevu (Appointment) oluşturabilmelidir.

  Background:
    Given kullanici "MedunnaURL" anasayfasına gider
    Then kullanici Make an Appointment butonuna tıklar

  Scenario: TC01 Kullanıcılar "Make an Appointment" sayfasindaki bilgileri eksiksiz doldurmali ve randevu oluşturabilmelidir
    Given name olarak firstname girer
    And lastname olarak "lastname" girer
    And SSN numarası olarak "SSN" girer
    And e-posta  "Email" girer
    And e-posta  "Email" girer
    And date olarak "RandevuTarihi" girer
    Then send an appointment request butonuna tıklar
    Then randevu tarihi olusturuldugunu kontrol eder


