@Tc
@medunnaAllProject
Feature:US10 Doktor olarak giris yapildiginda hasta bilgileri düzenlenebilmeli

  Background:
    Given kullanici "MedunnaURL" sayfasina gider

  Scenario:TC01 Doktor olarak giris yapilip hasta bilgileri görüntülenebilmeli

    Then kullanici gecerli bilgileri girerek basarili giris yapar
And kullanici My Appointments sekmesine tıklar
  And kullanici randevu listesini ve zaman dilimlerini bu sekmede görür

Scenario:TC02 Doktor olarak  "patient id, start date, end date, status" bilgilerini görebilmeli

  Then kullanici gecerli bilgileri girerek basarili giris yapar
  And kullanici My Appointments sekmesine tıklar
  And kullanici cikan listede en üst sırada olani secer
 And kullanici edit butonuna tıklayip patient id, start date, end date, status bilgilerinin görüldügünü test eder