@tc
@medunnaAllProject
Feature: US020_Admin Kullanici islemleri

  Background:
    Given admin url gider
    Then Sing in Tiklar
    And admin username ve password ile giris yapar
    Then administration butonuna tiklar
    And user management butonuna tiklar

  Scenario:TC001 Kayitli kisilerin bilgilerini gorebilmeli

    Given ilgili personeli bulur
    Then personel bilgisi icin viev tiklanir
    And bilgiler gorulur


  Scenario: TC002 admin doktor icin aktiv ve rol atama

    Then  testdoktor icin edit tiklar
    And Activated bun-tonuna tiklar
    Then profil atamasi yapilir
    And save butonuna tiklanir

  Scenario: TC002 admin personel icin aktiv ve rol atama

    Then  testpersonel icin edit tiklar
    And Activated bun-tonuna tiklar
    Then personel profil atamasi yapilir
    And save butonuna tiklanir

  Scenario: TC002 admin hasta icin aktiv ve rol atama

    Then  testhasta icin edit tiklar
    And Activated bun-tonuna tiklar
    Then hasta profil atamasi yapilir
    And save butonuna tiklanir


  Scenario: TC003 admin kullanici silebilmeli

    Then ilgili kullaniciyi silmek icin delete tiklar





