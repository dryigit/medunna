Feature: US014--Yatılı tedavi işlemleri


  Background:
    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giriş yapar
    Then My Pages Buttonunu Tiklar
    Then My Inpatients butonuna tıklar
    And Yatılı Hasta bilgileri için edit tıklanır


  Scenario: TC001---Doktor yatılı hasta bilgilerini görebilmeli ve güncelleyebilmeli

    Then doktor yatılı hatasta bilgilerini görebilmeli


  Scenario: TC001--bilgileri güncelleme

    And doktor yatılı hasta bilgilerini günceller


  Scenario: TC002---Status bilgilerini güncelleme

    Then status bilgilerini güncelleyebilmeli


  Scenario:TC003----Doktor rezerve edilmiş odayı güncelleyebilmeli