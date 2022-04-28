@medunnaAllProject
Feature: US022 Staff test sonuclarini görür ve degisiklik yapabilir

  Background:

    Given Kullanici anasayfaya gider
    And Kullanici insan ikonuna tiklar.
    And Kullanici seceneklerden Sign in secer
    And Kullanici username ve password bilgilerini girer
    Then Kullanici SignIn butonuna tiklar.


  Scenario: TC01 Kullanici SSN ile arama yapabilir

    Given Kullanici MyPages yazisina tiklar.
    And Kullanici seceneklerden Search Patient secer
    And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
    When Kullanici Show Appointments butonuna tiklar
    And Kullanici Edit butonuna tiklar
    Then Kullanici randevu bilgilerine ulasabildigini test eder


  Scenario: TC02 Kullanici test sonuclarini görür

    Given Kullanici MyPages yazisina tiklar.
    And Kullanici seceneklerden Search Patient secer
    And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
    When Kullanici Show Appointments butonuna tiklar
    And Kullanici Show Tests butonuna tiklar.
    And Kullanici View Results butonuna tiklar
    Then Kullanici test sonuclarini gorur


  Scenario: TC03 Kullanici test sonuclarini güncelleyebilir

    Given Kullanici MyPages yazisina tiklar.
    And Kullanici seceneklerden Search Patient secer
    And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
    When Kullanici Show Appointments butonuna tiklar
    And Kullanici Show Tests butonuna tiklar.
    And Kullanici View Results butonuna tiklar
    Then Kullanici test sonuclarini gorur
    And Kullanici Edit butonuna tiklar
    And Kullanici bilgileri gunceller
    Then Kullanici Save butonuna tiklar
