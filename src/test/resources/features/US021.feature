Feature: US021 Staff randevulari gorur

  Background:

    Given Kullanici anasayfaya gider
    And Kullanici insan ikonuna tiklar.
    And Kullanici seceneklerden Sign in secer
    And Kullanici username ve password bilgilerini girer
    Then Kullanici SignIn butonuna tiklar.


  Scenario: TC01_Staff sadece randevulari güncelleyebilir.

   Given Kullanici MyPages yazisina tiklar.
    And Kullanici seceneklerden Search Patient secer
    And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
    And Kullanici Show Appointments butonuna tiklar
    And Kullanici Edit butonuna tiklar
    And Kullanici Start DateTime texboxini günceller
    Then Kullanici Save butonuna tiklar


    Scenario: TC02_Staff hasta durumunu(status) günceller.

      Given Kullanici MyPages yazisina tiklar.
      And Kullanici seceneklerden Search Patient secer
      And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
      And Kullanici Show Appointments butonuna tiklar
      And Kullanici Edit butonuna tiklar
      When Kullanici Status texboxina tiklar
      And Kullanici Unapproved,Pending ve Cancelled secenegini secebildigini test eder
      And Kullanici Completed secenegini secemedigini test eder


    Scenario: TC03_Staff bazi texboxlari girememeli

      Given Kullanici MyPages yazisina tiklar.
      And Kullanici seceneklerden Search Patient secer
      And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
      And Kullanici Show Appointments butonuna tiklar
      When Kullanici Edit butonuna tiklar
      Then Kullanici Anamnesis, Treatment ve Diagnosis texboxina tiklayabildigini test eder


    Scenario: TC04_Hasta icin doktoru secebilmeli

      Given Kullanici MyPages yazisina tiklar.
      And Kullanici seceneklerden Search Patient secer
      And Kullanici Patient SSN texboxina hastanin SSN nosunu girer
      And Kullanici Show Appointments butonuna tiklar
      When Kullanici Edit butonuna tiklar
      And Kullanici Physician texboxinda doktoru secer
      Then Kullanici Save butonuna tiklar







