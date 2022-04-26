@medunnaAllProject
Feature: US014--Yatılı tedavi işlemleri


  Background:
    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giris yapar
    Then My Pages Buttonunu Tiklar
    Then My Inpatients butonuna tiklar
    And Yatili Hasta bilgileri için edit tiklanir


  Scenario: TC001---Doktor yatili hasta bilgilerini görebilmeli ve güncelleyebilmeli

    Then doktor yatili hatasta bilgilerini görebilmeli


  Scenario: TC001--bilgileri güncelleme

    And doktor yatili hasta bilgilerini günceller


  Scenario: TC002---Status bilgilerini güncelleme

    Then status bilgilerini güncelleyebilmeli


  Scenario:TC003----Doktor rezerve edilmiş odayi güncelleyebilmeli

    Given oda güncelleme