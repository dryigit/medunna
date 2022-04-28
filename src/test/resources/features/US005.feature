@medunnaAllProject

Feature: Kullanıcılar (patients), hastahaneden randevu (Appointment) oluşturabilmelidir.

  Background:
    Given lvnt kullanici "MedunnaURL" sayfasina gider
    Then lvnt kullanici Make an Appointment butonuna tiklar

  Scenario: TC01 Kullanıcılar "Make an Appointment" sayfasindaki bilgileri eksiksiz doldurmali ve randevu oluşturabilmelidir
    Given lvnt name olarak "firstname" girer
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta  "Email" girer
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date olarak "RandevuTarihi" girer
    Then lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder

  Scenario: TC02 Kullanıcılar Account Settings sayfasindaki sadece firstname alanini degistirmeli ve degisikligi kaydedebilmeli
    Given lvnt name alanini bos birakir
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta  "Email" girer
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date olarak "RandevuTarihi" girer
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir

  Scenario: TC03 Kullanıcılar randevu alanındaki lastname alanını boş bırakır  ve randevu alamaz
    Given lvnt name olarak "firstname" girer
    And lvnt lastname alanini bos birakir
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta  "Email" girer
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date olarak "RandevuTarihi" girer
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir

  Scenario: TC04 Kullanıcılar randevu alanındaki SSN alanını boş bırakır  ve randevu alamaz

    Given lvnt name olarak "firstname" girer
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarasi alanini bos birakir
    And lvnt e-posta  "Email" girer
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date olarak "RandevuTarihi" girer
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir

  Scenario: TC05 Kullanıcılar randevu alanındaki e-mail alanını boş bırakır  ve randevu alamaz
    Given lvnt name olarak "firstname" girer
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta alanini bos birakir
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date olarak "RandevuTarihi" girer
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir

  Scenario: TC06 Kullanıcılar randevu alanındaki telefon alanını boş bırakır  ve randevu alamaz
    Given lvnt name olarak "firstname" girer
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta  "Email" girer
    And lvnt telefon alanini bos birakir
    And lvnt date olarak "RandevuTarihi" girer
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir

  Scenario: TC07 Kullanıcılar randevu alanındaki tarih alanını boş bırakır  ve randevu alamaz
    Given lvnt name olarak "firstname" girer
    And lvnt lastname olarak "lastname" girer
    And lvnt SSN numarası olarak "SSN" girer
    And lvnt e-posta  "Email" girer
    And lvnt telefon olarak "PhoneNumber" girer
    And lvnt date alanini bos birakir
    And lvnt send an appointment request butonuna tiklar
    Then lvnt randevu tarihi olusturuldugunu kontrol eder ama negatif sonuc alir