@tc
Feature: US014--Yatılı tedavi islemleri


  Background:
    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giris yapar
    Then My Pages Buttonunu Tiklar
    Then My Inpatients butonuna tiklar
    And Yatili Hasta bilgileri icin edit tiklanir


  Scenario: TC001---Doktor yatili hasta bilgilerini gorebilmeli ve guncelleyebilmeli

    Then doktor yatili hatasta bilgilerini gorebilmeli


  Scenario: TC001--bilgileri güncelleme

    And doktor yatili hasta bilgilerini gunceller


  Scenario: TC002---Status bilgilerini güncelleme

    Then status bilgilerini guncelleyebilmeli


  Scenario:TC003----Doktor rezerve edilmis odayi guncelleyebilmeli

    Given oda guncelleme