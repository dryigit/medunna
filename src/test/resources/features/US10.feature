@Tc
@medunnaAllProject
Feature:US10 Doktor olarak giris yapildiginda hasta bilgileri düzenlenebilmeli

  Background:
    Given kullanici "MedunnaURL" sayfasina gider

  Scenario:TC01 Doktor olarak giris yapilip hasta bilgileri görüntülenebilmeli

    Then kullanici gecerli bilgileri girerek basarili giris yapar
And kullanici My Appointments sekmesine tiklar
  And kullanici randevu listesini ve zaman dilimlerini bu sekmede gorur

Scenario:TC02 Doktor olarak  "patient id, start date, end date, status" bilgilerini görebilmeli

  Then kullanici gecerli bilgileri girerek basarili giris yapar
  And kullanici My Appointments sekmesine tiklar
  And kullanici cikan listede en ust sirada olani secer
 And kullanici edit butonuna tiklayip patient id, start date, end date, status bilgilerinin goruldugunu test eder