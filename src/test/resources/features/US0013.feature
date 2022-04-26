@smoke
@medunnaAllProject
Feature: US013--Test Results Islemleri


  Background:

    Given Doktor url gider
    Then Sing in Tiklar
    And Username ve Password ile giris yapar
    Then My Pages Buttonunu Tiklar
    Then My Appointments tiklar
    And Hasta bilgileri icin edit tiklanir


  Scenario: TC001--Test Results ile ilgili alanlarin gorulebilmesi

    And Guncellenen test sonuclari icin Show Test Results tiklanir
    And Gelen sonuc icin View Results tiklanir
    Then Ilgli alanlar kontrol edilir


  Scenario: TC002---Doktor "Request Impatient yapabilmeli

    Then Yatili hasta icin ilgili alanlar doldurulur
    And Request Impatient tiklanir


