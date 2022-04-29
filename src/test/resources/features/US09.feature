@Tc
@medunnaAllProject
Feature:US09 Staff olarak hasta bilgileri görüntülenebilmeli,düzenlenebilmeli

  Background:
    Given kullanici "MedunnaURL" sayfasina gider

  Scenario:TC01 Hasta bilgileri detaylarina ulasabilme


    Then kullanici gecerli bilgileri girerek basarili giris yapar
    Then  kullanici My pages butonuna tiklar acilan sekmeden In Patient secer
    And   acilan sayfa da goruntulenen hastalardan ilk sirada olan hasta secilir

    And hasta bilgilerinin acildigi sayfa Patient yazisinin goruldugu ile test edilir

  Scenario:TC02 Hasta bilgilerinin düzenlenmesi


    Given kullanici gecerli bilgileri girerek basarili giris yapar
    Then  kullanici My pages butonuna tiklar acilan sekmeden In Patient secer
    And   acilan sayfa da goruntulenen hastalardan ilk sirada olan hasta secilir

    Then kullanici edit butonuna tiklar
    And kullanici acilan sayfa da firstname_lastname_email_phone bilgilerini duzenler
    Then kullanici save butonuna basarak bilgilerin kaydedildigini test eder

  Scenario:TC03 SSN numarasına göre hasta araması yapilmali


    Then kullanici gecerli bilgileri girerek basarili giris yapar
    Then  Kullanici My pages butonuna tiklar acilan sekmeden Search Patient secer

    And kullanici SSN kutusuna gecerli bir SSN numarasi girer
    Then kullanici gelen bilgilerden ilk sirada olan hastayi secer
    And acilan sayfada edit butonuna tiklanir
    Then kullanici acilan sayfada firstname,lastname,email,phone boxlarinin bos olmadigini test eder

  Scenario:TC04 Kullanici herhangi bir hasta bilgisini silebilmeli


    Given kullanici gecerli bilgileri girerek basarili giris yapar

    Then  Kullanici My pages butonuna tiklar acilan sekmeden Search Patient secer

    And kullanici SSN kutusuna gecerli bir SSN numarasi girer
    Then kullanici gelen bilgilerden ilk sirada olan hastayi secer
    And acilan sayfada edit butonuna tiklanir
    Then kullanici firstname textini siler ve silindigini test eder

  Scenario:TC05 Yukarıdaki tüm seçenekler bir Admin ve Staff tarafından yapılabilir,
                 ancak staff hastaları silememeli.

    Given kullanici gecerli bilgileri girerek basarili giris yapar
    Then  kullanici My pages butonuna tiklar acilan sekmeden In Patient secer
    And kullanici staff olarak hastalari silemedigini test eder




  Scenario:TC06 Staff, hastaları SSN kimliklerine göre arayabilir, ancak Admin arayamaz.

    Given kullanici Admin olarak giris yapar
    And kullanici hastalari SSN kimlik numaralarina gore arama yapamadigini test eder



