@Tc1
Feature: US013--Test Results Islemleri


  Background:

    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giriş yapar
    Then My Pages Buttonunu Tiklar
    Then My Appointments tıklar
    And Hasta bilgileri için edit tıklanır


  Scenario: TC001--Test Results ile ilgili alanların görülebilmesi

    And Güncellenen test sonuçları için Show Test Results tıklanır
    And Gelen sonuç için View Results tıklanır
    Then İlgli alanlar kontrol edilir


  Scenario: TC002---Doktor "Request Impatient yapabilmeli

    Then Yatılı hasta için ilgili alanlar doldurulur
    And Request Impatient tıklanır
Feature: US013--Test Results Islemleri

  Background:

    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giriş yapar
    Then My Pages Buttonunu Tiklar
    Then My Appointments tıklar
    And Hasta bilgileri için edit tıklanır


  Scenario: TC001--Test Results ile ilgili alanların görülebilmesi

    And Güncellenen test sonuçları için Show Test Results tıklanır
    And Gelen sonuç için View Results tıklanır
    Then İlgli alanlar kontrol edilir


  Scenario: TC002---Doktor "Request Impatient yapabilmeli

    Then Yatılı hasta için ilgili alanlar doldurulur
    And Request Impatient tıklanır
